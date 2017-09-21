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

	import com.google.gson.Gson;

	public class LoadContactServlet extends HttpServlet {

		protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
			
			HttpSession session = req.getSession();
			String cusEmail = session.getAttribute("sessionname").toString();
			PersistenceManager pm = PMF.get().getPersistenceManager();
			PrintWriter out = res.getWriter();
			String output ="";
			Query q = pm.newQuery(DetailsJDO.class);
			q.setFilter("loggedEmail =='"+cusEmail+"'");			
			List<DetailsJDO> result =(List<DetailsJDO>)q.execute();
			System.out.println(cusEmail);
			System.out.println("no of cusotomer :"+result.size());
			Gson gson = new Gson();
			output = gson.toJson(result);
			out.write(output);
			
		}
	}
