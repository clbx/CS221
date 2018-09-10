public class testString{

	public static void main(String[] args) {

		CSString noinput = new CSString();
		CSString stringput = new CSString("Hello World");
		CSString intinput = new CSString(123);


		//TESTS
		System.out.println(noinput.toString());
		System.out.println(stringput.toString());
		System.out.println(intinput.toString());


    System.out.println("Char at 2");
		System.out.println(noinput.charAt(2));

    System.out.println("Set to 'Hello World'");
		intinput.set("Hello World");


		System.out.println(intinput.toString());

		CSString str = new CSString("Hello World");


    System.out.println("Set to integer 234");
		str.set(234);

		System.out.println(str.toString());


    System.out.println("Set to Hello World");
		str.set("World Hello");

    System.out.println("To String: ");
		System.out.println(str.toString());

    System.out.println("Length of string");
		System.out.println(str.length());

    System.out.println("Expand String");
		str.expand(12);

    System.out.println("Print length after expand");
		System.out.println(str.length());

    System.out.println("Append boop");
		str.append("boop");

		System.out.println(str.toString());

    System.out.println("Append m");
		str.append('m');

		System.out.println(str.toString());

    System.out.println("find 'boop' ");
		CSString index = new CSString("boop");

		System.out.println(str.find(index));

    System.out.println("Find boop after 12 (Its not there)");
		System.out.println(str.find(index, 12));

    System.out.println("Create 2 new strings 'apple' and 'banana'");
		CSString first = new CSString("Apple");
		CSString second = new CSString("Banana");


    System.out.println("Compare apple to banana");
		System.out.println("Should be -1");
		System.out.println(first.compareTo(second));

    System.out.println("Compare banana to apple");
		System.out.println("Should be 1");
		System.out.println(second.compareTo(first));

	}

}
