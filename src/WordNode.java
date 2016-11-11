
public class WordNode {
private String word;
private TextList txtlist;
private WordNode next_node;
private WordList connected_list; // bu kisim sadece hasharrayde kayitli olan node doludur o da ona baglanan listeyi tutmak icin
public WordNode(String ttl){
	this.word=ttl;
	this.next_node=null;
	this.txtlist=new TextList();
	this.connected_list=new WordList();
 }
// kelimelerin tutuldugu node lar
// Get and Set Blocks

public String getWord() {
	return word;
}
public TextList getTxtlist() {
	return txtlist;
}

public void setTxtlist(TextList txtlist) {
	this.txtlist = txtlist;
}

public void setWord(String name) {
	this.word = name;
}
public WordNode getNext_node() {
	return next_node;
}
public WordNode getconnected_list_head_first_node(){
	return connected_list.getHead();
}
public void setNext_node(WordNode next_node) {
	this.next_node = next_node;
}

public WordList getConnected_list() {
	return connected_list;
}

public void setConnected_list(WordList connected_list) {
	this.connected_list = connected_list;
}

//List operation methods
public WordNode headGetter(){
	return connected_list.getHead();
}
public TextNode searchText(String txt){
	TextNode returnnode;
	returnnode=txtlist.search(txt);
	return returnnode;
}
public void initializeTextList(String text_title){
	this.txtlist.initializationProcess(text_title);
}





}
