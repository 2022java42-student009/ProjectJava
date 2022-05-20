package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.bean.BuyBean;

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
	public List<BuyBean> findAllBuylog() throws DAOException {
		String sql = "SELECT b.user_id, s.stock_id, bo.book_number, s.stock_state, b.selesday, b.price, b.remarks, bo.book_title, bo.category_id, bo.author \n"
				+ "    FROM buy b JOIN stock s ON b.stock_id = s.stock_id \n"
				+ "    JOIN book bo ON s.book_number = bo.book_number;";
		
		
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();) {
			List<BuyBean> list = new ArrayList<BuyBean>();
			while (rs.next()) {
				int userid = rs.getInt("userid");
				
				
				list.add();
			}
			return list;
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}
}