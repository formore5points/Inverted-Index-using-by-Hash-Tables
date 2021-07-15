
public class FileNode {
	private String file_Name;
	private FileNode next;
	private int word_Count;

	public FileNode(String file_Name) {
		super();
		this.file_Name = file_Name;
		this.next = null;
		this.word_Count = 1;
	}

	public String getFile_Name() {
		return file_Name;
	}

	public void setFile_Name(String file_Name) {
		this.file_Name = file_Name;
	}

	public FileNode getNext() {
		return next;
	}

	public void setNext(FileNode next) {
		this.next = next;
	}

	public int getWord_Count() {
		return word_Count;
	}

	public void setWord_Count(int word_Count) {
		this.word_Count = word_Count;
	}

}
