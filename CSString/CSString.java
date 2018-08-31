public class CSString{

	//Default size 256
	private char[] str;


	//CONSTRUCTORS
	/*
	* Takes nothing, sets str to nothing
	*/
	public CSString(){
		this.str = new char[1];
	}
	/*
	* Takes a String, sets str to that
	*/
	public CSString(String input){
		this.str = new char[input.length()];
		for(int i = 0; i < input.length(); i++){
			this.str[i] = input.charAt(i);
		}
	}
	/*
	* Takes integer, sets str to string representation of that
	*/
	public CSString(int input){
		String intTemp = Integer.toString(input);
		this.str = new char[intTemp.length()];
		for(int i = 0; i < intTemp.length(); i++){
			this.str[i] = intTemp.charAt(i);
		}
	}

	//FUNCTIONS
	/*
	*params: the posision to look at
	*returns: the character at the position
	* gets the character at a certain position
	*/
	public char charAt(int position){
		return this.str[position];
	}
	/*
	*params: string to set CSString as
	*returns: nothing
	* Sets the CSString to a new string
	*/
	public void set(String str){
		this.str = new char[str.length()];
		for(int i = 0; i < str.length(); i++){
			this.str[i] = str.charAt(i);
		}

	}
	/*
	*params: integer to set CSSting as
	*returns: nothing
	* Sets the CSSString to a new String representation of an integer
	*/
	public void set(int number){
		String intTemp = Integer.toString(number);
		this.str = new char[intTemp.length()];
		for(int i = 0; i < intTemp.length(); i++){
			this.str[i] = intTemp.charAt(i);
		}
	}

	/*
	*params: none
	*returns: the length of the CSString
	* Just gets the length of CSString
	*/
	public int length(){
		return this.str.length;
	}

	/*
	*params:Number of elements to expand the array by
	*returns: none
	* Expands the array
	*/
	public void expand(int n){
		char[] temp = new char[str.length + n];
		this.str = temp;
	}

	/*
	*params: The string to append to the end of the array
	*returns: nothing
	*
	*/
	public void append(String str){

	}
	/*
	*params:
	*returns:
	*
	*/
	public void append(char ch){

	}

	/*
	*params:
	*returns:
	*
	*/
	public int compareTo(CSString str){
		return 0;
	}

	/*
	*params:
	*returns:
	*
	*/
	public int find(CSString str){
		return 0;
	}

	/*
	*params:
	*returns:
	*
	*/
	public int find(CSString str, int start){
		return 0;
	}

	/*
	*params:
	*returns:
	*
	*/
	public String toString(){
		String str = "";
		for(int i = 0; i < this.str.length; i++){
			str += this.str[i];
		}
		return str;
	}












}
