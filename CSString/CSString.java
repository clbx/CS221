public class CSString{

	private char[] str;
	private int length;


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
		this.length = input.length();
		for(int i = 0; i < input.length(); i++){
			this.str[i] = input.charAt(i);
		}
	}
	/*
	* Takes integer, sets str to string representation of that
	*/
	public CSString(int input){
		this.str = intToChar(input);
		length = this.str.length;
	}

	//FUNCTIONS
	/*
	*params: the input integer to be put in a char array
	*returns: the char array of the integer
	* Takes in an integer and retuns it as a character array
	*/
	private char[] intToChar(int n){
		int len = getDigitLen(n);
		char[] str = new char[len];
		for(int i = 0; i < len; i++){
			str[len-1-i] = (char)(n%10+48);
			n /= 10;
		}
		return str;
	};
	/*
	*params: int to find out length
	*returns: the number of digits
	* Returns how many digits there are in a integer
	*/
	private int getDigitLen(int n){
		int len = 0;
		while(n != 0){
			n /= 10;
			len++;
		}
		return len;
	}
	/*
	*params: the posision to look at
	*returns: the character at the position
	* gets the character at a certain position
	*/
	public char charAt(int position){
		//Checks to see if there an element at that point
		try{
			return this.str[position]; //If so return said element
		}
		catch(ArrayIndexOutOfBoundsException exception){
			return ' '; //Otherwise just return nothing
		}
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
		this.length = this.str.length;

	}
	/*
	*params: integer to set CSSting as
	*returns: nothing
	* Sets the CSSString to a new String representation of an integer
	*/
	public void set(int number){
		this.str = intToChar(number);
		this.length = this.str.length;
	}

	/*
	*params: none
	*returns: the length of the CSString
	* Just gets the length of CSString
	*/
	public int length(){
		return str.length;
	}

	/*
	*params:Number of elements to expand the array by
	*returns: none
	* Expands the array
	*/
	public void expand(int n){
		char[] temp = new char[str.length + n];
		for(int i = 0; i < this.str.length; i++){
			temp[i] = this.str[i];
		}
		this.str = temp;
	}

	/*
	*params: The string to append to the end of the array
	*returns: nothing
	*
	*/
	public void append(String str){
		char[] newstr = new char[this.length + str.length()];
		for(int i = 0; i < this.length; i++){
			newstr[i] = this.str[i];
		}
		int j = 0;
		for(int i = this.length; i < this.length+str.length(); i++){
			newstr[i] = str.charAt(j);
			j++;
		}
		this.str = newstr;
		this.length += str.length();
	}
	/*
	*params:
	*returns:
	*
	*/
	public void append(char ch){
		char[] newstr = new char[this.length + 1];
		for(int i = 0; i < this.length; i++){
			newstr[i] = this.str[i];
		}
		newstr[this.length] = ch;
		this.str = newstr;
		this.length += 1;
	}

	/*
	*params:
	*returns:
	*
	*/

	public int compareTo(CSString str){
		if(str == null){
			return 0;
		}
		for(int i = 0; i < str.length() && i < this.length; i++){
			if(str.charAt(i) > this.str[i]){
				return -1;
			}
			if(str.charAt(i) > this.str[i]){
				return 1;
			}

			if( i > str.length()){
				return 1;
			}
			if( i > this.str.length){
				return -1;
			}
		}
		return 0;
	}

	/*
	*params:
	*returns:
	*
	*/
	public int find(CSString str){
		if(str == null || str.length() == 0){
			return 0;
		}
		for(int i = 0; i < this.str.length; i++){
			if(i + str.length() > this.str.length){
				return -1;
			}
			int subIndex = i;
			for(int j=0; j < str.length(); j++){
				if(str.charAt(j) == this.str[subIndex]){
					if(j==str.length()-1){
						return i;
					}
					subIndex++;
				}
				else{
					break;
				}
			}
		}
		return -1;
	}

	/*
	*params:
	*returns:
	*
	*/
	public int find(CSString str, int start){
		if(str == null || str.length() == 0){
			return 0;
		}
		for(int i = start; i < this.str.length; i++){
			if(i + str.length() > this.str.length){
				return -1;
			}
			int subIndex = i;
			for(int j=0; j < str.length(); j++){
				if(str.charAt(j) == this.str[subIndex]){
					if(j==str.length()-1){
						return i;
					}
					subIndex++;
				}
				else{
					break;
				}
			}
		}
		return -1;
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
