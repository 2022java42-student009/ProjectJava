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
import la.bean.StockBean;

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
	public List<BookBean> findBookByIsbm(int isbmnumber) throws DAOException{
		String sql = "SELECT book_number,book_title,c.category_id,c.category_name ,author FROM book INNER JOIN bookcategory c ON book.category_id = c.category_id WHERE book_number = ?";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setInt(1, isbmnumber);
			try (ResultSet rs = st.executeQuery();) {
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
	
	//ISBMから在庫検索
	public List<StockBean> findStockByIsbm(int booknumber) throws DAOException{
		String sql = "SELECT stock_id,book.book_number,book.book_title,c.category_id,c.category_name,book.author,stock_state,price,remarks FROM stock INNER JOIN book ON stock.book_number = book.book_number INNER JOIN bookcategory c ON book.category_id = c.category_id WHERE book.book_number = ?";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setInt(1, booknumber);
			try (ResultSet rs = st.executeQuery();) {
				List<StockBean> list = new ArrayList<StockBean>();
				while (rs.next()) {
					int stockid = rs.getInt("stock_id");
					int isbm = rs.getInt("book_number");
					String title = rs.getString("book_title");
					int categoryid = rs.getInt("category_id");
					String categoryname = rs.getString("category_name");
					String author = rs.getString("author");
					String state = rs.getString("stock_state");
					int price = rs.getInt("price");
					String remarks = rs.getString("remarks");

					BookBean book = new BookBean(isbm, title, categoryid,categoryname, author);
					StockBean stock = new StockBean(stockid, book, state, price, remarks);
					list.add(stock);
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
	}
	
	//カテゴリーから在庫検索
	//ISBMから在庫検索
		public List<StockBean> findStockByCategory(int cid) throws DAOException{
			String sql = "SELECT stock_id,book.book_number,book.book_title,c.category_id,c.category_name,book.author,stock_state,price,remarks FROM stock INNER JOIN book ON stock.book_number = book.book_number INNER JOIN bookcategory c ON book.category_id = c.category_id WHERE c.category_id = ?";

			try (Connection con = DriverManager.getConnection(url, user, pass);
					PreparedStatement st = con.prepareStatement(sql);) {
				st.setInt(1, cid);
				try (ResultSet rs = st.executeQuery();) {
					List<StockBean> list = new ArrayList<StockBean>();
					while (rs.next()) {
						int stockid = rs.getInt("stock_id");
						int isbm = rs.getInt("book_number");
						String title = rs.getString("book_title");
						int categoryid = rs.getInt("category_id");
						String categoryname = rs.getString("category_name");
						String author = rs.getString("author");
						String state = rs.getString("stock_state");
						int price = rs.getInt("price");
						String remarks = rs.getString("remarks");

						BookBean book = new BookBean(isbm, title, categoryid,categoryname, author);
						StockBean stock = new StockBean(stockid, book, state, price, remarks);
						list.add(stock);
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
		}
	
	//タイトルから在庫検索
	public List<StockBean> findStockByTitle(String booktitle) throws DAOException{
		String sql = "SELECT stock_id,book.book_number,book.book_title,c.category_id,c.category_name,book.author,stock_state,price,remarks FROM stock INNER JOIN book ON stock.book_number = book.book_number INNER JOIN bookcategory c ON book.category_id = c.category_id WHERE book.book_title LIKE ?";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setString(1, "%"+booktitle+"%");
			try (ResultSet rs = st.executeQuery();) {
				List<StockBean> list = new ArrayList<StockBean>();
				while (rs.next()) {
					int stockid = rs.getInt("stock_id");
					int isbm = rs.getInt("book_number");
					String title = rs.getString("book_title");
					int categoryid = rs.getInt("category_id");
					String categoryname = rs.getString("category_name");
					String author = rs.getString("author");
					String state = rs.getString("stock_state");
					int price = rs.getInt("price");
					String remarks = rs.getString("remarks");

					BookBean book = new BookBean(isbm, title, categoryid,categoryname, author);
					StockBean stock = new StockBean(stockid, book, state, price, remarks);
					list.add(stock);
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
	}
	
	
	//金額絞り込み
	public List<StockBean> findStockByPrice(int rangeid) throws DAOException{
		String sql;
		switch (rangeid) {
		case 0:
			sql = "SELECT stock_id,book.book_number,book.book_title,c.category_id,c.category_name,book.author,stock_state,price,remarks FROM stock INNER JOIN book ON stock.book_number = book.book_number INNER JOIN bookcategory c ON book.category_id = c.category_id WHERE price BETWEEN 0 AND 1000";
			break;
		case 1:
			sql = "SELECT stock_id,book.book_number,book.book_title,c.category_id,c.category_name,book.author,stock_state,price,remarks FROM stock INNER JOIN book ON stock.book_number = book.book_number INNER JOIN bookcategory c ON book.category_id = c.category_id WHERE price BETWEEN 1001 AND 5000 ";
			break;
		case 2:
			sql = "SELECT stock_id,book.book_number,book.book_title,c.category_id,c.category_name,book.author,stock_state,price,remarks FROM stock INNER JOIN book ON stock.book_number = book.book_number INNER JOIN bookcategory c ON book.category_id = c.category_id WHERE price BETWEEN 5001 AND 10000 ";
			break;
		case 3:
			sql = "SELECT stock_id,book.book_number,book.book_title,c.category_id,c.category_name,book.author,stock_state,price,remarks FROM stock INNER JOIN book ON stock.book_number = book.book_number INNER JOIN bookcategory c ON book.category_id = c.category_id WHERE price > 10000 ";
			break;
		default:
			sql = "SELECT stock_id,book.book_number,book.book_title,c.category_id,c.category_name,book.author,stock_state,price,remarks FROM stock INNER JOIN book ON stock.book_number = book.book_number INNER JOIN bookcategory c ON book.category_id = c.category_id";
			break;
		}
		
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();) {
			List<StockBean> list = new ArrayList<StockBean>();
			while (rs.next()) {
				int stockid = rs.getInt("stock_id");
				int isbm = rs.getInt("book_number");
				String title = rs.getString("book_title");
				int categoryid = rs.getInt("category_id");
				String categoryname = rs.getString("category_name");
				String author = rs.getString("author");
				String state = rs.getString("stock_state");
				int price = rs.getInt("price");
				String remarks = rs.getString("remarks");

				BookBean book = new BookBean(isbm, title, categoryid,categoryname, author);
				StockBean stock = new StockBean(stockid, book, state, price, remarks);
				list.add(stock);
			}
			return list;
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}
	
}
