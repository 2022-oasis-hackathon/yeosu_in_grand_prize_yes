package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class JoinDAO {
	
	
	
	public void insertMember(HttpServletResponse response, HttpServletRequest request, ArrayList<String> list) {
		response.setContentType("text/html; charset=UTF-8");
		
		Connection con = null;
		PreparedStatement ps = null;

		try {

			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
			con = ds.getConnection();

			String sql = "INSERT INTO OASIS_MEMBER (email, NICKNAME, PHONENUM, PROFILE, score) "
					+ "VALUES (?, ?, ?, ?, 50)";
			
			ps = con.prepareStatement(sql);

			ps.setString(1, request.getParameter("email"));
			ps.setString(2, request.getParameter("nick"));
			ps.setString(3, request.getParameter("phone"));
			ps.setString(4, "/upload/oasis_profile/profileindex.png");
			
			
			
			for(String path : list) {
				System.out.println(path);
				ps.setString(4, path);
			}
						
			ps.executeQuery();

	        Cookie cookie = new Cookie("member", request.getParameter("email"));
	        
	        response.addCookie(cookie);
			
	        
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
