package _web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import _00_init.util.HibernateUtil;



//@WebListener
public class WebAppListener implements ServletContextListener {


    public WebAppListener() {
        // TODO Auto-generated constructor stub
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }


    public void contextInitialized(ServletContextEvent sce)  { 
    		HibernateUtil.getSessionFactory();
    }
	
}
