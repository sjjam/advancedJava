package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

//오라클에 접속하기
public class PreparedInsertTest {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		PreparedInsertTest obj = new PreparedInsertTest();
		System.out.println("*******게시글 등록*******");
		System.out.println("아이디:");
		String id = key.next();
		System.out.println("제목:");
		String title = key.next();
		System.out.println("내용:");
		String content = key.next();
		System.out.println();
		obj.insert(id, title, content);
	}
	public void insert(String id, String title, String content) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		Connection con = null;
		PreparedStatement stmt = null;
		/*String sql = "insert into tb_board values(board_seq.nextval,'"+
				id +"','"+ title + "','" + content
				+"',sysdate,0)";*/
		//외부에서 입력받을걸 ?로
		String sql = "insert into tb_board values(board_seq.nextval,?,?,?,sysdate,0)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
			
			//1. PreraredStatement생성
			stmt = con.prepareStatement(sql);
			//2. ?에 값 전달하기
			stmt.setString(1, id);
			stmt.setString(2, title);
			stmt.setString(3, content);
			//3. 실행하기
			int result = stmt.executeUpdate();
			System.out.println(result+"개 행 삽입성공");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("연결실패:");
			e.printStackTrace();//오류추적
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
