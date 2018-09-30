package com.java.solutions;

import java.util.Arrays;

public class FindIndexSumOfElementsWhoseLeftIsEqualToRightExample {

	public static void main(String...args) {
        int[] ar = { 2, 4, 4, 2, 6, 1, 1 };
        
        System.out.println( (52&1));
        System.err.println( Arrays.toString(ar) );
        
        int index = findIndex(ar);
        
        System.out.println( index != -1 ? 
        		"Sum of elements on left (i.e index 0 to "+ index + ") = Sum of elements on right (i.e "+ (index+1) +" to "+ (ar.length-1) +")" 
        		: "No index found where  sum of elements on left = sum of elements on right");
	
	}
	
	static int findIndex(int[] ar){
		
		int leftSum=0, rightSum=0;
		int leftIndex = 0, rightIndex=ar.length-1;
		
		while(leftIndex <= rightIndex) {
			if(leftSum > rightSum ) {
				rightSum += ar[rightIndex--];
			} else {
				leftSum += ar[leftIndex++];
			}
		}
		
		if( leftSum == rightSum ){
			return rightIndex;
		}
		
		return -1;
	}
}
