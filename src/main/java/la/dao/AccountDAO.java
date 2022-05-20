package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import la.bean.AdminBean;
import la.bean.MemberBean;

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
	//ログインチェック処理
	public boolean adminLoginCheck(String mail, String password) throws DAOException {
		String sql = "select * from admin where mail = ? and password = ?";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setString(1, mail);
			st.setString(2, password);
			try (ResultSet rs = st.executeQuery();) {
				if (rs.next()) {
					return true;
				}
				return false;
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
				throw new DAOException("レコードの取得に失敗しました。");
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}

	}
	//メソッド名適切か？getAdmin or findAdmin
	public AdminBean findAdmin(String mail) throws DAOException {
		String sql = "select * from admin where mail = ?";
		
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setString(1, mail);
			try (ResultSet rs = st.executeQuery();) {
				
				if (rs.next()) {
					
					int  id = rs.getInt("admin_id");
					String name = rs.getString("admin_name");
					String address = rs.getString("address");
					int tel = rs.getInt("tel");
					String email = rs.getString("mail");
					String birthday = rs.getString("birthday");
					Timestamp admissionday = rs.getTimestamp("admission_day");
					Timestamp leaveday = rs.getTimestamp("leave_day");
					String password = rs.getString("password");
					
					AdminBean bean = new AdminBean(id, name, address, tel, email, birthday, admissionday, leaveday, password);
					return bean;
				} else {
					//ユーザーが見つからなかったらnullを返す
					return null;
				}
				
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
				throw new DAOException("レコードの取得に失敗しました。");
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}
	
	/////////会員ログインチェック処理
	
	public boolean memberLoginCheck(String mail, String password) throws DAOException {
		String sql = "select * from member where mail = ? and password = ?";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setString(1, mail);
			st.setString(2, password);
			try (ResultSet rs = st.executeQuery();) {
				if (rs.next()) {
					return true;
				}
				return false;
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
				throw new DAOException("レコードの取得に失敗しました。");
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}

	}
	//メソッド名適切か？getMember or findMember
	public MemberBean findMember(String mail) throws DAOException {
		String sql = "select * from member where mail = ?";
		
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setString(1, mail);
			try (ResultSet rs = st.executeQuery();) {
				
				if (rs.next()) {
					
					int  id = rs.getInt("user_id");
					String name = rs.getString("user_name");
					String address = rs.getString("address");
					int tel = rs.getInt("tel");
					String email = rs.getString("mail");
					String birthday = rs.getString("birthday");
					Timestamp admissionday = rs.getTimestamp("admission_day");
					Timestamp leaveday = rs.getTimestamp("leave_day");
					String password = rs.getString("password");
					
					MemberBean bean = new MemberBean(id, name, address, tel, email, birthday, admissionday, leaveday, password);
					return bean;
				} else {
					//ユーザーが見つからなかったらnullを返す
					return null;
				}
				
			} catch (SQLException e) {
				// TODO: handle exception
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