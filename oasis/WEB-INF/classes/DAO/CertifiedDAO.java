package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class CertifiedDAO {
	
	public void deleteCertified(HttpServletResponse response, String email) {
		response.setContentType("text/html; charset=UTF-8");
		
		Connection con = null;
		PreparedStatement ps = null;

		try {

			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
			con = ds.getConnection();

			String sql = "DELETE FROM CERTIFIED WHERE MEMBER_EMAIL = ?";
			
			ps = con.prepareStatement(sql);

			ps.setString(1, email);

			ps.executeQuery();

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
	
	public int certifiedCheck(String email, String num) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
			con = ds.getConnection();

			String sql = "SELECT count(idx) from certified WHERE CERTIFIED_NUM = ? and "
					+ "MEMBER_EMAIL = ? AND "
					+ "wrdate + 5/(24*60) > SYSTIMESTAMP";
			ps = con.prepareStatement(sql);

			ps.setString(1, num);
			ps.setString(2, email);
			
			rs = ps.executeQuery();
			rs.next();
			
			if(rs.getInt(1) == 1) {
				return 1;	
			}
			return 0;
			
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
	
	public void insertCertified(HttpServletResponse response, String email, String num) {
		response.setContentType("text/html; charset=UTF-8");
		
		Connection con = null;
		PreparedStatement ps = null;

		try {

			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
			con = ds.getConnection();

			String sql = "INSERT INTO certified (idx, certified_num, member_email) VALUES (certified_sq.nextval, ?, ?)";
			
			ps = con.prepareStatement(sql);

			ps.setString(1, num);
			ps.setString(2, email);

			ps.executeQuery();

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
