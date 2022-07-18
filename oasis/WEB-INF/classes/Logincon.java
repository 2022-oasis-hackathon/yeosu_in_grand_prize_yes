import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.LoginDAO;

@WebServlet("/logincon")
public class Logincon extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String path = "";
		LoginDAO dao = new LoginDAO();
		
		
		if(dao.login(request, response) == 1) {
	        Cookie cookie = new Cookie("member", request.getParameter("email"));
	        
	        response.addCookie(cookie);
			path = "./membersave";
		}else {
			path = "./";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
		
	}
}
