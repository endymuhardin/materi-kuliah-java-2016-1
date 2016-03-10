package com.muhardin.endy.belajar.http;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.annotation.WebServlet;

import java.io.PrintWriter;
import java.io.IOException;

@WebServlet(urlPatterns = "/halo", loadOnStartup = 1)
public class HaloServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html");

		PrintWriter output = res.getWriter();
		output.println("<html>");
		output.println("<head>");
		output.println("<title>Halo Servlet</title>");
		output.println("</head>");
		output.println("<body>");
		output.println("<h1>Halo Servlet</h1>");
		output.println("</body>");
		output.println("</html>");
	}
}