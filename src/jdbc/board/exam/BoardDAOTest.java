package jdbc.board.exam;

import java.util.Scanner;

public class BoardDAOTest {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		BoardDAOImpl dao = new BoardDAOImpl();
		System.out.println("*******게시글 등록*******");
		System.out.println("아이디:");
		String id = key.next();
		System.out.println("제목:");
		String title = key.next();
		System.out.println("내용:");
		String content = key.next();
		System.out.println();
		dao.insert(id, title, content);
		System.out.println("*******게시글 삭제*******");
		System.out.println("boardnum:");
		int boardnum = key.nextInt();
		dao.delete(boardnum);
		System.out.println();
		System.out.println("*******게시글 수정*******");
		System.out.println("아이디:");
		String id2 = key.next();
		System.out.println("boardnum:");
		int boardnum2 = key.nextInt();
		dao.update(id2, boardnum2);
		System.out.println("*******게시글 출력*******");
		dao.select();
	}
}
