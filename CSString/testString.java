public class testString{

	public static void main(String[] args) {

		CSString noinput = new CSString();
		CSString stringput = new CSString("Hello World");
		CSString intinput = new CSString("123.456");


		//TESTS
		System.out.println(noinput.toString());
		System.out.println(stringput.toString());
		System.out.println(intinput.toString());

		System.out.println(noinput.charAt(2));
		System.out.println(stringput.charAt(2));
		System.out.println(intinput.charAt(2));



	}

}
