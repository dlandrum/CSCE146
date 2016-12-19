//This class brought to you by Don Landrum
public class IntDoubleLinkedListTester extends IntDoubleLinkList{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntDoubleLinkList theList = new IntDoubleLinkList();
		System.out.println("Welcome to the Double Linked List.");
		theList.goToNext();//shows error checking
		theList.goToPrev();//shows error checking
		theList.getDataAtCurrent();//shows default head value
		for(int i=0;i<10;i++)//populates list
		{
			theList.insertNodeAfterCurrent(i);
		}
		int fourteen = 14;
		int seven = 7;
		int twentytwo = 22;
		theList.showList();//prints list
		theList.goToPrev();//moves back one space
		theList.goToPrev();//moves back one space
		theList.getDataAtCurrent();//prints value 
		theList.goToNext();//moves forward one space
		theList.deleteCurrentNode();//deletes node
		theList.goToPrev();//moves back one space
		theList.goToPrev();//moves back one space
		theList.getDataAtCurrent();//prints value
		theList.setDataAtCurrent(fourteen);//resets value at node
		theList.inList(seven);//checks for the value 7
		theList.inList(twentytwo);//checks for the value 22
		theList.showList();//prints list
	}
}