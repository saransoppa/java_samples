package com.java.solutions;

public class SimpleDoubleLinkedList {

	Node head;
	
	class Node {
		int data;
		Node prev;
		Node next;
		
		Node(int data){
			this.data = data;
		}
	}
	
	public void push(int data){
		
		Node newNode = new Node(data);
		
		if(head == null) {
			head = newNode;
		} else {
			Node cNode = head;
			while(cNode.next != null){
				cNode = cNode.next;
			}
			cNode.next = newNode;
			newNode.prev = cNode;
		}
	}
	
	public void insertBefore(int pData, int nData){
		
		Node hNode = head, lNode=null, nNode = new Node(nData);
		
		while(hNode != null && hNode.data != pData){
			lNode = hNode;
			hNode = hNode.next;
		}
		
		lNode.next = nNode;
		nNode.prev = lNode;
		
		nNode.next = hNode;
		hNode.prev = nNode;
	}
	
	
	public void insertAfter(int cData, int nData){
		
		Node hNode = head, nNode = new Node(nData);
		
		while(hNode != null && hNode.data != cData){
			hNode = hNode.next;
		}
		nNode.next = hNode.next;
		hNode.next = nNode;
		
		nNode.prev = hNode;
		if(nNode.next != null) {
			nNode.next.prev = nNode;
		}
	}
	
	public void deleteNote( int dData){
		Node hNode = head, lNode=null;;
		
		while(hNode != null && hNode.data != dData){
			hNode = hNode.next;
			lNode = hNode;
		}
		print(hNode);
		
//		hNode.next.prev = hNode.prev;
//		hNode.prev.next = hNode.next;
	}
	
	
	public void print(Node head){
		
		Node hNode = head, lNode=null;
		System.out.println("Forward :");
		while(hNode != null){
			System.out.print(hNode.data + " ");
			lNode  = hNode;
			hNode = hNode.next;
		}
		System.out.println("\nReverse :");
		while(lNode != null){
			System.out.print(lNode.data + " ");
			lNode = lNode.prev;
		}
		System.out.println("");
	}
	
	public static void main(String[] args){
		
		SimpleDoubleLinkedList sd = new SimpleDoubleLinkedList();
		sd.push(1);
		sd.push(2);
		sd.push(3);
		sd.print(sd.head);
//		sd.insertBefore(3, 0);
//		sd.print(sd.head);
		
//		sd.insertAfter(2, 5);
//		sd.print(sd.head);
		
		sd.deleteNote(2);
		sd.print(sd.head);
		
	}
}
