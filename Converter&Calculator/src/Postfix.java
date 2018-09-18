import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author buxtonc
 */

class Postfix {

  private String infix;
  private Queue<String> queue = new LinkedList<>();


  Postfix(String infix) {
    this.infix = infix;
  }

  /**
   * @throws StackException if the stack overflows or underflows.
   */
  void processInfix() throws StackException {
    System.out.println("infix: " + infix);

    StringTokenizer tokens = new StringTokenizer(infix, " ");
    Stack<Character> stack = new Stack<>();

    while (tokens.hasMoreTokens()) {
      String tok = tokens.nextToken();
      //If token is operand. Push to queue
      if (isNumber(tok)) {
        queue.add(tok);
      }
      //If token is open paren. Push to stack
      else if (tok.equals("(")) {
        stack.push('(');
      }
      //If token is close paren. Push everything from stack to queue until close paren
      else if (tok.equals(")")) {
        while (stack.peek() != ('(') && !stack.isEmpty()) {
          queue.add(stack.pop() + "");
        }
        stack.pop();
      }
      //Otherwise check if its an operator
      else if (isOperator(tok)) {
        char ch = tok.charAt(0);
        try {
          if (!stack.isEmpty()) {
            if (getPrecidence(ch) > getPrecidence(stack.peek())) {
              stack.push(ch);
            } else {
              while (getPrecidence(ch) <= getPrecidence(stack.peek()) && !stack.isEmpty()) {
                queue.add(stack.pop() + "");
              }
              stack.push(ch);
            }
          } else {
            stack.push(ch);
          }
        }
        //TODO: Fix this garbage.
        catch (StackException e) {
          stack.push(ch);
        }
      }
      //If its none of those, skip it an let the user know they're a bad person
      else {
        System.out.println("You're a bad person");
      }

    }
    while (!stack.isEmpty()) {
      queue.add(stack.pop() + "");
    }

    System.out.println("Postfix Queue: " + queue);

  }

  /**
   * @return the number calculated from the postfix expression
   * @throws StackException if the stack overflows or underflows
   */
  double calculatePostfix() throws StackException {

    Stack<Double> stack = new Stack<>(queue.size());
    for (String item : queue) {
      //If it's a number put it on the stack
      if (isNumber(item) && !isOperator(item)) {
        stack.push(Double.parseDouble(item));
      }
      //If its an operator
      else {
        double a;
        double b;
        switch (item) {
          case "+":
            a = stack.pop();
            b = stack.pop();
            stack.push(a + b);
            break;
          case "-":
            b = stack.pop();
            a = stack.pop();
            stack.push(a - b);
            break;
          case "*":
            a = stack.pop();
            b = stack.pop();
            stack.push(a * b);
            break;
          case "/":
            b = stack.pop();
            a = stack.pop();
            stack.push(a / b);
            break;
        }
      }
    }
    return stack.pop();
  }

  /**
   * @param ch character being checking
   * @return the precidence of the character
   */
  private int getPrecidence(char ch) {
    if (ch == '+' || ch == '-') {
      return 1;
    } else if (ch == '*' || ch == '/') {
      return 2;
    }
    return 0;
  }

  /**
   * @param str the character being checked
   * @return if the character is a operator
   */
  private boolean isOperator(String str) {
    return (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"));
  }

  /**
   * @param str checks if the string is a number using a regex
   * @return is the string a number.
   */
  private boolean isNumber(String str) {
    try {
      Double.parseDouble(str);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

}
