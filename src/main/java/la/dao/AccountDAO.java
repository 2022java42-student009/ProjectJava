package la.dao;

//import java.sql.Connection;

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
	
	
	
}