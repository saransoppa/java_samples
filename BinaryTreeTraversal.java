package com.java.solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;



/*
 class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
} */

public class BinaryTreeTraversal 
{
	TreeNode root;

 public void printLevelOrder(TreeNode tNode){
	 Queue<TreeNode> treeQueue = new LinkedList<>();
     treeQueue.add(tNode);
     while(!treeQueue.isEmpty()) {
    	 TreeNode tempNode = treeQueue.poll();
    	 System.out.println(tempNode.val);
    	 if(tempNode.left != null){
    		 treeQueue.add(tempNode.left);
    	 }
    	 if(tempNode.right != null){
    		 treeQueue.add(tempNode.right);
    	 }
     }
	 
 }
 
 public List<List<Integer>> levelOrderBottom1(TreeNode root) {
	 if(root == null){
		 return new ArrayList<>();
	 }
	 Queue<TreeNode> treeQueue = new LinkedList<>();
	 Stack<List<Integer>> tStack = new Stack<>();
	 treeQueue.add(root);
	 int i = 0;
	 while(!treeQueue.isEmpty()) {
		 TreeNode tempNode = treeQueue.poll();
		 if( i == 0 || i%2 != 0){
			 List<Integer> lNodeList = new ArrayList<>();
			 if(null != tempNode)
				 lNodeList.add(tempNode.val);
			 tStack.add(lNodeList); 
		 } else {
			 if(null != tempNode)
				 tStack.peek().add(tempNode.val); 
		 }
		 if(tempNode != null){
			 treeQueue.add(tempNode.left);
			 treeQueue.add(tempNode.right);
		 }
		 i++;
	 }

	 List<List<Integer>> outterList = new ArrayList<>();;
	 while(!tStack.empty()) {
		 if(tStack.peek().isEmpty()) {
			 tStack.pop();
			 continue;
		 }
		 outterList.add(tStack.pop());
	 }
	 return outterList;
 }

 public List<List<Integer>> levelOrderBottom(TreeNode root) {
     Queue<TreeNode> queue = new LinkedList<TreeNode>();
     List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
     
     if(root == null) return wrapList;
     
     queue.offer(root);
     while(!queue.isEmpty()){
         int levelNum = queue.size();
         List<Integer> subList = new LinkedList<Integer>();
         for(int i=0; i<levelNum; i++) {
             if(queue.peek().left != null) queue.offer(queue.peek().left);
             if(queue.peek().right != null) queue.offer(queue.peek().right);
             subList.add(queue.poll().val);
         }
         wrapList.add(0, subList);
     }
     return wrapList;
 }
 
 public static void main(String args[]) 
 {
     BinaryTreeTraversal tree = new BinaryTreeTraversal();
     tree.root = new TreeNode(1);
     tree.root.left = new TreeNode(2);
     tree.root.right = new TreeNode(3);
     tree.root.left.left = new TreeNode(4);
//     tree.root.left.right = new TreeNode(5);
     tree.root.right.right = new TreeNode(5);
//     tree.root.right.right.left = new TreeNode(7);
 //    tree.root.left.left.left = new TreeNode(4);
  //   tree.root.left.left.left.left = new TreeNode(5);

    // Calling for Level-Order
    // tree.printLevelOrder(tree.root);
     System.out.println( tree.levelOrderBottom(tree.root));
 }
}

