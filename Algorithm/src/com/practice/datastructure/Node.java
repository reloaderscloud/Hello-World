package com.practice.datastructure;

public class Node {
	public int value;
	public Node next;
	public boolean inqueue = true;
	
	public Node(int value, Node next){
		this.value = value;
		this.next = next;
		
	}
}
