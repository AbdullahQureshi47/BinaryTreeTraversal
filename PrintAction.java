/*
    Implementation of PrintAction class.
    @author Alyce Brady
    Creation Date: Spring 2001
    
    The PrintAction class implements the NodeVisitor interface.
	It prints the contents of the node to System.out.
*/


public class PrintAction implements NodeVisitor
{
    public PrintAction ()
	{
	}

    public void visit(Object data)
	{
        if ( data != null )
            System.out.println (data.toString());
	}

}
