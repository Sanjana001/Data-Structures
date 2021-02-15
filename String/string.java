import java.util.Scanner;
class string{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the first string: ");
		String str_0 = sc.nextLine();
		System.out.print("Enter the second string (try to take string capital letters): ");
		String str_1 = sc.nextLine();
		System.out.print("Enter the third string: ");
		String str_2 = sc.nextLine();
		System.out.println();
		//let's find the length of str_0
		System.out.println("The length of the first string is "+str_0.length());
		//now let's convert the second string into lowercase
		System.out.println("The lowercase of second string is "+str_1.toLowerCase());
		//let's just convert the third string into uppercase
		System.out.println("The uppercase of third string is "+str_2.toUpperCase());
		//now its turn to concatenate the strings let's start its
		System.out.println("\nConcatenation of first and second string is "+str_0+str_1);
		System.out.println("Another method i.e concat(): "+str_0.concat(str_1.concat(str_2)));
		//let's add some string and numbers
		System.out.println("\nThe addition of \''apple\'' and 32 is "+"apple"+32);
		//let's find charcters in string
		System.out.println("\nThe first character of the first string is "+str_0.charAt(0)); //str.charAt(index)
		System.out.println("The index of the last charcter of the second string is "+str_1.indexOf(str_1.charAt(str_1.length()-1)));
		//let's start comparing
		System.out.println("\n Comparison between first string and second string: "+str_0.compareTo(str_1));
		System.out.println("Are second and third strings equal? "+str_1.equals(str_2));
	}
}