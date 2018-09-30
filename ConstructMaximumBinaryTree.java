package com.java.solutions;

import java.util.Arrays;

public class ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        
    	System.out.println("nums.length ->"+ nums.length);
    	if(null == nums || nums.length == 0) {
    		return null;
    	}
    	
    	int maxnumIndex = getMaxNumIndex(nums);
    	if(maxnumIndex < 0) {
    		return null;
    	}
    	int[] leftAry = getLeftArry(nums, maxnumIndex);
    	int[] rightAry = getRightArry(nums, maxnumIndex);
    	
    	TreeNode root = new TreeNode(nums[maxnumIndex]);
    	System.out.println("root ->"+ root.val);
    	
    	if(leftAry.length > 0) {
    		root.left = constructMaximumBinaryTree(leftAry);
    	}
    	
    	if(rightAry.length > 0) {
    		root.right = constructMaximumBinaryTree(rightAry);
    	}
    	
    	return root;
    }
    
    private int[] getLeftArry(int[] nums, int splitIndex){
    	
    	int[] leftAry = new int[splitIndex];
    	
    	for(int i = 0; i < leftAry.length; i++){
    		leftAry[i] = nums[i];
    	}
    	
    	System.out.println("LeftArray -> "+Arrays.toString(leftAry));
    	return leftAry;
    }
    
    private int[] getRightArry(int[] nums, int splitIndex){
    	
    	int max = splitIndex+1;
    	int[] rAry = new int[nums.length - max];
    	
    	for(int i = 0; i < rAry.length; i++){
    		rAry[i] = nums[(i+max)];
    	}
    	
    	System.out.println("RighttArray -> "+Arrays.toString(rAry) );
    	return rAry;
    }
    
    private int getMaxNumIndex(int[] nums) {
    	
    	if(null == nums)
    		return -1;
    	
    	int maxNum = -1;
    	int index = -1;
    	int maxIndex = -1;
    	for(int num : nums){
    		++index;
    		if(num > maxNum){
    			maxNum = num;
    			maxIndex = index;
    		} 
    	}
    	
    	System.out.println("maxIndex :"+maxIndex +", maxNum -> "+ maxNum);
    	return maxIndex;
    }
    
    public static void main(String[] args){
    
    	int[] nums = {3,2,1,6,0,5};
    	System.out.println("nums -> "+Arrays.toString(nums) );
    	ConstructMaximumBinaryTree cb = new ConstructMaximumBinaryTree();
    	TreeNode finalTree = cb.constructMaximumBinaryTree(nums);
    	
    	System.out.println("Root -> "+ finalTree.val + ", Left -> "+ finalTree.left.val + ", Right -> "+ finalTree.right.val);
    	System.out.println(finalTree.right.left.val);
    	
    }


}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}