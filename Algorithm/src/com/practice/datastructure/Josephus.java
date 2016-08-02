package com.practice.datastructure;


/*
 * This class use linked list to simulate 
 * Josephus problem
 */

public class Josephus {

	public static void main(String[] args) {
		
		//1. Create a linked list to create the circle
		int n = 7;
		int m =2;
		Node[] nodes = new Node[n];
		nodes[n - 1] = new Node(n, null);
		for(int i=n-2; i>=0; i--) {
			nodes[i] = new Node(i + 1, nodes[i + 1]);
		}
		//Point last to first
		nodes[n - 1].next = nodes[0];
		
		int count = n;
		int counter = 0; //Counter for m
		Node node = nodes[0];
		
		while(count > 1) {

			while(true) {
				if(node.inqueue) {
					counter++;
					if(counter == m) {
						break;
					}
				}
				node = node.next;
			}
			System.out.println(node.value);
			if(node.inqueue) {
				count--;
				node.inqueue = false;
			} 
			counter = 0;
			
		}
		
		for(Node nd : nodes) {
			if(nd.inqueue) {
				System.out.println("------" + nd.value);
			}
		}

	}

	
}
