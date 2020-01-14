package jdbc.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.board.exam.DBUtil;

public class DeptDAOImpl implements DeptDAO{

	@Override
	public int insert(DeptDTO dept) {
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "insert into dept values(?,?,?)";
		int result = 0;
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, dept.getDeptno());
			stmt.setString(2, dept.getDname());
			stmt.setString(3, dept.getLoc_code());
			result = stmt.executeUpdate();
			System.out.println(result+"개 행 삽입성공");
		}catch(SQLException e) {
			System.out.println("연결실패:");
			e.printStackTrace();//오류추적
		}finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
	}

	@Override
	public DeptDTO getDeptInfo(int deptno) {
		Connection con = null;
		PreparedStatement stmt = null;
		String sql ="select * from dept where deptno = ?";
		DeptDTO dept = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, deptno);
			rs = stmt.executeQuery();
			if(rs.next()) {//결과가 하나이므로 while말고 if도 가능
				dept = new DeptDTO(rs.getInt(1),rs.getString(2),rs.getString(3));
			}
			
		}catch(SQLException E) {
			System.out.println("연결실패:");
		}finally {
			DBUtil.close(null, stmt, con);
		}
		return dept;
	}

	@Override
	public int update(DeptDTO dept) {
		Connection con = null;
		PreparedStatement stmt = null;
		String sql ="update dept set dname = ? and set loc_code = ? where deptno = ?";
		int result = 0;
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, dept.getDname());
			stmt.setString(2, dept.getLoc_code());
			stmt.setInt(3, dept.getDeptno());
			result = stmt.executeUpdate();
			System.out.println(result+"개 행이 수정됐습니다");
		}catch(SQLException E) {
			System.out.println("연결실패:");
		}finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
	}

	@Override
	public int delete(int deptno) {
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "delete tb_board where deptno = ?";
		int result = 0;
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, deptno);
			result = stmt.executeUpdate();
			System.out.println(result+"개 행이 삭제됐습니다");
		}catch(SQLException e) {
			System.out.println("연결실패:");
		}finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
	}

	@Override
	public ArrayList<DeptDTO> getDeptList() {
		ArrayList<DeptDTO> deptlist = new ArrayList<DeptDTO>();
		DeptDTO dept = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from dept";
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				dept = new DeptDTO(rs.getInt(1),rs.getString(2),rs.getString(3));
				deptlist.add(dept);
			}
		}catch(SQLException e) {
			System.out.println("연결실패:");
		}finally {
			DBUtil.close(rs, stmt, con);
		}
		return deptlist;
	}

	@Override
	public ArrayList<EmpDTO> getMemberList(int deptno) {
		ArrayList<EmpDTO> emplist = new ArrayList<EmpDTO>();
		Connection con = null;
		PreparedStatement stmt = null;
		String sql ="select * from emp where deptno = ?";
		EmpDTO emp = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, deptno);
			rs = stmt.executeQuery();
			while(rs.next()) {//결과가 하나이므로 while말고 if도 가능
				emp = new EmpDTO(rs.getInt(1), rs.getString(2), rs.getString(3)
						,rs.getInt(4),rs.getDate(5),rs.getInt(6),
						rs.getInt(7),rs.getInt(8));
				emplist.add(emp);
			}
		}catch(SQLException E) {
			System.out.println("연결실패:");
		}finally {
			DBUtil.close(rs, stmt, con);
		}
		return emplist;
	}
	
}
