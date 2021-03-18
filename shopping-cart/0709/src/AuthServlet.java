

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AuthServlet
 */
@WebServlet({"/auth", "/logout"})
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		ServletContext app = getServletContext();
		HashMap<String, String> registeredUsers = new HashMap<String, String>();
		registeredUsers.put("azu", "001");
		registeredUsers.put("aldo", "002");
		registeredUsers.put("kane", "003");
		registeredUsers.put("sugata", "004");
		app.setAttribute("registeredUsers", registeredUsers);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String jsp = "login.jsp";
		
		switch (request.getServletPath()) {
		case "/auth":
			String id = (String)session.getAttribute("id");
			if(id != null) {
				jsp = "login.jsp";
			}
			request.getRequestDispatcher("/WEB-INF/"+jsp).forward(request, response);
			break;
		case "/logout":
			session.invalidate();
			response.sendRedirect("/logout");
			break;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		ServletContext app = getServletContext();
		HashMap<String, String> users = (HashMap<String, String>)app.getAttribute("registeredUsers");
		boolean islogin = true;
		if(users.get(id).contentEquals(password)) {
			HttpSession session = request.getSession(); 
			request.getSession(true).setAttribute("islogin", islogin);
			response.sendRedirect("cart");
		}else {
			String message = "UserID又passwordが間違えました。再入力してください";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
//		
		
	}

}
