import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CertifiedDAO;

@WebServlet("/certifiedCheck")
public class CertifiedCheck extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		CertifiedDAO cao = new CertifiedDAO();
		out.println(cao.certifiedCheck(request.getParameter("email"), request.getParameter("num")));
		
	}
}
