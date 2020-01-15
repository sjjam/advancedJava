package api.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy {
	public static void main(String[] args) {
		//FileTest01.java파일 copy하기
		//1. FileReader로 읽고 FileWriter로 출력하기
		//2. src/data/copy_result.txt로 생성하기
		//3. 콘솔로도 출력되도록 작성
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader("src/api/io/FileTest01.java");
			fw = new FileWriter("src/data/copy_result.txt");
			while(true) {
				int data = fr.read();
				if(data==-1) {
					break;
				}
				fw.write(data);
				System.out.print((char)data);
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fr!=null)fr.close();
				if(fw!=null)fw.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
