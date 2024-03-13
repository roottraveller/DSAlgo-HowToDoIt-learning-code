import java.util.*;

class RandomizeQuickSort {
	public static void main(String[] args) {
		QuickSort obj = new QuickSort();
		obj.sort(new int[]{10, 20, 15, -50, 40, 30, 80, 0, 15});
	}
}

class QuickSort { 
	private int elements[]; 
	private int length; 
	
	public void sort(int[] numbers) {  //should be called by QuickSort.sort(arr);
		if (numbers == null || numbers.length == 0) { 
			return; 
		} 
	
		this.elements = numbers; 
		this.length = numbers.length; 
		quickSort(0, length - 1); 
		
		for(int data : elements) System.out.print(data + " ");
   } 

	/* This method implements in-place quicksort algorithm recursively. */ 
	private void quickSort(int low, int high) { 
		int left= low; 
		int right= high; 
		
		//int pivot = elements[low + (high - low) / 2];  // pivot is middle index 
		int pivot = elements[new Random().nextInt(high) + 1]; //range 0 - high
		
		while (left <= right) { 
			/** 
			* As shown in above image, In each iteration, we will identify a 
			* number from left side which is greater then the pivot value, and 
			* a number from right side which is less then the pivot value. Once 
			* search is complete, we can swap both numbers. */ 
			
			while (elements[left] < pivot) { 
				left++; 
			} 
			
			while (elements[right] > pivot) { 
				right--; 
			} 
			
			if (left <= right) { 
				swap(left, right); // move index to next position on both sides 
				left++; right--; 
			} 
		} 
		
		// calls quickSort() method recursively 
		if (low < right) { 
			quickSort(low, right);
		 }
		 
		if (left < high) { 
			quickSort(left, high); 
		} 
	} 

	private void swap(int i, int j) { 
		int temp = elements[i]; 
		elements[i] = elements[j]; 
		elements[j] = temp; 
	} 
} 
