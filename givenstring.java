import java.util.Scanner;
class givenstring{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the string1: ");
		String first = sc.nextLine();
		System.out.print("Enter the string2: ");
		String second = sc.nextLine();
		System.out.print("Enter the string3: ");
		String str = sc.next(); 
		/*if(first.substring(0,str.length()).matches(str))System.out.println("true");
		else System.out.println("false");
		if(second.substring(0,str.length()).matches(str))System.out.println("true");
		else System.out.println("false");*/
		System.out.println(first.startsWith(str)); //checks whether first starts with str or not
		System.out.println(second.startsWith(str)); //checks whether second starts with str or not
	}
}