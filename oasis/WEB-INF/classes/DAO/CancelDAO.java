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

public class CancelDAO {
	public int insertCancel(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		HttpSession session = request.getSession();
		
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
			con = ds.getConnection();

			String sql = "INSERT INTO CANCELLATION (idx, reason, text, RESERVATION_IDX, MEMBER_EMAIL)"
					+ " VALUES (cancellation_sq.nextval, ?, ?, ?, ?)";

			ps = con.prepareStatement(sql);
			
			Oasis_member member = (Oasis_member)session.getAttribute("member");
			
			ps.setString(1, request.getParameter("reason"));
			ps.setString(2, request.getParameter("text"));
			ps.setInt(3, Integer.parseInt(request.getParameter("idx")));
			ps.setString(4, member.getEmail());
			
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
	
	public int cancel(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
			con = ds.getConnection();

			String sql = "UPDATE RESERVATION SET PICKUP_MEMBER_EMAIL = null, status = '픽업대기'  WHERE idx = ?";

			ps = con.prepareStatement(sql);
			
			ps.setInt(1, Integer.parseInt(request.getParameter("idx")));
			
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
}
