package jdbc.dept;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuUI {
 Scanner key = new Scanner(System.in);
 DeptDAO mdao = new DeptDAOImpl();
 public void insertMenu(){
  System.out.println("*******부서등록********");
  System.out.print("부서 번호 :");
  int deptno = key.nextInt();
  System.out.print("부서 이름 :");
  String dname = key.next();
  System.out.print("지역 코드 :");
  String loc_code = key.next();
  
  //여기에서 MemberDTO의 메소드를 호출하세요
  DeptDTO dept = new DeptDTO(deptno, dname, loc_code);
  int res = mdao.insert(dept);
  if(res > 0)
   System.out.println("INSERT success!");
  else
   System.out.println("INSERT fail!");
 }
 public void updateMenu(){
  System.out.println("*******부서수정********");
  System.out.print("수정할 부서 번호 :");
  int deptno = key.nextInt();
  System.out.print("부서 이름 :");
  String dname = key.next();
  System.out.print("지역 코드 :");
  String loc_code = key.next();
  
  //여기에서 MemberDTO의 메소드를 호출하세요
  DeptDTO dept = new DeptDTO(deptno, dname, loc_code);
  int res = mdao.update(dept);
  if(res > 0)
   System.out.println("UPDATE success!");
  else
   System.out.println("UPDATE fail!");
 }
 public void deleteMenu(){
  System.out.println("*******부서삭제********");
  System.out.print("삭제할 부서 번호 :");
  int deptno = key.nextInt();
  
  //여기에서 MemberDTO의 메소드를 호출하세요
  int res = mdao.delete(deptno);
  if(res > 0)
   System.out.println("DELETE success!");
  else
   System.out.println("DELETE fail!");
 }
 
 public void getDeptInfo() {
  System.out.println("*******부서정보조회********");
  System.out.print("deptno:");
	int deptno = key.nextInt();
	//여기에서 boardDAO의 메소드를 호출하세요
	DeptDTO dept = mdao.getDeptInfo(deptno);
		System.out.println(dept.getDeptno()+"\t"+
		dept.getDname()+"\t"+dept.getLoc_code());
	}
 
 public void getDeptListMenu(){
  System.out.println("*******모든 부서 목록********");
  ArrayList<DeptDTO> deptlist = mdao.getDeptList();
  int size = deptlist.size();
	for(int i=0;i<size;i++) {
		DeptDTO dept = deptlist.get(i);
		System.out.println(dept.getDeptno()+"\t"+
		dept.getDname()+"\t"+dept.getLoc_code());
	}
 }
 
 
 public void getMemberListMenu(){
  System.out.println("*******부서별 사원 목록********");
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