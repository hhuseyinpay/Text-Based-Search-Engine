import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;


public class FileOperation {
	private Set<String> stopword = new HashSet<String>();
	HashTable chainedHashTable;
	long start;
	long end;
	int counter;
	int rehashCount = 0;
	OpenAdressing oa;

	public FileOperation() {
		readStopWords();// load stopword in hashset
		chainedHashTable = new HashTable(10000); // chaining
		oa = new OpenAdressing(10000, (float) 0.5);
		counter = 0;
	}

	public void readWords(String folder,int caseNumber) {
		// dosya okumak icin
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		String line;
		

		String path[] = getDocumentName(folder);
		start = System.currentTimeMillis();// islem suresini olcmek icin
		for (int i = 0; i < path.length; i++) {// tek tek dosyalari dolasiyor
			if (path[i] != null) {
				try {// dosyalari okumak icin stream aciyor
					fis = new FileInputStream(folder + path[i]);
					isr = new InputStreamReader(fis, "UTF-8");
					br = new BufferedReader(isr);

					// satir satir okuyor
					while ((line = br.readLine()) != null) {
						String cleanWord[] = checkStopWords(line.toLowerCase(Locale.ENGLISH).replaceAll("[^a-zA-Z0-9\\s]", " ").split("\\s+"));
						for (String word : cleanWord) {
							if (word != null && word.length() > 2) {
								// ***HASH TABLE FUNCTION*****
								counter++;
								if(caseNumber == 1)
									oa.quadraticProbing(word, path[i].toString());
								else if(caseNumber == 2)
									oa.linearProbing(word, path[i].toString());
								else if(caseNumber == 3)
									oa.doubleProbing(word, path[i].toString());
								else if(caseNumber == 4){
									chainedHashTable.add(word, path[i].toString());
									if(chainedHashTable.getBigestCollision()>10){
										startRehashProcess(counter);
										rehashCount++;
//										System.out.println("rehashed ");
									}
								
								}
								
								
							}
						}
					}
					br.close();
				} catch (Exception ex) {
					System.out.println(ex.toString());
					System.out.println("Error: FileOperation > readWords()");
				}
			}
		}

		// print
		end = System.currentTimeMillis();
//		System.out.println((end - start) / 1000f + " seconds for reading");
	

		// ****SEARCH FUCTION****
	}
	
	private void startRehashProcess(int added_count){
		int size=chainedHashTable.nextPrime(chainedHashTable.getSize_of_table()*2);
		HashTable newtable = new HashTable(size);
		WordNode[] initialized_words = chainedHashTable.rehash2(added_count);
		
		for (int i = 0; i < initialized_words.length; i++) {
			if (initialized_words[i]!=null){
				WordNode wordtemp = initialized_words[i];
				
			
					TextNode texttemp = wordtemp.getTxtlist().getHead();
					while(texttemp!=null){
						newtable.add(wordtemp.getWord(), texttemp.getTxtName());
						texttemp=texttemp.getNextNode();
					}
				
				
			}
		}
		chainedHashTable=newtable;
		
	}

	private String[] checkStopWords(String[] words) {

		int len = words.length;
		String[] wordsRet = new String[len];
		for (int i = 0; i < len; i++)
			if (!stopword.contains(words[i]))
				wordsRet[i] = words[i].trim();

		return wordsRet;
	}

	private void readStopWords() {
		String line;
		try {
			InputStream fis = new FileInputStream("/Users/aaa/Documents/workspace/SearchEngine/src/stopwords.txt");
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);

			while ((line = br.readLine()) != null)
				stopword.add(line);

			br.close();
		} catch (IOException ex) {
			System.out.println(ex.toString());
			System.out.println("Error: FileOperation > readStopWords()");
		}
	}

	public String[] getDocumentName(String myAdress) {

		String[] documentAdress;
		File folder = new File(myAdress);
		File[] listOfFiles = folder.listFiles();
		documentAdress = new String[listOfFiles.length];

		for (int i = 0; i < listOfFiles.length; i++)
			if (listOfFiles[i].isFile() && listOfFiles[i].getName().endsWith(".txt"))
				documentAdress[i] = listOfFiles[i].getName();

		return documentAdress;
	}
}
