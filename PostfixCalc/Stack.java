public class Stack{

  private int[] stack;
  private int pos;


  public Stack(int height){
    this.stack = new int[height];
    this.pos = 0;
  }

  public void push(int input){
    if(pos == stack.length){
      int[] newstack = new int[stack.length + 5];
      for(int i = 0; i < stack.length; i++){
        newstack[i] = stack[i];
      }
      stack = newstack;
    }

   stack[++pos] = input;
  }

  public int pop(){
    if(pos == 0){
      return 0;
    }
    int val = stack[pos];
    stack[pos] = 0;
    pos--;
    return val;
  }

}
