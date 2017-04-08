
public final class Mergesort {
	
	static int[] array;
	
	public static void run(int[] theArray){
		array = theArray;
		
		int arrayLength = array.length;
		
		long startTime = System.nanoTime();
		
		//do the actual merge sort
		mergeSort(array, 0, arrayLength - 1);
		
		long endTime = System.nanoTime() - startTime;
		System.out.println("Merge Sort [Best/Avg/Worst: O(n log n)] runtime (ns) = " + endTime);
		
	}
	
	public static void mergeSort(int[] currentArray, int left, int right){
		if (right > left){
			int middle = (right + left) / 2;
			
			mergeSort(currentArray, left, middle);
			mergeSort(currentArray, middle + 1, right);
			
			merge(currentArray, left, middle, right);
		}
	}
	
	public static void merge(int[] currentArray, int left, int middle, int right){
		//find sizes of subarrays
		int lengthLeft = middle - left + 1;
		int lengthRight = right - middle;
		//initialize new temp arrays
		int[] leftArray = new int[lengthLeft];
		int[] rightArray = new int[lengthRight];
		//create temporary arrays
		for (int i = 0; i < lengthLeft; i++){
			leftArray[i] = currentArray[i + left];
		}
		for (int j = 0; j < lengthRight; j++){
			rightArray[j] = currentArray[j + middle + 1];
		}
		
		//go through left and right, revert i and j to restart for loops
		//k is the starting index of the merged subArray
		int i = 0, j = 0;
		int k = left;
		
		while (i < lengthLeft && j < lengthRight){
			//while loop will iterate through Left & Right while comparing and adding
			if (leftArray[i] <= rightArray[j]){
				currentArray[k] = leftArray[i];
				i++;
			} else {
				currentArray[k] = rightArray[j];
				j++;
			}
			k++;
		}
		
		//deal with remaining values
		while (i < lengthLeft){
			currentArray[k] = leftArray[i];
			i++;
			k++;
		}
		
		while (j < lengthRight){
			currentArray[k] = rightArray[j];
			j++;
			k++;
		}
		
	}

}
