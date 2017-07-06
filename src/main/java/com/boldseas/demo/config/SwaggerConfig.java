package com.boldseas.demo.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * description :
 * author : wenbo.chen@boldseas.com
 * Created time : 2017/07/06 18:58.
 */
@Configurable
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestAPI(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.boldseas"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(instance());
    }

    private ApiInfo instance() {
        return new ApiInfo(
                "DEMO REST API",
                "USER REST API",
                "1.0",
                "Terms of service",
                new Contact("尔东陈", "https://github.com/chenwenbo", "berry@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");

    }

}
