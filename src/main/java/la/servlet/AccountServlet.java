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
//新規会員登録＆ログイン機能
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
			MemberBean bean = (MemberBean) session.getAttribute("member");
			try {
				AccountDAO dao = new AccountDAO();
				dao.memberRegister(bean);
				gotoPage(request, response, "registerend.jsp");
			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			// ユーザ情報変更（仮） 豊住川瀬担当
		} else if (action.equals("useredit")) {

			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String tel = request.getParameter("tel");
			String mail = request.getParameter("mail");
			String password = request.getParameter("password");
			MemberBean member = new MemberBean();
			member.setName(name);
			member.setAddress(address);
			member.setTel(tel);
			member.setMail(mail);
			member.setPassword(password);

			session.setAttribute("editmember", member);

			gotoPage(request, response, "usereditcheck.jsp");

		} else if (action.equals("edit")) {

			// ユーザ情報変更（仮） 豊住川瀬担当
			try {
				AccountDAO dao = new AccountDAO();
				MemberBean member = (MemberBean) session.getAttribute("member");
				int userid = member.getId();

				MemberBean editmember = (MemberBean) session.getAttribute("editmember");

				dao.useredit(editmember.getName(), editmember.getAddress(), editmember.getTel(), editmember.getMail(),
						editmember.getPassword(), userid);
				
				gotoPage(request, response, "usereditend.jsp");
			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			
//退会機能担当豊住
		} else if (action.equals("end")) {
			try {
				AccountDAO dao = new AccountDAO();
//				int code = Integer.parseInt(request.getParameter("code"));
				
				MemberBean member = (MemberBean) session.getAttribute("member");
				int userid = member.getId();
				dao.memberDelete(userid);
//
//				MemberBean editmember = (MemberBean) session.getAttribute("editmember");
//
//				dao.useredit(editmember.getName(), editmember.getAddress(), editmember.getTel(), editmember.getMail(),
//						editmember.getPassword(), userid);
				
				gotoPage(request, response, "accountdeleteend.jsp");
			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		} else if (action.equals("logout")) {
			session.invalidate();
			gotoPage(request, response, "index.jsp");
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