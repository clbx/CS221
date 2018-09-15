/**
 * @class Postfix
 * @author buxtonc
 * @modifed 9/15/18
 *
 * @desc Postfix class that contains tools for converting infix to postfix
 *       calculating postfix.
 */

public class Postfix {

  private String postfix = "";
  private String infix;

  public Postfix(String infix) {
    this.infix = infix;
  }


  /**
   * @throws StackException
   */
  public void processInfix() throws StackException {

    boolean needSpace = true;
    Stack<Character> stack = new Stack<>(infix.length());

    for (int i = 0; i < infix.length(); i++) {
      needSpace = true;
      //If its a operand, just push it to the postfix
      if (!isOperator(infix.charAt(i))) {
        postfix += infix.charAt(i);
        try {
          if (Character.isDigit(infix.charAt(i + 1)) || infix.charAt(i + 1) == '.')
            needSpace = false;
        } catch (StringIndexOutOfBoundsException e) {
        }
      }
      //If you run intso a ( slap it on the stack
      else if (infix.charAt(i) == '(') {
        stack.push('(');
        needSpace = false;
      }
      //If you run into it's big brother you gotta go looking for the little one
      else if (infix.charAt(i) == ')') {
        while (stack.peek() != '(') {
          postfix += stack.pop();
          postfix += " ";
        }
        stack.pop();
        needSpace = false;
      }
      //If its a operator we gotta start really playing with the stack
      else if (isOperator(infix.charAt(i))) {
        try {
          needSpace = false;
          //If the precidence is higher, just put it on the stack
          if (getPrecidence(infix.charAt(i)) > getPrecidence(stack.peek())) {
            stack.push(infix.charAt(i));
            needSpace = false;
          }
          //If its lower
          else {
            while (getPrecidence(infix.charAt(i)) <= getPrecidence(stack.peek())) {
              postfix += stack.pop();
              postfix += " ";
              needSpace = false;
            }
            stack.push(infix.charAt(i));
          }
        } catch (StackException e) { //But if the stack is empty, then we just put it on
          stack.push(infix.charAt(i));
        }

      }

      if (needSpace) {
        postfix += " ";
      }
    }
    //Pop all remaining operators
    while (true) {
      try {
        postfix += stack.pop();
        postfix += " ";
      } catch (StackException e) {
        break;
      }
    }
    System.out.println("Postfix: " + postfix);
  }

  /**
   *
   * @return the number calculated from the postfix expression
   * @throws StackException
   */
  public double calculatePostfix() throws StackException {

    Stack<Double> stack = new Stack<>(postfix.length());
    int i = 0;
    while (i < postfix.length()) {
      String temp = "";
      //Get the next thing in a string for usage
      while (postfix.charAt(i) != ' ') {
        temp += postfix.charAt(i);
        i++;
      }
      //If it's a number put it on the stack
      if (isNumber(temp) && !isOperator(temp.charAt(0))) {
        stack.push(Double.parseDouble(temp));
      }
      //If its an operator
      else {
        double a;
        double b;
        switch (temp) {
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
      i++;
    }
    return stack.pop();
  }

  /**
   *
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
   *
   * @param ch the character being checked
   * @return if the character is a operator
   */
  private boolean isOperator(char ch) {
    return (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '(' || ch == ')');
  }

  /**
   *
   * @param str checks if the string is a number using a regex
   * @return is the string a number.
   */
  private boolean isNumber(String str) {
    return str.matches("[+-]?\\d*(\\.\\d+)?");
  }

}
