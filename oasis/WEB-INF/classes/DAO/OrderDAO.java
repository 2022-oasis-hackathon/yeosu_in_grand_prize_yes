package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import DTO.Oasis_member;
import DTO.Reservation;

public class OrderDAO {
	
	
	
	public void insertOrder(HttpServletResponse response, HttpServletRequest request) {
		response.setContentType("text/html; charset=UTF-8");
		
		Connection con = null;
		PreparedStatement ps = null;

		try {

			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
			con = ds.getConnection();

			String sql = "INSERT INTO reservation\r\n"
					+ "            (idx,\r\n"
					+ "             name,\r\n"
					+ "             strart_time,\r\n"
					+ "             end_time,\r\n"
					+ "             status,\r\n"
					+ "             estimated_time,\r\n"
					+ "             member_email,\r\n"
					+ "             pickup_member_email,\r\n"
					+ "             reward,\r\n"
					+ "             departure,\r\n"
					+ "             details_departure,\r\n"
					+ "             destination,\r\n"
					+ "             details_destination,\r\n"
					+ "             mobility,\r\n"
					+ "             requested,\r\n"
					+ "             text,\r\n"
					+ "             score, departure_lat, departure_lon, destination_lat, destination_lon"
					+ ")\r\n"
					+ "VALUES      (reservation_sq.NEXTVAL,\r\n"
					+ "             ?,\r\n" //1. name
					+ "             To_date(?, 'YYYY-MM-DD HH24:MI:SS'),\r\n" //2. strart_time
					+ "             NULL,\r\n"
					+ "             '픽업대기',\r\n"
					+ "             NULL,\r\n"
					+ "             ?,\r\n" //3. email
					+ "             NULL,\r\n"
					+ "             ?,\r\n" //4. reward
					+ "             ?,\r\n" //5. departure
					+ "             ?,\r\n" //6. details_departure
					+ "             ?,\r\n" //7. destination
					+ "             ?,\r\n" //8. details_destination
					+ "             NULL,\r\n"
					+ "             ?,\r\n" //9. requested
					+ "             ?,\r\n" //10. text
					+ "             NULL, ?, ?, ?, ?)";
			
			ps = con.prepareStatement(sql);
			
			HttpSession session = request.getSession();
			Reservation reservation = (Reservation)session.getAttribute("reservation");
			Oasis_member member = (Oasis_member)session.getAttribute("member");
			
			
			ps.setString(1, reservation.getName());
			ps.setString(2, reservation.getStart_time().replace("T", " "));
			ps.setString(3, member.getEmail());
			ps.setInt(4, reservation.getReward());
			ps.setString(5, reservation.getDeparture());
			ps.setString(6, reservation.getDetails_departure());
			ps.setString(7, reservation.getDestination());
			ps.setString(8, reservation.getDetails_destination());
			ps.setString(9, reservation.getRequested());
			ps.setString(10, reservation.getText());
			ps.setDouble(11, reservation.getDeparture_lat());
			ps.setDouble(12, reservation.getDeparture_lon());
			ps.setDouble(13, reservation.getDestination_lat());
			ps.setDouble(14, reservation.getDestination_lon());
			
			
			
			ps.executeUpdate();
			
	        
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				System.out.print(e2);
			}
		}
	}
}
