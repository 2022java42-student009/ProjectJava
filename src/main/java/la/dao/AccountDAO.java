package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import la.bean.AdminBean;

public class AccountDAO{
	String url = "jdbc:postgresql:projectjava";
	String user="postgres";
	String pass="himitu";
	
	public AccountDAO() throws DAOException{
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("ドライバの登録に失敗しました");
		}
		
	}
	
	public Object AdminLogin() throws DAOException{
		String sql = "select admin_id,admin_name,mail,password from admin\r\n"
				+ "where mail = 'test@com'and password = 'pass'";
		
		try(Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			
			return null;
		}catch(SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました");
		}
		
	}
	
	
	
}