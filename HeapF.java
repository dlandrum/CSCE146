//This class brought to you by Don Landrum
public class HeapF {
	public static final int DEFAULT_SIZE = 100;
	public class Phrase {
		private String input;//string given
		private int f;//number of F's
		public Phrase(String anInput){
			input = anInput;
			int temp = 0;
			for(int i = 0; i<anInput.length(); i++){//counts F's
				if(anInput.charAt(i)=='f' || anInput.charAt(i)=='F'){
					temp++;
				}
			}
			f = temp;
		}
	}
	private Phrase[] heap;//this is a MIN heap
	private int size;//always assumed to look at last open element
	public HeapF(){
		heap = new Phrase[DEFAULT_SIZE];
		size = 0;
	}
	public HeapF(int a){
		if(a>0){
			heap = new Phrase[DEFAULT_SIZE];
			size = 0;
		}
	}
	public void insert(String aString){
		if(size>=heap.length){
			System.out.println("Full");
			return;
		}
		heap[size] = new Phrase(aString);//insert it at the end
		bubbleUp();//fix the heap
		size++;
	}
	private void bubbleUp(){
		int index = this.size;
		while(index>0){
			int parent = -1;
			if(index%2!=0){//left child
				parent = (index-1)/2;
			}
			else{//right child
				parent = (index-2)/2;
			}
			if(parent >=0 && heap[index].f<heap[parent].f){//out of order,swap
				Phrase temp = heap[parent];
				heap[parent] = heap[index];
				heap[index] = temp;
			}
			else{//in order, so all is well, so end the loop
				break;
			}
			index = parent;
		}
	}
	public Phrase peek(){
		if(heap == null){
			return null;
		}
		return heap[0];
	}
	public Phrase delete(){
		Phrase retVal = peek();
		if(retVal==null)//error checking
			return retVal;
		heap[0] = heap[size-1];//move last to first
		heap[size-1] = null;//delete last
		size--;
		reheapify();//fix heap
		return retVal;
	}
	private void reheapify(){
		int index = 0;
		while(index*2+1 < size){
			int smallIndex = index*2+1;//left assumed smaller
			if(index*2+2 < size && heap[index*2+1].f > heap[index*2+2].f){//left greater than right
				smallIndex = index*2+2;//right is actually smaller
			}
			if(heap[index].f > heap[smallIndex].f){//parent greater than smallest child, swap
				Phrase temp = heap[index];
				heap[index] = heap[smallIndex];
				heap[smallIndex] = temp;
			}
			else{//all is well, end it
				break;
			}
			index = smallIndex;//keeps following it down the tree
		}
	}
	public void heapSort(){
		HeapF tempHeap = new HeapF(heap.length);//deep copy
		Phrase[] cloneHeap = heap.clone();//deep copy
		for(int i = 0; i<size; i++){
			if(cloneHeap[i]!=null)
				tempHeap.insert(cloneHeap[i].input);//fills tempHeap
		}
		for(int i = size; i>=0; i--){//until the heap is empty
			Phrase aPhrase = tempHeap.delete();//remove the head
			if(aPhrase!=null)
				System.out.println(aPhrase.input);//print it out
		}
		System.out.println("");
	}
}