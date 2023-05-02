package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import entities.User;
import models.UserModel;

/**
 * Servlet implementation class Cadastro
 */

@WebServlet(name = "Cadastro", urlPatterns = {"/Cadastro"})
public class Cadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 BufferedReader reader = request.getReader();
		 Gson gson = new Gson();

		 User user = gson.fromJson(reader, User.class);
		 
		 UserModel model = new UserModel();
		 
		 try {
			 model.insert(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	     response.setContentType("application/json");
	     response.setCharacterEncoding("UTF-8");
	     String json = gson.toJson(user);
	     response.getWriter().write(json);
	}

}
