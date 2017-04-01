import java.util.Iterator;
import java.util.Random;

public class Algorithms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] testArray = new int[100];
		for (int idx = 0; idx < testArray.length; idx++){
			Random rand = new Random();
			testArray[idx] = rand.nextInt(100) + 1;
		}
		
		
		int[] bubbleArray = testArray;
		int[] selectionArray = testArray;
		
		bubbleArray = bubbleSort(bubbleArray);
		System.out.println("Bubble Sort:");
		for (int value : bubbleArray){
			System.out.print(value + " ");
		}
		
		System.out.println("\n-------------------<(^.^)>");
		
		selectionArray = selectionSort(selectionArray);
		System.out.println("Selection Sort:");
		for (int value: selectionArray){
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

}
