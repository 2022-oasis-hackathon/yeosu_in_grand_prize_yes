import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.Reservation;

@WebServlet("/address2")
public class Address2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8"); //요청 관련 인코딩 처리
		response.setContentType("text/html;charset=utf-8"); //응답 관련 인코딩 처리
		

		HttpSession session = request.getSession();
		
		Reservation reservation = new Reservation();
		
		reservation.setDetails_destination(request.getParameter("details_destination"));
		reservation.setDestination(request.getParameter("destination"));
		reservation.setDestination_lat(Double.parseDouble(request.getParameter("destination_lat")));
		reservation.setDestination_lon(Double.parseDouble(request.getParameter("destination_lon")));
		
		session.setAttribute("reservation", reservation);
		
		RequestDispatcher rd = request.getRequestDispatcher("address2.jsp");
		rd.forward(request, response);
		
	}
}
