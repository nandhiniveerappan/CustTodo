package com.example.Todolist;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.Servlet;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

public class DeleteContactServlet extends HttpServlet  {

	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		
		String data = req.getParameter("data");
		System.out.println(data);
		PersistenceManager pm = PMF.get().getPersistenceManager();
		HttpSession session = req.getSession();
		
		JSONObject json = null;
		
		try {
			json = new JSONObject(data);
			System.out.println("customer email in delete servlet ( json ) :"+json);
			String customerEmail = json.get("custEmail").toString();
			System.out.println("customer email in delete servlet "+customerEmail);
			Query q = pm.newQuery(DetailsJDO.class);
			q.setFilter("loggedEmail =='"+session.getAttribute("sessionname").toString()+"' && email =='"+customerEmail+"'");
			List<DetailsJDO> result = (List<DetailsJDO>)q.execute();
			DetailsJDO customer = pm.getObjectById(DetailsJDO.class,result.get(0).getKey());
			pm.deletePersistent(customer);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			pm.close();
		}
		
	}
}
