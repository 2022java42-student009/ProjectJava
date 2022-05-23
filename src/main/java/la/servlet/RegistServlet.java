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
import la.dao.DAOException;
import la.dao.RegistDAO;

@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String action = request.getParameter("action");
		
		if(action.equals("registlist")) {
			try {
			RegistDAO dao = new RegistDAO();
			MemberBean bean = (MemberBean)session.getAttribute("member");
			session.setAttribute("Regist", dao.findAllRegist(bean.getId()));
			System.out.println(bean.getId());//テストコード
			gotoPage(request, response, "/exhibitloglist.jsp");
			
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
