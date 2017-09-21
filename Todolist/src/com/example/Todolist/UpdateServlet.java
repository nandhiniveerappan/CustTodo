package com.example.Todolist;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UpdateServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();
		List<String> todolist = new ArrayList<String>();
		System.out.println("inside udpatecustomerservlet");
		
		String data = req.getParameter("data");
		
		JSONObject json =null;
		
		try {
			
			json = new JSONObject(data);
			System.out.println("data from js"+json);
			String customerName= json.getString("name");		
        	String customerNum=json.getString("number");
        	String customerEmail= json.getString("email");
        	String customerAddr=json.getString("address");			
			String currentCustEmail = json.get("currentCustEmail").toString();
			System.out.println("currentemail"+currentCustEmail);
			JSONArray todoarray = json.getJSONArray("todoList");
			if(todoarray!=null){
				for(int i=0;i<todoarray.length();i++){
				todolist.add(todoarray.getString(i));
				}
			}
			System.out.println(todolist);
			System.out.println(todoarray);
			Query q= pm.newQuery(DetailsJDO.class);
			q.setFilter("loggedEmail =='"+session.getAttribute("sessionname").toString()+"' && email =='"+currentCustEmail+"'");
			
			List<DetailsJDO> result1 = (List<DetailsJDO>) q.execute();
			System.out.println("list"+result1);
			if(!(result1.isEmpty())){
				DetailsJDO details = pm.getObjectById(DetailsJDO.class,result1.get(0).getKey());
				details.setName(customerName);
				details.setPhone(customerNum);
				details.setEmail(customerEmail);
			    details.setAddress(customerAddr);
				details.setTodoList(todolist);
				pm.makePersistent(details);
				out.write("updated");
			}			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			pm.close();
		}
	}
}
		
	

