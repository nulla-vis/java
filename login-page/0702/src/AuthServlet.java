

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AuthServlet
 */
@WebServlet("/auth")
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
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userID = request.getParameter("userID");
		String password = request.getParameter("password");
		String message = "そのユーザーデータがありません。";
		ServletContext app = getServletContext();
		HashMap<String, String> users = (HashMap<String, String>)app.getAttribute("registeredUsers");
		
		if(users.get(userID).contentEquals(password)) {
			request.setAttribute("userID", userID);
			System.out.println(password);
			System.out.println(users.get(userID).contentEquals(password));
			request.getRequestDispatcher("/WEB-INF/welcome.jsp").forward(request, response);
		}else {
			request.setAttribute("message", message);;
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
//		
		
	}

}
