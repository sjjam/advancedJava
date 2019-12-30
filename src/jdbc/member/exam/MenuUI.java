package jdbc.member.exam;
import java.util.ArrayList;
import java.util.Scanner;

import jdbc.board.exam.BoardDTO;

public class MenuUI {
	Scanner key = new Scanner(System.in);
	MemberDAO dao = new MemberDAOImpl();
	public void insertMenu(){
		//�Ի����� ���ó�¥ - sysdate, point = 1000�� ���Եǵ���
		System.out.println("*******������********");
		System.out.print("���̵�:");
		String id = key.next();
		System.out.print("�н�����:");
		String pass = key.next();
		System.out.print("����:");
		String name = key.next();
		System.out.print("�ּ�:");
		String addr = key.next();
		System.out.print("�μ���ȣ:");
		String deptno = key.next();
		//���⿡�� EmpDAO�� �޼ҵ带 ȣ���ϼ���
		MemberDTO user = new MemberDTO(id, pass, name, addr, deptno);
		int result = dao.insert(user);
		if(result>0) {
			System.out.println("��� ��� ����");
		}else {
			System.out.println("��� ��� ����");
		}
	}
	public void updateMenu(){
		System.out.println("*******�������********");
		System.out.print("���̵�:");
		String id = key.next();
		System.out.print("�ּ�:");
		String addr = key.next();
		//���⿡�� EmpDAO�� �޼ҵ带 ȣ���ϼ���
		int result = dao.update(id, addr);
		if(result>0) {
			System.out.println("��� ���� ����");
		}else {
			System.out.println("��� ���� ����");
		}
	}
	public void deleteMenu(){
		System.out.println("*******�������********");
		System.out.print("���̵�:");
		String id = key.next();
		//���⿡�� EmpDAO�� �޼ҵ带 ȣ���ϼ���
		int result = dao.delete(id);
		if(result>0) {
			System.out.println("��� ���� ����");
		}else {
			System.out.println("��� ���� ����");
		}
	}
	public void findByAddrMenu(){
		System.out.println("*******����˻�********");
		System.out.print("�ּ�:");
		String addr = key.next();
		//���⿡�� EmpDAO�� �޼ҵ带 ȣ���ϼ���
		ArrayList<MemberDTO> list = dao.findByAddr(addr);
		int size = list.size();
		for(int i=0;i<size;i++) {
			MemberDTO mem = list.get(i);
			System.out.println(mem.getId()+"\t"+
			mem.getPass()+"\t"+mem.getName()+"\t"+
			mem.getAddr()+"\t"+mem.getDeptno()+"\t"+mem.getHireDate()+"\t"+mem.getPoint());
		}
	}
	
	
	public void selectMenu(){
		System.out.println("*******�����ȸ********");
		//���⿡�� EmpDAO�� �޼ҵ带 ȣ���ϼ��� - ��ü�����ȸ
		ArrayList<MemberDTO> list = dao.memberList();
		int size = list.size();
		for(int i=0;i<size;i++) {
			MemberDTO mem = list.get(i);
			System.out.println(mem.getId()+"\t"+
			mem.getPass()+"\t"+mem.getName()+"\t"+
			mem.getAddr()+"\t"+mem.getDeptno()+"\t"+mem.getHireDate()+"\t"+mem.getPoint());
		}
	}
	
	public void loginMenu() {
		System.out.println("*******�α���********");
		System.out.print("id:");
		String id = key.next();
		System.out.print("pass:");
		String pass = key.next();
		MemberDTO mem = dao.login(id, pass);
		if(mem==null) {
			System.out.println("�α��� ����");
		}else {
			System.out.println("�α��� ����");
		}
	}
}


















