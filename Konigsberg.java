//This class brought to you by Don Landrum
import java.util.*;
public class Konigsberg {
	public static final int ISLAND_SIZE = 5;//land-masses 1, 2, 3, and 4, index 0 is never used
	public static final int BRIDGE_SIZE = 8;//bridges 1-7, 0 is never used
	private int[][] graph;
	ArrayList<Integer[]> a;//used to store all of the possible permutations
	public Konigsberg(){//no need for parameterized constructor due to fixed nature of problem
		graph = new int[ISLAND_SIZE][BRIDGE_SIZE];
		a = new <Integer[]> ArrayList();
	}
	public void addEdge(int bridge){
		if(bridge<=0){//forces index 0 to be ignored
			System.out.println("Edge Input Error");
			return;
		}
		switch(bridge){//1 is north, 2 is middle, 3 is east, 4 is south
		//first index is the land-mass, the second is the bridge, and a 1 value indicates that the bridge has one end on that landmass
		case 1:
			graph[1][1]=1;
			graph[2][1]=1;
			break;
		case 2:
			graph[1][2]=1;
			graph[2][2]=1;
			break;
		case 3:
			graph[2][3]=1;
			graph[3][3]=1;
			break;
		case 4:
			graph[1][4]=1;
			graph[3][4]=1;
			break;
		case 5:
			graph[2][5]=1;
			graph[4][5]=1;
			break;
		case 6:
			graph[2][6]=1;
			graph[4][6]=1;
			break;
		case 7:
			graph[3][7]=1;
			graph[4][7]=1;
			break;
		default:
			break;
		}
	}
	private int moveLand(int start, int bridge){//given one end of a bridge and the name of that bridge, return the other end of that bridge
		if(start == 1 && bridge == 1)
			return 2;
		if(start == 2 && bridge == 1)
			return 1;
		if(start == 1 && bridge == 2)
			return 2;
		if(start == 2 && bridge == 2)
			return 1;
		if(start == 3 && bridge == 3)
			return 2;
		if(start == 2 && bridge == 3)
			return 3;
		if(start == 1 && bridge == 4)
			return 3;
		if(start == 3 && bridge == 4)
			return 1;
		if(start == 4 && bridge == 5)
			return 2;
		if(start == 2 && bridge == 5)
			return 4;
		if(start == 2 && bridge == 6)
			return 4;
		if(start == 4 && bridge == 6)
			return 2;
		if(start == 3 && bridge == 7)
			return 4;
		if(start == 4 && bridge == 7)
			return 3;
		else//if nothing matches, return negative one to indicate that the bridge and the landmass passed in are not related
			return -1;
	}
	public boolean traverse(){
		boolean eulerWalk = false;//assumed impossible
		for(Integer[] n : a){//for all permutations
			int startLand = 2;//assumed to start at an arbitrary landmass, in this case 2
			if(graph[2][n[0]]==0 && graph[1][n[0]]==1)//if it actually starts at 1
				startLand = 1;
			else if(graph[2][n[0]]==0 && graph[3][n[0]]==1)//if it actually starts at 3
				startLand = 3;
			else if(graph[2][n[0]]==0 && graph[4][n[0]]==1)//if it actually starts at 4
				startLand = 4;
			if(graph[startLand][n[0]]==0){//cannot cross this bridge
				continue;//this is not a solution
			}
			else{//crosses bridge, moves onto next land mass and next bridge in array
				int m = moveLand(startLand, n[0]);
				if(graph[m][n[1]]==0){//cannot cross this bridge
					continue;//this is not a solution
				}
				else{
					int o = moveLand(m, n[1]);
					if((graph[o][n[2]]==0)){//cannot cross this bridge
						continue;//this is not a solution
					}
					else {
						int p = moveLand(o, n[2]);
						if((graph[p][n[3]]==0)){//cannot cross this bridge
							continue;//this is not a solution
						}
						else{
							int q = moveLand(p, n[3]);
							if((graph[q][n[4]]==0)){//cannot cross this bridge
								continue;//this is not a solution
							}
							else{
								int r = moveLand(q, n[4]);
								if((graph[r][n[5]]==0)){//cannot cross this bridge
									continue;//this is not a solution
								}
								else{
									int s = moveLand(r, n[5]);
									if((graph[s][n[6]]==0)){//cannot cross this bridge
										continue;//this is not a solution, no more checks
									}
									else{//if it makes it through all of these checks, then it is a valid path
										eulerWalk = true;
									}
									}
								}
							}
						}
					}
				}
			}
		return eulerWalk;
	}
	public void permutations(Set<Integer> items, Stack<Integer> perm, int length) {
		//I received some help in setting up the set that I wrote this method
		if(perm.size() == length) {//if the size of the stack fits the desired size of the permutation
	    	a.add(perm.toArray(new Integer[0]));//convert it to an array and add that array to the ArrayList a
	    }
	    Integer[] availableItems = items.toArray(new Integer[0]);
	    for(Integer i : availableItems) {
	        perm.push(i);//push the integer onto the stack
	        items.remove(i);//remove it from the items list
	        permutations(items, perm, length);//recursive call
	        items.add(perm.pop());
	    }
	}
}