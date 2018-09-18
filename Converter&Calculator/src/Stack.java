/**
 * @param <Type> The type of the stack
 * @author buxtonc
 */
class Stack<Type> {
  private Type[] stack;
  private int sp;

  /**
   * @param size of the stack
   */
  Stack(int size) {
    stack = (Type[]) new Object[size];
    sp = -1;
  }

  Stack() {
    stack = (Type[]) new Object[128];
    sp = -1;
  }

  /**
   * @param value value to push on to the stack
   * @throws StackException if the stack overflows
   */
  void push(Type value) throws StackException {
    if (sp >= stack.length - 1) throw (new StackException("Stack Overflow"));
    stack[++sp] = value;
  }

  /**
   * @return the top of the stack
   * @throws StackException if the stack underflows
   */
  Type pop() throws StackException {
    if (sp < 0) throw (new StackException("Stack Underflow"));
    return stack[sp--];
  }

  /**
   * @return the top of the stack
   * @throws StackException if the stack is empty
   */
  Type peek() throws StackException {
    if (sp < 0) throw (new StackException("Stack Empty"));
    return stack[sp];
  }

  boolean isEmpty() {
    return (sp == -1);
  }

}
