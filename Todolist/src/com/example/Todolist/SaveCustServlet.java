package com.example.Todolist; 
import java.io.IOException;  
import java.io.PrintWriter;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;   
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.Todolist.PMF;




public class SaveCustServlet  extends HttpServlet {  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
                           throws ServletException, IOException {  
     response.setContentType("text/html");
     HttpSession session = request.getSession();
     PrintWriter out=response.getWriter();
     PersistenceManager pm = PMF.get().getPersistenceManager();
     String data=request.getParameter("data");
     System.out.println("Data "+data);
          
        try {   
        	System.out.println("Data "+data);
        	System.out.println(data);
        	JSONObject json= new JSONObject(data);
        	System.out.println("Customer:"+json);
        	String customerName= json.getString("name");
        	System.out.println("Customer:"+customerName);
        	String customerEmail= json.getString("email");
        	String customerNum=json.getString("number");
        	String customerAddr=json.getString("address");
        	System.out.println("fname :"+customerName+" email :"+customerEmail+ " num:" +customerNum+" addr:"+customerAddr);
        	 Query q = pm.newQuery(DetailsJDO.class);
        	 q.setFilter("loggedEmail =='"+session.getAttribute("sessionname").toString()+"' && email =='"+customerEmail+"'");
        			 List<DetailsJDO> res = (List<DetailsJDO>) q.execute();
        	 if(!(res.isEmpty())){
     			System.out.println("Customer email already exist");
     			out.print("failure");
     		}
     		else{
     			System.out.println("custJDO");
     			DetailsJDO detail =new DetailsJDO();
    			detail.setLoggedEmail(session.getAttribute("sessionname").toString());
    			detail.setName(customerName);
     			detail.setEmail(customerEmail);
     			detail.setPhone(customerNum);
     			detail.setAddress(customerAddr);
    			out.print("success");
     			pm.makePersistent(detail);
     		}        		                  	
        }
        catch (JSONException e) {
			// TODO Auto-generated catch block
			System.out.println("error in json");
		}
        
		finally{
			pm.close();
			
		}
        out.close();  
    }  
  }  
