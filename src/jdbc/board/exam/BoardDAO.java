package jdbc.board.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//tb_board���̺��� �׼����ϴ� ����� ���ǵ� Ŭ����
public class BoardDAO {
	public void select() {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select id,title,content from tb_board";
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.print(rs.getString(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.println(rs.getString(3)+"\t");
			}
		}catch(SQLException E) {
			System.out.println("�������:");
		}finally {
			try {
				if(stmt !=null)stmt.close();
				if(con !=null)con.close();
				if(rs !=null)rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	public void delete(int boardnum) {
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "delete tb_board where boardnum = ?";
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, boardnum);
			int result = stmt.executeUpdate();
			System.out.println(result+"�� ���� �����ƽ��ϴ�");
		}catch(SQLException e) {
			System.out.println("�������:");
		}finally {
			try {
				if(stmt !=null)stmt.close();
				if(con !=null)con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	public void update(String id, int boardnum) {
		Connection con = null;
		PreparedStatement stmt = null;
		String sql ="update tb_board set id = ? where boardnum = ?";
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setInt(2, boardnum);
			int result = stmt.executeUpdate();
			System.out.println(result+"�� ���� �����ƽ��ϴ�");
		}catch(SQLException E) {
			System.out.println("�������:");
		}finally {
			try {
				if(stmt !=null)stmt.close();
				if(con !=null)con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void insert(String id, String title, String content) {
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "insert into tb_board values(board_seq.nextval,?,?,?,sysdate,0)";
		try {
			con = DBUtil.getConnect();
			
			//1. PreraredStatement����
			stmt = con.prepareStatement(sql);
			//2. ?�� �� �����ϱ�
			stmt.setString(1, id);
			stmt.setString(2, title);
			stmt.setString(3, content);
			//3. �����ϱ�
			int result = stmt.executeUpdate();
			System.out.println(result+"�� �� ���Լ���");
		}catch(SQLException e) {
			System.out.println("�������:");
			e.printStackTrace();//��������
		}finally {
			try {
				if(stmt !=null)stmt.close();
				if(con !=null)con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
