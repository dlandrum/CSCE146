//This class brought to you by Don Landrum
public class MinIntHeap <T extends Comparable <T>>{//I used T so that I could set indices to null
	public static final int HEAP_SIZE = 128;//max depth of 7
	private T[] heap;
	private int size;
	public MinIntHeap(){
		heap = (T[])(new Comparable[HEAP_SIZE]);//typecasting
		size = 0;
	}
	public void insert(T aValue){
		heap[size] = aValue;
		insertHelp();//bubble down
		size++;
	}
	private void insertHelp(){
		int index = this.size;
		while(index>0){
			int parent = -1;
			if(index%2!=0){//the index is a left child
				parent = (index-1)/2;
			}
			else{//the index is a right child
				parent = (index-2)/2;
			}
			if(parent >=0 && heap[index].compareTo(heap[parent])<0){//out of order
				T temp = heap[parent];
				heap[parent] = heap[index];
				heap[index] = temp;
			}
			else{//in order, so end the loop
				break;
			}
			index = parent;//repeat
		}
	}
	public T delete(){
		T returnT = heap[0];//preserves value to be returned
		heap[0] = heap[size-1];//takes last inserted value and makes it the root
		heap[size-1] = null;//deletes last inserted value from heap
		size--;
		reheapify();//fixes any possible out-of-order problems from the deletion
		return returnT;
	}
	private void reheapify(){
		int index = 0;
		while(index*2+1 < size){
			int smallIndex = index*2+1;//left child assumed to be smaller than right
			if(index*2+2 < size && heap[index*2+1].compareTo(heap[index*2+2])>0){//right child is less than left
				smallIndex = index*2+2;//resets smallIndex to right child
			}
			if(heap[index].compareTo(heap[smallIndex])>0){//parent greater than smallest child
				T temp = heap[index];
				heap[index] = heap[smallIndex];
				heap[smallIndex] = temp;
			}
			else{//in order, end the loop
				break;
			}
			index = smallIndex;//keeps following it down the tree
		}
	}
	public void heapSort(){
		MinIntHeap copy = new MinIntHeap();//makes a new instance of this class
		T [] ArrCopy = heap.clone();//clones the heap of the main instance
		for(int i = 0; i<size; i++){//populates the new copy class with the heap of the old one
			copy.insert(ArrCopy[i]);
		}
		for(int i = size; i>0; i--){//prints out the new copy class (destroying it) in sorted order
			System.out.print(copy.delete().toString()+" ");
		}
	}
	public void print(){
		for(int i = 0; i<size; i++){//prints out the heap in breadth order
			if(heap[i] != null)
				System.out.println(heap[i].toString());
		}
	}
}