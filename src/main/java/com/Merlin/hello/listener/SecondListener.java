package com.Merlin.hello.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/*
    整合listener：组件注册方式
 */
public class SecondListener implements ServletContextListener{

        @Override
        public void contextInitialized(ServletContextEvent sce) {
            System.out.println("ListenerSecond···Init···");
        }

        @Override
        public void contextDestroyed(ServletContextEvent sce) {
            System.out.println("ListenerSecond···Destory···");
        }
}
