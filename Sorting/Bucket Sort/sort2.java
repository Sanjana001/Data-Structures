package practice;
import java.util.*;

class BucketSort{
	void sort( float[] arr, float max ) {
		int size = arr.length;
		int result_size = (int) max * size + 1;
		
		// create buckets of arrayList
		ArrayList<Float>[] bucket = new ArrayList[result_size];
		
		// initialize the buckets
		for( int i=0;i<result_size;i++ ){
			bucket[i] = new ArrayList<Float>();
		}
		
		// add the array elements into different buckets
		for( float num: arr ) {
			int n = (int) num * size;
			bucket[n].add( num );
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
			for( float j : bucket[i] )
				arr[index++] = j;
		}
	}
}

public class sort2 {
	public static void main(String[] args) {
		BucketSort bucketSort = new BucketSort();
		float[] arr = { (float) 0.6, (float) 0.98, (float) 0.54, (float) 0.978, (float) 0.50, (float) 0.63, (float) 0.59, (float) 0.45, (float) 0.502, (float) 0.64 };
		
		System.out.println( "Before Sorting: ");
		System.out.println( "arr = " + Arrays.toString( arr ) );
		
		// get the maximum element
		float max = getMax( arr );
		
		// sort the array
		bucketSort.sort( arr, max );
		
		System.out.println( "After Sorting: " );
		System.out.println( "arr = " + Arrays.toString( arr ) );
	}
	private static float getMax(float[] arr) {
		float max = arr[0];
		for( float num : arr )
			max = num > max ? num : max;
		return max;
	}
}

/*
Bucket Sort: ( max = 0.98 ,  size = 10, result_size = 10 )
bucket[0] = []
bucket[1] = []
bucket[2] = []
bucket[3] = []
bucket[4] = [ 0.45 ]
bucket[5] = [ 5.4, 0.50, 0.59, 0.502 ]
bucket[6] = [ 0.6, 0.63, 0.65 ]
bucket[7] = []
bucket[8] = [ 79 ]
bucket[9] = [ 0.98, 0.978 ]
*/