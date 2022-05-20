package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import la.bean.RegistBean;

public class RegistDAO {
	private String url = "jdbc:postgresql:projectjava";
	private String user = "postgres";
	private String pass = "himitu";

	public RegistDAO() throws DAOException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new DAOException("JDBCドライバの登録に失敗しました。");
		}

	}

	// 登録された本全データ
	public List<RegistBean> findAllRegist() throws DAOException {
		String sql = "select book.book_number,book.book_title,book.author,bookcategory.category_name,regist_day,price,remarks FROM regist INNER JOIN book ON regist.book_number = book.book_number INNER JOIN bookcategory ON book.category_id = bookcategory.category_id WHERE user_id = ?";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();) {
			
			List<RegistBean>list = new ArrayList<RegistBean>();
			while(rs.next()) {
				int book = rs.getInt("book_number");
				String title = rs.getString("book_title");
				String author = rs.getString("author");
				String categoryname = rs.getString("category_name");
				Timestamp registday = rs.getTimestamp("regist_day");
				int prise = rs.getInt("price");
				String remarks = rs.getString("remarks");
				
				
				
				
				
			}
			
			return list;
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}

	// 会員IDでソートされたデータ
	

	// 会員ようデータ料金変更

}
