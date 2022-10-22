package com.vrtrain.springboot.config;

import com.vrtrain.springboot.config.interceptor.AdminInterceptor;
import com.vrtrain.springboot.config.interceptor.UserInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userInterceptor())
                .addPathPatterns("/question/getRandomByScene", "/question/getRandomTestPaper",
                        "/answer-sheet/getScoreByUser", "/answer-sheet/save2");
        registry.addInterceptor(adminInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login", "/user/register",
                        "/trainee/register", "/trainee/login",
                        "/question/getRandomByScene", "/question/getRandomTestPaper", "/question/getAllByScene",
                        "/answer-sheet/getScoreByUser", "/answer-sheet/save2",
                        "/answer-sheet/getByUser", "/answer-sheet/getDetailScoreByUser",
                        "/law/getAllByScene",
                        "/audio/*");
    }

    @Bean
    public UserInterceptor userInterceptor() {
        return new UserInterceptor();
    }
    @Bean
    public AdminInterceptor adminInterceptor() {
        return new AdminInterceptor();
    }
}