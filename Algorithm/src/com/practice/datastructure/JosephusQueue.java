package com.practice.datastructure;

public class JosephusQueue {

	public static void main(String[] args) {
		
		int n = 7;
		int m = 2;
		
		//1. Populate the queue
		IntegerQueue queue = new IntegerQueue();
		
		for(int i=0; i<n; i++) {
			queue.queue(new Integer(i));
		}
		
		//2. Start round
		int count = 0;
		while(true){
			if(queue.size() == 1) {
				System.out.println("--------" + queue.dequeue());
				break;
			}
			while(count < m) {
				Integer i = queue.dequeue();
				count++;
				if(count == m) {
					System.out.println(i);
					break;
				} else {
					queue.queue(i);
				}
			}			
			count = 0;			
		}
		

	}
	
	

}
