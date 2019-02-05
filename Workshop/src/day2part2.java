import java.util.ArrayList;
import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day2part2 {


		public static void main(String[] args) {
			File fil;


			ArrayList<String> tabell = new ArrayList<String>();

			try {

				fil = new File("inputday2.txt");
				Scanner scan = new Scanner(fil);

				while (scan.hasNext()) {
					tabell.add(scan.next());
				}

			} catch (FileNotFoundException e) {
			}
				
				Iterator<String> i = tabell.iterator();
				
				while (i.hasNext()) {
				
					String linje = i.next();
					char[] tab = linje.toCharArray();
					ArrayList<Character> chartab = new ArrayList<Character>();
					for (char c : tab) {
						chartab.add(c);
					}
					int like = 0;
					char ulik = 'x';
					char ulik2 = 'x';

					for (String c : tabell) {

						char[] tab2 = c.toCharArray();
						ArrayList<Character> chartab2 = new ArrayList<Character>();
						for (char a : tab2) {
							chartab2.add(a);
						}
						Iterator<Character> i1 = chartab.iterator();
						Iterator<Character> i2 = chartab2.iterator();
						while (i1.hasNext() && i2.hasNext()) {
							char c1 = i1.next();
							char c2 = i2.next();
							if (c2 != c1) {
								like++;
								ulik2 = c2;
								ulik = c1;
							}
						}
						if (like <= 1 && ulik != 'x') {
							chartab2.remove(ulik2);
							chartab.remove(ulik);
							if (chartab.equals(chartab)) 
								System.out.println(chartab.toString());
						}

					}
					
				}

				
			

		}

	}

