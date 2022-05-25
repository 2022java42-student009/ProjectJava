package la.servlet;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/AccountManagementServlet")
public class AccountManagementServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		String action = request.getParameter("action");

		if (action == null || action.length() == 0) {
			try {
				AccountDAO dao = new AccountDAO();
				List<MemberBean> members = dao.findAllMember();
				request.setAttribute("users", members);
				gotoPage(request, response, "usersearch.jsp");
			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		} else if (action.equals("usersearch")) {
			int id = Integer.parseInt(request.getParameter("id"));
			
			try {
				AccountDAO dao = new AccountDAO();
				List<MemberBean> members = dao.findMemberById(id);
				request.setAttribute("users", members);
				
				gotoPage(request, response, "usersearch.jsp");
			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		} else if (action.equals("edit")) {
			int id = Integer.parseInt(request.getParameter("id"));

			try {
				AccountDAO dao = new AccountDAO();
				List<MemberBean> members = dao.findMemberById(id);
				session.setAttribute("user", members.get(0));
				session.setAttribute("beforeid", members.get(0).getId());
				gotoPage(request, response, "usermanagement.jsp");
			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		} else if (action.equals("editcheck")) {
			int id = Integer.parseInt(request.getParameter("userid"));
			String name = request.getParameter("username");
			String pass = request.getParameter("userpass");
			MemberBean member = new MemberBean();
			member.setId(id);
			member.setName(name);
			member.setPassword(pass);
			session.setAttribute("editmember", member);
			gotoPage(request, response, "usermanagementcheck.jsp");

		} else if (action.equals("editcheckend")) {

			MemberBean member = (MemberBean) session.getAttribute("editmember");
			int id = (int) session.getAttribute("beforeid");

			try {
				AccountDAO dao = new AccountDAO();
				dao.memberEdit(member, id);

				gotoPage(request, response, "usermanagementend.jsp");
			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		} else if (action.equals("deletecheck")) {

			gotoPage(request, response, "userdeletecheck.jsp");

		} else if (action.equals("deletecheckend")) {
			
			int id = (int) session.getAttribute("beforeid");
			System.out.println("log");

			try {
				AccountDAO dao = new AccountDAO();
				dao.memberDelete(id);
				
				gotoPage(request, response, "userdeleteend.jsp");
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