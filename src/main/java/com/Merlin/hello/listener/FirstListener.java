package com.Merlin.hello.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/*
    整合listener：注解@ServletComponentScan
 */
@WebListener
public class FirstListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ListenerFirst···Init···");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("LiFstirstener···Destory···");
    }
}
