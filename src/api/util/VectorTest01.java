package api.util;

import java.util.Vector;

//Vector를 만들고 사용하는 방법
public class VectorTest01 {
	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer>();//vector<>안에 타입 지정 비워두었을 땐 문자,숫자 둘다 가능
		//v.add("java");
		v.add(10);//Vector는 api
		System.out.println("Vector의 용량:"+v.capacity());//총 사이즈
		System.out.println("Vector에 저장된 요소의 객수:"+v.size());
	}
}
