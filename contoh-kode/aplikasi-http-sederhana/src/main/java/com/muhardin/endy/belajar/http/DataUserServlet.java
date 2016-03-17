package com.muhardin.endy.belajar.http;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.annotation.WebServlet;

import java.io.PrintWriter;
import java.io.IOException;

import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@WebServlet(urlPatterns = "/data", loadOnStartup = 1)
public class DataUserServlet extends HttpServlet {

	private List<Map<String, String>> dataUser = new ArrayList<>();
	private ObjectMapper jsonMapper = new ObjectMapper();

	public DataUserServlet(){
		for(int i=1; i<11; i++){
			Map<String, String> user = new HashMap<>();
			user.put("username", "user"+i);
			user.put("email", "user"+i+"@example.com");
			dataUser.add(user);
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws IOException {


		String contentType = req.getHeader("Accept");

		if(contentType == null){
			res.sendError(406, "Content Type "+contentType+" tidak tersedia");
			return;
		}

		if("text/csv".equalsIgnoreCase(contentType)){
			res.setContentType(contentType);
			PrintWriter output = res.getWriter();
			output.println(konversiJadiCsv());
			return;
		}

		if("application/json".equalsIgnoreCase(contentType)){
			res.setContentType(contentType);
			PrintWriter output = res.getWriter();
			output.println(konversiJadiJson());
			return;
		}

		if(contentType.contains("text/html")){
			res.setContentType("text/html");
			PrintWriter output = res.getWriter();
			output.println("<html>");
			output.println("<head>");
			output.println("<title>Data User</title>");
			output.println("</head>");
			output.println("<body>");
			output.println("<h1>Data User</h1>");

			output.println(konversiJadiHtml());

			output.println("</body>");
			output.println("</html>");
			return;
		}

		res.sendError(406, "Content Type "+contentType+" tidak tersedia");
	}

	private String konversiJadiHtml(){
		StringBuilder hasil = new StringBuilder();

		hasil.append("<table border=1 cellpadding=10 cellspacing=0>\n");
		hasil.append("<thead>\n");
		hasil.append("<tr><th>Nama</th><th>Email</th></tr>\n");
		hasil.append("</thead>\n");

		for(Map<String, String> u : dataUser){
			hasil.append("<tr><td>"+u.get("username")+"</td>");
			hasil.append("<td>"+u.get("email")+"</td></tr>\n");
		}

		hasil.append("</table>\n");

		return hasil.toString();
	}

	private String konversiJadiCsv(){
		StringBuilder hasil = new StringBuilder();

		hasil.append("username,email\n");
		for(Map<String, String> u : dataUser){
			hasil.append(u.get("username")+","+u.get("email")+"\n");
		}

		return hasil.toString();
	}

	private String konversiJadiJson(){
		try{
			return jsonMapper.writer()
			.with(SerializationFeature.INDENT_OUTPUT)
			.writeValueAsString(dataUser);
		} catch (Exception err){
			err.printStackTrace();
			return "{data: \"Error\"}";
		} 
	}
}