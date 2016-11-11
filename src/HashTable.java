import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class HashTable {
	private int size_of_table; // arrayin size
	private WordNode[] hashArray;
	private int bigestCollision;
	
	
	
public HashTable(int table_size){
    this.size_of_table = nextPrime(table_size);
    hashArray = new WordNode[size_of_table];
    bigestCollision = 0;
}

// for prime number calc
public int nextPrime(int n) {
    boolean isPrime = false;

    int start = 2; 

    while (!isPrime) {
        
        n += 1;
        
        int m = (int) Math.ceil(Math.sqrt(n));

        isPrime = true;
        
        for (int i = start; i <= m; i++) {
            if (n % i == 0) {
                isPrime = false;
                break;
            } 
        }
        
    }
    return n;
}

// Getters and Setters/////////

public int getSize_of_table() {
	return size_of_table;
}
public int getBigestCollision() {
	return bigestCollision;
}

public void setBigestCollision(int bigestCollision) {
	this.bigestCollision = bigestCollision;
}

public void setSize_of_table(int size_of_table) {
	this.size_of_table = size_of_table;
}
public WordNode[] getHashArray() {
	return hashArray;
}
public void setHashArray(WordNode[] hashArray) {
	this.hashArray = hashArray;
}

////////////////////////////////

public int hashFunction(String str){ //hash function
	 String key = str.toLowerCase(); // that provides a resolve conflicts between upper and lower case
	 long prime = 0x811C9DC5;
     long hash = 0;

     for(int i = 0; i < key.length(); i++)
     {
     hash *= prime;
     hash ^= key.charAt(i);
     }
     
     if(hash<0)
    	 hash=hash*(-1);
     int return_value=(int)(hash % size_of_table);
     return return_value;
}


//public WordList rehash(){
//	WordList returnlist = new WordList();
//	for (int i = 0; i < hashArray.length; i++) {
//		if(hashArray[i]!=null){
//			
//			
//			if(hashArray[i].headGetter()!=null){
//				WordNode temp = hashArray[i].getconnected_list_head_first_node();
//				while(temp!=null){
//					WordNode addition_node = temp;
//					returnlist.add(addition_node);
//					temp=temp.getNext_node();
//				}
//				returnlist.add(hashArray[i]);
//			}
//			else{
//				WordNode addition_node=hashArray[i];
//				returnlist.add(addition_node);
//			}
//			
//		}
//	}
//	return returnlist;
//}

// rehash process
public WordNode[] rehash2(int count){
	WordNode[] returnarray = new WordNode[count];
	int index=0;
	for (int i = 0; i < hashArray.length; i++) {
		if(hashArray[i]!=null){
			returnarray[index]=hashArray[i];
			index++;
			if(hashArray[i].headGetter()!=null){
				WordNode temp = hashArray[i].headGetter();
				while(temp!=null){
					returnarray[index]=temp;
					index++;
					temp=temp.getNext_node();
				}
			}
		}
		
		
	}
	return returnarray;
}
public void add(String word,String text_title){ // ekleme fonksiyonu
	 int value = hashFunction(word);
	 if(hashArray[value]==null){
		 WordNode newnode=new WordNode(word);
		 newnode.initializeTextList(text_title);
		 hashArray[value]=newnode;
	 }
	 else{
		 if(hashArray[value].headGetter() == null){
			if(hashArray[value].getWord().equalsIgnoreCase(word)){
				hashArray[value].initializeTextList(text_title);
			}
			else{
				WordList newlist=new WordList();
				newlist.initializationProcess(word, text_title);
				hashArray[value].setConnected_list(newlist);
				hashArray[value].setNext_node(newlist.getHead());
			}
		 }
		 else{
			 if(hashArray[value].getConnected_list()!=null){
				 if(hashArray[value].getConnected_list().getCollision() > getBigestCollision())
					 setBigestCollision(hashArray[value].getConnected_list().getCollision());
			 }
			 if(hashArray[value].getWord().equalsIgnoreCase(word)){
				 hashArray[value].initializeTextList(text_title);
			 }
			 else{
				 hashArray[value].getConnected_list().initializationProcess(word, text_title);
				 hashArray[value].setNext_node( hashArray[value].headGetter());
			 }
		 }
	 }
	 
	 
	 
	 
	 
}
// Search Method under construction
public TextList search(String word){ // search fonksiyonu 
	int value = hashFunction(word);
	if(hashArray[value]!=null){
		if(hashArray[value].getWord().equalsIgnoreCase(word)){
			return hashArray[value].getTxtlist();
		}
		else{
			if(hashArray[value].headGetter()!=null){
				WordNode temp = hashArray[value].headGetter();
				
				while(temp!=null){
					if(temp.getWord().equalsIgnoreCase(word)){
						
						return temp.getTxtlist();						
					}
					temp=temp.getNext_node();
					
				}
                return null;
			}
			else
				return null;
			
		}
	}
	else
		return null;
}
//Test///////////////////////////////////////////////////////////////
public void display() throws FileNotFoundException{
	PrintStream console = System.out;
	long time = System.currentTimeMillis();
	File file = new File(time + "hashtable.txt");
	FileOutputStream fos = new FileOutputStream(file);
	PrintStream ps = new PrintStream(fos);
	System.setOut(ps);
	for (int i = 0; i < hashArray.length; i++) {
		if(hashArray[i]!=null){
			System.out.println(hashArray[i].getWord() + " - " + "[" + i + "]");
			if(hashArray[i].headGetter()!=null){
				WordNode temp = hashArray[i].headGetter();
				while(temp!=null){
					System.out.print(" - " + temp.getWord().toLowerCase() + " - ");
					temp=temp.getNext_node();
				}
			}
		}
		
		
	}
//	System.out.println();
//	System.out.println("Collision is " + getCollisionNumber() + " times occured.");
	System.setOut(console);
}


public int getCollisionNumber(){
	int collision = 0;
	for (int i = 0; i < hashArray.length; i++) {
		if(hashArray[i] != null)
			collision=collision + hashArray[i].getConnected_list().getCollision();
	}
	return collision;
}

// You will add a system that recognizes which sorting will be done
public void searchDisplay(String wordtry) throws FileNotFoundException{ // attigimiz kelimeyi arayip bize onun hangi txtlerde kactane oldugunu gosterir
	TextList returnedlist = search(wordtry);
	PrintStream console = System.out;
	long time = System.currentTimeMillis();
	File file = new File(time + "output.txt");
	FileOutputStream fos = new FileOutputStream(file);
	PrintStream ps = new PrintStream(fos);
	System.setOut(ps);
	if(returnedlist != null){
		TextNode temp = returnedlist.getHead();
		while(temp!=null){
			System.out.println(temp.getTxtName() + " - " + temp.getWordCount());
			temp=temp.getNextNode();
		}
	}
	System.setOut(console);
	System.out.println("File written successfully: " + file.getAbsolutePath());
	
}
/////////////////////////////////////////////////////////
}
