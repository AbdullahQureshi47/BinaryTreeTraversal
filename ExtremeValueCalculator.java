
/**
 * This class implements the node visitor and its purpose is to return the maximum and minimum
 * values in the tree
 * @author Abdullah 
 * Date: 11/3/2018
 *
 */
public class ExtremeValueCalculator implements NodeVisitor{
	int largest;
	int smallest;
	
	public ExtremeValueCalculator()
	{
		largest=Integer.MIN_VALUE;
		smallest=Integer.MAX_VALUE;
	}

	@Override
	//This method overrides the visit method from the NodeVisitor class
	public void visit(Object data) {
		if(data==null)
		System.out.println("The tree is empty");
		else
			// The parameter data must be of the comparable type. Thats why here I cast it into an int
		{ if(((Integer) data).intValue()>largest)
			largest=(int) data;
		if(((Integer) data).intValue()<smallest)
			smallest=(int)data;
			
		}
		//Accounts for the case when the data value is equal to both the smallest and the
		//largest value in the tree
		if(smallest==(int)data && largest==(int) data)
			data=smallest;
	}
	/**
	 * @return the largest
	 */
	public int getLargest() {
		return largest;
	}

	/**
	 * @return the smallest
	 */
	public int getSmallest() {
		return smallest;
	}

	/**
	 * This method return the maximum and minimum values in the tree
	 */
	public void printResults()
	{
		System.out.println("Maximum Value" + ":" + largest);
		System.out.println("Minimum Value" + ":"+ smallest);
	}
}
