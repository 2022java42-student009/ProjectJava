package la.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
					request.setAttribute("member", dao.findMember(mail));
					gotoPage(request, response, "usertop.jsp");
				} else {
					request.setAttribute("errmsg", "メールアドレスかパスワードが間違っています。");
					gotoPage(request, response, "userlogin.jsp");
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