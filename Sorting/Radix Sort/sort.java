package practice;
import java.util.*;

class CountingSort{
	void sort( int[] arr, int place ) {
		int[] result = new int[arr.length];
		
		// get the maximum digit
		int max = ( arr[0] / place ) % 10;
		for( int num : arr ) 
			max = ( num / place ) % 10 > max ? ( num / place ) % 10 : max;
		
		// initialize the count array
		int[] count = new int[max+1];
		for( int i=0;i<=max;i++ )
			count[i] = 0;
		
		// put the count of elements in count array
		for( int i=0;i<arr.length;i++ )
			count[ ( arr[i] / place ) % 10 ] += 1;
		
		// make the cumulative sum
		for( int i=1;i<=max;i++ )
			count[i] += count[i-1];
		
		// store the sorted array in result
		for( int i=arr.length-1;i>=0;i-- ) {
			result[ count[ ( arr[i] / place ) % 10 ] - 1 ] = arr[i];
			count[ ( arr[i] / place ) % 10 ] -= 1;
		}
		
		// put the result into array
		for( int i=0;i<arr.length;i++ )
			arr[i] = result[i];
	}
}

public class sort {
	public static void main(String[] args) {
		CountingSort radixSort = new CountingSort();
		int[] arr = { 1, 944, 23, 756, 79, 0, 585 };
		
		System.out.println( "Before Sorting: ");
		System.out.println( "arr = " + Arrays.toString( arr ) );
		
		// get the maximum element
		int max = getMax( arr );
		for( int place = 1 ; max/place > 0 ; place *= 10 ) {
			// sort the array
			radixSort.sort( arr, place);
		}
		
		System.out.println( "After Sorting: " );
		System.out.println( "arr = " + Arrays.toString( arr ) );
	}
	private static int getMax(int[] arr) {
		int max = arr[0];
		for( int num : arr )
			max = num > max ? num : max;
		return max;
	}
}