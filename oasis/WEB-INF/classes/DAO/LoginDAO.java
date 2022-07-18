package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import DTO.Oasis_member;

public class LoginDAO {
	
	public String getCookieValue(Cookie[] cookies, String cookieName) {
		
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals(cookieName)) {
				return cookie.getValue();
			}
		}
		return "";
	}
	
	public int membersave(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
			con = ds.getConnection();

			String sql = "SELECT email, nickname, PHONENUM, PROFILE, SCORE FROM OASIS_MEMBER WHERE EMAIL = ?";
			ps = con.prepareStatement(sql);

			Cookie[] cookies = request.getCookies();
			
			ps.setString(1, getCookieValue(cookies, "member"));
			
			rs = ps.executeQuery();
			rs.next();
			
			
			HttpSession session = request.getSession();
			
			Oasis_member member = new Oasis_member();
			
			member.setEmail(rs.getString(1));
			member.setNickname(rs.getString(2));
			member.setPhonenum(rs.getString(3));
			member.setProfile(rs.getString(4));
			member.setScore(rs.getInt(5));
			
			session.setAttribute("member", member);
			
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
	
	public int login(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
			con = ds.getConnection();

			String sql = "SELECT count(email) FROM OASIS_MEMBER WHERE EMAIL = ?";
			ps = con.prepareStatement(sql);

			ps.setString(1, request.getParameter("email"));
			
			rs = ps.executeQuery();
			rs.next();
			
			if(rs.getInt(1) == 1) {
		        Cookie cookie = new Cookie("member", request.getParameter("email"));
		        
		        response.addCookie(cookie);
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
}
