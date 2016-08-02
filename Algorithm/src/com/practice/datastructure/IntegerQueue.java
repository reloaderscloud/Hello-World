package com.practice.datastructure;

import java.util.ArrayList;
import java.util.List;

/*
 * Implement a Queue using arraylist
 */
public class IntegerQueue {
	
	private List<Integer> queue = null;
	
	public IntegerQueue() {
		queue = new ArrayList<Integer>();
	}
	
	public Integer dequeue() {
		Integer i = null;
		if(queue.size()>0){
			i = queue.get(0);
			queue.remove(0);
		}		
		return i; 
	}
	
	public void queue(Integer i) {
		queue.add(i);
	}
	
	public int size() {
		return queue.size();
	}
	
}
