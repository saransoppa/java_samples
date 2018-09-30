package com.java.solutions;

public class SimpleLinkedList {

	ListNode head;

	class ListNode {
		int data;
		ListNode next;
		ListNode(int val){
			data = val;
			next = null; 
		}
	}

	private void push(int nData) {
		System.out.println( "-----push-----");
		ListNode node = new ListNode(nData);
		if(null == head ){
			node.next = null;
			head = node;
		} else {
			ListNode cNode = head, nNode = null;
			while(null != cNode) {
				nNode = cNode;
				cNode = cNode.next;
			}
			nNode.next = node;

		}
	}

	void pushAfterKey(int pKey, int nKey){
		System.out.println( "-----pushAfterKey-----");
		ListNode cNode = head, nNode = null;
		ListNode tmpNode = new ListNode(nKey);

		while(cNode != null && cNode.data != pKey ) {
			cNode = cNode.next;
		}

		if(cNode == null) return;

		nNode = cNode.next;
		cNode.next = tmpNode;
		tmpNode.next = nNode;
		
	}

	void pushBeforeKey(int pKey, int nKey){
		System.out.println( "-----pushBeforeKey-----");
		ListNode cNode = head, pNode = null;
		ListNode tmpNode = new ListNode(nKey);

		while(cNode != null && cNode.data != pKey ) {
			pNode = cNode;
			cNode = cNode.next;
		}

		if(cNode == null) return;
		
		pNode.next = tmpNode;
		tmpNode.next = cNode;
		
	}


	private void deleteNode(int key){
		System.out.println( "-----deleteNode-----");
		ListNode lNode = head, pNode = null;
		if(null != lNode && lNode.data == key){
			head = lNode.next;
			return;
		}
		while(null != lNode && lNode.data != key){
			pNode = lNode;
			lNode = lNode.next;
		}

		if(lNode == null){
			return;
		}
		pNode.next = lNode.next;

	}

	void printNode(){
		ListNode cNode = head;
		while(cNode != null){
			System.out.println( cNode.data );
			cNode = cNode.next;
		}
		System.out.println( "----------");
	}
	
	void printNode(ListNode cNode ){
		//ListNode cNode = head;
		while(cNode != null){
			System.out.println( cNode.data );
			cNode = cNode.next;
		}
		System.out.println( "----------");
	}
	
	void reverseNode() {
		System.out.println( "-----reverseNode-----");
		ListNode cNode = head, pNode=null, nNode=null;
		
		while(cNode != null){
			nNode = cNode.next;
			cNode.next = pNode;
			pNode = cNode;
			cNode = nNode;
		}
		head = pNode;
	}

	public boolean hasCycle() {
		System.out.println( "-----hasCycle-----");
		ListNode fastNode = head, slowNode = head;
		while(slowNode != null && fastNode != null && fastNode.next != null ) {
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;
			if(slowNode == fastNode) {
				return true;
			}
			
		}
		return false;
	}
	
	public ListNode getCycleNode() {
		System.out.println( "-----getCycleNode-----");
		ListNode fastNode = head, slowNode = head;
		while(slowNode != null && fastNode != null && fastNode.next != null ) {
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;
			
			if(slowNode == fastNode) {
//				ListNode tempNode = head;
//				while(tempNode != slowNode) {
//					tempNode = tempNode.next;
//					slowNode = slowNode.next;
//				}
				System.out.println("CycleNode data: "+ slowNode.data);
				return slowNode;
			}
		}
		return null;
	}
	
	public static void main(String[] args){

		SimpleLinkedList sl = new SimpleLinkedList();

//		for(int i=0;i<5;i++){
//			sl.push( i);
//		}
		sl.push(1);
		sl.push(3);
		sl.push(2);
		//sl.head.next.next.next = sl.head;
		
		//sl.printNode();

//		sl.deleteNode(3);
//		sl.printNode();
//
//		sl.pushAfterKey(4,5);
//		sl.printNode();
//		
//		sl.pushBeforeKey(2, 6);
//		sl.printNode();
//		
	sl.reverseNode();
		sl.printNode();
//		
		
		//System.out.println("CricleN List :"+  sl.hasCycle());
		
		//sl.getCycleNode();
		//sl.printNode(resultNode);
	}
}


