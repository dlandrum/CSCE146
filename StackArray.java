//This class brought to you by Don Landrum
public class StackArray <T> {
	public static final int DEFAULT_SIZE = 100;
	public T[] stack;
	int headIndex; //points to last inserted element, NOT first empty element
	public StackArray(){
		this.stack = (T[]) new Object[DEFAULT_SIZE]; //this is typecasting
		this.headIndex = 0;
	}
	public StackArray(int aSize){
		if(aSize>0){
			this.stack = (T[]) new Object[aSize];
			this.headIndex = 0;
		}
		else{
			System.out.println("Invalid size");
		}
	}
	public void push(T aData){
		if(headIndex+1>=stack.length){
			System.out.println("Cannot be added. Stack is full.");
			return;
		}
		if(stack[0] == null){
			stack[0] = aData;
			return;
		}
		headIndex++;
		stack[headIndex] = aData;
	}
	public T pop(){
		T aPop = stack[headIndex];
		stack[headIndex] = null;
		headIndex--;
		if(headIndex<0){
			headIndex = 0;
		}
		return aPop;
	}
}