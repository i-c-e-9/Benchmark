package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18786")
public class BenchmarkTest18786 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

		String bar = doSomething(param);
		
		response.getWriter().write(bar.toCharArray());
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map74861 = new java.util.HashMap<String,Object>();
		map74861.put("keyA-74861", "a_Value"); // put some stuff in the collection
		map74861.put("keyB-74861", param.toString()); // put it in a collection
		map74861.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map74861.get("keyB-74861"); // get it back out
		bar = (String)map74861.get("keyA-74861"); // get safe value back out
	
		return bar;	
	}
}