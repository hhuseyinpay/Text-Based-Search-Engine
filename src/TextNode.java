
public class TextNode {
	private String txtName;
	private int wordCount;
	private TextNode nextNode;
	private int rank;

	// textlerin tutuldugu node listesi word node larda bulunur
	public TextNode(String ttl) {
		this.txtName = ttl;
		this.wordCount = 1;
		rank = 0;

	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getRank() {
		return rank;
	}

	public String getTxtName() {
		return txtName;
	}

	public void setTxtName(String title) {
		this.txtName = title;
	}

	public int getWordCount() {
		return wordCount;
	}

	public void setWordCount(int word_count) {
		this.wordCount = word_count;
	}

	public TextNode getNextNode() {
		return nextNode;
	}

	public void setNextNode(TextNode next_node) {
		this.nextNode = next_node;
	}

}
