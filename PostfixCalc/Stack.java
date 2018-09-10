
public class Stack {
	double[] stack = null;
	int sp = -1;
	
	public Stack(int size) {
		stack = new double[size];
		sp = -1;
	}
	
	public Stack() {
		stack = new double[100];
		sp = -1;
	}
	
	public void push(double value) throws StackException {
		if (sp>=stack.length-1) throw(new StackException("Stack Overflow"));
		stack[++sp] = value;
	}
	
	public double pop() throws StackException {
		if (sp<0) throw(new StackException("Stack Underflow"));
		return stack[sp--];
	}
	
	public double peek() throws StackException {
		if (sp<0) throw(new StackException("Stack Empty"));
		return stack[sp];
	}
	public double top() throws StackException {
		if (sp<0) throw(new StackException("Stack Empty"));
		return stack[sp];
	}
	
}
