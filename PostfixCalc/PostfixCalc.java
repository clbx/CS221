import java.util.Scanner;

public class PostfixCalc {

	public static void main(String[] args) throws StackException {
		Stack stack = new Stack(5);
		Scanner kb = new Scanner(System.in);
		double n;
		String line;
		double a,b;

		while (kb.hasNext()) {
			line = kb.nextLine();
			if (Character.isDigit(line.charAt(0))) {
				n = Double.parseDouble(line);
				stack.push(n);
			}
			else {
				switch (line.charAt(0)) {
				case '+':
					b = stack.pop();
					a = stack.pop();
					stack.push(a+b);
					break;
				case '-':
					b = stack.pop();
					a = stack.pop();
					stack.push(a-b);
					break;
				case '?':
					System.out.println(stack.peek());
				}
			}

		}
	}

}
