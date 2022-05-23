package la.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.CategoryBean;
import la.bean.StockBean;
import la.dao.BookDAO;
import la.dao.DAOException;

@WebServlet("/StockSerchServlet")
public class StockSerchServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
//		HttpSession session = request.getSession();
		String action = request.getParameter("action");

		if (action == null || action.length() == 0 || action.equals("top")) {
			gotoPage(request, response, "booksearch.jsp");

		} else if (action.equals("category")) {
			int categoryid = Integer.parseInt(request.getParameter("categoryid"));

			try {
				BookDAO dao = new BookDAO();
				List<StockBean> stocks = dao.findStockByCategory(categoryid);
				request.setAttribute("stocks", stocks);
				gotoPage(request, response, "booksearch.jsp");
			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		} else if (action.equals("isbn")) {
			int isbn = Integer.parseInt(request.getParameter("id"));

			try {
				BookDAO dao = new BookDAO();
				List<StockBean> stocks = dao.findStockByIsbm(isbn);
				request.setAttribute("stocks", stocks);
				gotoPage(request, response, "booksearch.jsp");
			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		} else if (action.equals("title")) {
			String title = request.getParameter("name");

			try {
				BookDAO dao = new BookDAO();
				List<StockBean> stocks = dao.findStockByTitle(title);
				request.setAttribute("stocks", stocks);
				gotoPage(request, response, "booksearch.jsp");
			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		} else if (action.equals("price")) {
			int range = Integer.parseInt(request.getParameter("pricerange"));

			try {
				BookDAO dao = new BookDAO();
				List<StockBean> stocks = dao.findStockByPrice(range);
				request.setAttribute("stocks", stocks);
				gotoPage(request, response, "booksearch.jsp");
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

	public void init() throws ServletException {
		try {
			BookDAO dao = new BookDAO();
			List<CategoryBean> list = dao.findAllCategory();
			getServletContext().setAttribute("categories", list);
		} catch (DAOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
