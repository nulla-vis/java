

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.heartrails.Area;
import com.heartrails.Response;

/**
 * Servlet implementation class HRSearchServlet
 */
@WebServlet("/hrsearch")
public class HRSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HRSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hashcodeStr = request.getParameter("area");
		System.out.println("STR" + hashcodeStr);
		HttpSession session = request.getSession();
		if(hashcodeStr == null) {
			//sessionのクリア
//			session.invalidate();
			System.out.println("no data");
		}else {
			System.out.println("Entered");
			int hashCode = Integer.parseInt(hashcodeStr);
			//hashCodeを持つAreaをsessionに保管されたList<Area>
			//から探して、requestに付加する。
			ArrayList<Area> result = (ArrayList<Area>) session.getAttribute("result");
			for(Area a : result) {
				if (a.hashCode() == hashCode) {
					System.out.println("equal");
					System.out.println(a.getPostal());
					System.out.println(a.getCity());
					System.out.println(a.getCity_kana());
					System.out.println(a.getPrefecture());
					System.out.println(a.getTown());
					System.out.println(a.getTown_kana());
					request.setAttribute("detail", a);
				}
			}
		}
		request.getRequestDispatcher("/WEB-INF/hrsearch.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String key = request.getParameter("key");
		Response r = HRJson.search(key);
		//検索されたList<Area>をsessionに付加する。
		ArrayList<Area> result =  (ArrayList<Area>) r.getLocation();
		if (result != null) {
			HttpSession session = request.getSession();
			request.getSession(true).setAttribute("result", result);
		}
		
		request.getRequestDispatcher("/WEB-INF/hrsearch.jsp").forward(request, response);
	}

}
