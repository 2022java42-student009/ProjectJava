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

import la.bean.BookBean;
import la.bean.CategoryBean;
import la.dao.BookDAO;
import la.dao.DAOException;

@WebServlet("/BookManagementServlet")
public class BookManagementServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String action = request.getParameter("action");

		if (action == null || action.length() == 0) {
			try {
				BookDAO dao = new BookDAO();
				List<BookBean> books = dao.findAllBook();
				request.setAttribute("books", books);
				gotoPage(request, response, "adminbooksearch.jsp");
			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} 
			
		} else if (action.equals("isbn")) {
			int isbn = Integer.parseInt(request.getParameter("id"));

			try {
				BookDAO dao = new BookDAO();
				BookBean book = dao.findBookByIsbm(isbn);
				request.setAttribute("book", book);
				gotoPage(request, response, "adminbooksearch.jsp");
			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		} else if (action.equals("edit")) {
			int isbn = Integer.parseInt(request.getParameter("id"));

			try {
				BookDAO dao = new BookDAO();
				BookBean book = dao.findBookByIsbm(isbn);
				request.setAttribute("book", book);
				session.setAttribute("beforeisbn", book.getIsbm());
				gotoPage(request, response, "bookmanagement.jsp");
			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		} else if (action.equals("editcheck")) {
			int isbn = Integer.parseInt(request.getParameter("number"));
			String[] category = request.getParameter("category").split(",");;
			int categoryid = Integer.parseInt(category[0]);
			String categoryname = category[1];
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			BookBean book = new BookBean(isbn, title, categoryid, categoryname, author);
			session.setAttribute("book", book);
			gotoPage(request, response, "bookmanagementcheck.jsp");


		} else if (action.equals("editcheckend")) {
			
			BookBean book =  (BookBean) session.getAttribute("book");
			int isbn = (int) session.getAttribute("beforeisbn");

			try {
				BookDAO dao = new BookDAO();
				dao.BookEdit(book,isbn);
				
				gotoPage(request, response, "bookmanagementend.jsp");
			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		} else if (action.equals("deletecheck")) {
			
			int isbn = Integer.parseInt(request.getParameter("number"));
			session.setAttribute("isbn", isbn);
			
			gotoPage(request, response, "bookdeletecheck.jsp");


		} else if (action.equals("deletecheckend")) {
			
			int isbn = (int) session.getAttribute("isbn");
			

			try {
				BookDAO dao = new BookDAO();
				dao.BookDelete(isbn);
				
				gotoPage(request, response, "bookdeleteend.jsp");
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
