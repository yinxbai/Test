package com.ll.crm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author InRoota
 * @date 2021-06-30  11:26
 */
@Configuration
public class MvcConfig extends WebMvcConfigurationSupport {

//    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
//            "classpath:/resources/",
//            "classpath:/static/", "classpath:/templates/" };

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
////                .addResourceLocations("classpath:/templates/");
//        super.addResourceHandlers(registry);
    }
}
