import java.util.*;

public class binarySearch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = { 1, 4, 23, 55, 69, 90 };
		displayArr( arr );
		// scan the number which has to be search
		System.out.print( "Enter the number: ");
		int num = sc.nextInt();
		// do the binary search
		binarySearch( arr, num );
		sc.close();
	}

	private static void binarySearch(int[] arr, int num) {
		// TODO Auto-generated method stub
		int left = 0, right = arr.length-1;
		int middle = 0;
		while( left <= right ) {
			middle = ( left + right ) / 2;
			if( arr[middle] == num ) {
				System.out.println( "Present " );
				return ;
			}
			if( arr[middle] < num ) {
				left = middle + 1;
			} else right = middle - 1;
		}
		System.out.println( "Absent" );
	}

	private static void displayArr(int[] arr) {
		// display array
		System.out.print( "arr = [ " );
		for( int i=0;i<arr.length-1;i++ )
			System.out.print( arr[i] + ", ");
		System.out.println( arr[ arr.length-1 ] + " ]");
	}
}
