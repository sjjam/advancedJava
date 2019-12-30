package jdbc.member.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.board.exam.BoardDTO;
import jdbc.board.exam.DBUtil;

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

	@Override
	public ArrayList<MemberDTO> findByAddr(String addr) {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		MemberDTO mem = null;
		String sql = "select * from member where addr like ?";
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "%"+addr+"%");
			rs = stmt.executeQuery();
			while(rs.next()) {//=> 레코드를 조회하기 위해서는
				mem = new MemberDTO(rs.getString(1),
						rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getDate(6),rs.getInt(7));
				list.add(mem);
			}
		}catch(SQLException e) {
			System.out.println("연결실패");
		}finally {
			DBUtil.close(rs, stmt, con);
		}
		return list;
	}
	@Override
	public MemberDTO login(String id, String pass) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from member where id = ? and pass = ?";
		MemberDTO mem = null;
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, pass);
			rs = stmt.executeQuery();
			while(rs.next()) {
				mem = new MemberDTO(rs.getString(1),rs.getString(2),
									rs.getString(3),rs.getString(4),
									rs.getString(5));
			}
		}catch(SQLException e) {
			System.out.println("연결실패");
		}finally {
			DBUtil.close(rs, stmt, con);
		}
		return mem;
	}
	@Override
	public ArrayList<MemberDTO> memberList() {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from member";
		MemberDTO mem = null;
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				mem = new MemberDTO(rs.getString(1),rs.getString(2),
									rs.getString(3),rs.getString(4),
									rs.getString(5),rs.getDate(6),rs.getInt(7));
				list.add(mem);
			}
		}catch(SQLException e) {
			System.out.println("연결실패");
		}finally {
			DBUtil.close(rs, stmt, con);
		}
		return list;
	}
}