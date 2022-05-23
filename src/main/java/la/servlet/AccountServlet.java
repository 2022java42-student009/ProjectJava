package la.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import la.bean.MemberBean;
import la.dao.AccountDAO;
import la.dao.DAOException;

@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		String action = request.getParameter("action");

		if (action.equals("memberlogin")) {
			String mail = request.getParameter("email");
			String pass = request.getParameter("pass");
			try {
				AccountDAO dao = new AccountDAO();
				if (dao.memberLoginCheck(mail, pass)) {
					session.setAttribute("member", dao.findMember(mail));
					session.setAttribute("loginstate", true);
					gotoPage(request, response, "usertop.jsp");
				} else {
					request.setAttribute("errmsg", "メールアドレスかパスワードが間違っています。");
					gotoPage(request, response, "userlogin.jsp");
				}

			} catch (DAOException e) {
				e.printStackTrace();

			}
		} else if (action.equals("adminlogin")) {
			String mail = request.getParameter("email");
			String pass = request.getParameter("pass");
			try {
				AccountDAO dao = new AccountDAO();
				if (dao.adminLoginCheck(mail, pass)) {
					
					session.setAttribute("admin", dao.findAdmin(mail));
					session.setAttribute("loginstate", true);
					gotoPage(request, response, "admintop.jsp");
				} else {
					request.setAttribute("errmsg", "メールアドレスかパスワードが間違っています。");
					gotoPage(request, response, "adminlogin.jsp");
				}

			} catch (DAOException e) {
				e.printStackTrace();

			}
		} else if (action.equals("registercheck")) {
			String name = request.getParameter("username");
			String address = request.getParameter("address");
			String tel = request.getParameter("tel");
			String mail = request.getParameter("mail");
			String birthday = request.getParameter("birthday");
			String password = request.getParameter("password");

			MemberBean bean = new MemberBean(name, address, tel, mail, birthday, password);
			
			session.setAttribute("member", bean);
			gotoPage(request, response, "registercheck.jsp");

		} else if (action.equals("register")) {
			MemberBean bean =  (MemberBean) session.getAttribute("member");
			try {
				AccountDAO dao = new AccountDAO();
				dao.memberRegister(bean);
				gotoPage(request, response, "registerend.jsp");
			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック
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