//If we want to scan any value from the user then we must include the Scanner library before scanning the inputs.
import java.util.Scanner;
class scanner{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		//let's scan the string
		System.out.print("Enter the string: ");
		String str = sc.next(); //it terminates the scanner as soon as it finds space in string
		//Another method to scan the string with spaces is 'sc.nextLine()'
		System.out.println("The string is "+str);
		//now let just scan the integer
		System.out.print("Enter the integer: ");
		Integer num = sc.nextInt();
		System.out.println("You have entered "+num+" as integer.");
		//its now turn to scan the float number
		System.out.print("Enter the float number: ");
		Float flt = sc.nextFloat();
		System.out.println("The float number is "+flt);
		//now here's come a one more method
		System.out.print("Enter the double number: ");
		Double dbl = sc.nextDouble();
		System.out.println("The double number is "+dbl);
        //let's scan a one more variable of boolean
        System.out.print("Enter the boolean value: ");
        Boolean bool = sc.nextBoolean();
        System.out.println("The boolean expression is "+bool);
	}
}