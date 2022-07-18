import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.Reservation;

@WebServlet("/order")
public class Order extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8"); //요청 관련 인코딩 처리
		response.setContentType("text/html;charset=utf-8"); //응답 관련 인코딩 처리
		
		HttpSession session = request.getSession();
		
		Reservation reservation = (Reservation)session.getAttribute("reservation");
		
		reservation.setDetails_departure(request.getParameter("details_departure"));
		reservation.setDeparture(request.getParameter("departure"));
		reservation.setName(request.getParameter("name"));
		
		session.setAttribute("reservation", reservation);
		
		RequestDispatcher rd = request.getRequestDispatcher("./order.jsp");
		rd.forward(request, response);
		
	}
}
