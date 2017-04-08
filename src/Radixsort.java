
public final class Radixsort {

	public static void run(int[] testArray) {
		long startTime = System.nanoTime();

		int n = testArray.length;
		int maximum = getMax(testArray);
		radixSort(maximum, testArray, n);
		
		long endTime = System.nanoTime() - startTime;
		System.out.println("Radix Sort (LSD) [Best/Avg/Worst: O(nk)] runtime (ns) = " + endTime);
	}
	
	public static void run(int maximum, int[] testArray) {
		long startTime = System.nanoTime();

		int n = testArray.length;
		radixSort(maximum, testArray, n);
		
		long endTime = System.nanoTime() - startTime;
		System.out.println("Radix Sort /w Max (LSD) [Best/Avg/Worst: O(nk)] runtime (ns) = " + endTime);
	}
	
	public static void radixSort(int maximum, int[]testArray, int n){
		int[] sortedArray = new int[n];
		
		//create an array of the same size as the test array for copying purposes

		for (int mod = 10; maximum/(mod/10) > 0; mod *= 10) {
			int[] digitBucket = new int[10];
			
			for (int i = 0; i < 10; i++) {
				// fill 0-9 "digitBucket" ArrayList with blank ArrayLists
				digitBucket[i] = 0;
			}

			for (int number : testArray) {
				// add numbers into bucket based on the least significant digit
				digitBucket[(number % mod) / (mod / 10)]++;
			}
			
			for (int i = 1; i < 10; i++){
				//for each value in the digitBucket from index 1 and beyond,
				//we will build a scaffold to place digits in the output array
				//scaffold tells us how many there are, so we can place them in designated areas
				//in the output array
				digitBucket[i] += digitBucket[i - 1];
			}

			for (int i = n - 1; i >= 0; i--) {
				// set number to allocated section of sortedArray, decrement count in bucket
				//this has to be backwards because digitBucket's counter for each digit is decrementing!
				sortedArray[digitBucket[(testArray[i] % mod)/(mod / 10)] - 1] = testArray[i];
				digitBucket[(testArray[i] % mod)/(mod / 10)]--;
			}

			for (int i = 0; i < n; i++) {
				testArray[i] = sortedArray[i];
			}

			// clear out the array for another use, move to next LSD position
		}

	}
	
	private static int getMax(int[] array){
		int returnValueIdx = 0;
		for (int i = 1; i < array.length; i++){
			if(array[i] > array[returnValueIdx]){
				returnValueIdx = i;
			}
		}
		return array[returnValueIdx];
	}

}
