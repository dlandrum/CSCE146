//This class brought to you by Don Landrum
public class SheepHeap {
	public class Sheep {
		private String name;
		private int weight;
		public Sheep(String aName, int aWeight){//creates a sheep with parameters, default is not needed since I don't use it
			if(aWeight<=0)
				return;
			name = aName;
			weight = aWeight;
		}
		public String toString(){//used to printout the contents of the sheep
			return (name+", "+weight);
		}
	}
	private Sheep[] heap;
	private int size;
	public SheepHeap(){//default constructor
		heap = new Sheep [128];
		size = 0;
	}
	public void addSheep(String aString, int aWeight){
		if(heap[0] == null){//first sheep
			Sheep aSheep = new Sheep(aString, aWeight);
			heap[size] = aSheep;
			size++;
			return;
		}
		Sheep aSheep = new Sheep(aString, aWeight);
		heap[size] = aSheep;//adds sheep to end of heap
		climbUp();//fixes heap
		size++;
	}
	private void climbUp(){
		int child = size;//index of child
		while(child>0){//for the whole heap
			int parent = (child-1)/2;//assumes the child is the left
			if(child%2 == 0)
				parent = (child-2)/2;//corrects child as right
			if((parent>=0) && (heap[child].weight < heap[parent].weight)){//swap parent and child
				Sheep temp = heap[parent];
				heap[parent] = heap[child];
				heap[child] = temp;
			}
			else{//all is well
				break;
			}
			child = parent;//check parent next
		}
	}
	public Sheep deleteSheep(){
		Sheep aSheep = heap[0];
		if(size==0){//no sheep to delete
			return null;
		}
		if(heap[size-1]!=null){//the heap has at least two items left
			heap[0] = heap[size-1];
			heap[size-1] = null;
			size--;
			climbDown();//reheapify
			return aSheep;
		}
		heap[0] = null;//the heap has only one item, so it is returned and the heap is empty
		size--;
		return aSheep;
	}
	private void climbDown(){
		int parent = 0;
		while(2*parent+1<size){//for entire heap
			int child = 2*parent+1;//assumes left child is smaller
			if(((2*parent+2)<size) && (heap[2*parent+1].weight>heap[2*parent+2].weight))
				child = child+1;//right child is actually smaller
			if(heap[parent].weight>heap[child].weight){//swap the child and parent
				Sheep temp = heap[parent];
				heap[parent] = heap[child];
				heap[child] = temp;
			}
			else{//all is well
				break;
			}
			parent = child;//this took a long time to figure out, talk about it in the lab report
		}
	}
	public void sheepHeapSort(){
		Sheep [] clone = new Sheep[128];
		SheepHeap aClone = new SheepHeap();
		for(int i = 0; i<clone.length; i++){//copies heap into clone
			if(heap[i]==null){
				i = 10000;//effectively breaks the loop upon encountering a null place
			}
			else{
				clone[i] = heap[i];				
			}
		}
		for(int i = 0; i<clone.length; i++){//deep copy
			if(clone[i]==null)
				i = 10000;//effectively breaks the loop upon encountering a null place
			else
				aClone.addSheep(clone[i].name, clone[i].weight);
		}
		while(true){
			Sheep aSheep = aClone.deleteSheep();//deletes deep copy one-at-a-time until it is empty
			if(aSheep == null){
				break;
			}
			System.out.println(aSheep.name+", "+aSheep.weight);
		}
	}
	public void sheepRollCall(){
		for(Sheep s : heap){//prints them all 
			if(s!=null){
				System.out.println(s.name+", "+s.weight);
			}
		}
	}
}