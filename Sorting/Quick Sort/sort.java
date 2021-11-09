import java.util.*;

class QuickSort{
	int doPartioning( int[] arr , int left, int right ) {
		// selects the rightmost element as pivot
		int pivot = arr[right];
		int index = left - 1;
		
		for( int i=left;i<right;i++ ) {
			if( arr[i] <= pivot ) {
				index++;
				// swap the elements
				int temp = arr[index];
				arr[index] = arr[i];
				arr[i] = temp;
			}
		}
		
		int temp = arr[index+1];
		arr[index+1] = arr[right];
		arr[right] = temp;
		
		return index+1;
	}
	void sort( int[] arr, int left , int right ) {
		if( left < right ) {
			int partition = doPartioning( arr, left, right );
			sort( arr , left , partition-1 );
			sort( arr, partition+1, right );
		}
	}
}

public class sort {
	public static void main(String[] args) {
		QuickSort quickSort = new QuickSort();
		int[] arr = { 1, 94, 23, 75, 9, 0, -5 };
		System.out.println( "Before Sorting: ");
		System.out.println( "arr = " + Arrays.toString( arr ) );
		// do sort
		quickSort.sort( arr , 0 , arr.length-1 );
		System.out.println( "After Sorting: " );
		System.out.println( "arr = " + Arrays.toString( arr ) );
	}
}
