
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Day1 {

	public static void main(String[] args) {

		FileReader fil;
		try {
			fil = new FileReader("input.txt");
			BufferedReader buff = new BufferedReader(fil);

			int summer = buff.lines().mapToInt(x -> Integer.parseInt(x)).sum();
			System.out.println(summer);
		} catch (FileNotFoundException e) {
		}

	}

}
