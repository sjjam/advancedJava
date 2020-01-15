package api.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ScoreTest {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src/data/score.txt"));
			int count = 0;//½ÇÇàÈ½¼ö
			int sum = 0;
			while(true) {
				String line = br.readLine();
				if(line==null) {
					break;
				}
				String[] data = line.split(",");
				System.out.println(data[0]+ "ÀÇ Á¡¼ö´Â "+data[1]+"Á¡");
				count++;
				sum += Integer.parseInt(data[1]);
			}
			System.out.println("ÃÑÁ¡ : "+sum);
			System.out.println("Æò±Õ : "+(sum/count));
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 

	}
}
