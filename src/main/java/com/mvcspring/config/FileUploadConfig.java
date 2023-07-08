package com.mvcspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;


// THIS CLASS IS FOR FILE UPLOAD CONFIGURATION
// IT CAN BE ADDED THROUGH DIFFERENT CONFIGURATION IN THE DISPATCHER SERVLET
// BUT USED THE CLASS INSTEAD, FOR EASIER TO UNDERSTAND REASONS
@Configuration
public class FileUploadConfig {

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSize(5242880); // Set the maximum file size allowed
        return resolver;
    }

}