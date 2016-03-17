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
		
		// http://localhost:8080/halo?n=endy&email=endy.muhardin@gmail.com
		String nama = req.getParameter("n");
		String email = req.getParameter("email");

		if(!"endy".equals(nama)){
			res.sendError(404, "Nama "+nama+" tidak ditemukan");
			return;
		}

		res.setContentType("text/html");
		PrintWriter output = res.getWriter();
		output.println("<html>");
		output.println("<head>");
		output.println("<title>Halo "+nama+"</title>");
		output.println("</head>");
		output.println("<body>");
		output.println("<h1>Halo "+nama+"</h1>");
		output.println("Email : "+email);
		output.println("</body>");
		output.println("</html>");
	}
}