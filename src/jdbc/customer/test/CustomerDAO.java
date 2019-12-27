package jdbc.customer.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.member.exam.DBUtil;

public class CustomerDAO{
	public int insert(CustomerDTO customer) {
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "insert into customer values(?,?,?,sysdate,5000,?)";
		int result = 0;
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, customer.getId());
			stmt.setString(2, customer.getPass());
			stmt.setString(3, customer.getName());
			stmt.setString(4, customer.getAddr());
			result = stmt.executeUpdate();
			System.out.println("등록 완료");
		}catch(SQLException e) {
			System.out.println("등록 실패");
		}finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
	}
	public int update(String id, String addr) {
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "update customer set addr = ? where id = ?";
		int result = 0;
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, addr);
			stmt.setString(2, id);
			result = stmt.executeUpdate();
			System.out.println("수정 완료");
		}catch(SQLException e) {
			System.out.println("수정 실패");
		}finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
	}
	public int delete(String id) {
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "delete customer where id = ?";
		int result = 0;
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			result = stmt.executeUpdate();
			System.out.println("삭제 완료");
		}catch(SQLException e) {
			System.out.println("삭제 실패");
		}finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
	}
}
