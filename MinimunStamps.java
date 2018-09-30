package com.java.solutions;

public class MinimunStamps {

	public static void main(String[] args) {
		int stampPrices[] = {1,2,3,4,5,6,7};
		int postage = 20;
		
		System.out.println(minimumStamps(postage,stampPrices));
		
  }
	
	public static int minimumStamps(int postage, int[] stampPrices) {
		  /* Strategy: this algorithm uses a greedy technique.  We
		   * repeatedly buy the largest possible stamp.
		   */
		  // The number of stamps needed.
		  int count = 0;
		  
		  if(null == stampPrices || stampPrices.length == 0){
			  return 0;
		  }
		  // The index of the most expensive stamp to consider.
		  int stamp = stampPrices.length - 1;
		  // Repeatedly choose a price and remove copies until the
		  // postage reaches 0.
		  while (postage > 0) {
		    // Find the most expensive stamp we still need.
		    while (stampPrices[stamp] > postage) --stamp;
		    // Buy a stamp at the price.
		    postage -= stampPrices[stamp];
		    count += 1;
		  } // while (postage > 0)
		  // That's it, we're done.
		  return count;
		} 
	
}
