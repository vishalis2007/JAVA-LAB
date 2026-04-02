
import java.util.Scanner;
class ArithOp {
public static void add(int a, int b) {
int result = a + b;
System.out.println("Addition = " + result);
}
public static void sub(int a, int b) {
int result = a - b;
System.out.println("Subtraction = " + result);
}
public static void mul(int a, int b) {
int result = a * b;
System.out.println("Multiplication = " + result);
}
/**
* Performs division of two integers.
* Handles division by zero using try-catch.
*
* @param a Dividend
* @param b Divisor
*/
public static void div(int a, int b) {
try {

int result = a / b;
System.out.println("Division = " + result);

}
catch (ArithmeticException e) {

System.out.println("Error: Cannot divide by zero.");
}
finally{
System.out.println("Division operation finished.");
}
}
}
public class Main {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.print("Enter first number: ");
int num1 = sc.nextInt();
System.out.print("Enter second number: ");
int num2 = sc.nextInt();

ArithOp.add(num1, num2);
ArithOp.sub(num1, num2);
ArithOp.mul(num1, num2);
ArithOp.div(num1, num2);
sc.close();
}
}