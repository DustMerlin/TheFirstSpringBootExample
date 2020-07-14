package com.Merlin.hello.filter;


import javax.servlet.*;
import java.io.IOException;
/*
    整合方式二：使用组件注册的方式
 */

public class SecondFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("enter the second filter");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("left the second filter");
    }
}
