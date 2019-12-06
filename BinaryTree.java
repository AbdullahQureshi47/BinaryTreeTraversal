import java.util.Queue;
import java.util.LinkedList;
/*

The BinaryTree Class

@author Autumn C. Spaulding <a href="mailto:autumn@max.cs.kzoo.edu">email</a>
Creation Date: 24 July 2000

Modifications:
    Modifier: Alyce Brady
    Modification Date: November 11, 2002
    Modifications Made: Modifications to documentation (e.g., to remove
        empty preconditions); added levelOrderTraversal;
        also modified to use NodeAction interface.
    Modifier: Nathan Sprague
    Modification Date: May 10, 2010
    Modifications Made: Modified to use Java Queue interface.

Modifications:
    Modifier: Abdullah Qureshi
    Modification Date: 11/4/2018
    Modifications Made: Added various methods for tree traversal and to get various characteristics for tree

Description:
    This file contains some of the implementation of a BinaryTree class. 
    It is intended as an outline and starting point for the "Binary Trees"
    lab in the Data Structures course.  The implementation is based on the 
    recursive definition of a tree rather than on the graph theory definition
    of a tree (compare to Bailey, 190).
    
    A binary tree is either:
        1.  An empty tree; or
        2.  a node, called a root (the node contains the data), and two 
            children, left and right, each of which are themselves binary trees.
                (Berman, "Data Structures via C++: Objects by Evolution", 1997.)
    
    In this implementation, an empty tree is represented by a node with null
    data and null references for the children.  A leaf node is represented by
    a node with a data value and two references to empty trees (NOT a data
    value and two null references!).  We could represent this as an object
    invariant: data, left, right are either all null (representing an empty
    tree) or none of them are null (a non-empty tree).

*/

public class BinaryTree
{
    //data:
    protected Object data;
    protected BinaryTree left;
    protected BinaryTree right;
        
    /*tested*/
    /** Creates an empty binary tree with no data and no children. */
    public BinaryTree()
    {
        //this is the constructor for the BinaryTree object
        data = null;
        left = null;
        right = null;
    }
     
    /*tested*/
    /** Tests whether this is an empty tree.
            @return true if the tree is empty; false otherwise
    */
    public boolean isEmpty()
    {
        return data == null;
    }
   
    /*tested*/
    /** Gets the data associated with the root node of this particular tree
        (recall recursive definition of trees).
            @return value associated with tree's root node; 
                          null if tree is empty
    */
    public Object getElement()
    {
        return data;
    }

    /*tested*/
    /** Gets the left child of the current tree.
            @return the left child (a tree)
    */
    public BinaryTree leftTree()
    {
        return left;
    }

    /*tested*/
    /** Gets the right child of the current tree.
            @return the right child (a tree)
    */
    public BinaryTree rightTree()
    {
        return right;
    }

    /** Adds elements to a binary tree.  This implementation adds the
        elements in breadth-first (top-down, left-to-right) order.
            @param value the value to be added to the tree.
            @return true when the value has been added; should never return false
    */
    public boolean add(Object value)
    {
        Queue<Object> queue = new LinkedList<Object>();
        queue.add(this);
        while( ! queue.isEmpty() )
        {
            BinaryTree tree = (BinaryTree)queue.remove();

            //if the current position is null, then we know we can place a
            //value here.
            //place the value in that position in the tree, and create new 
            //BinaryTrees for its children, which will both initially be null.
            if (tree.isEmpty())
            {
                tree.data = value;
                tree.left = new BinaryTree();
                tree.right = new BinaryTree();
                return true;
            }
            //otherwise, if the position is not null (that is, we can't place
            //it at the current position), then we add the left and right children
            //to the queue (if we can) and go back to the beginning of the loop.
            queue.add(tree.left);
            queue.add(tree.right);
        }
        return false;    //this statement should never be executed.
    }

	/** Traverses the tree in breadth-first order.
	        @param action an object that will act on all the nodes in the tree
	*/
	public void breadthFirstTraversal(NodeVisitor action)
	{
		Queue<Object> queue = new LinkedList<Object>();
		queue.add(this);
		while( ! queue.isEmpty() )
		{
			BinaryTree tree = (BinaryTree)queue.remove();
			if ( ! tree.isEmpty() )
            {
    			action.visit(tree.getElement());  			
    			queue.add(tree.leftTree());
    			queue.add(tree.rightTree());
            }
		}
	}	
    
