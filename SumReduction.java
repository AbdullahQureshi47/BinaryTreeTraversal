
/**
 * This class also implements NodeVisitor class and visit method for this adds up all the node
 * values in the tree.
 * @author Abdullah 
 *
 */
public class SumReduction implements NodeVisitor {
	
	int Sum;
	public SumReduction()
	{
		Sum=0;
	}
	
	@Override
	//Adds up all the node values
	public void visit(Object data) {
		if(data !=null)
		{// The parameter must be an integer
			Integer int1= (Integer) data;
			Sum+=int1.intValue();
		}
	
	}
	
	/**
	 * This method prints out the sum of all the nodes in the tree.
	 */
	public void returnSum()
	{
		 System.out.println("The sum is"+ ": " + Sum);
		
	}

	
}
