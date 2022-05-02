package com.example.emos.wx.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName SwaggerConfig.java
 * @Description
 * @createTime 2022-04-26 16:16:00
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig{
    @Bean
    public Docket createRestApi(){
        Docket docket=new Docket(DocumentationType.SWAGGER_2);
//        设置页面标题
        ApiInfoBuilder builder = new ApiInfoBuilder();
        builder.title("EMOS在线办公系统");
        ApiInfo info= builder.build();
        docket.apiInfo(info);
//        选择方法
        ApiSelectorBuilder selectorBuilder = docket.select();
//        过滤路径
        selectorBuilder.paths(PathSelectors.any());
//        必须有@ApiOperaation注解
        selectorBuilder.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class));
        docket=selectorBuilder.build();

//        设置在header中获取token
        ApiKey apiKey = new ApiKey("token","token","header");
        List<ApiKey> apiKeyList = new ArrayList<>();
        apiKeyList.add(apiKey);
        docket.securitySchemes(apiKeyList);

        AuthorizationScope scope = new AuthorizationScope("global","accessEverything");
        AuthorizationScope[] scopes = {scope};
        SecurityReference reference = new SecurityReference("token",scopes);
        List refList = new ArrayList();
        refList.add(reference);
        SecurityContext context = SecurityContext.builder().securityReferences(refList).build();
        List ctxList = new ArrayList();
        ctxList.add(context);
        docket.securityContexts(ctxList);

        return docket;
    }
}
