import java.util.Scanner;
class math{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the first number: ");
		Integer num1 = sc.nextInt();
		System.out.print("\nEnter the second number: ");
		Integer num2 = sc.nextInt();
		//let's find the maximum between these two numbers
		System.out.println("The maximum number between "+num1+" and "+num2+" is "+Math.max(num1,num2));
		//let's find the minimum between these two numbers
		System.out.println("The minimum number between "+num1+" and "+num2+" is "+Math.min(num1,num2));
		//let's just find square root of num1
		System.out.println("\nThe square root of number "+num1+" is "+Math.sqrt(num1));
	        //let's also find the cube root of num2
		System.out.println("The cube root of number "+num2+" is "+Math.cbrt(num2));
	       //now its turn to find power of num1 to num2
		System.out.println("\n"+num1+" raised to power "+num2+" is "+Math.pow(num1,num2));
	        //let's also round of num1
		System.out.println("The rounded value of "+num1+" is "+Math.round(num1));
		//its now turn to find any random number between 0 to num2-1 
		System.out.println("The random number between "+num2+" is "+(int)(Math.random()*num2));
		//here is the time to find the absolute (positive) value of -num1
		System.out.println("The absolute value of "+(-num1)+" is "+Math.abs(-num1));
		//let's find the exponential power of num2
		System.out.println("The exponential power of "+num2+" is "+Math.exp(num2));
	}
}
