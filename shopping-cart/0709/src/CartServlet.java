

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet({"/cart","/clear"})
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String jsp = "show.jsp";
		HashMap<String, Integer> cart = (HashMap<String, Integer>)session.getAttribute("cart");
		
		switch (request.getServletPath()) {
		case "/cart":
			if(request.getSession().getAttribute("islogin")==null) {
				response.sendRedirect("auth");
			}else {
				cart = new HashMap<>();
				session.setAttribute("cart", cart);
				request.getRequestDispatcher("/WEB-INF/"+jsp).forward(request, response);
			}
			break;
		case "/clear":
			cart.clear();
			response.sendRedirect("cart");
			break;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String item = request.getParameter("item");
		String numStr = request.getParameter("num");
		if (numStr == "") {
			numStr = "0";
		}
		int num = Integer.parseInt(numStr);
		
		String jsp = "show.jsp";
		HttpSession session = request.getSession();
		HashMap<String, Integer> cart = (HashMap<String, Integer>)session.getAttribute("cart");
		if(cart.containsKey(item)) {
			cart.put(item,cart.get(item)+num);
		}else if(item != "") {
			cart.put(item, num);
		}
		request.setAttribute("cart", cart);
		request.getRequestDispatcher("/WEB-INF/"+jsp).forward(request, response);
	}

}
