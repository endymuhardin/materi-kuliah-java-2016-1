package com.muhardin.endy.belajar.http;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.annotation.WebServlet;

import java.io.PrintWriter;
import java.io.IOException;

@WebServlet("/scopedemo")
public class ScopeDemoServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String nama = req.getParameter("nama");
		String email = req.getParameter("email");

		if(nama == null){
			nama = (String) req.getSession().getAttribute("nama");
		} else {
			req.getSession().setAttribute("nama", nama);
		}

		res.setContentType("text/html");
		PrintWriter output = res.getWriter();
		output.println("<html>");
		output.println("<head>");
		output.println("<title>Session Demo</title>");
		output.println("</head>");
		output.println("<body>");
		output.println("<h1>Halaman 2</h1>");
		output.println("<h2>Halo "+nama+"</h2>");
		output.println("<h2>Email :  "+email+"</h2>");
		
		output.println("<a href=\"/scopedemo\">Reload halaman ini</a>");

		output.println("</body>");
		output.println("</html>");
	}
}