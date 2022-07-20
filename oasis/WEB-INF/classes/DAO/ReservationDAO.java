package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import DTO.Oasis_member;
import DTO.Reservation;


public class ReservationDAO {
	
	public void pickdownPhone(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
			con = ds.getConnection();

			String sql = "SELECT m.phonenum FROM RESERVATION r JOIN"
					+ " oasis_MEMBER m ON "
					+ "r.MEMBER_EMAIL = m.EMAIL "
					+ "WHERE r.idx = ?";
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, Integer.parseInt(request.getParameter("idx")));
			
			rs = ps.executeQuery();
			rs.next();
			
			request.setAttribute("pickdownPhone", rs.getString(1));
			
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
				if (rs != null)
					rs.close();
			} catch (Exception e2) {
				System.out.print(e2);
			}
		}

	}
	
	public void pickupPhone(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
			con = ds.getConnection();

			String sql = "SELECT m.phonenum FROM RESERVATION r JOIN"
					+ " oasis_MEMBER m ON "
					+ "r.PICKUP_MEMBER_EMAIL = m.EMAIL "
					+ "WHERE r.idx = ?";
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, Integer.parseInt(request.getParameter("idx")));
			
			rs = ps.executeQuery();
			rs.next();
			
			request.setAttribute("pickupPhone", rs.getString(1));
			
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
				if (rs != null)
					rs.close();
			} catch (Exception e2) {
				System.out.print(e2);
			}
		}

	}
	
	public int evaluation(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
			con = ds.getConnection();

			String sql = "UPDATE reservation SET SCORE = ? WHERE idx = ?";

			ps = con.prepareStatement(sql);

			
			ps.setInt(1, Integer.parseInt(request.getParameter("score")));
			ps.setInt(2, Integer.parseInt(request.getParameter("idx")));
			
			ps.executeUpdate();

		} catch (Exception e) {
			System.out.print(e);
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
				if (rs != null)
					rs.close();
			} catch (Exception e2) {
				System.out.print(e2);
			}
		}
		return 0;

	}
	
	public int delivery(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		HttpSession session = request.getSession();
		
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
			con = ds.getConnection();

			String sql = "UPDATE RESERVATION SET PICKUP_MEMBER_EMAIL = ?, status = ?  WHERE idx = ?";

			ps = con.prepareStatement(sql);

			
			
			Oasis_member member = (Oasis_member)session.getAttribute("member");
			
			ps.setString(1, member.getEmail());
			ps.setString(2, request.getParameter("status"));
			ps.setInt(3, Integer.parseInt(request.getParameter("idx")));
			
			ps.executeUpdate();

		} catch (Exception e) {
			System.out.print(e);
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
				if (rs != null)
					rs.close();
			} catch (Exception e2) {
				System.out.print(e2);
			}
		}
		return 0;

	}
	
	public int reservation(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
			con = ds.getConnection();

			String sql = "SELECT idx, strart_time, status, member_email, reward,\r\n"
					+ "					 departure, details_departure, destination,\r\n"
					+ "					 details_destination, requested, departure_lat, "
					+ "departure_lon, destination_lat, destination_lon, text FROM reservation WHERE idx = ?";

			ps = con.prepareStatement(sql);

			ps.setInt(1, Integer.parseInt(request.getParameter("idx")));
			
			rs = ps.executeQuery();
			
			rs.next();

			Reservation reservation = new Reservation();
			reservation.setIdx(rs.getInt(1));
			reservation.setStart_time(rs.getString(2));
			reservation.setStatus(rs.getString(3));
			reservation.setMember_email(rs.getString(4));
			reservation.setReward(rs.getInt(5));
			reservation.setDeparture(rs.getString(6));
			reservation.setDetails_departure(rs.getString(7));
			reservation.setDestination(rs.getString(8));
			reservation.setDetails_destination(rs.getString(9));
			reservation.setRequested(rs.getString(10));
			reservation.setDeparture_lat(rs.getDouble(11));
			reservation.setDeparture_lon(rs.getDouble(12));
			reservation.setDestination_lat(rs.getDouble(13));
			reservation.setDestination_lon(rs.getDouble(14));
			reservation.setText(rs.getString(15));
			
			request.setAttribute("reservation", reservation);
			
			
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
				if (rs != null)
					rs.close();
			} catch (Exception e2) {
				System.out.print(e2);
			}
		}
		return 0;

	}
}
