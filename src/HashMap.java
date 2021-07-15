import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class HashMap {
	private WordNode[] body;
	private int capacity;
	private int load_Factor;
	private int current_Size;
	private int collision_count;
	private long indexing_Time;

	public HashMap(int capacity) {
		this.capacity = capacity;
		this.body = new WordNode[capacity];
		this.load_Factor = 50;
		this.current_Size = 0;
		this.collision_count = 0;
		this.indexing_Time = 0;
	}

	public WordNode[] getBody() {
		return body;
	}

	public void setBody(WordNode[] body) {
		this.body = body;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getLoad_Factor() {
		return load_Factor;
	}

	public void setLoad_Factor(int load_Factor) {
		this.load_Factor = load_Factor;
	}

	public int getCurrent_Size() {
		return current_Size;
	}

	public void setCurrent_Size(int current_Size) {
		this.current_Size = current_Size;
	}

	public int getCollision_count() {
		return collision_count;
	}

	public void setCollision_count(int collision_count) {
		this.collision_count = collision_count;
	}

	public long getIndexing_Time() {
		return indexing_Time;
	}

	public void setIndexing_Time(long index_Time) {
		this.indexing_Time = index_Time;
	}

	// Common------------------------------------------------------------------
	public void put(WordNode wn, int choice) {

		if (choice == 1) {
			long startTime = System.nanoTime();
			put_Function_1(wn);
			long estimatedTime = System.nanoTime() - startTime;
			indexing_Time = indexing_Time + estimatedTime;
		} else if (choice == 2) {
			long startTime = System.nanoTime();
			put_Function_2(wn);
			long estimatedTime = System.nanoTime() - startTime;
			indexing_Time = indexing_Time + estimatedTime;
		} else if (choice == 3) {
			long startTime = System.nanoTime();
			put_Function_3(wn);
			long estimatedTime = System.nanoTime() - startTime;
			indexing_Time = indexing_Time + estimatedTime;
		} else if (choice == 4) {
			long startTime = System.nanoTime();
			put_Function_4(wn);
			long estimatedTime = System.nanoTime() - startTime;
			indexing_Time = indexing_Time + estimatedTime;
		} else if (choice == 5) {
			setLoad_Factor(80);
			long startTime = System.nanoTime();
			put_Function_1(wn);
			long estimatedTime = System.nanoTime() - startTime;
			indexing_Time = indexing_Time + estimatedTime;
		} else if (choice == 6) {
			setLoad_Factor(80);
			long startTime = System.nanoTime();
			put_Function_2(wn);
			long estimatedTime = System.nanoTime() - startTime;
			indexing_Time = indexing_Time + estimatedTime;
		} else if (choice == 7) {
			setLoad_Factor(80);
			long startTime = System.nanoTime();
			put_Function_3(wn);
			long estimatedTime = System.nanoTime() - startTime;
			indexing_Time = indexing_Time + estimatedTime;
		} else {
			setLoad_Factor(80);
			long startTime = System.nanoTime();
			put_Function_4(wn);
			long estimatedTime = System.nanoTime() - startTime;
			indexing_Time = indexing_Time + estimatedTime;
		}

	}

	public void list_Words() {
		int count = 0;
		for (int i = 0; i < body.length; i++) {
			if (body[i] != null) {
				System.out.print("Word Name: " + i + " " + body[i].getWord() + "---------- File Names: ");
				FileNode head = body[i].getFile();
				if (head.getNext() == null)
					System.out.println(head.getFile_Name() + " Word Count: " + head.getWord_Count());
				else {
					while (head != null) {
						System.out.print(head.getFile_Name() + " Word Count: " + head.getWord_Count() + " ");
						head = head.getNext();
					}
					System.out.println();
				}

				count++;
			}
		}
		System.out.println(count);
	}

	public float getCurrentLoad_Factor() {
		float result = (float) current_Size / capacity;
		return result * 100;
	}

	public int SSF(String key) {
		int ssf = 0;
		key = key.toUpperCase();
		for (int i = 0; i < key.length(); i++) {
			ssf = ssf + key.charAt(i) - 64;
		}
		return ssf;
	}

	public int PAFold(String key) {
		key = key.toUpperCase();
		int paf = 0;
		int prime = 33;
		for (int i = 0; i < key.length(); i++) {
			paf = (int) (paf + (key.charAt(i) - 64) * Math.pow(prime, key.length() - i - 1));
		}
		return paf;
	}

	public long get_Average_Indexing_Time() {
		long result = getIndexing_Time() / getCurrent_Size();
		return result;

	}

	public long[] searchTimes(int func) throws IOException {
		long[] results = new long[3];
		long[] temp = new long[1000];
		int index = 0;
		long sum = 0;
		long estimatedTime = 0;
		File searchtext = new File("C:\\Users\\hp1\\Desktop\\DataStHW1\\1000.txt");
		BufferedReader searchtextreader = new BufferedReader(new FileReader(searchtext));
		String current_File_Reader;
		while ((current_File_Reader = searchtextreader.readLine()) != null) {
			if (func == 1 | func == 5) {
				long startTime = System.nanoTime();
				search_1(1, current_File_Reader);
				estimatedTime = System.nanoTime() - startTime;
			}

			else if (func == 2 | func == 6) {
				long startTime = System.nanoTime();
				search_2(1, current_File_Reader);
				estimatedTime = System.nanoTime() - startTime;
			}

			else if (func == 3 | func == 7) {
				long startTime = System.nanoTime();
				search_3(1, current_File_Reader);
				estimatedTime = System.nanoTime() - startTime;
			}

			else if (func == 4 | func == 8) {
				long startTime = System.nanoTime();
				search_4(1, current_File_Reader);
				estimatedTime = System.nanoTime() - startTime;
			}
			temp[index] = estimatedTime;
			index++;
		}
		Arrays.sort(temp);
		results[0] = temp[999];
		results[1] = temp[0];
		for (int i = 0; i < temp.length; i++) {
			sum = sum + temp[i];
		}
		sum = sum / 1000;
		results[2] = sum;
		return results;
	}

	public int PAF(String key) {
		key = key.toUpperCase();
		int x = 33;
		int result = 0;

		for (int i = 0; i < key.length(); i++) {
			result = (result * x + (key.charAt(i) - 64)) % capacity;
		}

		return result;
	}

	// First------------------------------------------------------------------
	public void put_Function_1(WordNode wn) {
		String file_Name = wn.getFile().getFile_Name();
		String key = wn.getWord();
		int j = 0;
		int hash = (SSF(key) + j) % capacity;

		if (body[hash] != null && !body[hash].getWord().equalsIgnoreCase(key)) {
			int m = getCollision_count();
			m++;
			setCollision_count(m);
		}

		if (body[hash] == null) {
			current_Size++;
			body[hash] = wn;

		} else {
			if (body[hash].getWord().equalsIgnoreCase(key)) {

				FileNode head = body[hash].getFile();

				while (!head.getFile_Name().equalsIgnoreCase(file_Name) && head.getNext() != null) {
					head = head.getNext();
				}

				if (head.getFile_Name().equalsIgnoreCase(file_Name)) {
					int a = head.getWord_Count();
					a++;
					head.setWord_Count(a);

				} else {
					FileNode node = new FileNode(file_Name);
					head.setNext(node);
				}

			} else {

				while (body[hash] != null && !body[hash].getWord().equalsIgnoreCase(key)) {
					j++;
					hash = (SSF(key) + j) % capacity;
				}

				if (body[hash] == null) {
					current_Size++;
					body[hash] = wn;

				} else if (body[hash].getWord().equalsIgnoreCase(key)) {
					FileNode head = body[hash].getFile();
					while (!head.getFile_Name().equalsIgnoreCase(file_Name) && head.getNext() != null) {
						head = head.getNext();
					}

					if (head.getFile_Name().equalsIgnoreCase(file_Name)) {
						int a = head.getWord_Count();
						a++;
						head.setWord_Count(a);

					} else {
						FileNode node = new FileNode(file_Name);
						head.setNext(node);
					}
				}

			}

		}
		if (getCurrentLoad_Factor() >= load_Factor) {
			resize_1();
		}

	}

	public void resize_1() {
		int cap = capacity * 2;
		WordNode[] resized = new WordNode[capacity * 2];
		WordNode[] temp = new WordNode[capacity * 2];
		for (int i = 0; i < body.length; i++) {
			if (body[i] != null) {
				temp[i] = body[i];
			}
		}

		setCapacity(cap);
		setCurrent_Size(0);
		setCollision_count(0);
		setBody(resized);

		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != null) {
				put_Function_1(temp[i]);
			}
		}

	}

	public void search_1(int choice, String key) {
		if (choice == 0) {
			Scanner input = new Scanner(System.in);
			System.out.print(">Search: ");
			String key1 = input.next();
			key = key1;
		}

		int documentcount = 0, j = 0;
		int hash = (SSF(key) + j) % capacity;

		if (body[hash] != null && body[hash].getWord().equalsIgnoreCase(key)) {

			FileNode head = body[hash].getFile();

			while (head != null) {
				System.out.println(head.getWord_Count() + "-" + head.getFile_Name());
				documentcount++;
				head = head.getNext();
			}
		} else {
			while (body[hash] != null && !body[hash].getWord().equalsIgnoreCase(key)) {
				j++;
				hash = (SSF(key) + j) % capacity;
			}
			if (body[hash] == null) {
				System.out.println("Not found!");

			} else if (body[hash].getWord().equalsIgnoreCase(key)) {
				FileNode head = body[hash].getFile();

				while (head != null) {
					System.out.println(head.getWord_Count() + "-" + head.getFile_Name());
					documentcount++;
					head = head.getNext();
				}

			}

		}
		if (documentcount != 0) {
			System.out.println();
			System.out.println(documentcount + " documents found");
		}

	}

	public void remove_1(String key) {
		int j = 0;
		int hash = (SSF(key) + j) % capacity;
		if (body[hash] == null) {
			System.out.println("There is no word to remove");
		} else if (body[hash].getWord().equalsIgnoreCase(key)) {
			body[hash] = null;
			System.out.println(key + " is removed.");
			current_Size--;
		} else {
			while (body[hash] != null && !body[hash].getWord().equalsIgnoreCase(key)) {
				j++;
				hash = (SSF(key) + j) % capacity;
			}
			if (body[hash] == null) {
				System.out.println("There is no word to remove!");

			} else if (body[hash].getWord().equalsIgnoreCase(key)) {
				body[hash] = null;
				System.out.println(key + " is removed.");
				current_Size--;

			}
		}

	}

	// Second------------------------------------------------------------------
	public void put_Function_2(WordNode wn) {
		String file_Name = wn.getFile().getFile_Name();
		String key = wn.getWord();
		int j = 0;
		int q = 7;
		int k = SSF(key);
		int dk = q - (k % q);
		int hash = ((k % capacity) + (j * dk)) % capacity;

		if (body[hash] != null && !body[hash].getWord().equalsIgnoreCase(key)) {
			int m = getCollision_count();
			m++;
			setCollision_count(m);
		}

		if (body[hash] == null) {
			current_Size++;
			body[hash] = wn;

		} else {
			if (body[hash].getWord().equalsIgnoreCase(key)) {

				FileNode head = body[hash].getFile();

				while (!head.getFile_Name().equalsIgnoreCase(file_Name) && head.getNext() != null) {
					head = head.getNext();
				}

				if (head.getFile_Name().equalsIgnoreCase(file_Name)) {
					int a = head.getWord_Count();
					a++;
					head.setWord_Count(a);

				} else {
					FileNode node = new FileNode(file_Name);
					head.setNext(node);
				}

			} else {

				while (body[hash] != null && !body[hash].getWord().equalsIgnoreCase(key)) {
					j++;
					hash = ((k % capacity) + (j * dk)) % capacity;
				}

				if (body[hash] == null) {
					current_Size++;
					body[hash] = wn;

				} else if (body[hash].getWord().equalsIgnoreCase(key)) {
					FileNode head = body[hash].getFile();
					while (!head.getFile_Name().equalsIgnoreCase(file_Name) && head.getNext() != null) {
						head = head.getNext();
					}

					if (head.getFile_Name().equalsIgnoreCase(file_Name)) {
						int a = head.getWord_Count();
						a++;
						head.setWord_Count(a);

					} else {
						FileNode node = new FileNode(file_Name);
						head.setNext(node);
					}
				}

			}

		}
		if (getCurrentLoad_Factor() >= load_Factor) {
			resize_2();
		}

	}

	public void resize_2() {
		int cap = capacity * 2;
		WordNode[] resized = new WordNode[capacity * 2];
		WordNode[] temp = new WordNode[capacity * 2];
		for (int i = 0; i < body.length; i++) {
			if (body[i] != null) {
				temp[i] = body[i];
			}
		}

		setCapacity(cap);
		setCurrent_Size(0);
		setCollision_count(0);
		setBody(resized);

		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != null) {
				put_Function_2(temp[i]);
			}
		}

	}

	public void search_2(int choice, String key) {
		if (choice == 0) {
			Scanner input = new Scanner(System.in);
			System.out.print(">Search: ");
			String key1 = input.next();
			key = key1;
		}

		int documentcount = 0, j = 0;
		int q = 7;
		int k = SSF(key);
		int dk = q - (k % q);
		int hash = ((k % capacity) + (j * dk)) % capacity;

		if (body[hash] != null && body[hash].getWord().equalsIgnoreCase(key)) {

			FileNode head = body[hash].getFile();

			while (head != null) {
				System.out.println(head.getWord_Count() + "-" + head.getFile_Name());
				documentcount++;
				head = head.getNext();
			}
		} else {
			while (body[hash] != null && !body[hash].getWord().equalsIgnoreCase(key)) {
				j++;
				hash = ((k % capacity) + (j * dk)) % capacity;
			}
			if (body[hash] == null) {
				System.out.println("Not found!");

			} else if (body[hash].getWord().equalsIgnoreCase(key)) {
				FileNode head = body[hash].getFile();

				while (head != null) {
					System.out.println(head.getWord_Count() + "-" + head.getFile_Name());
					documentcount++;
					head = head.getNext();
				}

			}

		}
		if (documentcount != 0) {
			System.out.println();
			System.out.println(documentcount + " documents found");
		}

	}

	public void remove_2(String key) {
		int j = 0;
		int q = 7;
		int k = SSF(key);
		int dk = q - (k % q);
		int hash = ((k % capacity) + (j * dk)) % capacity;
		if (body[hash] == null) {
			System.out.println("There is no word to remove");
		} else if (body[hash].getWord().equalsIgnoreCase(key)) {
			body[hash] = null;
			System.out.println(key + " is removed.");
			current_Size--;
		} else {
			while (body[hash] != null && !body[hash].getWord().equalsIgnoreCase(key)) {
				j++;
				hash = ((k % capacity) + (j * dk)) % capacity;
			}
			if (body[hash] == null) {
				System.out.println("There is no word to remove!");

			} else if (body[hash].getWord().equalsIgnoreCase(key)) {
				body[hash] = null;
				System.out.println(key + " is removed.");
				current_Size--;

			}
		}

	}

	// Third------------------------------------------------------------------

	public void put_Function_3(WordNode wn) {
		String file_Name = wn.getFile().getFile_Name();
		String key = wn.getWord();
		int j = 0;
		int hash = ((PAF(key) + j) % capacity);

		if (body[hash] != null && !body[hash].getWord().equalsIgnoreCase(key)) {
			int m = getCollision_count();
			m++;
			setCollision_count(m);
		}

		if (body[hash] == null) {
			current_Size++;
			body[hash] = wn;

		} else {
			if (body[hash].getWord().equalsIgnoreCase(key)) {

				FileNode head = body[hash].getFile();

				while (!head.getFile_Name().equalsIgnoreCase(file_Name) && head.getNext() != null) {
					head = head.getNext();
				}

				if (head.getFile_Name().equalsIgnoreCase(file_Name)) {
					int a = head.getWord_Count();
					a++;
					head.setWord_Count(a);

				} else {
					FileNode node = new FileNode(file_Name);
					head.setNext(node);
				}

			} else {

				while (body[hash] != null && !body[hash].getWord().equalsIgnoreCase(key)) {
					j++;
					hash = ((PAF(key) + j) % capacity);
				}

				if (body[hash] == null) {
					current_Size++;
					body[hash] = wn;

				} else if (body[hash].getWord().equalsIgnoreCase(key)) {
					FileNode head = body[hash].getFile();
					while (!head.getFile_Name().equalsIgnoreCase(file_Name) && head.getNext() != null) {
						head = head.getNext();
					}

					if (head.getFile_Name().equalsIgnoreCase(file_Name)) {
						int a = head.getWord_Count();
						a++;
						head.setWord_Count(a);

					} else {
						FileNode node = new FileNode(file_Name);
						head.setNext(node);
					}
				}

			}

		}
		if (getCurrentLoad_Factor() >= load_Factor) {
			resize_3();
		}

	}

	public void resize_3() {
		int cap = capacity * 2;
		WordNode[] resized = new WordNode[capacity * 2];
		WordNode[] temp = new WordNode[capacity * 2];
		for (int i = 0; i < body.length; i++) {
			if (body[i] != null) {
				temp[i] = body[i];
			}
		}

		setCapacity(cap);
		setCurrent_Size(0);
		setCollision_count(0);
		setBody(resized);

		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != null) {
				put_Function_3(temp[i]);
			}
		}

	}

	public void search_3(int choice, String key) {

		if (choice == 0) {
			Scanner input = new Scanner(System.in);
			System.out.print(">Search: ");
			String key1 = input.next();
			key = key1;
		}

		int documentcount = 0, j = 0;
		int hash = ((PAF(key) + j) % capacity);

		if (body[hash] != null && body[hash].getWord().equalsIgnoreCase(key)) {

			FileNode head = body[hash].getFile();

			while (head != null) {
				System.out.println(head.getWord_Count() + "-" + head.getFile_Name());
				documentcount++;
				head = head.getNext();
			}
		} else {
			while (body[hash] != null && !body[hash].getWord().equalsIgnoreCase(key)) {
				j++;
				hash = ((PAF(key) + j) % capacity);
			}
			if (body[hash] == null) {
				System.out.println("Not found!");

			} else if (body[hash].getWord().equalsIgnoreCase(key)) {
				FileNode head = body[hash].getFile();

				while (head != null) {
					System.out.println(head.getWord_Count() + "-" + head.getFile_Name());
					documentcount++;
					head = head.getNext();
				}

			}

		}
		if (documentcount != 0) {
			System.out.println();
			System.out.println(documentcount + " documents found");
		}
	}

	public void remove_3(String key) {
		int j = 0;
		int hash = ((PAF(key) + j) % capacity);
		if (body[hash] == null) {
			System.out.println("There is no word to remove");
		} else if (body[hash].getWord().equalsIgnoreCase(key)) {
			body[hash] = null;
			System.out.println(key + " is removed.");
			current_Size--;
		} else {
			while (body[hash] != null && !body[hash].getWord().equalsIgnoreCase(key)) {
				j++;
				hash = ((PAF(key) + j) % capacity);
			}
			if (body[hash] == null) {
				System.out.println("There is no word to remove!");

			} else if (body[hash].getWord().equalsIgnoreCase(key)) {
				body[hash] = null;
				System.out.println(key + " is removed.");
				current_Size--;

			}
		}

	}

	// Fourth------------------------------------------------------------------
	public void put_Function_4(WordNode wn) {
		String file_Name = wn.getFile().getFile_Name();
		String key = wn.getWord();
		int j = 0;
		int q = 7;
		int k = PAF(key);
		int dk = q - (k % q);
		int hash = ((k % capacity) + (j * dk)) % capacity;

		if (body[hash] != null && !body[hash].getWord().equalsIgnoreCase(key)) {
			int m = getCollision_count();
			m++;
			setCollision_count(m);
		}

		if (body[hash] == null) {
			current_Size++;
			body[hash] = wn;

		} else {
			if (body[hash].getWord().equalsIgnoreCase(key)) {

				FileNode head = body[hash].getFile();

				while (!head.getFile_Name().equalsIgnoreCase(file_Name) && head.getNext() != null) {
					head = head.getNext();
				}

				if (head.getFile_Name().equalsIgnoreCase(file_Name)) {
					int a = head.getWord_Count();
					a++;
					head.setWord_Count(a);

				} else {
					FileNode node = new FileNode(file_Name);
					head.setNext(node);
				}

			} else {

				while (body[hash] != null && !body[hash].getWord().equalsIgnoreCase(key)) {
					j++;
					hash = ((k % capacity) + (j * dk)) % capacity;
				}

				if (body[hash] == null) {
					current_Size++;
					body[hash] = wn;

				} else if (body[hash].getWord().equalsIgnoreCase(key)) {
					FileNode head = body[hash].getFile();
					while (!head.getFile_Name().equalsIgnoreCase(file_Name) && head.getNext() != null) {
						head = head.getNext();
					}

					if (head.getFile_Name().equalsIgnoreCase(file_Name)) {
						int a = head.getWord_Count();
						a++;
						head.setWord_Count(a);

					} else {
						FileNode node = new FileNode(file_Name);
						head.setNext(node);
					}
				}

			}

		}
		if (getCurrentLoad_Factor() >= load_Factor) {
			resize_4();
		}

	}

	public void resize_4() {
		int cap = capacity * 2;
		WordNode[] resized = new WordNode[capacity * 2];
		WordNode[] temp = new WordNode[capacity * 2];
		for (int i = 0; i < body.length; i++) {
			if (body[i] != null) {
				temp[i] = body[i];
			}
		}

		setCapacity(cap);
		setCurrent_Size(0);
		setCollision_count(0);
		setBody(resized);

		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != null) {
				put_Function_4(temp[i]);
			}
		}

	}

	public void search_4(int choice, String key) {
		if (choice == 0) {
			Scanner input = new Scanner(System.in);
			System.out.print(">Search: ");
			String key1 = input.next();
			key = key1;
		}
		int documentcount = 0, j = 0;
		int q = 7;
		int k = PAF(key);
		int dk = q - (k % q);
		int hash = ((k % capacity) + (j * dk)) % capacity;

		if (body[hash] != null && body[hash].getWord().equalsIgnoreCase(key)) {

			FileNode head = body[hash].getFile();

			while (head != null) {
				System.out.println(head.getWord_Count() + "-" + head.getFile_Name());
				documentcount++;
				head = head.getNext();
			}
		} else {
			while (body[hash] != null && !body[hash].getWord().equalsIgnoreCase(key)) {
				j++;
				hash = ((k % capacity) + (j * dk)) % capacity;
			}
			if (body[hash] == null) {
				System.out.println("Not found!");

			} else if (body[hash].getWord().equalsIgnoreCase(key)) {
				FileNode head = body[hash].getFile();

				while (head != null) {
					System.out.println(head.getWord_Count() + "-" + head.getFile_Name());
					documentcount++;
					head = head.getNext();
				}

			}

		}
		if (documentcount != 0) {
			System.out.println();
			System.out.println(documentcount + " documents found");
		}

	}

	public void remove_4(String key) {

		int j = 0;
		int q = 7;
		int k = PAF(key);
		int dk = q - (k % q);
		int hash = ((k % capacity) + (j * dk)) % capacity;
		if (body[hash] == null) {
			System.out.println("There is no word to remove");
		} else if (body[hash].getWord().equalsIgnoreCase(key)) {
			body[hash] = null;
			System.out.println(key + " is removed.");
			current_Size--;
		} else {
			while (body[hash] != null && !body[hash].getWord().equalsIgnoreCase(key)) {
				j++;
				hash = ((k % capacity) + (j * dk)) % capacity;
			}
			if (body[hash] == null) {
				System.out.println("There is no word to remove!");

			} else if (body[hash].getWord().equalsIgnoreCase(key)) {
				body[hash] = null;
				System.out.println(key + " is removed.");
				current_Size--;

			}
		}

	}

}
