package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entities.User;
import factories.ConnectionFactory;

public class UserDao {

	public void insert(User user) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO USERS (name, user_name, email, password) VALUES (?, ?, ?, ?)";
		
		Connection connection = new ConnectionFactory().getConnection();
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		stmt.setString(1, user.getName());
		stmt.setString(2, user.getUser_name());
		stmt.setString(3, user.getEmail());
		stmt.setString(4, user.getPassword());
		
		stmt.execute();
		stmt.close();
		connection.close();
		
	}

}
