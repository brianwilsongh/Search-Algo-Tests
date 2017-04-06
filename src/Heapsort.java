import java.util.Arrays;

public final class Heapsort {
	static int[] heapArray;
	static int heapArrayLength;

	public static void run(int[] inputArray) {
		// clone the input array into a heapArray we can work with
		heapArray = inputArray.clone();
		heapArrayLength = inputArray.length;

		// start the timer
		long startTime = System.nanoTime();

		// build the heap
		heapify(heapArray);

		// pull from the heap, replacing each value of inputArray as iteration
		int ctr = 0;
		//counter for inputArray index value
		for (int idx = heapArrayLength - 1; idx >= 0; idx--) {
			inputArray[ctr] = heapArray[0];
			ctr++;
			heapArray[0] = heapArray[idx];
			minHeap(heapArray, 0);
			heapArrayLength--;
		}

		// end the timer, record/print
		long endTime = System.nanoTime() - startTime;
		System.out.println("Heap Sort runtime (ns) = " + endTime);

	}

	private static void minHeap(int[] array, int idx) {
		// this currently works with min heap, keeping small at top of heap
		int idxLeft = (idx * 2) + 1;
		int idxRight = (idx * 2) + 2;
		int minimum = idx;
		
		if (idxLeft < heapArrayLength && array[idxLeft] < array[idx]){
			minimum = idxLeft;
		}
		
		if (idxRight < heapArrayLength && array[idxRight] < array[minimum]){
			minimum = idxRight;
		}
		
		if (idx != minimum){
			swap(array, idx, minimum);
			minHeap(array, minimum);
		}
		

	}
	
	private static void swap(int[] array, int i, int j){
		//helper method to swap the values at two indices
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private static void heapify(int[] array) {

		for (int idx = heapArrayLength; idx >= 0; idx--) {
			minHeap(array, idx);
		}

	}

}
