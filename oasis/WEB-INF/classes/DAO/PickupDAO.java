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

import DTO.Reservation;

public class PickupDAO {

	public void pickupList(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		HttpSession session = request.getSession();
		
		System.out.println("pickuplist start");
		
		ArrayList<Reservation> list = new ArrayList<Reservation>();
		
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
			con = ds.getConnection();

			String sql = "SELECT idx, DEPARTURE, DESTINATION, STRART_TIME, REWARD, name FROM reservation";
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();

			while(rs.next()) {
				Reservation reservation = new Reservation();
				reservation.setIdx(rs.getInt(1));
				reservation.setDeparture(rs.getString(2));
				reservation.setDestination(rs.getString(3));
				reservation.setReward(rs.getInt(4));
				reservation.setName(rs.getString(5));
				System.out.println(reservation.getIdx());
				list.add(reservation);
			}
			
			request.setAttribute("pickuplist", list);
			System.out.println("pickuplist end");
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
