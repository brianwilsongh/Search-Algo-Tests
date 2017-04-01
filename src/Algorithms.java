import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Algorithms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("How long do you want the test array? (give integer)");
		int lengthOfTestArray = scanner.nextInt();
		System.out.println("Generate random values between 1 and... (give integer)");
		int randomCeiling = scanner.nextInt();
		System.out.println("-~-~-~(╯ಠ_ರೃ)╯︵ ┻━┻ LET'S DO THIS! \n");
		//END INPUT, user has defined size of array and range for values
		
		
		int[] testArray = new int[lengthOfTestArray];
		for (int idx = 0; idx < testArray.length; idx++){
			//generate an array of random numbers
			Random rand = new Random();
			testArray[idx] = rand.nextInt(randomCeiling) + 1;
		}
		
		//create copies for each of the sorting algorithms
		int[] bubbleArray = testArray;
		int[] selectionArray = testArray;
		int[] insertionArray = testArray;
		
		bubbleArray = bubbleSort(bubbleArray);
		System.out.println("Bubble Sort:");
		for (int value : bubbleArray){
			System.out.print(value + " ");
		}
		
		System.out.println("\n-----------------");
		
		selectionArray = selectionSort(selectionArray);
		System.out.println("Selection Sort:");
		for (int value: selectionArray){
			System.out.print(value + " ");
		}
		
		System.out.println("\n-----------------");
		
		insertionArray = insertionSort(insertionArray);
		System.out.println("Insertion Sort");
		for (int value: insertionArray){
			System.out.print(value + " ");
		}
		
		

	}
	
	public static int[] bubbleSort(int[] array){
		//bubble sort iterates through array, rearranging 2 at a time
		//currently makes it ASCENDING
		long startTime = System.nanoTime();
		
		int trailingNum = 0;
		int arrayLength = array.length;
		boolean flag = true;
		
		while (flag){
			flag = false;
			for (int idx = arrayLength - 1; idx > 0; idx--){
				if (array[idx] < array[idx - 1]){
					trailingNum = array[idx];
					array[idx] = array[idx - 1];
					array[idx - 1] = trailingNum;
					flag = true;
				}
			}
		}
		
		long endTime = System.nanoTime() - startTime;
		System.out.println("Bubble Sort runtime (ns) = " + endTime);
		return array;
	}
	
	
	public static int[] selectionSort(int[] array){
		//finds next element out of order, swaps with correct position
		//currently ASCENDING
		long startTime = System.nanoTime();
		
		int arrayLength = array.length;
		
		for (int idx = 0; idx < array.length; idx++){
			int lastMinimum = 0;
			int lastMinimumIndex = 0;
			
			for (int innerIdx = idx; innerIdx < array.length; innerIdx++){
				if (innerIdx == idx){
					//if first iteration, set the minimum as first value
					lastMinimumIndex = innerIdx;
				}
				if (array[innerIdx] < array[lastMinimumIndex]){
					//if value at position smaller than min index, replace
					lastMinimumIndex = innerIdx;
				}
				//loop exit with best min index starting from index of outer
			}
			
			if (idx != lastMinimumIndex){
				//if minimum value is not at the current index
				int tempMin = array[lastMinimumIndex];
				array[lastMinimumIndex] = array[idx];
				array[idx] = tempMin;
			}
		}
		
		long endTime = System.nanoTime() - startTime;
		System.out.println("Selection Sort runtime (ns) = " + endTime);
		return array;
	}
	
	public static int[] insertionSort(int[] array){
		long startTime = System.nanoTime();
		
		int current;
		int innerIdx;
		
		int arrayLength = array.length;
		for (int idx = 1; idx < arrayLength; idx++){
			//iterate through the array, happens just once
			current = array[idx];
			for (innerIdx = idx - 1; current < array[innerIdx] && innerIdx >= 0; innerIdx--){
				//while current is "traveling" over larger values in array
				array[innerIdx + 1] = array[innerIdx];
				//shift the array elements over by 1 index
			}
			array[innerIdx + 1] = current;
		}
		
		long endTime = System.nanoTime() - startTime;
		System.out.println("Insertion Sort runtime (ns) = " + endTime);
		return array;
	}

}
