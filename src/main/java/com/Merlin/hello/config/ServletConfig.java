package com.Merlin.hello.config;


import com.Merlin.hello.servlet.SecondServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletRegistration;

@Configuration
public class ServletConfig {
    /*
            完成Servlet组件的注册
            且只在项目启动时执行一次
    */
    @Bean  //相当于xml中Bean标签,ServletRegistrationBean必须返回这个对象
    public ServletRegistrationBean getServletRegistrationBean(){
        //注册Servlet，实例化
        ServletRegistrationBean bean = new ServletRegistrationBean(new SecondServlet());
        //添加URL访问路径,访问路径一定要有/
        bean.addUrlMappings("/second");
        return bean;
    }
}
