package com.boldseas.springboot.config;

import com.google.common.base.Predicate;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * description :
 * author : wenbo.chen@boldseas.com
 * Created time : 2017/07/06 18:58.
 */
@Configurable
public class SwaggerConfig {

    @Bean
    public Docket eventRouteDocket() {
        return getDocket("event-route", new String[]{"/api/.*"}, "event route api", "event route api for active event route and trigger event route");
    }

    /**
     * 根据条件生成API文档
     *
     * @param name     名称
     * @param paths    匹配路径
     * @param title    标题
     * @param subTitle 副标题
     * @return
     */
    private Docket getDocket(String name, String[] paths, String title, String subTitle) {
        List<Predicate<String>> pridicates = new ArrayList<>();
        for (String path : paths) {
            pridicates.add(regex(path));
        }
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(name)
                .genericModelSubstitutes(DeferredResult.class)
                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("/")// base，最终调用接口后会和paths拼接在一起
                .select()
                .paths(or(pridicates))//过滤的接口
                .build()
                .apiInfo(getApiInfo(title, subTitle));
    }

    /**
     * 页面显示版权信息等
     *
     * @param title    页面标题
     * @param subTitle 页面副标题
     * @return
     */
    private ApiInfo getApiInfo(String title, String subTitle) {
        return new ApiInfo(title,//大标题
                subTitle,//小标题
                "0.1",//版本
                "NO terms of service",
                "wenbo.chen@boldseas.com",//作者
                "Boldseas保留所有解释权利",//链接显示文字
                "http://www.boldseas.com"//网站链接
        );
    }
}
