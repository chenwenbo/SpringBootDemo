package com.boldseas.demo.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * description :
 * author : wenbo.chen@boldseas.com
 * Created time : 2017/07/06 18:58.
 */
@Configurable
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.boldseas"))
                .paths(regex("/api/.*"))
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "SpringBoot REST API",
                "SpringBoot REST API",
                "1.0",
                "Terms of service",
                new Contact("chenwenbo", "https://github.com/chenwenbo", "beearys@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");
        return apiInfo;
    }


}
