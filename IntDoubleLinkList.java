//This class brought to you by Don Landrum
public class IntDoubleLinkList {
	public class ListNode{
		private int data;
		private ListNode nextLink;
		private ListNode prevLink;
		public ListNode(){
			this.data = -45986;//an intentionally random number so I know that this node is the head
			this.nextLink = null;
			this.prevLink = null;
		}
		public ListNode(int aData, ListNode aNext, ListNode aPrev){
			//No error checking is needed in this situation
			this.data = aData;
			this.nextLink = aNext;
			this.prevLink = aPrev;
		}
	}
	private ListNode head;
	private ListNode curr;
	public IntDoubleLinkList(){
		this.head = new ListNode();
		this.curr = head;
	}
	public void goToNext(){
		if(curr.nextLink == null){
			System.out.println("I cannot move forward because there is nothing there.");
			return;
		}
		curr = curr.nextLink;
	}
	public void goToPrev(){
		if(curr.prevLink == null){
			System.out.println("I cannot move backward because there is nothing there.");
			return;
		}
		curr = curr.prevLink;
	}
	public void getDataAtCurrent(){
		if(curr ==null){
			System.out.println("The current node is null, so I cannot obtain its data.");
			return;
		}
		int aData = curr.data;
		System.out.println("Data at current: "+aData);
	}
	public void setDataAtCurrent(int bData){
			curr.data = bData;
	}
	public void insertNodeAfterCurrent(int aData){
		ListNode aNode = new ListNode();
		if(curr.data == -45986){
			curr.data = aData;
	//		this will replace the default head with the first value
			return;
		}
		else if(curr.nextLink == null){
			aNode.data = aData;
			curr.nextLink = aNode;
			aNode.prevLink = curr;
			aNode.nextLink = null;
		}
		else{
    	aNode.data = aData;
    	curr.nextLink.prevLink = aNode;
    	aNode.nextLink = curr.nextLink;
    	curr.nextLink = aNode;
    	aNode.prevLink = curr;
		}
		goToNext();
	}
	public void deleteCurrentNode(){
		curr.prevLink.nextLink = curr.nextLink;
		curr.nextLink.prevLink = curr.prevLink;
	}
	public void showList(){
		if(head == null){
			System.out.println("Nothing to show.");
			return;
		}
		curr = head;
		while(curr.nextLink != null){
			System.out.println(curr.data);
			goToNext();
		}
		System.out.println(curr.data);
	}
	public void inList(int dData){
		curr = head;
		while(curr.nextLink != null){
			if(curr.data == dData){
				System.out.println("The number "+dData+" is in the list");
				return;
			}
			goToNext();
		}
		System.out.println("The number "+dData+" is not in the list");
	}
}