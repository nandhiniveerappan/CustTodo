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
import com.example.Todolist.CustJDO;
import com.example.Todolist.PMF;


public class SignupServlet extends HttpServlet {  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
                           throws ServletException, IOException {  
    	response.setContentType("text/html");  
        PrintWriter out=response.getWriter();
    	  
        String firstname=request.getParameter("firstname");  
        String lastname=request.getParameter("lastname");  
        String mailid=request.getParameter("mailid");  
        String passwd=request.getParameter("passwd");  
        PersistenceManager pm = PMF.get().getPersistenceManager();
        Query q = pm.newQuery(CustJDO.class);
        System.out.println("the query value is " + q);

    	q.setFilter("email == '"+mailid+"'");
        List<CustJDO> results = (List<CustJDO>) q.execute();
        try {
        	
        	if (!(results.isEmpty())) 
        	{
        		out.print("Account already exists please try to login or signup with different email");
        		request.getRequestDispatcher("index.jsp").include(request, response);  
                       		
             }
        	else
        	{        	
        		out.print("exec");
        		out.print(results);
        		CustJDO obj=new CustJDO();
        		obj.setFname(firstname);
        		obj.setLname(lastname);
        		obj.setEmail(mailid);
        		obj.setPwd(passwd);
        		System.out.println("signup page "+firstname);
        		System.out.println("signup page "+lastname);
        		System.out.println("signup page "+mailid);
        		System.out.println("signup page "+passwd);
                pm.makePersistent(obj);
                response.sendRedirect("index.jsp");   
        	}
        	
        } finally {
        	q.closeAll();
        	pm.close();
        }
        out.close();  
    }  
  
}  
