package jdbc.board.exam;

import java.util.Scanner;

public class BoardDAOTest {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		BoardDAOImpl dao = new BoardDAOImpl();
		System.out.println("*******�Խñ� ���*******");
		System.out.println("���̵�:");
		String id = key.next();
		System.out.println("����:");
		String title = key.next();
		System.out.println("����:");
		String content = key.next();
		System.out.println();
		dao.insert(id, title, content);
		System.out.println("*******�Խñ� ����*******");
		System.out.println("boardnum:");
		int boardnum = key.nextInt();
		dao.delete(boardnum);
		System.out.println();
		System.out.println("*******�Խñ� ����*******");
		System.out.println("���̵�:");
		String id2 = key.next();
		System.out.println("boardnum:");
		int boardnum2 = key.nextInt();
		dao.update(id2, boardnum2);
		System.out.println("*******�Խñ� ���*******");
		dao.select();
	}
}
