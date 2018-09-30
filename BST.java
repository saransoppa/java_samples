package com.java.solutions;

//private class Node {
//    int data;
//    Node left;
//    Node right;    
//    public Node(int data) {
//          this.data = data;
//          left = null;
//          right = null;
//    }
//   
//    public String toString() {
//          return "left :" + left +" right:"+right;
//    }
//}

/**
* Binary search tree implementation.
*/
public class BST {

    public Node root;

    public BST() {
          this.root = null;
    }

    public boolean contains(int id) {
    	Node current = root;
    	
    	while(current != null){
    		
    		if(current.data == id){
    			return true;
    		} else if(current.data > id){
    			current = current.left;
    		} else {
    			current = current.right;
    		}
    	}
     return false;
    }
  
    /*
    1) Node to be deleted is leaf:
    	  Simply remove from the tree.
    	              80                                  80
    	           /     \         delete(50)    	 	/   \
    	          60      100       --------->  	 60      100
    	         /  \    /  \                          \      /  \
    	       50   70  90   110                    70   90   110

    	2) Node to be deleted has only one child:
    	  Swap the child to the node and delete the new child.

    	              80                                  80
    	           /     \         delete(60)      		/   \
    	          60      100       --------->     		70     100
    	            \    /  \                                 /  \
    	            70  90   110                           90   110

    	3) Node to be deleted has both children:
    	 A. Find inorder successor of the node.
    	 B. Copy contents of the inorder successor to the node and delete the inorder successor.   
    	     (Inorder predecessor can also be used).

    	              80                                     90
    	           /     \         delete(80)      			/   \
    	          70      100       --------->     		   70    100
    	                  /   \                                      \
    	                90   110                                     110

    	Note: Inorder successor is needed only when right child is not empty.
    	Inorder successor can be obtained as the minimum value in right sub tree of the node.
    	*/
    /**
     * Functions to delete data.
     **/
    public boolean delete(int id) {
          Node parent = root;
          Node current = root;
          boolean isLeftChild = false;
          while(current.data!=id){
               parent = current;
               if(current.data>id) {
                    isLeftChild = true;
                    current = current.left;
               } else {
                    isLeftChild = false;
                    current = current.right;
               }

               if(current==null) {
                    return false;
               }
          }

          /**
           * Case 1: if node to be deleted has no children
           */
          if(current.left==null && current.right==null) {
               if(current==root) {
                    root = null;
               }
               if(isLeftChild ==true) {
                    parent.left = null;
               } else {
                    parent.right = null;
               }
          }

          /**
           * Case 2 : if node to be deleted has only one child
           */
          else if(current.right==null) {
               if(current==root) {
                    root = current.left;
               } else if(isLeftChild) {
                    parent.left = current.left;
               } else {
                    parent.right = current.left;
               }
          } else if(current.left==null) {
               if(current==root) {
                    root = current.right;
               } else if(isLeftChild) {
                    parent.left = current.right;
               } else {
                    parent.right = current.right;
               }
          }
          /**
           * Node to be deleted has two children.
           * Find inorder successor of the node.
           * Copy contents of the inorder successor to the node and
           * delete the inorder successor.
           * Note that inorder predecessor can also be used.
           **/

          else if(current.left!=null && current.right!=null) {

               //To found the minimum element in the right sub tree.
               Node successor = getSuccessor(current);
               if(current==root) {
                    root = successor;
               } else if(isLeftChild) {
                    parent.left = successor;
               } else {
                    parent.right = successor;
               }              
               successor.left = current.left;
          }         
          return true;        
    }

    private Node getSuccessor(Node deleleNode) {
          Node successsor = null;
          Node successsor_P = null;
          Node current = deleleNode.right;
          while(current!=null) {
               successsor_P = successsor;
               successsor = current;
               current = current.left;
          }
         
          /**
           * Check if successor has the right child,
           *      It cannot have left child for sure
           * If it does have the right child,
           *      add it to the left of successor_P.
           */
          if(successsor != deleleNode.right) {
               successsor_P.left = successsor.right;
               successsor.right = deleleNode.right;
          }
          return successsor;
    }

    public void insert(int element) {
          Node newNode = new Node(element);
          /** No element in the BST. */
          if(root==null) {
               root = newNode;
               return;
          }
          Node current = root;
          Node parent = null;
          while(true) {
               parent = current;
               /** find the leaf Node where element will be insert.*/
               if(element<current.data) {                
                    current = current.left;
                    /** Insert the element at the leaf. */
                    if(current==null) {
                          parent.left = newNode;
                          return;
                    }
               } else {
                    current = current.right;
                    /** Insert the element at the leaf. */
                    if(current==null) {
                          parent.right = newNode;
                          return;
                    }
               }
          }
    }

    /**
     * print all the elements in the In-Order.
     */
    public void display(Node root) {
          if(root!=null) {
               display(root.left);
               System.out.print(" " + root.data);
               display(root.right);
          }
    }
    
    
    public static void main(String arg[]) {
        BST bst = new BST();
        bst.insert(80);bst.insert(60);
        bst.insert(50);bst.insert(70);
        bst.insert(100);bst.insert(90);
        bst.insert(110);

        System.out.println("Original Tree : ");
        bst.display(bst.root);

        System.out.println("\n1)Node to be deleted is leaf:" +
                                           bst.delete(50));
        bst.display(bst.root);
       
        System.out.println("\n2)Node to be deleted has only one child:" + bst.delete(60));
        bst.display(bst.root);
       
        System.out.println("\n3) Node to be deleted has both children" + bst.delete(80));
        bst.display(bst.root);
  }
}
