/**
 * @author buxtonc
 * @param <Type> The type of the stack
 */
public class Stack<Type> {
  Type[] stack;
  int sp;

  /**
   *
   * @param size of the stack
   */
  public Stack(int size) {
    stack = (Type[]) new Object[size];
    sp = -1;
  }

  public Stack() {
    stack = (Type[]) new Object[128];
    sp = -1;
  }

  /**
   *
   * @param value value to push on to the stack
   * @throws StackException if the stack overflows
   */
  public void push(Type value) throws StackException {
    if (sp >= stack.length - 1) throw (new StackException("Stack Overflow"));
    stack[++sp] = value;
  }

  /**
   *
   * @return the top of the stack
   * @throws StackException if the stack underflows
   */
  public Type pop() throws StackException {
    if (sp < 0) throw (new StackException("Stack Underflow"));
    return stack[sp--];
  }

  /**
   *
   * @return the top of the stack
   * @throws StackException if the stack is empty
   */
  public Type peek() throws StackException {
    if (sp < 0) throw (new StackException("Stack Empty"));
    return stack[sp];
  }

  public boolean isEmpty(){
    return(sp == 0);
  }

}
