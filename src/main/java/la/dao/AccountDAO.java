package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import la.bean.AdminBean;
import la.bean.MemberBean;

public class AccountDAO {
	String url = "jdbc:postgresql:projectjava";
//	String url = "jdbc:postgresql:textbook";
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

	// ログインチェック処理
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

	// メソッド名適切か？getAdmin or findAdmin
	public AdminBean findAdmin(String mail) throws DAOException {
		String sql = "select * from admin where mail = ?";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setString(1, mail);
			try (ResultSet rs = st.executeQuery();) {

				if (rs.next()) {

					int id = rs.getInt("admin_id");
					String name = rs.getString("admin_name");
					String address = rs.getString("address");
					String tel = rs.getString("tel");
					String email = rs.getString("mail");
					String birthday = rs.getString("birthday");
					Timestamp admissionday = rs.getTimestamp("admission_day");
					Timestamp leaveday = rs.getTimestamp("leave_day");
					String password = rs.getString("password");

					AdminBean bean = new AdminBean(id, name, address, tel, email, birthday, admissionday, leaveday,
							password);
					return bean;
				} else {
					// ユーザーが見つからなかったらnullを返す
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

	///////// 会員ログインチェック処理

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

	// メソッド名適切か？getMember or findMember
	public MemberBean findMember(String mail) throws DAOException {
		String sql = "select * from member where mail = ?";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setString(1, mail);
			try (ResultSet rs = st.executeQuery();) {

				if (rs.next()) {

					int id = rs.getInt("user_id");
					String name = rs.getString("user_name");
					String address = rs.getString("address");
					String tel = rs.getString("tel");
					String email = rs.getString("mail");
					String birthday = rs.getString("birthday");
					Timestamp admissionday = rs.getTimestamp("admission_day");
					Timestamp leaveday = rs.getTimestamp("leave_day");
					String password = rs.getString("password");

					MemberBean bean = new MemberBean(id, name, address, tel, email, birthday, admissionday, leaveday,
							password);
					return bean;
				} else {
					// ユーザーが見つからなかったらnullを返す
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

	// 会員IDから会員検索
	public List<MemberBean> findMemberById(int id) throws DAOException {
		String sql = "SELECT * FROM member WHERE user_id = ?";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setInt(1, id);
			try (ResultSet rs = st.executeQuery()) {
				List<MemberBean> list = new ArrayList<MemberBean>();
				while (rs.next()) {
					int userid = rs.getInt("user_id");
					String name = rs.getString("user_name");
					String address = rs.getString("address");
					String tel = rs.getString("tel");
					String email = rs.getString("mail");
					String birthday = rs.getString("birthday");
					Timestamp admissionday = rs.getTimestamp("admission_day");
					Timestamp leaveday = rs.getTimestamp("leave_day");
					String password = rs.getString("password");

					MemberBean bean = new MemberBean(userid, name, address, tel, email, birthday, admissionday,
							leaveday, password);
					list.add(bean);
				}
				return list;
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}

	// 会員全員取得
	public List<MemberBean> findAllMember() throws DAOException {
		String sql = "SELECT * FROM member";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();) {
			List<MemberBean> list = new ArrayList<MemberBean>();
			while (rs.next()) {
				int userid = rs.getInt("user_id");
				String name = rs.getString("user_name");
				String address = rs.getString("address");
				String tel = rs.getString("tel");
				String email = rs.getString("mail");
				String birthday = rs.getString("birthday");
				Timestamp admissionday = rs.getTimestamp("admission_day");
				Timestamp leaveday = rs.getTimestamp("leave_day");
				String password = rs.getString("password");

				MemberBean bean = new MemberBean(userid, name, address, tel, email, birthday, admissionday, leaveday,
						password);
				list.add(bean);
			}
			return list;
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}

	// 会員登録

	public void memberRegister(MemberBean member) throws DAOException {

		String sql = "INSERT INTO member(user_name,address,tel,mail,birthday,admission_day,password) VALUES(?,?,?,?,?,current_timestamp,?)";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setString(1, member.getName());
			st.setString(2, member.getAddress());
			st.setString(3, member.getTel());
			st.setString(4, member.getMail());
			st.setString(5, member.getBirthday());
			st.setString(6, member.getPassword());

			st.executeUpdate();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}

	}

	// 会員登録変更(ログインユーザ)
	public int useredit(String name, String address,String tel,String mail, String password,int userid) throws DAOException {

		String sql = "UPDATE member SET user_name=?, address=?, tel=?, mail=?, password=? WHERE user_id = ?";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
//			st.setString(1, member.getName());
//			st.setString(2, member.getAddress());
//			st.setString(3, member.getTel());
//			st.setString(4, member.getMail());
//			st.setString(5, member.getBirthday());
//			st.setString(6, member.getPassword());
		st.setString(1,name);
		st.setString(2,address);
		st.setString(3,tel);
		st.setString(4,mail);
		st.setString(5,password);
		st.setInt(6,userid);
		
			int rows = st.executeUpdate();
			return rows;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}
	}

	// 会員退会(ログインユーザ)
	public void memberDelete(int id) throws DAOException {

		String sql = "UPDATE member SET leave_day = current_timestamp, password = gen_random_uuid() WHERE user_id = ?";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {

			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}

	}

	//管理者　会員アカウント管理
	public void memberEdit(MemberBean member, int id) throws DAOException {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "UPDATE member SET (user_id,user_name,password) = (?,?,?) WHERE user_id = ?";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setInt(1, member.getId());
			st.setString(2, member.getName());
			st.setString(3, member.getPassword());
			st.setInt(4, id);
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
		
	}

}