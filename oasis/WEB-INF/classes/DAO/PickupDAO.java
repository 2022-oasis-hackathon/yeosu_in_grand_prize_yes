package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import DTO.Oasis_member;
import DTO.Reservation;

public class PickupDAO {

	public void pickdownlist(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		HttpSession session = request.getSession();
		
		System.out.println("pickdownlist start");
		
		ArrayList<Reservation> list = new ArrayList<Reservation>();
		
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
			con = ds.getConnection();

			String sql = "SELECT idx, DEPARTURE, DESTINATION, STRART_TIME, REWARD,"
					+ " name, m.PROFILE, ESTIMATED_TIME, STATUS FROM reservation r "
					+ "JOIN OASIS_MEMBER m "
					+ "on m.EMAIL = r.MEMBER_EMAIL "
					+ "WHERE r.PICKUP_MEMBER_EMAIL = ?";
			
			ps = con.prepareStatement(sql);
			
			Oasis_member member = (Oasis_member)session.getAttribute("member");
			ps.setString(1, member.getEmail());
			
			
			rs = ps.executeQuery();

			while(rs.next()) {
				Reservation reservation = new Reservation();
				reservation.setIdx(rs.getInt(1));
				reservation.setDeparture(rs.getString(2));
				reservation.setDestination(rs.getString(3));
				reservation.setStart_time(rs.getString(4));
				reservation.setReward(rs.getInt(5));
				reservation.setName(rs.getString(6));
				reservation.setProfile(rs.getString(7));
				reservation.setEstimate_time(rs.getString(8));
				reservation.setStatus(rs.getString(9));
				System.out.println(reservation.getIdx());
				list.add(reservation);
			}
			
			request.setAttribute("pickdownlist", list);
			System.out.println("pickdownlist end");
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
			
			
			rs = ps.executeQuery();
			rs.next();
			
			request.setAttribute("phone", rs.getString(1));
			
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
	
	public void orderList(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		HttpSession session = request.getSession();
		
		System.out.println("orderList start");
		
		ArrayList<Reservation> list = new ArrayList<Reservation>();
		
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
			con = ds.getConnection();

			String sql = "SELECT idx, DEPARTURE, DESTINATION, STRART_TIME, REWARD,"
					+ " name, m.PROFILE, ESTIMATED_TIME, STATUS FROM reservation r "
					+ "JOIN OASIS_MEMBER m "
					+ "on m.EMAIL = r.MEMBER_EMAIL "
					+ "WHERE r.MEMBER_EMAIL = ?";
			
			ps = con.prepareStatement(sql);
			
			Oasis_member member = (Oasis_member)session.getAttribute("member");
			ps.setString(1, member.getEmail());
			
			
			rs = ps.executeQuery();

			while(rs.next()) {
				Reservation reservation = new Reservation();
				reservation.setIdx(rs.getInt(1));
				reservation.setDeparture(rs.getString(2));
				reservation.setDestination(rs.getString(3));
				reservation.setStart_time(rs.getString(4));
				reservation.setReward(rs.getInt(5));
				reservation.setName(rs.getString(6));
				reservation.setProfile(rs.getString(7));
				reservation.setEstimate_time(rs.getString(8));
				reservation.setStatus(rs.getString(9));
				System.out.println(reservation.getIdx());
				list.add(reservation);
			}
			
			request.setAttribute("orderList", list);
			System.out.println("orderList end");
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
	
	public void pickupList(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		ArrayList<Reservation> list = new ArrayList<Reservation>();
		
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
			con = ds.getConnection();

			String sql = "SELECT idx, DEPARTURE, DESTINATION, STRART_TIME, REWARD,"
					+ " name, m.PROFILE, departure_lat, departure_lon, destination_lat, destination_lon FROM reservation r JOIN"
					+ " OASIS_MEMBER m on m.EMAIL = r.MEMBER_EMAIL WHERE status = '픽업대기'";
			
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();

			while(rs.next()) {
				Reservation reservation = new Reservation();
				reservation.setIdx(rs.getInt(1));
				reservation.setDeparture(rs.getString(2));
				reservation.setDestination(rs.getString(3));
				reservation.setStart_time(rs.getString(4));
				reservation.setReward(rs.getInt(5));
				reservation.setName(rs.getString(6));
				reservation.setProfile(rs.getString(7));
				reservation.setDeparture_lat(rs.getDouble(8));
				reservation.setDeparture_lon(rs.getDouble(9));
				reservation.setDestination_lat(rs.getDouble(10));
				reservation.setDestination_lon(rs.getDouble(11));
				
				list.add(reservation);
			}
			
			request.setAttribute("pickuplist", list);
			
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
	
}
