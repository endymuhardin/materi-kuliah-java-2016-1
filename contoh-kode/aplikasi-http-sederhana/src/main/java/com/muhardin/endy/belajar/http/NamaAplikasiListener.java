package com.muhardin.endy.belajar.http;

import javax.servlet.*;
import javax.servlet.annotation.*;

@WebListener
public class NamaAplikasiListener implements ServletContextListener {
	
	public void contextInitialized(ServletContextEvent sce) {
        System.out.println("===== Aplikasi start =====");
        sce.getServletContext().setAttribute("aplikasi", "Aplikasi Demo Scope");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("===== Aplikasi stop =====");
    }
}