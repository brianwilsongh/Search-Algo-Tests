import java.util.Random;
import java.util.Scanner;

public class Algorithms {

	static boolean displayOutput = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("How long do you want the test array? (give integer)");
		int lengthOfTestArray = scanner.nextInt();
		System.out.println("Generate random values between 1 and... (give integer)");
		int randomCeiling = scanner.nextInt();
		System.out.println("Display sorted arrays onto screen? ('true' or 'false')");
		displayOutput = scanner.nextBoolean();
		System.out.println("-~-~-~(╯ಠ_ರೃ)╯︵ ┻━┻ LET'S DO THIS! \n");
		scanner.close();
		// END INPUT, closer scanner now that user has defined size of array and
		// range for values

		int[] testArray = new int[lengthOfTestArray];
		for (int idx = 0; idx < testArray.length; idx++) {
			// generate an array of random numbers
			Random rand = new Random();
			testArray[idx] = rand.nextInt(randomCeiling) + 1;
		}

		// create copies for each of the sorting algorithms
		int[] bubbleArray = testArray.clone();
		int[] selectionArray = testArray.clone();
		int[] insertionArray = testArray.clone();
		int[] quickArray = testArray.clone();
		int[] mergeArray = testArray.clone();
		int[] heapArray = testArray.clone();
		int[] radixArray = testArray.clone();
		int[] radixArrayWithMax = testArray.clone();

		bubbleArray = bubbleSort(bubbleArray);
		if (displayOutput) {
			for (int value : bubbleArray) {
				System.out.print(value + " ");
			}
		}

		System.out.println("\n-----------------");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		selectionArray = selectionSort(selectionArray);
		if (displayOutput) {
			for (int value : selectionArray) {
				System.out.print(value + " ");
			}
		}

		System.out.println("\n-----------------");

		insertionArray = insertionSort(insertionArray);
		if (displayOutput) {
			for (int value : insertionArray) {
				System.out.print(value + " ");
			}
		}

		System.out.println("\n-----------------");

		Quicksort.run(quickArray);
		if (displayOutput) {
			for (int value : quickArray) {
				System.out.print(value + " ");
			}
		}

		System.out.println("\n-----------------");

		Mergesort.run(mergeArray);
		if (displayOutput) {
			for (int value : mergeArray) {
				System.out.print(value + " ");
			}
		}

		System.out.println("\n-----------------");

		Heapsort.run(heapArray);
		if (displayOutput) {
			for (int value : heapArray) {
				System.out.print(value + " ");
			}
		}

		System.out.println("\n-----------------");

		Radixsort.run(radixArray);
		if (displayOutput) {
			for (int value : radixArray) {
				System.out.print(value + " ");
			}
		}
		// this portion of radix sort has overloaded run method, fed maximum
		System.out.println(" ");
		Radixsort.run(randomCeiling, radixArrayWithMax);
		if (displayOutput) {
			for (int value : radixArrayWithMax) {
				System.out.print(value + " ");
			}
		}
	}

	public static int[] bubbleSort(int[] array) {
		// bubble sort iterates through array, rearranging 2 at a time
		// currently makes it ASCENDING
		long startTime = System.nanoTime();

		int trailingNum = 0;
		int arrayLength = array.length;
		boolean flag = true;

		while (flag) {
			flag = false;
			for (int idx = arrayLength - 1; idx > 0; idx--) {
				if (array[idx] < array[idx - 1]) {
					trailingNum = array[idx];
					array[idx] = array[idx - 1];
					array[idx - 1] = trailingNum;
					flag = true;
				}
			}
		}

		long endTime = System.nanoTime() - startTime;
		System.out.println("Bubble Sort [Best: O(n), Worst: O(n^2)] runtime (ns) = " + endTime);
		return array;
	}

	public static int[] selectionSort(int[] array) {
		// finds next element out of order, swaps with correct position
		// currently ASCENDING
		long startTime = System.nanoTime();

		int arrayLength = array.length;

		for (int idx = 0; idx < arrayLength; idx++) {
			int lastMinimumIndex = 0;

			for (int innerIdx = idx; innerIdx < array.length; innerIdx++) {
				if (innerIdx == idx) {
					// if first iteration, set the minimum as first value
					lastMinimumIndex = innerIdx;
				}
				if (array[innerIdx] < array[lastMinimumIndex]) {
					// if value at position smaller than min index, replace
					lastMinimumIndex = innerIdx;
				}
				// loop exit with best min index starting from index of outer
			}

			if (idx != lastMinimumIndex) {
				// if minimum value is not at the current index
				int tempMin = array[lastMinimumIndex];
				array[lastMinimumIndex] = array[idx];
				array[idx] = tempMin;
			}
		}

		long endTime = System.nanoTime() - startTime;
		System.out.println("Selection Sort [Best/Worst: O(n^2)] runtime (ns) = " + endTime);
		return array;
	}

	public static int[] insertionSort(int[] array) {
		int current;
		int innerIdx;
		int idx;
		int arrayLength = array.length;

		long startTime = System.nanoTime();
		for (idx = 1; idx < arrayLength; idx++) {
			// iterate through the array, happens just once
			current = array[idx];
			for (innerIdx = idx; innerIdx > 0; innerIdx--) {
				// iterate backwards through the previously sorted array with
				// new element
				if (array[innerIdx] < array[innerIdx - 1]) {
					array[innerIdx] = array[innerIdx - 1];
					array[innerIdx - 1] = current;
				}
			}
		}

		long endTime = System.nanoTime() - startTime;
		System.out.println("Insertion Sort [Best: O(n), Worst: O(n^2)] runtime (ns) = " + endTime);
		return array;
	}

}
