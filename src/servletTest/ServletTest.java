package servletTest;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletTest extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		ClassLoader cl = ServletTest.class.getClassLoader();
//		URL abc = cl.getResource("log4j.properties");
//		String pathStr = abc.getPath();
		RequestDispatcher rd = req.getRequestDispatcher("/home.jsp");
		rd.forward(req,resp);
	}
	
	
	
}
