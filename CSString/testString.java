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


		noinput.set("Hello World");
		stringput.set("Hello World");
		intinput.set("Hello World");

		System.out.println(noinput.toString());
		System.out.println(stringput.toString());
		System.out.println(intinput.toString());

		CSString str = new CSString("Hello World");

		str.set(2);

		System.out.println(str.toString());


		str.set("World Hello");

		System.out.println(str.toString());

		System.out.println(str.length());

		str.expand(2);

		str.append("boop ");

		System.out.println(str.toString());

		str.append('m');

		System.out.println(str.toString());

		CSString index = new CSString("boop");

		System.out.println(str.find(index));

		System.out.println(str.find(index, 7));







	}

}
