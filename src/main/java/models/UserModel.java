package models;

import java.sql.SQLException;

import DAOs.UserDao;
import entities.User;

public class UserModel {
	
	UserDao dao = new UserDao();
	
	public void insert(User user) throws SQLException, ClassNotFoundException {
		dao.insert(user);
	}
}
