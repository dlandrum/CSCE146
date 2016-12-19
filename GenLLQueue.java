//This class brought to you by Don Landrum
public class GenLLQueue <T> {
	public class ListNode{
		private T data;
		private ListNode link;
		public ListNode(){
			this.data = null;
			this.link = null;
		}
	}
	private ListNode head;
	private ListNode tail;
	public GenLLQueue(){
		this.head = null;
		this.tail = null;
	}
	public void enqueue(T aVariable){
		if(tail == null && head == null){
			ListNode newNode = new ListNode();
			newNode.data = aVariable;
			head = newNode;
			tail = newNode;
			head.link = tail;
			return;
		}
		ListNode newNode = new ListNode();
		newNode.data = aVariable;
		tail.link = newNode;
		tail = tail.link;
	}
	public T dequeue(){
		T aReturn = head.data;
		head = head.link;
		if(head == null){
			tail = null;
		}
		return aReturn;
	}
	public T peek(){
		T bReturn = head.data;
		return bReturn;
	}
	public void showQueue(){
		ListNode curr = new ListNode();
		curr.data = head.data;
		curr.link = head.link;
		while(curr.link != null){
			System.out.println(curr.data);
			curr = curr.link;
		}
		System.out.println(curr.data);
	}
}
