import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.LoginDAO;

@WebServlet("/membersave")
public class Membersave extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		LoginDAO dao = new LoginDAO();
		dao.membersave(request, response);
		
		RequestDispatcher rd = request.getRequestDispatcher("./main.jsp");
		rd.forward(request, response);
		
	}
}
