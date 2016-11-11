
public class OANode {

	private String word;
	private TextList textList;

	public OANode(String key, String path) {
		textList = new TextList();
		this.word = key;
		textList.initializationProcess(path);
	}

	public String getWord() {
		return word;
	}

	public void add(String path) {
		textList.initializationProcess(path);
	}

	public TextList getTextList() {
		return textList;
	}

}
