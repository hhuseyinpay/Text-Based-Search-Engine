
public class TextList {
	private int length;
    private TextNode head=null;

    public TextList(){
    	length=0;
    }
    
    
public int getLength() {
		return length;
	}


	public void setLength(int length) {
		this.length = length;
	}


public TextNode getHead() {
	return head;
}

public void add(TextNode node) {
	setLength(getLength()+1);
	if(this.head==null){
		this.head = node;	
	}
	else{
		node.setNextNode(head);
		head=node;
	}
	
}

public void initializationProcess(String word){
	String table_addition = word.toLowerCase();
	
	if(this.head != null){
		TextNode temp=getHead();
		boolean flag=false;
		
		while(temp != null){
			if(temp.getTxtName().equalsIgnoreCase(table_addition)){
				temp.setWordCount(temp.getWordCount()+1);
				flag=true;
				break;
			}
			temp=temp.getNextNode();
		}
		
		if(flag==false){
			TextNode newnode = new TextNode(table_addition);
			add(newnode);
		}
			
		
	}
	else{
		TextNode newnode = new TextNode(table_addition);
		add(newnode);
	}
	
}
public TextNode search(String txt){ // This part could be a problem for us because of return statements observe its behaviour
	if(head!=null){
		TextNode temp = getHead();
		while(temp != null){
			if(temp.getTxtName().equalsIgnoreCase(txt)){
				return temp;
			}
			temp=temp.getNextNode();
		}
		return null;
	}
	else
		return null;
}


}
