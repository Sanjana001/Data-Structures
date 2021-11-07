import java.util.*;

class BubbleSort{
	static void sort( int[] arr ) {
		for( int i=0;i<arr.length-1;i++ ) {
			for( int j=0;j<arr.length-i-1;j++ ) {
				if( arr[j] > arr[j+1] ) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
}

public class sort {
	public static void main(String[] args) {
		BubbleSort bubbleSort = new BubbleSort();
		int[] arr = { 1, 94, 23, 75, 9, 0, -5 };
		System.out.println( "Before Sorting: ");
		System.out.println( "arr = " + Arrays.toString( arr ) );
		// do sort
		bubbleSort.sort( arr );
		System.out.println( "After Sorting: " );
		System.out.println( "arr = " + Arrays.toString( arr ) );
	}
}
