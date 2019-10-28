package main.java;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.channels.FileChannel;

public class ServletTest extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		ClassLoader cl = ServletTest.class.getClassLoader();
//		URL abc = cl.getResource("log4j.properties");
//		String pathStr = abc.getPath();
//		RequestDispatcher rd = req.getRequestDispatcher("/home.jsp");
//		rd.forward(req,resp);
        response.setContentType("text/plain;charset=utf-8");
        PrintWriter writer=response.getWriter();
        InputStream in=request.getInputStream();
        File f = new File("/tmp/upload");
        //把文件存到/tmp/upload
        FileOutputStream fout = new FileOutputStream(f);




        byte[] b=new byte[1024];
        int n=0;
        while ((n=in.read(b))!=-1){
            fout.write(b,0,n);
        }
        fout.close();
        in.close();
        writer.println("Finished uploading files!");
        writer.close();




	}
	
	
	
}