	/**
	 * Traverse the tree in depth-first order. It use pre-order algorithm 
	 * @param action
	 */
	public void preOrderTraversal(NodeVisitor action)
	{
		//Queue<Object> queue=new LinkedList<Object>();
//	queue.add(this);
//	while(!queue.isEmpty())
//	{
//		BinaryTree tree=(BinaryTree) queue.remove();
//		if(!tree.isEmpty())
//		{
//			action.visit(tree.getElement());
//			this.leftTree().preOrderTraversal(action);
//			this.rightTree().preOrderTraversal(action);
//		}
//	}
		
		if (this.isEmpty())
		return;
		
	else
		{// Goes to the root then the left child then the right child
			action.visit(this.getElement());
			this.leftTree().preOrderTraversal(action);
			this.rightTree().preOrderTraversal(action);
		}
	}
	
	/**Traverse the tree in depth-first order. It uses in-order algorithm
	 * @param action
	 */
	public void inOrderTraversal(NodeVisitor action)
	{
		if (this.isEmpty())
			return;
		else 
		{ //Goes to the left child then to the root and then to the right child
			this.leftTree().inOrderTraversal(action);
			action.visit(this.getElement());
			this.rightTree().inOrderTraversal(action);
		}
		
	}
    
	/**
	 * Traverse the tree in depth-first order. It uses post-order algorithm
	 * @param action
	 */
	public void postOrderTraversal(NodeVisitor action)
	{
		if (this.isEmpty())
			return;
		else
			
		{ //Goes to the left child then the the right child and then the root node
			this.leftTree().inOrderTraversal(action);
			this.rightTree().inOrderTraversal(action);
			action.visit(this.getElement());
		}
	}
	
	/**
	 * @return true if the node is a leaf and vice versa
	 */
	public boolean isLeaf()
	{ 
		if(this.leftTree().getElement()==null && this.rightTree().getElement()==null)
			return true;
		return false;
		
	}
	
	/**
	 * @return Returns the number of nodes of the tree
	 */
	public int numNodes()
	{ int count=0;
		if(this.isEmpty())
			return 0;
		else
			{// Increments the count and adds it to the number that we get from each recursion
			count++;
			count+=this.leftTree().numNodes();
			count+=this.rightTree().numNodes();
			}
//		else
//			return;
		
		return count;
	}
	
	/**
	 * @return Number of leaves in the tree
	 */
	public int numLeaves()
	{int count=0;
		if (this.isEmpty())
			return 0;
		else
		{
			if(this.isLeaf())
				count++;
			// Increments the count and adds it to the number that we get from each recursion
			count+=this.leftTree().numLeaves();
			count+=this.rightTree().numLeaves();
		}
		return count;
	}
	
	/**
	 * @return the height of the tree
	 */
	public int depth() {
//	{int count=0;
//		if(this.isEmpty())
//			return 0;
//		else
//		{ //Adds up the longest path
//			if(!(this.leftTree().getElement()==null) || !(this.rightTree().getElement()==null))
//			count++;
//			count+=this.leftTree().depth();
//			count+=this.rightTree().depth();
//		}
//		return count;
		

		if(this.isEmpty())
			return 0;
		else
		{ //Compares the height of each subtree
			int leftH=this.leftTree().depth();
			int rightH=this.rightTree().depth();

		
		if(leftH>rightH)
		return (leftH+1);
		else
			return (rightH+1);
	}
	}

	/**
	 * @param obj
	 * @return true if the object is in the tree and vice versa
	 */
	public boolean contains(Object obj)
	{
		if(this.isEmpty())
			return false;
		else
		{
			if(this.getElement()==obj)
				return true;
			
			return this.leftTree().contains(obj) || this.rightTree().contains(obj);
		}
	}
	
	/**
	 * @param obj
	 * @return The number of occurrences of an object
	 */
	public int numOccurrences(Object obj)
	{int count=0;
		if(this.isEmpty())
			return 0;
		else 
		{
			if(this.getElement()==obj)
				count++;
			count+=this.leftTree().numOccurrences(obj);
			count+=this.rightTree().numOccurrences(obj);
		}
		return count;
	}
	
	
}    //end class BinaryTree
