

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class now
 */
@WebServlet("/now")
public class now extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public now() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html ; charset=UTF-8");
//		PrintWriter out = response.getWriter();
		String title = "現在の日付と時間";
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");	
		String strDate= "GET : "+formatter.format(date);
		//DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now())
//		out.println("<!DOCTYPE html><html><head><head><body>");
//		out.println("<h1 align = \"center\">" + title +"</h1>\n" +
//				"<h2 align = \"center\">GET :" + strDate + "</h2>\n" +
//				"</body></html>"
//				);
		request.setAttribute("title", title);
		request.setAttribute("strDate", strDate);
		request.getRequestDispatcher("/now.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html ; charset=UTF-8");
//		PrintWriter out = response.getWriter();
		String title = "現在の日付と時間";
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");	
		String strDate="POST : "+ formatter.format(date);
		//DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now())
//		out.println("<!DOCTYPE html><html><head><head><body>");
//		out.println("<h1 align = \"center\">" + title +"</h1>\n" +
//				"<h2 align = \"center\">POST: " + strDate + "</h2>\n" +
//				"</body></html>"
//				);
		request.setAttribute("title", title);
		request.setAttribute("strDate", strDate);
		request.getRequestDispatcher("/now.jsp").forward(request, response);
	}

}
