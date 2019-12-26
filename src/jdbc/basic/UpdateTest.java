package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		String sql ="update tb_board ";
		sql = sql + "set id='kang' ";
		sql = sql + "where boardnum=2";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();
			int result = stmt.executeUpdate(sql);
			System.out.println(result+"개 행이 수정됐습니다");
		}catch(ClassNotFoundException e){
			System.out.println("드라이버로딩 실패");
		}catch(SQLException E) {
			System.out.println("연결실패:");
		}

	}

}
