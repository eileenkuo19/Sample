package servlet_examples;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Hello extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// server.xml Row63 useBodyEncodingForURI="true"
		req.setCharacterEncoding("Big5"); // �ݦbreq.getParameter("name")���e, �N��H�S�w���r���s�X���B�zP.250
		res.setContentType("text/html; charset=Big5");
		PrintWriter out = res.getWriter();

		String name = req.getParameter("name");
//        String name = req.getParameter("name").trim(); 
		// ���Wtrim�N�|�X�{500���~�]���O�ŭ�, �q���e���ܤ���J���Ŧr��D�ŭ�, ���|�X�{500
		
		// ���ըϥΪ̥�����ƬO�_���ŭȩΪŦr��(���ΪťյL�k�קK)
		System.out.println(name == null);                  // X (�����n, ���W�Ŧr��(�ťթΤ���J)�|��false)
		System.out.println("----------------");
		if (name != null) {
			System.out.println(name.trim().length() == 0); // V JDK 1.0
			System.out.println(name.trim().isEmpty()); 	   // V JDK 1.6
			System.out.println(name.trim().equals(""));    // V JDK 1.0, �]���Ӧn, ���٬O�i�H
		}

		out.println("<HTML>");
		out.println("<HEAD><TITLE>Hello, " + name + "</TITLE></HEAD>");
		out.println("<BODY>");
		out.println("Hello, �A�n: " + name);
		out.println("</BODY></HTML>");
	}

	public String getServletInfo() {
		return "A servlet that knows the name of the person to whom it's" + "saying hello";
	}
}
