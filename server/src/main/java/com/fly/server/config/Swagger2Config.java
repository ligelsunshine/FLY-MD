package com.fly.server.config;

import com.fly.common.utils.YmlPropertySourceFactory;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author LIGEL
 */
@PropertySource(value = {"classpath:./SwaggerConfiguration.yml"}, encoding = "UTF-8", factory = YmlPropertySourceFactory.class)
@ConfigurationProperties(prefix = "swagger")
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Value("${swagger.enable}")
    private Boolean enable;
    @Value("${swagger.apiInfo.title}")
    private String title;
    @Value("${swagger.apiInfo.contact.name}")
    private String contactName;
    @Value("${swagger.apiInfo.contact.url}")
    private String contactUrl;
    @Value("${swagger.apiInfo.contact.email}")
    private String contactEmail;
    @Value("${swagger.apiInfo.version}")
    private String version;
    @Value("${swagger.apiInfo.description}")
    private String description;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                //开启配置
                .enable(enable)
                .apiInfo(apiInfo())
                .select()
                //生成api文档扫描,这里是一个坑，我用的路径扫描，应该用注解扫描
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title(title)
                //作者
                .contact(new Contact(contactName, contactUrl, contactEmail))
                //版本号
                .version(version)
                //描述
                .description(description)
                .build();
    }
}

