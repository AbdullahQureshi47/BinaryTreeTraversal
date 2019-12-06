/*
	Main file for Binary Tree Lab
	@author Autumn C. Spaulding
	Creation Date: 24 July 2000
	
	More thorough documentation may be found within the BinaryTree class file.
*/

public class BinaryTreeLab
{

	public static void main(String args[])
	{
		
		//construct an empty binary tree here.
		BinaryTree myTree= new BinaryTree();
		
		//insert elements in level order here.
		myTree.add(1);
		myTree.add(2);
		myTree.add(3);
		myTree.add(4);
		myTree.add(5);
		myTree.add(25);
		myTree.add(0);
		myTree.add(142);
		myTree.add(17);
		myTree.add(26);
		myTree.add(25);

		//traverse the tree in breadth-first order to see what you have done.
		NodeVisitor printer = new PrintAction();
        SumReduction summer= new SumReduction();
		System.out.println("******Traversing Tree: breadth-first order******");
		myTree.breadthFirstTraversal(printer);
		
		System.out.println("Inorder Traversal");
		myTree.inOrderTraversal(printer);
		
		System.out.println("Post-order Traversal");
		myTree.postOrderTraversal(printer);
		
		System.out.println("Pre-order Traversal");
		myTree.preOrderTraversal(printer);
		
		System.out.println("Number of Nodes");
		System.out.println(myTree.numNodes());
		
		System.out.println("Number of leaves");
		System.out.println(myTree.numLeaves());
		
		System.out.println("Depth");
		System.out.println(myTree.depth());
		
		System.out.println("Does it contain 2");
		System.out.println(myTree.contains(2));
		
		System.out.println("No of Occorunces of 25");
		System.out.println(myTree.numOccurrences(25));
		
		
		
        myTree.breadthFirstTraversal(summer);
        System.out.println("Sum of the values of all the nodes");
        ((SumReduction) summer).returnSum();
        
		NodeVisitor extVal= new ExtremeValueCalculator();
		myTree.breadthFirstTraversal(extVal);
		System.out.println("Min Max results:");
		((ExtremeValueCalculator) extVal).printResults();
	}

}	//end class BinaryTreeLab
