import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class OpenAdressing {

	public enum Probing {
		LINEAR, DOUBLE, QUADRATIC
	}


	private int currentSize, TABLE_SIZE;
	private float LOAD_FACTOR;
	private int PRIME;
	
	//My Try
	public Probing probing;

	private OANode table[];
	private int collisions;

	public OpenAdressing(int capacity, float loadFactor) {
		currentSize = 1;
		collisions = 0;
		TABLE_SIZE = nextPrime(capacity / 2);
//		System.out.println("Table size: " + TABLE_SIZE);
		PRIME = nextPrime(capacity);
		table = new OANode[PRIME];
		LOAD_FACTOR = loadFactor;
		TABLE_SIZE = PRIME;
	}

	public int getTableSize(){
		return table.length;
	}
	
	public void displayTable(){
		PrintStream console = System.out;
		long time = System.currentTimeMillis();
		File file = new File(time + "hashtable.txt");
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintStream ps = new PrintStream(fos);
		System.setOut(ps);
		for (int i = 0; i < table.length; i++) {
			if(table[i] != null){
			System.out.println(table[i].getWord().toLowerCase());
			}
		}
		System.setOut(console);
	}
	
	public void linearProbing(String word, String path) {
		if (isReHash())
			reHash(Probing.LINEAR);

		int key = hash_hasan(word) % TABLE_SIZE;
		int check = key;
		do {
			if (table[key] == null) {// yer bos ise direk ekle
				table[key] = new OANode(word, path);
				currentSize++;
				return;
			} else if (table[key].getWord().equals(word)) {
				table[key].add(path);
				return;
			} else {
				key = (key + 1) % TABLE_SIZE;
				collisions++;
			}
		} while (check != key);
//		System.out.println("kayip");
	}

	public void doubleProbing(String word, String path) {
		if (isReHash())
			reHash(Probing.DOUBLE);

		int key = hash_hasan(word) % TABLE_SIZE;
		int check = key;
		do {
			if (table[key] == null) {// yer bos ise direk ekle
				table[key] = new OANode(word, path);
				currentSize++;
				return;
			} else if (table[key].getWord().equals(word)) {
				table[key].add(path);
				return;
			} else {
				key = (key + hash_berk(word)) % TABLE_SIZE;
				collisions++;
			}
		} while (check != key);
//		System.out.println("kayip");
	}

	public void quadraticProbing(String word, String path) {
		if (isReHash())
			reHash(Probing.QUADRATIC);

		int key = hash_hasan(word) % TABLE_SIZE;
		int h = 0;
		while (true) {
			if (table[key] == null) {// yer bos ise direk ekle
				table[key] = new OANode(word, path);
				currentSize++;
				return;
			} else if (table[key].getWord().equals(word)) {// şu anki yerde yeni
				table[key].add(path);// path listesine ekle
				return;
			} else {
				h++;
				key = (key + h * h + h << 10) % TABLE_SIZE;
				collisions++;
			}
		}
	}

	public TextList search(String word, Probing TYPE) {
		int key = hash_hasan(word) % TABLE_SIZE;
		if (table[key] == null) // control
			return null;

		switch (TYPE) {
		case LINEAR:
			while (true) {
				if (table[key] == null)
					return null;
				else if (table[key].getWord().equalsIgnoreCase(word))
					return table[key].getTextList();
				else
					key = (key + 1) % TABLE_SIZE;

			}
		case DOUBLE:
			while (true) {
				if (table[key] == null)
					return null;
				else if (table[key].getWord().equalsIgnoreCase(word))
					return table[key].getTextList();
				else
					key = (key + hash_berk(word)) % TABLE_SIZE;
			}
		case QUADRATIC:
			int h = 0;
			while (true) {
				if (table[key] == null)
					return null;
				else if (table[key].getWord().equalsIgnoreCase(word))
					return table[key].getTextList();
				else {
					h++;
					key = (key + h * h + h << 10) % TABLE_SIZE;
					collisions++;
				}
			}
		default:
//			System.out.println("Search Failed!");
			break;
		}
		return null;
	}

	public int hash_hasan(String word) {
		int len, tmp, hash;

		if ((len = word.length() - 1) <= 0 || word == null) {
			word = "xyza";
			len = 3;
		}

		int rem = len & 3;
		hash = len << 25;
		for (; len > 0; len--) {
			hash += word.charAt(len);
			tmp = (word.charAt(len >> 1) << 11) ^ hash;
			hash = (hash << 16) ^ tmp;
			hash += hash >> 11;
		}

		switch (rem) {
		case 3:
			hash += hash >> 16;
			hash ^= hash << 16;
			hash ^= word.charAt(len >> 1) << 29;
			hash += hash >> 11;
			hash += hash & 1;
			break;
		case 2:
			hash += hash >> 16;
			hash ^= hash << 11;
			hash += hash >> 17;
			break;
		case 1:
			hash += word.charAt(len >> 1);
			hash ^= hash << 10;
			hash += hash >> 1;
			hash += hash & 1;
			break;
		}

		hash ^= hash << 3;
		hash += hash >> 5;
		hash ^= hash << 4;
		hash += hash >> 17;
		hash ^= hash << 25;
		hash += hash >> 6;
		return Math.abs(hash);
	}

	public int hash_berk(String str) { // hash function
		String key = str.toLowerCase(); // that provides a resolve conflicts
										// between upper and lower case
		long prime = 0x811C9DC5;
		long hash = 0;
		for (int i = 0; i < key.length(); i++) {
			hash *= prime;
			hash ^= key.charAt(i);
		}

		if (hash < 0)
			hash = hash * (-1);

		int return_value = (int) (hash % TABLE_SIZE);
		return return_value;
	}

	private void reHash(Probing TYPE) {
//		System.out.println("rehash");
//		System.out.println("currentSize" + currentSize);

		OANode tmp[] = new OANode[PRIME];
		int key;
		for (int i = 0; i < TABLE_SIZE; i++) {
			if (table[i] != null) {
				key = hash_hasan(table[i].getWord()) % PRIME;
				int h = 0;
				while (tmp[key] != null) {
					switch (TYPE) {
					case LINEAR:
						key = (key + 1) % TABLE_SIZE;
						collisions++;
						break;
					case DOUBLE:
						key = (key + hash_berk(table[i].getWord())) % TABLE_SIZE;
						collisions++;
						break;
					case QUADRATIC:
						h++;
						key = (key + h * h + h << 4) % TABLE_SIZE;
						collisions++;
						break;
					}
				}
				tmp[key] = table[i];
			}
		}
		TABLE_SIZE = PRIME;
		table = tmp;
		PRIME = nextPrime(PRIME);
//		System.out.println("After rehash table size: " + TABLE_SIZE);
	}

	private boolean isReHash() {
		if ((float) (((float) currentSize) / (float) TABLE_SIZE) > LOAD_FACTOR)
			return true;
		else
			return false;
	}

	public int getCollisions() {
		return collisions;
	}

	private int nextPrime(int number) {
		int n = number << 1;
		if (n % 2 == 0)
			n++;
		for (; !isPrime(n); n += 2)
			;
		return n;
	}

	private boolean isPrime(int n) {
		if (n == 2 || n == 3)
			return true;

		if (n == 1 || n % 2 == 0)
			return false;

		for (int i = 3; i * i <= n; i += 2)
			if (n % i == 0)
				return false;

		return true;
	}

}
