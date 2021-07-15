
public class WordNode {
	private String word;
	private FileNode file;

	public WordNode(String word,String file_Name) {

		this.word = word;
		this.file = new FileNode(file_Name);
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public FileNode getFile() {
		return file;
	}

	public void setFile(FileNode file) {
		this.file = file;
	}

}
