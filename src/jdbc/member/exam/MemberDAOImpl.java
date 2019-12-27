package jdbc.member.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberDAOImpl implements MemberDAO{
	public int insert(MemberDTO user) {
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "insert into member values(?,?,?,?,?,sysdate,1000)";
		int result = 0;
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, user.getId());
			stmt.setString(2, user.getPass());
			stmt.setString(3, user.getName());
			stmt.setString(4, user.getAddr());
			stmt.setString(5, user.getDeptno());
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
		String sql = "update member set addr = ? where id = ?";
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
		String sql = "delete member where id = ?";
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
