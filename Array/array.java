import java.util.*;
class array{
	public static void main(String[] args){
		String[] str = {"Hello","User","How","are","you?"};
		//Integer[][] arr1 = {{1,2,3},{4,5,6}};
		Integer[] arr = {1,56,89,32,64,0,3,2};
		System.out.println("The length of the string array is "+str.length);
		//let's find the elements of this array
		/*for(int i=0;i<str.length;i++){
			System.out.print(str[i]+" ");
		}*/
		System.out.print("The elements inside the string array are: [ ");
		for(String s: str){
			System.out.print(s+" ");
		}
		System.out.println("]");
		//if I want to print my array as string
		System.out.println("\nThe 2d array is "+Arrays.toString(str));
		//let's sort the array
		Arrays.sort(str);
		System.out.println("\nAfter sorting the string array will become "+Arrays.toString(str));
		//let's sort the integer array between 2 to 6 index
		Arrays.sort(arr,2,7);
		System.out.println("\nAfter sorting the array from 2nd to 6th index the resultant array is "+Arrays.toString(arr));
		//now I want to fill my whole string array with "Welcome"
		Arrays.fill(str,"Welcome");
		System.out.println("\nAfter filling the \'' Welcome \'' value the string array will now become is "+Arrays.toString(str));
		//if I want to create a new array whose starting elements are same as that of "arr" array elements
		System.out.println("\nAfter copying the arr elements, here's the original array of length 12 "+Arrays.toString(Arrays.copyOf(arr,12)));
		//if I want to create a new array whose starting elements are same as that of elements between 2 to 6 index of "arr"
		System.out.println("After copying the arr elements, here's the original array of length 12 "+Arrays.toString(Arrays.copyOfRange(arr,2,7)));
	}
}
