package com.boldseas.springboot.schedule;

import com.boldseas.springboot.domain.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * description :
 * author : wenbo.chen@boldseas.com
 * Created time : 2017/07/09 14:35.
 */
@Component
public class Schedule {

    private Mail mail;

    @Autowired
    public Schedule(Mail mail) {
        this.mail = mail;
    }


    @Scheduled(fixedRate = 36000)
    public void mailJob() {
        mail.start();
    }
}
