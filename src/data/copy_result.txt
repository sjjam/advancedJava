package api.io;

import java.io.File;

public class FileTest01 {
	public static void main(String[] args) {
		//액세스하고 싶은 파일이나 폴더의 위치를 File객체 만들때 매개변수에 정의
		//1. c:\iot\iotest폴더 - c:\\iot\\iotest로 표현
		File file1 = new File("c:/iot/iotest");//\t,\n
		//2. 프로젝트 폴더에 저장한 test.txt파일
		//   => 경로를 정의하지 않는 경우 기본으로 인식하는 위치는 프로젝트 폴더
		File file2 = new File("test.txt");
		//3. src/data폴더에 저장된 test.txt파일
		File file3 = new File("src/data/test.txt");//상대경로
		System.out.println(file1);
		System.out.println(file2);
		System.out.println(file3);
		
		System.out.println("file3.canRead()=>"+file3.canRead());
		System.out.println("file3.canWrite()=>"+file3.canWrite());
		System.out.println("file3.getName()=>"+file3.getName());
		System.out.println("file3.getAbsolutePath()=>"+file3.getAbsolutePath());
		System.out.println("file3.getParent()=>"+file3.getParent());
		System.out.println("file3.getPath()=>"+file3.getPath());
		System.out.println("file3.isDirectory()=>"+file3.isDirectory());
		System.out.println("file1.isDirectory()=>"+file1.isDirectory());
		System.out.println("file3.isFile()=>"+file3.isFile());
		System.out.println("file1.isFile()=>"+file1.isFile());
		System.out.println("file3.isHidden()=>"+file3.isHidden());
		System.out.println("file3.lastModified()=>"+file3.lastModified());
		System.out.println("file3.length()=>"+file3.length());
		file3.setReadOnly();
	}
}
