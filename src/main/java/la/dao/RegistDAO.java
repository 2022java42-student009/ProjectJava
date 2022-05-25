package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import la.bean.RegistArrangeBean;

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
	public List<RegistArrangeBean> findAllRegist(int userid) throws DAOException {
		String sql = "select stock.stock_id,book.book_number,book.book_title,book.author,bookcategory.category_name,regist_day,regist.price,regist.remarks FROM regist INNER JOIN book ON regist.book_number = book.book_number INNER JOIN bookcategory ON book.category_id = bookcategory.category_id INNER JOIN stock ON stock.stock_id = regist.stock_id WHERE user_id = ?";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setInt(1, userid);

			try (ResultSet rs = st.executeQuery()) {
				List<RegistArrangeBean> list = new ArrayList<RegistArrangeBean>();
				while (rs.next()) {
					int stockid = rs.getInt("stock_id");
					int book = rs.getInt("book_number");
					String title = rs.getString("book_title");
					String author = rs.getString("author");
					String categoryname = rs.getString("category_name");
					Timestamp registday = rs.getTimestamp("regist_day");
					int prise = rs.getInt("price");
					String remarks = rs.getString("remarks");

					// 使用テーブル レジスト ブック ブックカテゴリー
					RegistArrangeBean bean = new RegistArrangeBean(stockid, book, title, author, categoryname,
							registday, prise, remarks);
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

	// 会員用出品本データ削除
	public void deleteRegist(int stock_id) throws DAOException {
		String sql = "DELETE FROM regist WHERE stock_id = ?";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setInt(1, stock_id);

			st.executeUpdate();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}

		String sql2 = "DELETE FROM stock WHERE stock_id = ?";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql2);) {
			st.setInt(1, stock_id);

			st.executeUpdate();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}

	}

	// 出品履歴個別参照
	public List<RegistArrangeBean> findsingleRegist(int stock_id) throws DAOException {
		String sql = "select stock.stock_id,book.book_number,book.book_title,book.author,bookcategory.category_name,regist_day,regist.price,regist.remarks FROM regist INNER JOIN book ON regist.book_number = book.book_number INNER JOIN bookcategory ON book.category_id = bookcategory.category_id INNER JOIN stock ON stock.stock_id = regist.stock_id WHERE stock.stock_id = ?";
		
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setInt(1, stock_id);

			try (ResultSet rs = st.executeQuery();) {

				List<RegistArrangeBean> list = new ArrayList<RegistArrangeBean>();
				while (rs.next()) {
					int stockid = rs.getInt("stock_id");
					int book = rs.getInt("book_number");
					String title = rs.getString("book_title");
					String author = rs.getString("author");
					String categoryname = rs.getString("category_name");
					Timestamp registday = rs.getTimestamp("regist_day");
					int prise = rs.getInt("price");
					String remarks = rs.getString("remarks");

					RegistArrangeBean bean = new RegistArrangeBean(stockid, book, title, author, categoryname,
							registday, prise, remarks);
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

	// 会員用出品データ編集
	public void changeRegist(int stockid, int isbm, int price, String state, String remarks) throws DAOException {
		String sql = "UPDATE regist SET book_number = ?,price = ?,remarks = ? WHERE stock_id = ?;";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setInt(1, isbm);
			st.setInt(2, price);
			st.setString(3, remarks);
			st.setInt(4, stockid);

			st.executeUpdate();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}

		String sql_2 = "UPDATE stock SET book_number = ?,stock_state = ?,price = ?,remarks = ? WHERE stock_id = ?;";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql_2);) {
			st.setInt(1, isbm);
			st.setString(2, state);
			st.setInt(3, price);
			st.setString(4, remarks);
			st.setInt(5, stockid);
			
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}

	// 出品システム
	public void listingRegist(int book_number, String state, int price, String remarks, int userid)
			throws DAOException {
		String sql = "insert into stock(book_number,stock_state,price,remarks) values (?,?,?,?)";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setInt(1, book_number);
			st.setString(2, state);
			st.setInt(3, price);
			st.setString(4, remarks);

			st.executeUpdate();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}

		String sql_2 = "insert into regist(user_id,book_number,regist_day,price,remarks) values (?,?,current_timestamp,?,?)";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql_2);) {
			st.setInt(1, userid);
			st.setInt(2, book_number);
			st.setInt(3, price);
			st.setString(4, remarks);

			st.executeUpdate();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}

}
