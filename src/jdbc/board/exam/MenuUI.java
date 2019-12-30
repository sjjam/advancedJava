package jdbc.board.exam;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuUI {
	Scanner key = new Scanner(System.in);
	BoardDAO dao = new BoardDAOImpl();
	public void insertMenu(){
		System.out.println("*******�Խñ۵��********");
		System.out.print("���̵�:");
		String id = key.next();
		System.out.print("����:");
		String title = key.next();
		System.out.print("����:");
		String content = key.next();
		//���⿡�� boardDAO�� �޼ҵ带 ȣ���ϼ���
		//int result = dao.insert(id, title, content);
		BoardDTO board = new BoardDTO(id, title, content);
		int result = dao.insert(board);
		//���ó��
		if(result>0) {
			System.out.println("�Խñ۵�� ����");
		}else {
			System.out.println("�� ��� ����");
		}
	}
	public void updateMenu(){
		System.out.println("*******�Խñۼ���********");
		System.out.print("���̵�:");
		String id = key.next();
		System.out.print("�Խñ۹�ȣ:");
		int boardnum = key.nextInt();
		//���⿡�� boardDAO�� �޼ҵ带 ȣ���ϼ���
		int result = dao.update(id, boardnum);
		if(result>0) {
			System.out.println("�Խñۼ��� ����");
		}else {
			System.out.println("�� ���� ����");
		}
	}
	public void deleteMenu(){
		System.out.println("*******�Խñۻ���********");
		System.out.print("�Խñ۹�ȣ:");
		int boardnum = key.nextInt();
		//���⿡�� boardDAO�� �޼ҵ带 ȣ���ϼ���
		int result = dao.delete(boardnum);
		if(result>0) {
			System.out.println("�Խñۻ��� ����");
		}else {
			System.out.println("�� ���� ����");
		}
	}
	public void searchMenu(){
		System.out.println("*******�Խñ۰˻�********");
		System.out.print("����:");
		String title = key.next();
		//���⿡�� boardDAO�� �޼ҵ带 ȣ���ϼ���
		ArrayList<BoardDTO> boardlist = dao.findByTitle(title);
		int size = boardlist.size();
		for(int i=0;i<size;i++) {
			BoardDTO board = boardlist.get(i);
			System.out.println(board.getBoardNum()+"\t"+
			board.getTitle()+"\t"+board.getId()+"\t"+
			board.getHit());
		}
	}
	
	
	public void selectMenu(){
		System.out.println("*******�Խñ���ȸ********");
		//���⿡�� boardDAO�� �޼ҵ带 ȣ���ϼ��� - ��ü�����ȸ
		ArrayList<BoardDTO> boardlist = dao.select();
		int size = boardlist.size();
		for(int i=0;i<size;i++) {
			BoardDTO board = boardlist.get(i);
			System.out.println(board.getBoardNum()+"\t"+
			board.getTitle()+"\t"+board.getId()+"\t"+
			board.getHit());
		}
	}
	
	public void readMenu() {
		System.out.println("*******�Խñۻ���ȸ********");
		System.out.print("�۹�ȣ:");
		int boardnum = key.nextInt();
		BoardDTO board = dao.read(boardnum);
		if(board==null) {
			System.out.println("��ȸ�� �����Ͱ� �����ϴ�");
		}else {
		System.out.println("�۹�ȣ:"+board.getBoardNum());
		System.out.println("����:"+board.getTitle());
		System.out.println("�ۼ���:"+board.getId());
		System.out.println("����:"+board.getContent());
		System.out.println("�ۼ���¥:"+board.getWriteDate());
		System.out.println("��ȸ��:"+board.getHit());
		}
	}
}


















