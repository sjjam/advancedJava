package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTest {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		StringBuffer sql = new StringBuffer();
		sql.append("delete tb_board ");
		sql.append("where boardnum=3");
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();
			int result = stmt.executeUpdate(sql.toString());
			System.out.println(result+"�� ���� �����ƽ��ϴ�");
		}catch(ClassNotFoundException e){
			System.out.println("����̹��ε� ����");
		}catch(SQLException E) {
			System.out.println("�������:");
		}

	}

}
