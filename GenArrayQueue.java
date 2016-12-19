//This class brought to you by Don Landrum
public class GenArrayQueue <T> {
	public static final int DEFAULT_SIZE = 100;
	private T[] queue;
	public GenArrayQueue(){
		this.queue = (T[]) new Object[DEFAULT_SIZE];
	}
	public GenArrayQueue(int aSize){
		this.queue = (T[]) new Object[aSize];
	}
	public void enqueue(T aVariable){
		for(int i = 0; i<queue.length; i++){
			if(queue[i] == null){
				queue[i] = aVariable;
				return;
			}
		}
		System.out.println("The array is full and this item cannot be added");
	}
	public T dequeue(){
		T aReturn = queue[0];
		for(int i = 0; i< queue.length-1; i++){
			queue[i] = queue[i+1];
		}
		queue[queue.length-1] = null;
		return aReturn;
	}
	public T peek(){
		T bReturn = queue[0];
		return bReturn;
	}
	public void showQueue(){
		for(int i = 0; i<queue.length; i++){
			if(queue[i] != null){
				System.out.println(queue[i]);
			}
		}
	}
}
