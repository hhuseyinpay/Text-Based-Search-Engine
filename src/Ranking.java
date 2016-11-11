import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Ranking {

	private Sorting sorter;

	public enum Sort {
		MERGE, INSERTION, QUICK, RADIX, BUBBLE, SELECTION
	}

	public Sort sortType;

	public Ranking() {
		sorter = new Sorting();
	}

	////////////////////////////////// Necessary Ranking
	////////////////////////////////// Methods///////////////////////////////
	public void comparison(TextList[] queryContainLists,Sort sortType) throws FileNotFoundException {

		int sizeCount = 0; ///// This for learning total size

		///// This for learning total size
		for (int i = 0; i < queryContainLists.length; i++) {
			sizeCount = sizeCount + queryContainLists[i].getLength();
		}

		///// This for learning total size

		TextNode[] rankingArray = new TextNode[sizeCount]; // this will contain
															// nulls after
															// correct that we
															// will return it

		int paritionIndex = 0; // Will be parite the parts of the array

		for (int i = 0; i < queryContainLists.length; i++) {
			TextNode[] tempNodeArray = listToArrayConverter(queryContainLists[i]); // For
																					// converting
																					// related
																					// list
																					// to
																					// array
																					// prevent
																					// list
																					// problems

			// For understanding is it first tour
			if (paritionIndex > 0) {
				for (int j = 0; j < paritionIndex; j++) {
					for (int k = 0; k < tempNodeArray.length; k++) {
						if (rankingArray[j] != null) {

							if (rankingArray[j].getTxtName().equalsIgnoreCase(tempNodeArray[k].getTxtName())) {
								tempNodeArray[k].setRank(
										(int) ((tempNodeArray[k].getWordCount() + rankingArray[j].getWordCount()
												+ rankingArray[j].getRank()) * Math.pow(10, i + 1)));
								rankingArray[j] = null;

							}

						}
					}
				}
			}

			for (int k = 0; k < tempNodeArray.length; k++) {
				rankingArray[k + paritionIndex] = tempNodeArray[k];
				rankingArray[k + paritionIndex].setRank(tempNodeArray[k].getRank() + tempNodeArray[k].getWordCount());
			}

			paritionIndex = paritionIndex + tempNodeArray.length;

		}

		rankingArray = nullResolving(rankingArray);
		rankingArray = sortArrays(rankingArray, sortType);

		printTextFile(rankingArray);

	}

	public void printTextFile(TextNode[] resultArray) throws FileNotFoundException {
		/////////// For Displaying Array

		PrintStream console = System.out;
		long time = System.currentTimeMillis();
		File file = new File(time + "searchResult.txt");
		FileOutputStream fos = new FileOutputStream(file);
		PrintStream ps = new PrintStream(fos);
		System.setOut(ps);
		for (int i = 0; i < resultArray.length; i++) {

			System.out
					.println("Text Name is :" + resultArray[i].getTxtName() + " Rank is: " + resultArray[i].getRank());
		}

		System.setOut(console);
		
		/////////////////////////////////////////
	}
	
	
	public TextNode[] listToArrayConverter(TextList givenList) {

		if (givenList.getHead() != null) {
			int index = 0;
			TextNode[] returnArray = new TextNode[givenList.getLength()];
			TextNode temp = givenList.getHead();
			while (temp != null) {
				returnArray[index] = temp;
				index++;
				temp = temp.getNextNode();
			}
			return returnArray;
		} else
			return null;
	}

	public TextNode[] nullResolving(TextNode[] arrayContainNulls) {
		int nullCounter = 0;
		for (int i = 0; i < arrayContainNulls.length; i++) {
			if (arrayContainNulls[i] == null)
				nullCounter++;
		}
		TextNode[] returnArray = new TextNode[arrayContainNulls.length - nullCounter];
		int index = 0;
		for (int i = 0; i < arrayContainNulls.length; i++) {
			if (arrayContainNulls[i] != null) {
				returnArray[index] = arrayContainNulls[i];
				index++;
			}

		}
		return returnArray;

	}
	////////////////////////////////// Necessary Ranking
	////////////////////////////////// Methods///////////////////////////////
	
	
	public TextNode[] sortArrays(TextNode[] sortedArr, Sort sort){
		switch(sort){
		case INSERTION:
			sortedArr=sorter.insertionSort(sortedArr);
		case QUICK:
			sorter.quickSort(sortedArr, 0, sortedArr.length-1);
		case MERGE:
			sortedArr=sorter.mergeSort(sortedArr);
		case BUBBLE:
			sortedArr=sorter.BubbleSort(sortedArr);	
		case RADIX:
			sorter.radixsort(sortedArr, sortedArr.length);
		case SELECTION:
			sortedArr=sorter.SelectionSort(sortedArr);		
		}
		return sortedArr;
	}
	
}
