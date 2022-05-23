package la.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import la.dao.AccountDAO;
import la.dao.DAOException;
import la.dao.RegistDAO;


@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if (action.equals("adminlogin")) {
			String mail = "sample@com";
			String pass = "pass";
			try {
				AccountDAO dao = new AccountDAO();
				if(dao.adminLoginCheck(mail, pass)) {
					System.out.println("login成功！！！");
					request.setAttribute("admin", dao.findAdmin(mail));
					gotoPage(request, response, "/Testadmin.jsp");
				} else {
					request.setAttribute("errmsg", "メールアドレスかパスワードが間違えています");
					gotoPage(request, response, "/Testerr.jsp");
				}
			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			
			
		} 
	}
	*/
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if (action.equals("Registcheck")) {
			int userid = 1;
			try {
				RegistDAO dao = new RegistDAO();
				request.setAttribute("Regist", dao.findAllRegist(userid));
				gotoPage(request, response, "/TestRegist.jsp");

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


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
