package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.bean.BookBean;
import la.bean.CategoryBean;

public class BookDAO {
	private String url = "jdbc:postgresql:projectjava";
	private String user = "postgres";
	private String pass = "himitu";

	public BookDAO() throws DAOException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new DAOException("JDBCドライバの登録に失敗しました。");
		}

	}

//	全ての本を取得
	public List<BookBean> findAllBook() throws DAOException {
		String sql = "SELECT book_number,book_title,c.category_id,c.category_name ,author FROM book INNER JOIN bookcategory c ON book.category_id = c.category_id;";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();) {
			List<BookBean> list = new ArrayList<BookBean>();
			while (rs.next()) {
				int isbm = rs.getInt("book_number");
				String title = rs.getString("book_title");
				int categoryid = rs.getInt("category_id");
				String categoryname = rs.getString("category_name");
				String author = rs.getString("author");

				BookBean bean = new BookBean(isbm, title, categoryid,categoryname, author);
				list.add(bean);
			}
			return list;
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}

	}

	// カテゴリーの取得
	public List<CategoryBean> findAllCategory() throws DAOException {
		String sql = "SELECT * FROM bookcategory ORDER BY category_id";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();) {
			List<CategoryBean> list = new ArrayList<CategoryBean>();
			while (rs.next()) {
				int id = rs.getInt("category_id");
				String name = rs.getString("category_name");
				CategoryBean bean = new CategoryBean(id, name);
				list.add(bean);
			}
			return list;
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}

	}

	// カテゴリーから絞り込み
	/*public List<BookBean> findByCategory(int categoryId) throws DAOException {
		String sql = "SELECT * FROM book WHERE category_id = ? ORDER BY category_id";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setInt(1, categoryId);
			try (ResultSet rs = st.executeQuery();) {
				List<BookBean> list = new ArrayList<BookBean>();
				while (rs.next()) {
					int isbm = rs.getInt("book_number");
					String title = rs.getString("book_title");
					int category = rs.getInt("category_id");
					String author = rs.getString("author");

					BookBean bean = new BookBean(isbm, title, category, author);
					list.add(bean);
				}
				return list;
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
		
	}*/
	

	
	
	//ISBMから本検索
	public BookBean findBookByIsbm(int isbmnumber) throws DAOException{
		String sql = "SELECT book_number,book_title,c.category_id,c.category_name ,author FROM book INNER JOIN bookcategory c ON book.category_id = c.category_id WHERE book_number = ?";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setInt(1, isbmnumber);
			try (ResultSet rs = st.executeQuery();) {
				
				if (rs.next()) {
					int isbm = rs.getInt("book_number");
					String title = rs.getString("book_title");
					int categoryid = rs.getInt("category_id");
					String categoryname = rs.getString("category_name");
					String author = rs.getString("author");

					BookBean bean = new BookBean(isbm, title, categoryid,categoryname, author);
					return bean;
				}
				return null;
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

	public void bookEdit(BookBean book,int isbn) throws DAOException {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "UPDATE book SET (book_number,book_title,category_id,author) = (?,?,?,?) WHERE book_number = ?";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setInt(1, book.getIsbm());
			st.setString(2, book.getTitle());
			st.setInt(3, book.getCategoryid());
			st.setString(4, book.getAuthor());
			st.setInt(5, isbn);
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
		
	}

	public void bookDelete(int isbn) throws DAOException {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "DELETE FROM book WHERE book_number = ?";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setInt(1, isbn);
			
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}

	

	
	
	
	
}
