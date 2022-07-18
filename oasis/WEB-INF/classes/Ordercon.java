import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.OrderDAO;
import DTO.Reservation;

@WebServlet("/ordercon")
public class Ordercon extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8"); //요청 관련 인코딩 처리
		response.setContentType("text/html;charset=utf-8"); //응답 관련 인코딩 처리
		
		HttpSession session = request.getSession();
		
		Reservation reservation = (Reservation)session.getAttribute("reservation");
		
		reservation.setStart_time(request.getParameter("strart_time"));
		reservation.setReward(Integer.parseInt(request.getParameter("reward")));
		reservation.setText(request.getParameter("text"));
		reservation.setRequested(request.getParameter("requested"));
		
		session.setAttribute("reservation", reservation);
		
		OrderDAO dao = new OrderDAO();
		dao.insertOrder(response, request);
		
		response.sendRedirect("./main.jsp");
		
	}
}
