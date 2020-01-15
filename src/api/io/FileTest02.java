package api.io;

import java.io.File;
import java.text.SimpleDateFormat;

//폴더의 내부를 탐색
public class FileTest02 {
	public static void main(String[] args) {
		//c:\iot\iotest폴덩의 하위 폴더 및 파일을 출력
		//[출력형태]
		//a -----------[폴더]
		//b -----------[폴더]
		//ArrayTest01.java ----------[파일:(파일의 사이즈 출력)]
		//.
		//.
		//.
		//마지막 접속한 날짜를 년 월 일의 형식으로 출력
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		File file = new File("C:\\IOT\\iotest");
		File[] filelist = file.listFiles();
		//해본거
		/*for (File info : filelist) {
			if(info.isDirectory()) {
				System.out.println(info.getName()+" -----------[폴더]");
			}
			if(info.isFile()) {
				System.out.println(info.getName()+" ---[파일:("+info.length()+")]:"
						+sdf.format(info
								.lastModified()));
			}
		}*/
		for (int i = 0; i < filelist.length; i++) {
			if(filelist[i].isDirectory()) {
				System.out.println(filelist[i].getName()+" -----------[폴더]");
			}else {
				System.out.println(filelist[i].getName()+" ---[파일:("+filelist[i].length()+")]:"
						+sdf.format(filelist[i]
								.lastModified()));
			}
		}
	}
}
