package com.java.solutions;

public class MaxDiffInArray {
	
	 int maxDiff(int arr[], int arr_size) 
	    {
	        int max_diff = -1;//arr[1] - arr[0];
	        int i, j;
	        for (i = 0; i < arr_size; i++) 
	        {
	            for (j = i + 1; j < arr_size; j++) 
	            {
	            	if(max_diff < 0 ) {
	            		max_diff = arr[j] - arr[i];
	            	} 
	                if (arr[j] - arr[i] > max_diff)
	                    max_diff = arr[j] - arr[i];
	            }
	        }
	        return max_diff;
	    }
	 
	    /* Driver program to test above functions */
	    public static void main(String[] args) 
	    {
	    	MaxDiffInArray maxdif = new MaxDiffInArray();
	        int arr[] = {12,2,56,43,67,789};
	        System.out.println("Maximum differnce is " + 
	                                maxdif.maxDiff(arr, arr.length));
	    	
	    	
	    }
}

