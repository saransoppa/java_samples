package com.java.solutions;

public class AddTwoNumber {

	public static void main(String[] args){
		
		AddTwoNumber solution = new AddTwoNumber();
		//int[] temp = new int[]{-3,-14,-5,7,8,42,8,3};//{2,-3,3,1,10,8,2,5,13,-5,3,-18};
		//System.out.println( solution.solution(temp));
		int[] intArry1 = {2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,9};
		int[] intArry2 = {5,6,4,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,9,9,9,9};
		ListNode l1 =  solution.appenedToNewNode(intArry1);// solution.new ListNode(0);
		
		//l1.next =  solution.new ListNode(4);
		//l1.next.next = solution.new ListNode(3);
		
		ListNode l2 = solution.appenedToNewNode(intArry2);//solution.new ListNode(1);
		//l2.next =  solution.new ListNode(6);
		//l2.next.next = solution.new ListNode(4);
		
		ListNode output = solution.addTwoNumbers(l1, l2);
		//System.out.println( "Output ->> "+ (null != output ? output.val : null) );
		while ( output != null ){ 
			System.out.println( "Output ->> "+ output.val );
		  output = output.next;
		  
		} 
				
	}
	
	private ListNode appenedToNewNode(int[] intArr){
		ListNode node = null;
		for(int s : intArr) {
			if(node == null) {
				node = new ListNode(s);; 
			} else {
				ListNode lastNode = node;
				ListNode lastPrevNode = null;
				while(lastNode != null) {
					lastPrevNode = lastNode;
					lastNode = lastNode.next;
				}
				lastPrevNode.next = new ListNode(s);
			}
		}
		return node;
	}
	
	
	public class ListNode {
		     int val;
		     ListNode next;
		     ListNode(int x) { val = x; next=null;}
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carryForward = 0;
		int lSum = 0;
		ListNode results = null;

		while(l1 != null || l2 != null){
			if(l1 != null) 
				lSum = l1.val;

			if(l2 != null) 
				lSum = lSum + l2.val;

			if(results == null) {
				results = new ListNode((int)(lSum%10) );
				carryForward = (int)(lSum/10);
			} else {
				//if( lSum > 0) {
					ListNode last = results;
					while(last.next != null){
						last = last.next;
					}
					last.next = new ListNode(((int)((lSum+carryForward)%10)) );
					carryForward =  (int)((lSum+carryForward)/10);
				//}
			}

			l1 = (null != l1 ? l1.next : null);
			l2 = (null != l2 ? l2.next : null);
			lSum = 0;
		}

		if( carryForward > 0 ) {
			ListNode last = results;
			while(last.next != null){
				last = last.next;
			}
			last.next = new ListNode(carryForward);
		}
		return results;
	}
	
	
	
   public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
	   /*   long l1Num = 0L, l2Num = 0L;
       int count = 0;
	   while( l1 != null) {
		   l1Num = l1Num + (long) (l1.val * Math.pow(10,count));
		   l1 = l1.next;
		   count++;
	   }
	   count = 0;
	   while( l2 != null) {
		   l2Num = l2Num + (long) (l2.val * Math.pow(10,count));
		   l2 = l2.next;
		   count++;
	   }
	   
	   l1Num = (l1Num+l2Num);
	   System.out.println("Sum -> "+ l1Num);
	   
	   ListNode results =  new ListNode((int)(l1Num%10) );
	   if(l1Num != 0 ){
		   while((l1Num / 10) > 0) {
			   l1Num = (l1Num / 10);
			   addToNextNode( results, l1Num);
		   }
	   }
	   return results; */
	   
	   //String sum = null;
	   int carryForward = 0;
	   int lSum = 0;
//	   StringBuilder l1String = new StringBuilder();
//	   StringBuilder l2String = new StringBuilder();
//	   StringBuilder resultsBuf = new StringBuilder();
	   
	   ListNode results = null;
	   
	   while(l1 != null || l2 != null){
		   
		   if(l1 != null) 
		      lSum = l1.val;
		   
		   if(l2 != null) 
			   lSum = lSum + l2.val;
		   
		   if(results == null) {
			   results = new ListNode((int)(lSum%10) );
			   carryForward = (int)(lSum/10);
		   } else {
			   ListNode last = results;
			   while(last.next != null){
				   last = last.next;
			   }
			   last.next = new ListNode(((int)(lSum%10) + carryForward) );
			   carryForward =  (int)(lSum/10);
		   }
		   
		   l1 = (null != l1 ? l1.next : null);
		   l2 = (null != l2 ? l2.next : null);
		   lSum = 0;
	   }
	   
	   if( carryForward > 0 ) {
		   ListNode last = results;
		   while(last.next != null){
			   last = last.next;
		   }
		   last.next = new ListNode(carryForward);
	   }
	   
//	   while(l1 != null || l2 != null){
//		   
//		   if(l1 != null) 
//			   l1String.append( l1.val );
//		   
//		   if(l2 != null) 
//			   l2String.append( l2.val );
//		   
//		   l1 = (null != l1 ? l1.next : null);
//		   l2 = (null != l2 ? l2.next : null);
//	   }
//	   
//	   
//	   l1String =  l1String.reverse();
//	   l2String =  l2String.reverse();
//	   System.out.println("l1String :"+ l1String + ", l2String :"+ l2String );
//	   int l1Length = l1String.length();
//	   int l2Length = l2String.length();
//	   
//	   int l1Index = 0;
//	   int l2Index = 0;
//	   while(l1Index < l1Length || l2Index < l2Length) {
//		   
//		   if( l1Length == l2Length ) {
//
//			   if(l1Index < l1Length ) {
//				   System.out.println("l1String :"+ Integer.valueOf( ""+l1String.charAt(l1Index)));
//				   lSum += Integer.valueOf(""+ l1String.charAt(l1Index++)); 
//			   }
//
//			   if(l2Index < l2Length ) {
//				   lSum += Integer.valueOf(""+l2String.charAt(l2Index++)); 
//			   }
//
//		   } else if (l1Length > l2Length){
//			   if(l1Index < l1Length ) {
//				   System.out.println("l1String :"+ Integer.valueOf( ""+l1String.charAt(l1Index)));
//				   lSum += Integer.valueOf(""+ l1String.charAt(l1Index++)); 
//			   }
//
//			   if( l1Index == l2Index && l2Index < l2Length  ) {
//				   lSum += Integer.valueOf(""+l2String.charAt(l2Index++)); 
//			   }
//			   
//		   }
//		   resultsBuf.append(((lSum%10) + carryForward));
//		   carryForward =  (int)(lSum/10);
//		   
//		   lSum = 0;
//	   }
//	   
//	   System.out.println("resultsBuf :"+ resultsBuf);
	   
	   return results;
	   
    }
   
//   private void addToNextNode(ListNode node, long num){
//	   while(node.next != null){
//		   node = node.next;
//	   }
//	   node.next = new ListNode((int)(num%10) );
//   }
     
}
