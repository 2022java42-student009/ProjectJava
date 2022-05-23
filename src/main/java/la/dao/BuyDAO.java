package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import la.bean.BuyArrangeBean;

public class BuyDAO {
	String url = "jdbc:postgresql:projectjava";
	String user = "student";
	String pass = "himitu";

	public BuyDAO() throws DAOException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("ドライバの登録に失敗しました");
		}
	}

	public List<BuyArrangeBean> findAllBuylog(int userid) throws DAOException {
		String sql = "SELECT buy.selesday, book.book_title, stock.book_number,bookcategory.category_name, stock.price FROM buy JOIN stock ON buy.stock_id = stock.stock_id JOIN book ON stock.book_number = book.book_number JOIN bookcategory ON book.category_id = bookcategory.category_id WHERE user_id = ?;";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setInt(1,userid);
			
			try (ResultSet rs = st.executeQuery();) {

				List<BuyArrangeBean> list = new ArrayList<BuyArrangeBean>();
				while (rs.next()) {
					Timestamp selesday = rs.getTimestamp("selesday");
					String title = rs.getString("book_titke");
					int book = rs.getInt("book_number");
					String bookcategory = rs.getString("category_name");
					int price = rs.getInt("price");

					BuyArrangeBean bean = new BuyArrangeBean(selesday, title, book, bookcategory, price);
					list.add(bean);

				}
				return list;
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
				throw new DAOException("レコードの取得に失敗しました。");
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");

		}
	}
}