package servlet_examples;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Hello extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// server.xml Row63 useBodyEncodingForURI="true"
		req.setCharacterEncoding("Big5"); // 需在req.getParameter("name")之前, 代表以特定的字元編碼集處理P.250
		res.setContentType("text/html; charset=Big5");
		PrintWriter out = res.getWriter();

		String name = req.getParameter("name");
//        String name = req.getParameter("name").trim(); 
		// 打上trim就會出現500錯誤因為是空值, 從表單送的話不輸入為空字串非空值, 不會出現500
		
		// 測試使用者打的資料是否為空值或空字串(全形空白無法避免)
		System.out.println(name == null);                  // X (但不好, 表單上空字串(空白或不輸入)會為false)
		System.out.println("----------------");
		if (name != null) {
			System.out.println(name.trim().length() == 0); // V JDK 1.0
			System.out.println(name.trim().isEmpty()); 	   // V JDK 1.6
			System.out.println(name.trim().equals(""));    // V JDK 1.0, 也不太好, 但還是可以
		}

		out.println("<HTML>");
		out.println("<HEAD><TITLE>Hello, " + name + "</TITLE></HEAD>");
		out.println("<BODY>");
		out.println("Hello, 你好: " + name);
		out.println("</BODY></HTML>");
	}

	public String getServletInfo() {
		return "A servlet that knows the name of the person to whom it's" + "saying hello";
	}
}
