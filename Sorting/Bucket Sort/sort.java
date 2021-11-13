import java.util.*;

class BucketSort{
	void sort( int[] arr, int max ) {
		int size = arr.length;
		int result_size = max / size + 1;
		
		// create buckets of arrayList
		ArrayList<Integer>[] bucket = new ArrayList[result_size];
		
		// initialize the buckets
		for( int i=0;i<result_size;i++ ){
			bucket[i] = new ArrayList<Integer>();
		}
		
		// add the array elements into different buckets
		for( int num: arr ) {
			int quotient = num / size;
			bucket[quotient].add( num );
		}
		
		// sort the buckets
		for( int i=0;i<result_size;i++ ) {
			if( bucket[i].size() != 0 ){
				Collections.sort( bucket[i] );
			}
		}
		
		// put the sorted elements into array
		int index = 0;
		for( int i=0;i<result_size;i++ ) {
			for( int j : bucket[i] )
				arr[index++] = j;
		}
	}
}

public class sort {
	public static void main(String[] args) {
		BucketSort bucketSort = new BucketSort();
		int[] arr = { 100, 19, 2, 79, 33, 0, 55, 88, 99 };
		
		System.out.println( "Before Sorting: ");
		System.out.println( "arr = " + Arrays.toString( arr ) );
		
		// get the maximum element
		int max = getMax( arr );
		
		// sort the array
		bucketSort.sort( arr, max );
		
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

/*
Bucket Sort: ( max = 100 ,  size = 9, result_size = 12 )
bucket[0] = [ 2, 0 ]
bucket[1] = []
bucket[2] = [ 19 ]
bucket[3] = [ 33 ]
bucket[4] = []
bucket[5] = []
bucket[6] = [ 55 ]
bucket[7] = []
bucket[8] = [ 79 ]
bucket[9] = [ 88 ]
bucket[10] = []
bucket[11] = [ 100, 99 ]
*/