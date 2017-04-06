import java.util.Arrays;

public final class Heapsort {
	static int[] heapArray;
	

	public static void run(int[] inputArray) {
		heapArray = inputArray.clone();
		int inputArrayLength = inputArray.length;
		
		//start the timer
		long startTime = System.nanoTime();
		
		//build the heap
		buildMinHeap(heapArray);
		
		//pull from the heap, replacing each value of inputArray as iteration proceeds
		for (int idx = 0; idx < inputArrayLength; idx++){
			inputArray[idx] = pullRoot(heapArray);
		}
		
		//end the timer, record/print
		long endTime = System.nanoTime() - startTime;
		System.out.println("Heap Sort runtime (ns) = " + endTime);

	}
	
	private static int pullRoot(int[] array){
		//save root value, swap it with the last element in the tree
		int rootValue = array[0];
		int arrayLength = array.length;
		//shorter array will be filled with values after heapify
		int[] shorterArray = new int[arrayLength - 1];
		
		array[0] = array[arrayLength - 1];
		
		//heapify to trickle the new value down
		heapify(array, 0);
		
		//alter the original array ("testArray") by copying a 1-shorter version
		System.arraycopy(array, 0, shorterArray, 0, (arrayLength - 1));
		heapArray = shorterArray;

		
//		System.arraycopy(array, 0, testArray, 0, arrayLength - 1);
		return rootValue;
	}
	
	private static void heapify(int[] array, int idx){
		//this currently works with min heap, keeping small at top of heap
		int arrayLength = array.length;
		int idxLeftChild;
		int idxRightChild;
		int temp;
		
		if ((idx * 2) + 1 <= arrayLength -1){
			//if the left child exists, compare and swap if necessary, then recursively call heapify
			idxLeftChild = idx * 2 + 1;
			if (array[idx] > array[idxLeftChild]){
				temp = array[idx];
				array[idx] = array[idxLeftChild];
				array[idxLeftChild] = temp;
				heapify(array, idxLeftChild);
				//the left child was swapped with parent, so call heapifiy on THAT
			}
		}
		
		if ((idx * 2) + 2 <= arrayLength - 1){
			//if the right child exists, compare and swap if necessary, then recursively call heapify
			idxRightChild = idx * 2 + 2;
			if (array[idx] > array[idxRightChild]){
				temp = array[idx];
				array[idx] = array[idxRightChild];
				array[idxRightChild] = temp;
				heapify(array, idxRightChild);
				//the right child was swapped with parent, call heapify on THAT
			}
		}

	}

	private static void buildMinHeap(int[] array) {
		int arrayLength = array.length;
		boolean sortedFlag = false;

		while (!sortedFlag) {
			sortedFlag = true;
			for (int idx = 0; idx < array.length; idx++) {

				int indexOfLeftChild;
				int indexOfRightChild;
				int temp;

				if ((idx * 2) + 1 <= arrayLength - 1) {
					// check if left child exists, if so compare and swap if
					// necessary
					indexOfLeftChild = idx * 2 + 1;
					if (array[idx] > array[indexOfLeftChild]) {
						// if the left child is smaller than parent, swap the
						// values
						temp = array[idx];
						array[idx] = array[indexOfLeftChild];
						array[indexOfLeftChild] = temp;
						sortedFlag = false;
					}
				}

				if ((idx * 2) + 2 <= arrayLength - 1) {
					// check if right child exists, if so compare and swap if
					// necessary
					indexOfRightChild = idx * 2 + 2;
					if (array[idx] > array[indexOfRightChild]) {
						// if the right child is smaller than parent, swap the
						// values
						temp = array[idx];
						array[idx] = array[indexOfRightChild];
						array[indexOfRightChild] = temp;
						sortedFlag = false;
					}
				}

				// end?
			}

		}

	}

}
