package com.muhardin.endy.belajar.http;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;

@WebFilter("/scopedemo")
public class CekNamaFilter implements Filter {
	public void init(FilterConfig fc) throws ServletException {
        System.out.println("===== Filter diinisialisasi =====");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc) throws IOException, ServletException {
        System.out.println("Mengecek apakah nama sudah diisi");

        String nama = (String) ((HttpServletRequest)request).getServletContext().getAttribute("nama");
        if(nama == null){
        	nama = ((HttpServletRequest)request).getParameter("nama");
        }

        if(nama == null){
        	System.out.println("Nama belum diisi, redirect ke form input");
        	HttpServletResponse res = (HttpServletResponse) response;
        	res.sendRedirect("/scope.html");
        	return;
        } else {
        	System.out.println("Nama sudah ada, lanjutkan");
        }

        fc.doFilter(request, response);
        response.getWriter().println("<br /><em> tambahan response dari filter </em>");
    }

    public void destroy() {
        System.out.println("===== Filter di-destroy =====");
    }
}