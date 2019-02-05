import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1part2 {

	public static void main(String[] args) {
		File fil;
		int sum = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		boolean ferdig = false;
		
		try {
			while (true) {
			fil = new File("input.txt");
			Scanner scan = new Scanner(fil);
			
			
			while (scan.hasNext()) {
				
				int next = scan.nextInt();
				sum += next;
				if (list.contains(sum)) {
					System.out.println(sum);
					return;
				}
				list.add(sum);
				
	
			}
			
			
			}
				

		} catch (FileNotFoundException e) {
		}
		

	}

}
