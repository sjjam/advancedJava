package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PrepardUpdateTest {

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		PrepardUpdateTest obj = new PrepardUpdateTest();
		System.out.println("********게시글 수정********");
		System.out.println("id:");
		String id = key.next();
		System.out.println("boardnum:");
		int boardnum = key.nextInt();
		System.out.println();
		obj.update(id, boardnum);

	}
	public void update(String id, int boardnum) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		Connection con = null;
		PreparedStatement stmt = null;
		String sql ="update tb_board set id = ? where boardnum = ?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setInt(2, boardnum);
			int result = stmt.executeUpdate();
			System.out.println(result+"개 행이 수정됐습니다");
		}catch(ClassNotFoundException e){
			System.out.println("드라이버로딩 실패");
		}catch(SQLException E) {
			System.out.println("연결실패:");
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
