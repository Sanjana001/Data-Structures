import java.util.*;
class methods{
	public static void main(String[] args){
		Integer[] arr = {1,2,8,6,0};
		Integer[] arr1 = {19,6,0,1,2};
		//let's find 6 element inside arr by using binarysearch
		//For binarySearch we need to sort the array first
		Arrays.sort(arr);
		Arrays.sort(arr1);
		System.out.println("\n6 is present at index "+Arrays.binarySearch(arr,6)+" inside arr.");
		//now let's check whether arr and arr1 are equal or not
		//we can also use Arrays.compare(arr,arr1) method to compare the arrays
		System.out.println("\n "+Arrays.toString(arr)+" and "+Arrays.toString(arr1)+" are Equal? "+Arrays.equals(arr,arr1));
		//let's check the index of the first mismatched element
		System.out.println("\nThe index of the first mismatched element is "+Arrays.mismatch(arr,arr1));
		//let's convert the array into list
		System.out.println("\narr as list is "+Arrays.asList(arr)); 
	}
}