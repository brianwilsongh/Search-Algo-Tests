
public final class Quicksort {
	private static int[] array;

	
	public static void run(int[] inputArray) {
		// Quicksort is moved to its own class, changes array in here

		//member array is set equal to input array
		array = inputArray;
		int arrayLength = array.length;
		
		long startTime = System.nanoTime();
		
		//do the actual sort
		doQuicksort(0, arrayLength - 1);
		
		long endTime = System.nanoTime() - startTime;
		System.out.println("Quick Sort [Best/Avg: O(n log n), Worst: O(n^2)] runtime (ns) = " + endTime);
		
	}

	private static void doQuicksort(int startIndex, int endIndex) {

		int pivot = array[startIndex + ((endIndex - startIndex) / 2)];
		// pivot is the approx middle of the array, chosen randomly
		int i = startIndex;
		int j = endIndex;

		while (i < j) {
			// while the start and end haven't met yet
			while (array[i] < pivot) {
				i++;
			}

			while (array[j] > pivot) {
				j--;
			}
			
			if (i <= j){
				swapIndexValues(i, j);
				//move index to next position
				i++;
				j--;
			}
		}
		
		if (startIndex < j){
			//if there is a left chunk of array, call recursively
			doQuicksort(startIndex, j);
		}
		
		if (endIndex > i){
			//if the right chunk exists, call recursively
			doQuicksort(i, endIndex);
		}
		
	}
	
	private static void swapIndexValues(int i, int j){
		//helper method to swap values left/right of the pivot
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		
	}

}
