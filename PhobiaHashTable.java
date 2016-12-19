//This class brought to you by Don Landrum
import java.util.*;
public class PhobiaHashTable {
	public class Phobia{
		public String name;
		public String description;
		public Phobia(String aName, String aDescription){
			name = aName;
			description = aDescription;
		}
		public String toString(){
			if(name==null || description== null)
				return null;
			String ret = name+"- "+description;
			return ret;
		}
		public boolean equals(Phobia aPhobia){
			if(aPhobia.name.equalsIgnoreCase(name) && aPhobia.description.equalsIgnoreCase(description))
				return true;
			else
				return false;
		}
	}
	private ArrayList<Phobia>[] data;//hash table
	public PhobiaHashTable(){
		data = new ArrayList[26];//26 letters
		for(int i = 0; i<26; i++){
			data[i] = new ArrayList<Phobia>();//creates each arraylist
		}
	}
	public void add(String aName, String aDescription){//takes in parameters, makes a phobia, passes it below
		Phobia newPhobia = new Phobia(aName, aDescription);
		add(newPhobia);
	}
	private void add(Phobia aPhobia){
		String testName = aPhobia.name.toLowerCase();
		int character = testName.charAt(0)-97;//uses ASCII to translate a to 0, b to 1, c to 2, and so on
		data[character].add(aPhobia);
	}
	public void remove(String aName, String aDescription){//takes in parameters, makes a phobia, passes it below
		Phobia newPhobia = new Phobia(aName, aDescription);
		remove(newPhobia);
	}
	private void remove(Phobia aPhobia){
		for(int i = 0; i< data.length;i++){
			for(int j = 0; j<data[i].size();j++){
				if(data[i].get(j).equals(aPhobia)==true){
					//remove this one
					data[i].remove(j);
				}
			}
		}
	}
	public String lookup(String aName){//returns the description given a name
		for(ArrayList<Phobia> a : data){
			for(Phobia p : a){
				if(p.name.equalsIgnoreCase(aName)){
					//return this description
					return p.description;
				}
			}
		}
		return "This phobia is not found";
	}
	public void printHashTable(){//prints every phobia
		for(ArrayList<Phobia> a : data){
			for(Phobia p : a){
				System.out.println(p.toString());
			}
		}
	}
}