import java.util.*;

class InsertionSort{
	static void sort( int[] arr ) {
		for( int i=1;i<arr.length;i++ ) {
			int key = arr[i];
			int index = i - 1;
			while( index >= 0 && arr[index] > key ) {
				arr[index+1] = arr[index];
				index--;
			}
			arr[index+1] = key;
		}
	}
}

public class hello {
	public static void main(String[] args) {
		InsertionSort insertionSort = new InsertionSort();
		int[] arr = { 1, 94, 23, 75, 9, 0, -5 };
		System.out.println( "Before Sorting: ");
		System.out.println( "arr = " + Arrays.toString( arr ) );
		// do sort
		insertionSort.sort( arr );
		System.out.println( "After Sorting: " );
		System.out.println( "arr = " + Arrays.toString( arr ) );
	}
}

/* Working

   At i = 1: arr = { 1, 94 23 75 9 0 -5 }
   At i = 2: arr = { 1, 23, 94 , 75 , 9, 0, -5 }
   At i = 3: arr = { 1, 23, 75, 94, 9, 0, -5 }
   At i = 4: arr = { 1, 9, 23, 75, 94, 0, -5 }
   At i = 5: arr = { 0, 1, 9, 23, 75, 94, -5 }
   At i = 6: arr = { -5, 0, 1, 9, 23, 75, 94 }
*/
