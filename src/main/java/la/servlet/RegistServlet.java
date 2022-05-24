package la.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import la.bean.BookBean;
import la.bean.MemberBean;
import la.bean.StockBean;
import la.dao.BookDAO;
import la.dao.DAOException;
import la.dao.RegistDAO;

@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		String action = request.getParameter("action");

		if (action.equals("registlist")) {
			try {
				RegistDAO dao = new RegistDAO();
				MemberBean bean = (MemberBean) session.getAttribute("member");
				session.setAttribute("Regist", dao.findAllRegist(bean.getId()));
				gotoPage(request, response, "/exhibitloglist.jsp");

			} catch (DAOException e) {
				e.printStackTrace();
			}

			// 出品
		} else if (action.equals("listingcheck")) {
			try {
				int isbm = Integer.parseInt(request.getParameter("number"));
				int price = Integer.parseInt(request.getParameter("price"));
				String state = request.getParameter("example");
				String remarks = request.getParameter("remarks");
				BookDAO dao = new BookDAO();
				BookBean book = (BookBean) dao.findBookByIsbm(isbm);

				MemberBean bean = (MemberBean) session.getAttribute("member");
				StockBean Sbean = new StockBean(bean.getId(), book, state, price, remarks);

				session.setAttribute("listingdata", Sbean);
				gotoPage(request, response, "/exhibitcheck.jsp");

			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		} else if (action.equals("listing")) {

			try {
				RegistDAO dao = new RegistDAO();
				StockBean Sbean = (StockBean) session.getAttribute("listingdata");
				MemberBean bean = (MemberBean) session.getAttribute("member");
				dao.listingRegist(Sbean.getBook().getIsbm(), Sbean.getState(), Sbean.getPrice(), Sbean.getRemarks(),
						bean.getId());
				gotoPage(request, response, "/exhibitend.jsp");
			} catch (DAOException e) {
				e.printStackTrace();
			}

		}else if(action.equals("deletecheck")) {
				int listnumber = Integer.parseInt(request.getParameter("listnumber"));
				session.setAttribute("delete", listnumber);
				System.out.println(listnumber);
				
				gotoPage(request, response, "/exhibitdeletecheck.jsp");
			
		}else if(action.equals("deletelist")) {
			try {
				int number = (int)session.getAttribute("delete");
				RegistDAO dao = new RegistDAO();
				dao.deleteRegist(number);
		
				gotoPage(request, response, "/exhibitdeleteend.jsp");
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
