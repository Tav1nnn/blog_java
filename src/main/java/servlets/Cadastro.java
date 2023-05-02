package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class Cadastro
 */
public class Cadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Gson gson = new Gson();

		Person person = new Person();
		person.setName("João");
		person.setAddress("Rua do Meio");

		String json = gson.toJson(person);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 Gson gson = new Gson();

	     Person person = gson.fromJson(request.getReader(), Person.class);
	     response.setContentType("application/json");
	     response.setCharacterEncoding("UTF-8");
	     String json = gson.toJson(person);
	     response.getWriter().write(json);
	}

}
