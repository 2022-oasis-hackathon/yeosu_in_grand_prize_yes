package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


public class SaveimgDAO {
	public int delivery(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
			con = ds.getConnection();

			String sql = "UPDATE RESERVATION SET status = ? WHERE idx = ?";

			ps = con.prepareStatement(sql);
			
			ps.setString(1, request.getParameter("status"));
			ps.setInt(2, Integer.parseInt(request.getParameter("idx")));
			
			ps.executeUpdate();
			System.out.println("업데이트: 저는 끝났습니다!");
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
	
	
	public void insertimg(HttpServletResponse response, HttpServletRequest request, ArrayList<String> list) {
		response.setContentType("text/html; charset=UTF-8");
		
		Connection con = null;
		PreparedStatement ps = null;

		try {
			System.out.println("사진: 저는 시작합니다!");
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
			con = ds.getConnection();

			String sql = "INSERT INTO respicture VALUES (respicture_sq.nextval, ?, ?)";
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(2, Integer.parseInt(request.getParameter("idx")));

			for(String path : list) {
				System.out.println(path);
				ps.setString(1, path);
			}
						
			ps.executeUpdate();
			System.out.println("사진: 저도 끝났습니다!");
			
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
