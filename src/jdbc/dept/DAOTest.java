package jdbc.dept;

import java.util.Scanner;

public class DAOTest {

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		System.out.println("******인사관리시스템******");
		System.out.println("1. 부서등록");
		System.out.println("2. 부서정보조회");
		System.out.println("3. 부서정보수정");
		System.out.println("4. 부서삭제");
		System.out.println("5. 모든 부서목록 확인하기");
		System.out.println("6. 부서별 사원 목록 확인");
		System.out.print("원하는 작업을 선택하세요:");
		int choice = key.nextInt();
		show(choice);
	}
	
	public static void show(int choice) {
		MenuUI ui = new MenuUI();
		switch (choice) {
		case 1:
			ui.insertMenu();
			break;
		case 2:
			ui.getDeptInfo();
			break;
		case 3:
			ui.updateMenu();
			break;
		case 4:
			ui.deleteMenu();
			break;
		case 5:
			ui.getDeptListMenu();
			break;
		case 6:
			ui.getMemberListMenu();
			break;
		}
	}

}
