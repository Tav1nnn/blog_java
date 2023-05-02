package factories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() throws ClassNotFoundException {
		try {
			
			  	String url = "jdbc:postgresql://localhost:5432/blog_java";
	            String user = "postgres";
	            String password = "123";
	            Class.forName("org.postgresql.Driver");
	            return DriverManager.getConnection(url, user, password);
	            
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Erro ao conectar: " + e.getMessage());
		}
		return null;
	}
}
