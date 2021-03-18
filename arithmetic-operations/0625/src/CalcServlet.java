

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/calc.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String xStr = request.getParameter("xStr");
		String yStr = request.getParameter("yStr");
		int x = Integer.parseInt(xStr);
		int y = Integer.parseInt(yStr);
			//===================================================
		double plus = x + y;
		double minus = x - y;
		double times = x * y;
		double divide = x / y;
		double result [] = {x,y,plus,minus,times,divide};
		x=10;
		y=20;
		request.setAttribute("result", result);
		request.setAttribute("x", x);
		request.setAttribute("y", y);
		request.getRequestDispatcher("/WEB-INF/calc.jsp").forward(request, response);
	}
	
	void noInput(PrintWriter out) {
		out.println("<!DOCTYPE html><html><head><head><body>");
		out.println("フォームにデータが入力されませんでした<br>");
		out.println("<a href='calc.html'>戻る</a>");
		out.println("</body></html>");
	}

}
