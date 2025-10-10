package jp.co.seminar.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.seminar.beans.MeetingRoom;
import jp.co.seminar.beans.ReservationBean;


@WebServlet("/CancelServlet")
public class CancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CancelServlet() {
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
		String errorReason = "";
		try {
			MeetingRoom meetingroom = (MeetingRoom) session.getAttribute("meetingroom");
			meetingroom.cancel((ReservationBean)session.getAttribute("cancelresevation"));
			nextPage = request.getContextPath() + "/canceled.jsp";
//		} catch (ServletException e) {
//			e.printStackTrace();
//			System.err.println("リクエスト処理エラー");
//			errorReason = "リクエスト処理エラー";
//			nextPage = "/cancelerror.jsp";
//			
//		}catch (IOException e) {
//			e.printStackTrace();
//			System.err.println("入出力処理エラー");
//			errorReason = "入出力処理エラー";
//			nextPage = "/cancelerror.jsp";
		}catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			errorReason = e.getMessage();
			nextPage = "/cancelerror.jsp";
		}
		request.setAttribute("errorReason", errorReason);
		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

}
