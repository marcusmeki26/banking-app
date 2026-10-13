package com.marcus.banking_app.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfiguration implements WebMvcConfigurer {
  @Value("${FRONTEND_ORIGIN}")
  private String origin;

  @Override 
  public void addCorsMappings(CorsRegistry registry){
    
    registry.addMapping("/**")
            .allowedOrigins(origin)
            .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
            .allowedHeaders("Content-Type")
            .maxAge(3600);
  }
}
