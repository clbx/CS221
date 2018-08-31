public class testString{

	public static void main(String[] args) {

		CSString noinput = new CSString();
		CSString strinput = new CSString("Hello World");
		CSString intinput = new CSString("123.456");


		//TESTS
		System.out.println(noinput.toString());
		System.out.println(strinput.toString());
		System.out.println(intinput.toString());


	}

}
