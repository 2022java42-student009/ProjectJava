package la.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.BookBean;
import la.dao.BookDAO;
import la.dao.DAOException;

@WebServlet("/BookSerchServlet")
public class BookSerchServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

		if (action == null || action.length() == 0) {
			gotoPage(request, response, "adminbooksearch.jsp");
			
		} else if (action.equals("isbn")) {
			int isbn = Integer.parseInt(request.getParameter("id"));

			try {
				BookDAO dao = new BookDAO();
				List<BookBean> books = dao.findBookByIsbm(isbn);
				request.setAttribute("books", books);
				gotoPage(request, response, "adminbooksearch.jsp");
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
