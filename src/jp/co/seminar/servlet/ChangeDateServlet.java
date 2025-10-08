

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ChangeDateServlet")
public class ChangeDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ChangeDateServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage;
		try {
			nextPage = request.getContextPath() + "/login.jsp";
		} catch (SecurityException e) {
			e.printStackTrace();
			nextPage = request.getContextPath() + "/login.jsp";
			System.err.println("リクエスト処理不可");
		}
		response.sendRedirect(nextPage);
		return;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String nextPage;
		try {
			String date = request.getParameter("date");
			String page = request.getParameter("page");
			HttpSession session = request.getSession();
			session.getAttribute("meetingroom").getDate(date);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
