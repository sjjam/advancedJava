package api.util;

import java.util.ArrayList;

public class ArrayLiseExam01 {
	public static void main(String[] args) {
		//79,55,100,98,99를 ArrayList에 총점과 평균을 출력하세요.
		//[출력형태]
		//총점 : 
		//평균 :
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(79);
		list.add(55);
		list.add(100);
		list.add(98);
		list.add(99);
		int sum = 0;
		double avg = 0;
		
		for(int i=0;i<list.size();i++) {
			
			sum = sum+list.get(i);
			avg = (double)sum/list.size();
		}
		System.out.println("총점 : "+sum);
		System.out.println("평군 : "+avg );
	}

}
