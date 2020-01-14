package jdbc.dept;

import java.util.ArrayList;

public interface DeptDAO {
	public int insert(DeptDTO dept);
	public DeptDTO getDeptInfo(int deptno);
	public int update(DeptDTO dept);
	public int delete(int deptno);
	public ArrayList<DeptDTO> getDeptList();
	public ArrayList<EmpDTO> getMemberList(int deptno);
}
