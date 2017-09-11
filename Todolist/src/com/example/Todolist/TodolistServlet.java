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

if(password.equals("admin123")){  
out.print("You are successfully logged in!");  
out.print("<br>Welcome, "+name);  
request.getRequestDispatcher("todo.html").include(request, response); 
Cookie ck=new Cookie("name",name);  
response.addCookie(ck);  
}else{  
out.print("<p style= font-size:23px;>sorry, username or password error! Please login again</p>");  
request.getRequestDispatcher("index.html").include(request, response);  
}  

out.close();  
}  

}
