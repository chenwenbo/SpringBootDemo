package com.boldseas.springboot.domain;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.internet.MimeMessage;

/**
 * description :
 * author : wenbo.chen@boldseas.com
 * Created time : 2017/07/09 14:40.
 */
@Component
public class Mail {
    private static final Logger logger = LoggerFactory.getLogger(Mail.class);

    private JavaMailSender javaMailSender;
    private Configuration configuration;

    @Autowired
    public Mail(JavaMailSender javaMailSender, Configuration configuration) {
        this.javaMailSender = javaMailSender;
        this.configuration = configuration;
    }

    private SimpleMailMessage getSimpleMailInstance() {
        SimpleMailMessage simpleMessage = new SimpleMailMessage();
        simpleMessage.setFrom("594017622@qq.com");
        simpleMessage.setTo("1210945390@qq.com");
        simpleMessage.setSubject("test mail");
        simpleMessage.setText("this is a test mail form spring boot");
        return simpleMessage;
    }

    private MimeMessage getMimeMailMessage() {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom("594017622@qq.com");
            helper.setTo("1210945390@qq.com");
            helper.setSubject("主题：模板邮件");
            Template template= configuration.getTemplate("email.ftl");
            String emailHtml = FreeMarkerTemplateUtils.processTemplateIntoString(template, getModel());
            helper.setText(emailHtml, true);
        } catch (Exception e) {
            logger.error("create mail template error");
        }
        return mimeMessage;
    }

    private User getModel() {
        User user = new User();
        user.setUserName("berry");
        return user;
    }

    @Async
    public void start() {
//        javaMailSender.send(getSimpleMailInstance());
        javaMailSender.send(getMimeMailMessage());
    }
}
