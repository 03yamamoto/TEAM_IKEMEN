package jp.co.seminar.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
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

		MeetingRoom meetingroom = new MeetingRoom();
		String nextPage;
		
		try {
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		
//		ログイン処理をMeetingroomのloginメソッドを用いて行う
		if (meetingroom.login(userId,userPw)) {
			HttpSession session = request.getSession();
			if (session.isNew()) {
				session.setMaxInactiveInterval(60 * 15);
				session.getAttribute("meetingroom",meetingroom);
			}
			nextPage = request.getContextPath() + "/menu.jsp";
		}else {
			nextPage = request.getContextPath() + "/login.jsp";
		}
		}catch (ServletException e) {
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
