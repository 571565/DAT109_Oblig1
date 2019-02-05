import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2 {

	public static void main(String[] args) {
		File fil;

		int sum3 = 0;
		int sum2 = 0;

	

		try {

			fil = new File("inputday2.txt");
			Scanner scan = new Scanner(fil);

			while (scan.hasNext()) {
				
				ArrayList<Character> tabell = new ArrayList<Character>();

				String linje = scan.next();
				char[] tab = linje.toCharArray();
				for (char c : tab) {
					tabell.add(c);
				}
				boolean check3 = false;
				boolean check2 = false;

				for (Character c : tabell) {

					int like = 0;

					for (Character i : tabell) {

						if (c == i) {
							like++;
						}

					}
					if (like == 3 && !check3) {
						sum3++;
						check3 = true;

					}
					if (like == 2 && !check2) {
						sum2++;
						check2 = true;
					}

				}

			}

		} catch (FileNotFoundException e) {
		}
		System.out.println(sum3 * sum2);

	}

}
