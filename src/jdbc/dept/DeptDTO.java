package jdbc.dept;

public class DeptDTO {
	private int deptno;
	private String dname;
	private String loc_code;
	
	public DeptDTO() {
		
	}

	public DeptDTO(int deptno, String dname, String loc_code) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc_code = loc_code;
	}

	@Override
	public String toString() {
		return "EmpDTO [deptno=" + deptno + ", dname=" + dname + ", loc_code=" + loc_code + "]";
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc_code() {
		return loc_code;
	}

	public void setLoc_code(String loc_code) {
		this.loc_code = loc_code;
	}
}
