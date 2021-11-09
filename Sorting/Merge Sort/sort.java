import java.util.*;

class MergeSort{
	static void merge( int[] arr , int l, int m, int r ) {
		int left_size = m - l + 1;
		int right_size = r - m;
		
		int[] left = new int[left_size];
		int[] right = new int[right_size];
		
		// put the elements in left
		for( int i=0;i<left_size;i++ )
			left[i] = arr[l+i];
		
		// put the elements in right
		for( int i=0;i<right_size;i++ )
			right[i] = arr[m+i+1];
		
		int index = l;
		l = 0;
		r = 0;
		
		while( l<left_size && r<right_size ) {
			if( left[l] <= right[r] ) {
				arr[index] = left[l];
				l++;
			} else arr[index] = right[r++];
			index++;
		}
		
		// put the rest elements in array
		while( l<left_size )
			arr[index++] = left[l++];
		
		while( r<right_size )
			arr[index++] = right[r++];
	}
	static void sort( int[] arr, int left , int right ) {
		if( left < right ) {
			int middle = ( left + right ) / 2;
			sort( arr , left , middle );
			sort( arr, middle+1, right );
			merge( arr, left , middle , right );
		}
	}
}

public class sort {
	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
		int[] arr = { 1, 94, 23, 75, 9, 0, -5 };
		System.out.println( "Before Sorting: ");
		System.out.println( "arr = " + Arrays.toString( arr ) );
		// do sort
		mergeSort.sort( arr , 0 , arr.length-1 );
		System.out.println( "After Sorting: " );
		System.out.println( "arr = " + Arrays.toString( arr ) );
	}
}
