package la.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import la.bean.BuyBean;
import la.bean.MemberBean;
import la.bean.StockBean;
import la.dao.BuyDAO;
import la.dao.DAOException;
import la.dao.StockDAO;

/**
 * Servlet implementation class BuyServlet
 */
@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String action = request.getParameter("action");

		if (action.equals("buylist")) {
			try {
				BuyDAO dao = new BuyDAO();
				MemberBean bean = (MemberBean)session.getAttribute("member");
				session.setAttribute("Buy", dao.findAllBuylog(bean.getId()));
				gotoPage(request, response, "/buyloglist.jsp");
			} catch (DAOException e) {
				e.printStackTrace();
				request.setAttribute("message", "内部エラー発生");
				
			}
		} else if(action.equals("buycheck")) {
			int id = Integer.parseInt(request.getParameter("stockid"));

			try {
				StockDAO dao = new StockDAO();
				StockBean stock = dao.findStockByStockid(id);
				session.setAttribute("stock", stock);
				
				gotoPage(request, response, "buycheck.jsp");
			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}else if(action.equals("buyend")) {
			try {
				StockBean stock = (StockBean) session.getAttribute("stock");
				MemberBean member = (MemberBean) session.getAttribute("member");
				BuyBean bean = new BuyBean(member.getId(), stock.getId(), stock.getPrice(), stock.getRemarks());
				BuyDAO dao = new BuyDAO();
				dao.insertBuy(bean);
				dao.deleteStock(stock.getId());
				
				gotoPage(request, response, "buyend.jsp");
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
