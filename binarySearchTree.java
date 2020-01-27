package dataStructures;
import java.util.*;
public class binarySearchTree {

	class Node
	{
		int key;
		Node left;
		Node right;
		Node(int d)
		{
			this.key=d;
		}
	}
	static Node root;
	
	public Node addRec(Node current, int v)
	{
	       if(current==null)
	    	   return new Node(v);
	       else if(current.key>v)
	    	   current.left=addRec(current.left,v);
	       else if(v>current.key)
	    	   current.right=addRec(current.right,v);
	       return current;
	}
	public void add(int v)
	{
		root=addRec(root,v);
	}
	public void InTraversal(Node node)
	{
		if(node!=null)
		{
			InTraversal(node.left);
			System.out.println(node.key);
			InTraversal(node.right);
			
		}
	}
	
	public Node deleteRec(Node root, int v)
	{
		if(root == null)
			return root;
		else if(v<root.key)
			root.left=deleteRec(root.left,v);
		else if(v>root.key)
			root.right=deleteRec(root.right,v);
		else {
			if(root.left==null)
				return root.right;
			else if(root.right==null)
				return root.left;
			root.key=minValue(root.right);
			root.right=deleteRec(root.right,v);
						
		}
		return root;
	}
	public int minValue(Node current)
	{
		int m=current.key;
		while(current.left!=null)
		{
			m=current.left.key;
			current=current.left;
		}
		return m;
	}
	public static void main(String args[])
	{
		binarySearchTree bst=new binarySearchTree();
		boolean s=true;
		Scanner input=new Scanner(System.in);
		System.out.println("enter choice");
		int c=input.nextInt();
		
		while(s)
		{
			switch(c) {
			case 1: int n=input.nextInt(); 
				bst.add(n);
				System.out.println("enter choice");
				 c=input.nextInt();
				 break;
			case 2: bst.InTraversal(root);
			System.out.println("enter choice");
			 c=input.nextInt();
			 break;
			case 3:
				int v=input.nextInt();
				bst.deleteRec(root,v);
			System.out.println("enter choice");
			 c=input.nextInt();
			 break;
			case 4: s=false;
			
			}
		}
	}
	
}
