import java.util.Arrays;

public class Sorting {

	
	// MergeSort by Berk
	
	public TextNode[] mergeSort(TextNode[] data){  // This method for merge sort its recursive and return a sorted array
		  
		
		  int dataLength = data.length;
		  if(dataLength<=1){
		    return data;
		  }
		  else{
		    TextNode[] sorted = new TextNode[dataLength];
		    int middle = dataLength/2;
		    int rem = dataLength-middle;
		    TextNode[] left = new TextNode[middle];
		    TextNode[] right = new TextNode[rem];
		    System.arraycopy(data, 0, left, 0, middle);
		    System.arraycopy(data, middle, right, 0, rem);
		    left = this.mergeSort(left);
		    right = this.mergeSort(right);
		    sorted = merge(left, right);
		    return sorted;
		  }
		}
		 
		public TextNode[] merge(TextNode[] left, TextNode[] right){  // This method for merging given array
		  int lengthLeft = left.length;
		  int lengthRight = right.length;
		  TextNode[] merged = new TextNode[lengthLeft+lengthRight];
		  int i = 0;
		  int j = 0;
		  while(i<lengthLeft||j<lengthRight){
		    if(i<lengthLeft & j<lengthRight){
		      if(left[i].getWordCount()<=right[j].getWordCount()){
		        merged[i+j] = left[i];
		        i++;
		      }
		      else{
		        merged[i+j] = right[j];
		        j++;
		      }
		    }
		    else if(i<lengthLeft){
		      merged[i+j] = left[i];
		      i++;
		    }
		    else if(j<lengthRight){
		      merged[i+j] = right[j];
		      j++;
		     }
		   }
		   return merged;
		}
		// MergeSort by Berk
	    
	     // InsertionSort by Berk
		 public TextNode[] insertionSort(TextNode[] input){ 
	         
		        TextNode temp;
		        for (int i = 1; i < input.length; i++) {
		            for(int j = i ; j > 0 ; j--){
		                if(input[j].getWordCount() < input[j-1].getWordCount()){
		                    temp = input[j];
		                    input[j] = input[j-1];
		                    input[j-1] = temp;
		                }
		            }
		        }
		        return input;
		    }
     
	    
	    
		   //QuickSort by Hasan Huseyin
			static int partition(TextNode arr[], int left, int right) {
				int i = left, j = right;
				TextNode tmp;
				int pivot = arr[(left + right) / 2].getWordCount();

				while (i <= j) {
					while (arr[i].getWordCount() < pivot)
						i++;
					while (arr[j].getWordCount() > pivot)
						j--;
					if (i <= j) {
						tmp = arr[i];
						arr[i] = arr[j];
						arr[j] = tmp;
						i++;
						j--;
					}
				}
				;

				return i;
			}

			static void quickSort(TextNode arr[], int left, int right) {
				int index = partition(arr, left, right);
				if (left < index - 1)
					quickSort(arr, left, index - 1);
				if (index < right)
					quickSort(arr, index, right);
			}
			
			
			
			// RadixSort by Hasan Huseyin
			// A utility function to get maximum value in arr[]
			static TextNode getMax(TextNode arr[], int n) {
				TextNode mx = arr[0];
				for (int i = 1; i < n; i++)
					if (arr[i].getWordCount() > mx.getWordCount())
						mx = arr[i];
				return mx;
			}

			// A function to do counting sort of arr[] according to
			// the digit represented by exp.
			static void countSort(TextNode arr[], int n, int exp) {
				TextNode output[] = new TextNode[n]; // output array
				int i;
				int count[] = new int[10];
				Arrays.fill(count, 0);

				// Store count of occurrences in count[]
				for (i = 0; i < n; i++)
					count[(arr[i].getWordCount() / exp) % 10]++;

				// Change count[i] so that count[i] now contains
				// actual position of this digit in output[]
				for (i = 1; i < 10; i++)
					count[i] += count[i - 1];

				// Build the output array
				for (i = n - 1; i >= 0; i--) {
					output[count[(arr[i].getWordCount() / exp) % 10] - 1] = arr[i];
					count[(arr[i].getWordCount() / exp) % 10]--;
				}

				// Copy the output array to arr[], so that arr[] now
				// contains sorted numbers according to curent digit
				for (i = 0; i < n; i++)
					arr[i] = output[i];
			}

			// The main function to that sorts arr[] of size n using
			// Radix Sort	
			static void radixsort(TextNode arr[], int n) {
				// Find the maximum number to know number of digits
				TextNode m = getMax(arr, n);

				// Do counting sort for every digit. Note that instead
				// of passing digit number, exp is passed. exp is 10^i
				// where i is current digit number
				for (int exp = 1; m.getWordCount() / exp > 0; exp *= 10)
					countSort(arr, n, exp);
			}
			
			//BubbleSort by Baris
			public TextNode[] BubbleSort(TextNode[] num)
			{
			     int j;
			     boolean flag = true;   // set flag to true to begin first pass
			     TextNode temp;   //holding variable

			     while ( flag )
			     {
			            flag= false;    //set flag to false awaiting a possible swap
			            for( j=0;  j < num.length -1;  j++ )
			            {
			                   if ( num[ j ].getRank() < num[j+1].getRank() )   // change to > for ascending sort
			                   {
			                           temp = num[ j ];                //swap elements
			                           num[ j ] = num[ j+1 ];
			                           num[ j+1 ] = temp;
			                          flag = true;              //shows a swap occurred  
			                  } 
			            } 
			      } 
			     return num;
			} 
			
			
			// SelectionSort by Baris
			public TextNode[] SelectionSort (TextNode[] num)
			{
			     int i, j, first;
				 TextNode temp;  
			     for ( i = num.length - 1; i > 0; i -- )  
			     {
			          first = 0;   //initialize to subscript of first element
			          for(j = 1; j <= i; j ++)   //locate smallest element between positions 1 and i.
			          {
			               if( num[j].getRank() < num[first].getRank() )         
			                 first = j;
			          }
			          temp = num[ first ];   //swap smallest found with element in position i.
			          num[ first ] = num[ i ];
			          num[ i ] = temp; 
			      } 
			     return num;
			}
		 
		 
		 
}
