package api.util;

import java.util.Vector;

//Vector�� ����� ����ϴ� ���
public class VectorTest01 {
	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer>();//vector<>�ȿ� Ÿ�� ���� ����ξ��� �� ����,���� �Ѵ� ����
		//v.add("java");
		v.add(10);//Vector�� api
		System.out.println("Vector�� �뷮:"+v.capacity());//�� ������
		System.out.println("Vector�� ����� ����� ����:"+v.size());
	}
}
