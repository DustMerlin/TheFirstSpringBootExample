package com.Merlin.hello.config;
/*
    filter配置类
 */

import com.Merlin.hello.filter.SecondFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.FilterRegistration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean getFilterRegistrationBean(){
        FilterRegistrationBean bean = new FilterRegistrationBean(new SecondFilter());
//        bean.addUrlPatterns(new String[]{"*.jsp","*.do"});
//        下方的url一定不要忘记加/
        bean.addUrlPatterns("/second");
        return bean;
    }
}
