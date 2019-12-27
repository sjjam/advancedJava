package jdbc.board.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//tb_board���̺��� �׼����ϴ� ����� ���ǵ� Ŭ����
public class BoardDAOImpl implements BoardDAO{
	public int insert(BoardDTO board) {
		System.out.println("dto���޼ҵ�:"+board);
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "insert into tb_board values(board_seq.nextval,?,?,?,sysdate,0)";
		int result = 0;//�޼ҵ� �������� ����� ����
		try {
			con = DBUtil.getConnect();
			
			//1. PreraredStatement����
			stmt = con.prepareStatement(sql);
			//2. ?�� �� �����ϱ�
			stmt.setString(1, board.getId());
			stmt.setString(2, board.getTitle());
			stmt.setString(3, board.getContent());
			//3. �����ϱ�
			result = stmt.executeUpdate();
			System.out.println(result+"�� �� ���Լ���");
		}catch(SQLException e) {
			System.out.println("�������:");
			e.printStackTrace();//��������
		}finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
	}
	public void select() {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from tb_board";
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.print(rs.getString(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3)+"\t");
				System.out.print(rs.getString("content")+"\t");
				System.out.print(rs.getDate(5)+"\t");
				System.out.println(rs.getInt(6));
			}
		}catch(SQLException e) {
			System.out.println("�������:");
		}finally {
			DBUtil.close(rs, stmt, con);
		}
	}
	public int delete(int boardnum) {
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "delete tb_board where boardnum = ?";
		int result = 0;
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, boardnum);
			result = stmt.executeUpdate();
			System.out.println(result+"�� ���� �����ƽ��ϴ�");
		}catch(SQLException e) {
			System.out.println("�������:");
		}finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
	}
	public int update(String id, int boardnum) {
		Connection con = null;
		PreparedStatement stmt = null;
		String sql ="update tb_board set id = ? where boardnum = ?";
		int result = 0;
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setInt(2, boardnum);
			result = stmt.executeUpdate();
			System.out.println(result+"�� ���� �����ƽ��ϴ�");
		}catch(SQLException E) {
			System.out.println("�������:");
		}finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
	}
	public int insert(String id, String title, String content) {
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "insert into tb_board values(board_seq.nextval,?,?,?,sysdate,0)";
		int result = 0;//�޼ҵ� �������� ����� ����
		try {
			con = DBUtil.getConnect();
			
			//1. PreraredStatement����
			stmt = con.prepareStatement(sql);
			//2. ?�� �� �����ϱ�
			stmt.setString(1, id);
			stmt.setString(2, title);
			stmt.setString(3, content);
			//3. �����ϱ�
			result = stmt.executeUpdate();
			System.out.println(result+"�� �� ���Լ���");
		}catch(SQLException e) {
			System.out.println("�������:");
			e.printStackTrace();//��������
		}finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
	}
	
}
