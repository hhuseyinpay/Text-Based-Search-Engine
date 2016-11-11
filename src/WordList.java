
public class WordList {
	private WordNode head=null;
	private int collision;

	
	public WordList(){
		collision=0;
	}
	
	public WordNode getHead() {
		return head;
	}

	public void setHead(WordNode node) {
		if(this.head==null){
			this.head = node;	
		}
		else{
			node.setNext_node(head);
			head=node;
		}
		
	}
	
	public int getCollision() {
		return collision;
	}

	public void setCollision(int collision) {
		this.collision = collision;
	}

	public void add(WordNode node){
		setCollision(getCollision()+1);
		setHead(node);
	}
	public void initializationProcess(String word,String text_title){
		if (head != null){
			WordNode temp=getHead();
			boolean flag=false;
			
			while(temp != null){
				if(temp.getWord().equalsIgnoreCase(word)){
					temp.initializeTextList(text_title);
					flag=true;
					break;
				}
				temp=temp.getNext_node();
			}
			
			if(flag==false){
				WordNode newnode = new WordNode(word);
				newnode.initializeTextList(text_title);
				add(newnode);
			}
				
		}
		else{
			WordNode newnode = new WordNode(word);
			newnode.initializeTextList(text_title);
			add(newnode);
		}
	}
}
