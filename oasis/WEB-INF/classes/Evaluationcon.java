import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.soap.AddressingFeature.Responses;

import DAO.ReservationDAO;

@WebServlet("/evaluationcon")
public class Evaluationcon extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8"); //요청 관련 인코딩 처리
		response.setContentType("text/html;charset=utf-8"); //응답 관련 인코딩 처리
		
		ReservationDAO dao = new ReservationDAO();
		dao.evaluation(request, response);
		
		response.sendRedirect("./");
		
	}
}
