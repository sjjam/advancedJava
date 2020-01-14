package jdbc.dept;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuUI {
 Scanner key = new Scanner(System.in);
 DeptDAO mdao = new DeptDAOImpl();
 public void insertMenu(){
  System.out.println("*******�μ����********");
  System.out.print("�μ� ��ȣ :");
  int deptno = key.nextInt();
  System.out.print("�μ� �̸� :");
  String dname = key.next();
  System.out.print("���� �ڵ� :");
  String loc_code = key.next();
  
  //���⿡�� MemberDTO�� �޼ҵ带 ȣ���ϼ���
  DeptDTO dept = new DeptDTO(deptno, dname, loc_code);
  int res = mdao.insert(dept);
  if(res > 0)
   System.out.println("INSERT success!");
  else
   System.out.println("INSERT fail!");
 }
 public void updateMenu(){
  System.out.println("*******�μ�����********");
  System.out.print("������ �μ� ��ȣ :");
  int deptno = key.nextInt();
  System.out.print("�μ� �̸� :");
  String dname = key.next();
  System.out.print("���� �ڵ� :");
  String loc_code = key.next();
  
  //���⿡�� MemberDTO�� �޼ҵ带 ȣ���ϼ���
  DeptDTO dept = new DeptDTO(deptno, dname, loc_code);
  int res = mdao.update(dept);
  if(res > 0)
   System.out.println("UPDATE success!");
  else
   System.out.println("UPDATE fail!");
 }
 public void deleteMenu(){
  System.out.println("*******�μ�����********");
  System.out.print("������ �μ� ��ȣ :");
  int deptno = key.nextInt();
  
  //���⿡�� MemberDTO�� �޼ҵ带 ȣ���ϼ���
  int res = mdao.delete(deptno);
  if(res > 0)
   System.out.println("DELETE success!");
  else
   System.out.println("DELETE fail!");
 }
 
 public void getDeptInfo() {
  System.out.println("*******�μ�������ȸ********");
  System.out.print("deptno:");
	int deptno = key.nextInt();
	//���⿡�� boardDAO�� �޼ҵ带 ȣ���ϼ���
	DeptDTO dept = mdao.getDeptInfo(deptno);
		System.out.println(dept.getDeptno()+"\t"+
		dept.getDname()+"\t"+dept.getLoc_code());
	}
 
 public void getDeptListMenu(){
  System.out.println("*******��� �μ� ���********");
  ArrayList<DeptDTO> deptlist = mdao.getDeptList();
  int size = deptlist.size();
	for(int i=0;i<size;i++) {
		DeptDTO dept = deptlist.get(i);
		System.out.println(dept.getDeptno()+"\t"+
		dept.getDname()+"\t"+dept.getLoc_code());
	}
 }
 
 
 public void getMemberListMenu(){
  System.out.println("*******�μ��� ��� ���********");
  System.out.print("deptno :");
  int deptno = key.nextInt();
  ArrayList<EmpDTO> emplist = mdao.getMemberList(deptno);
  int size = emplist.size();
  	for(int i=0;i<size;i++) {
  		EmpDTO emp = emplist.get(i);
  		System.out.println(emp.getEmpno()+"\t"+emp.getEname()+"\t"+emp.getJob()
  		+"\t"+emp.getMgr()+"\t"+emp.getHiredate()+"\t"+emp.getSal()+"\t"+emp.getDeptno());
  	}
 }
}