package com.deluan.isonic.subsonic

import com.deluan.isonic.subsonic.advice.RequestLoggerAdvice
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

import static com.fasterxml.jackson.databind.DeserializationFeature.UNWRAP_ROOT_VALUE
import static com.fasterxml.jackson.databind.SerializationFeature.WRAP_ROOT_VALUE

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false).
                favorParameter(true).
                parameterName("f").
                ignoreAcceptHeader(true).
                useJaf(false).
                defaultContentType(MediaType.APPLICATION_XML).
                mediaType("xml", MediaType.APPLICATION_XML).
                mediaType("json", MediaType.APPLICATION_JSON)
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestLoggerAdvice());
    }

    @Bean
    public ObjectMapper objectMapper() {
        def mapper = new ObjectMapper()
        mapper.configure(WRAP_ROOT_VALUE, true)
        mapper.configure(UNWRAP_ROOT_VALUE, true)
        mapper
    }
}