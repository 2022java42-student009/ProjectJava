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
		String sql = "SELECT * FROM regist";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();) {
			
			List<RegistBean>list = new ArrayList<RegistBean>();
			while(rs.next()) {
				int id = rs.getInt("user_id");
				int isbm = rs.getInt("book_number");
				Timestamp day= rs.getTimestamp("regist_day");
				int price = rs.getInt("price");
				String remarks = rs.getString("remarks");
				
				RegistBean bean = new RegistBean(id,isbm,day,price,remarks);
				list.add(bean);
			}
			
			return list;
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}

	// 会員IDでソートされたデータ

	// 会員ようデータ

}
