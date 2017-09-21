package com.example.Todolist;
import java.io.IOException;  
import java.io.PrintWriter;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;  
import javax.servlet.http.Cookie;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;  
public class LoginServlet extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
                           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter(); 
        String mailid=request.getParameter("mailid");  
        String passwd=request.getParameter("passwd");
        HttpSession session = request.getSession();
        PersistenceManager pm = PMF.get().getPersistenceManager();
        Query q = pm.newQuery(CustJDO.class);
        q.setFilter("email == '"+mailid+"' && pwd == '"+passwd+"'");       
        List<CustJDO> results = (List<CustJDO>) q.execute(); 
        System.out.println(results);
 try {
          	if (!(results.isEmpty())) 
        	{
          		System.out.println("lll");
          		session.setAttribute("sessionname", mailid);
                response.sendRedirect("todo.jsp");            		
             }
        	else
        	{  
          		
           	   System.out.println("kkkk");       		
        	   out.print("<script type=\"text/javascript\">");
      		   out.print("alert('User or password incorrect');");     		
      		   out.print("</script>");
        	   request.getRequestDispatcher("index.jsp").include(request, response);  
        	}        	
   	} finally{
        	q.closeAll();
        	pm.close();
        } 
        out.close();  
    }    
}  

