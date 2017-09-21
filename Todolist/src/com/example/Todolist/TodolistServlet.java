package com.example.Todolist;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class TodolistServlet extends HttpServlet {
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)  
             throws ServletException, IOException {  
response.setContentType("text/html");  
PrintWriter out=response.getWriter();  

 

String name=request.getParameter("name");  
String password=request.getParameter("password");  

 

out.close();  
}  

}
