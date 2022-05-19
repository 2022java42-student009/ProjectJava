package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import la.bean.AdminBean;

public class AccountDAO {
	String url = "jdbc:postgresql:projectjava";
	String user = "postgres";
	String pass = "himitu";

	public AccountDAO() throws DAOException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("ドライバの登録に失敗しました");
		}

	}

	public AdminBean AdminLogin(String mail, String password) throws DAOException {
		String sql = "select admin_id,admin_name from admin where mail = '?'and password = '?'";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();) {

			st.setString(1, mail);
			st.setString(2, password);

			String id = rs.getString("admin_id");
			String name = rs.getString("admin_name");

			AdminBean bean = new AdminBean(id, name);

			return bean;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました");
		}

	}

}