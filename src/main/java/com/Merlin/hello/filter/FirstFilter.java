package com.Merlin.hello.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/*
    整合filter方式一：@WebFilter注解
    @ServletComponentScan //在spring boot 启东时会扫描@WebServlet注解，并将该类实例化
 */

//@WebFilter(filterName = "firstFilter",urlPatterns = {"*.do","*.jsp"})
@WebFilter(filterName = "firstFilter",urlPatterns = "/first")
public class FirstFilter implements Filter{

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("enter the first filter");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("left the first filter");
    }
}
