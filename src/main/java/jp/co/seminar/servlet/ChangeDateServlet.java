package jp.co.seminar.servlet;

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
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String nextPage;
		try {
			String date = request.getParameter("date");
			String page = request.getParameter("page");
			MeetingRoom meetingroom = (MeetingRoom) session.getAttribute("meetingroom");
			meetingroom.getDate(date);
			nextPage = request.getContextPath() + "/" + page;
			
		} catch (ServletException e) {
			e.printStackTrace();
			System.err.println("リクエスト処理エラー");
			nextPage = request.getContextPath() + "/login.jsp";
			
		}catch (IOException e) {
			e.printStackTrace();
			System.err.println("入出力処理エラー");
			nextPage = request.getContextPath() + "/login.jsp";
		}
		response.sendRedirect(nextPage);
		return;
	}

}
