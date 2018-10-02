import java.util.Scanner;

/**
 * @author buxtonc
 */
public class ConvertCalculate {

  public static void main(String[] args) throws StackException{
    Scanner in = new Scanner(System.in);
    System.out.println("Enter your infix equation");
    String infix = in.nextLine();
    Postfix postfix = new Postfix(infix);
    postfix.processInfix();
    System.out.println("Result: " + postfix.calculatePostfix());



  }
}

