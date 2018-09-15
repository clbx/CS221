
public class Stack<Type> {
  Type[] stack;
  int sp;

  public Stack(int size) {
    stack = (Type[]) new Object[size];
    sp = -1;
  }

  public Stack() {
    stack = (Type[]) new Object[128];
    sp = -1;
  }

  public void push(Type value) throws StackException {
    if (sp >= stack.length - 1) throw (new StackException("Stack Overflow"));
    stack[++sp] = value;
  }

  public Type pop() throws StackException {
    if (sp < 0) throw (new StackException("Stack Underflow"));
    return stack[sp--];
  }

  public Type peek() throws StackException {
    if (sp < 0) throw (new StackException("Stack Empty"));
    return stack[sp];
  }

  public Type top() throws StackException {
    if (sp < 0) throw (new StackException("Stack Empty"));
    return stack[sp];
  }

}
