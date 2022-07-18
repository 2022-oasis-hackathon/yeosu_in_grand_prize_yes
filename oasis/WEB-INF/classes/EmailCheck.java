import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.LoginDAO;

@WebServlet("/emailcheck")
public class EmailCheck extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		LoginDAO dao = new LoginDAO();
		if(dao.login(request, response) == 1) {
			out.print(1);
		}else {
			out.print(0);
		}
	}
}
