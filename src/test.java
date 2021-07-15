import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class test {

	public static void Menu(HashMap H, int func) throws IOException {
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		while (true) {
			System.out.println("\n1.- Search\n" + "2.- Remove\n" + "3.- List\n" + "4.- Collision Count\n"
					+ "5.- Current Size\n" + "6.- Indexing Time\n"+ "7.- Search Times\n");
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				if (func == 1 |func == 5 )
					H.search_1(0,"");
				else if (func == 2|func == 6)
					H.search_2(0,"");
				else if (func == 3|func == 7)
					H.search_3(0,"");
				else if (func == 4|func == 8)
					H.search_4(0,"");
				break;
			case 2:
				System.out.print(">Remove: ");
				String key = scan.next();
				if (func == 1 |func == 5 )
					H.remove_1(key);
				else if (func == 2|func == 6)
					H.remove_2(key);
				else if (func == 3|func == 7)
					H.remove_3(key);
				else if (func == 4|func == 8)
					H.remove_4(key);
				
				break;
			case 3:
				H.list_Words();
				break;
			case 4:
				System.out.println("Collision count= " + H.getCollision_count());
				break;
			case 5:
				System.out.println("Current Size: " + H.getCurrent_Size());
				break;
			case 6:
				System.out.println("Indexing Time: " + H.get_Average_Indexing_Time());
				break;
			case 7:
				System.out.println("Max Search Time is: "+H.searchTimes(func)[0]+" "+"MinSearch Time is: "+H.searchTimes(func)[1]+" Average Search Time is: "+H.searchTimes(func)[2]);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		String DELIMITERS = "[-+=" + " " + // space
				"\r\n " + // carriage return line fit
				"1234567890" + // numbers
				"Ã¢â‚¬â„¢'\"" + // apostrophe
				"(){}<>\\[\\]" + // brackets
				":" + // colon
				"," + // comma
				"Ã¢â‚¬â€™Ã¢â‚¬â€œÃ¢â‚¬â€�Ã¢â‚¬â€¢" + // dashes
				"Ã¢â‚¬Â¦" + // ellipsis
				"!" + // exclamation mark
				"." + // full stop/period
				"Ã‚Â«Ã‚Â»" + // guillemets
				"-Ã¢â‚¬ï¿½" + // hyphen
				"?" + // question mark
				"Ã¢â‚¬ËœÃ¢â‚¬â„¢Ã¢â‚¬Å“Ã¢â‚¬ï¿½" + // quotation marks
				";" + // semicolon
				"/" + // slash/stroke
				"Ã¢ï¿½â€�" + // solidus
				"Ã¢ï¿½Â " + // space?
				"Ã‚Â·" + // interpunct
				"&" + // ampersand
				"@" + // at sign
				"*" + // asterisk
				"\\" + // backslash
				"Ã¢â‚¬Â¢" + // bullet
				"^" + // caret
				"Ã‚Â¤Ã‚Â¢$Ã¢â€šÂ¬Ã‚Â£Ã‚Â¥Ã¢â€šÂ©Ã¢â€šÂª" + // currency
				"Ã¢â‚¬Â Ã¢â‚¬Â¡" + // dagger
				"Ã‚Â°" + // degree
				"Ã‚Â¡" + // inverted exclamation point
				"Ã‚Â¿" + // inverted question mark
				"Ã‚Â¬" + // negation
				"#" + // number sign (hashtag)
				"Ã¢â€�â€“" + // numero sign ()
				"%Ã¢â‚¬Â°Ã¢â‚¬Â±" + // percent and related signs
				"Ã‚Â¶" + // pilcrow
				"Ã¢â‚¬Â²" + // prime
				"Ã‚Â§" + // section sign
				"~" + // tilde/swung dash
				"Ã‚Â¨" + // umlaut/diaeresis
				"_" + // underscore/understrike
				"|Ã‚Â¦" + // vertical/pipe/broken bar
				"Ã¢ï¿½â€š" + // asterism
				"Ã¢Ëœï¿½" + // index/fist
				"Ã¢Ë†Â´" + // therefore sign
				"Ã¢â‚¬Â½" + // interrobang
				"Ã¢â‚¬Â»" + // reference mark
				"]";
		int choice = 1;
		int bound = 510;
		String default_Path = "C:\\Users\\hp1\\Desktop\\DataStHW1\\bbc\\";
		String cont_Path = "business\\";
		String file_Name = null;
		BufferedReader stop_Words_Reader = null;
		BufferedReader current_File_Reader = null;

		HashMap H = new HashMap(128);

		for (int i = 0; i < 5; i++) {// 5
			if (i == 1) {
				bound = 386;
				cont_Path = "entertainment\\";
			}
			if (i == 2) {
				bound = 417;
				cont_Path = "politics\\";
			}
			if (i == 3) {
				bound = 511;
				cont_Path = "sport\\";
			}
			if (i == 4) {
				bound = 401;
				cont_Path = "tech\\";
			}
			for (int j = 1; j <bound+1; j++) {// bound+1
				if (j < 10)
					file_Name = "00" + Integer.toString(j) + ".txt";
				else if (j > 99)
					file_Name = Integer.toString(j) + ".txt";
				else
					file_Name = "0" + Integer.toString(j) + ".txt";

				String final_Path = default_Path + cont_Path + file_Name;
				System.out.println(final_Path + " added.");
				File current_File = new File(final_Path);
				File stop_Words = new File("C:\\Users\\hp1\\Desktop\\DataStHW1\\stop_words_en.txt");
				stop_Words_Reader = new BufferedReader(new FileReader(stop_Words));
				current_File_Reader = new BufferedReader(new FileReader(current_File));
				String stop_Words_Line, current_File_Line;

				while ((current_File_Line = current_File_Reader.readLine()) != null) {
					String[] without_Delimiters = current_File_Line.split(DELIMITERS);
					boolean flag = true;
					for (int k = 0; k < without_Delimiters.length; k++) {
						if (!without_Delimiters[k].equals("")) {
							while ((stop_Words_Line = stop_Words_Reader.readLine()) != null) {
								if (stop_Words_Line.equalsIgnoreCase(without_Delimiters[k])) {
									flag = false;
								}

							}
							stop_Words_Reader = new BufferedReader(new FileReader(stop_Words));
							if (flag) {
								WordNode wn = new WordNode(without_Delimiters[k], cont_Path + file_Name);
								H.put(wn, choice);
							}

							flag = true;
						}
					}
				}
			}
		}
		System.out.println("Txt adding is finished.");
		Menu(H,choice);
	}
}
