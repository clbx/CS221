import java.util.Scanner;
import java.util.Stack;

public class ConvertCalculate {

  public static void main(String[] args) throws StackException {
    //Stack stack = new Stack(5);
    Scanner in = new Scanner(System.in);
    System.out.println("Enter your infix equation");
    String infix = in.next();
    Postfix postfix = new Postfix(infix);
    postfix.processInfix();
    System.out.println("Result: " + postfix.calculatePostfix());
  }

}
