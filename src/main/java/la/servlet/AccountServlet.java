package la.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import la.dao.AccountDAO;
import la.dao.DAOException;

@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		String action = request.getParameter("action");

		if (action.equals("memberlogin")) {
			String mail = request.getParameter("email");
			String pass = request.getParameter("pass");
			try {
				AccountDAO dao = new AccountDAO();
				if (dao.memberLoginCheck(mail, pass)) {
					HttpSession session = request.getSession();
					session.setAttribute("member", dao.findMember(mail));
					gotoPage(request, response, "usertop.jsp");
				} else {
					request.setAttribute("errmsg", "メールアドレスかパスワードが間違っています。");
					gotoPage(request, response, "userlogin.jsp");
				}

			} catch (DAOException e) {
				e.printStackTrace();

			}
		} else if(action.equals("adminlogin")) {
			String mail = request.getParameter("email");
			String pass = request.getParameter("pass");
			try {
				AccountDAO dao = new AccountDAO();
				if (dao.adminLoginCheck(mail, pass)) {
					HttpSession session = request.getSession();
					session.setAttribute("admin", dao.findAdmin(mail));
					gotoPage(request, response, "admintop.jsp");
				} else {
					request.setAttribute("errmsg", "メールアドレスかパスワードが間違っています。");
					gotoPage(request, response, "adminlogin.jsp");
				}

			} catch (DAOException e) {
				e.printStackTrace();

			}
		} 
		

	}

	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page)
			throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}