package com.practice.sort;

import com.practice.common.CommonUtils;

//Implement Heap Sort algorithm

public class HeapSort {
	
static int[] array = CommonUtils.getIntegarArray(50);
	
	public static void main(String[] args) {
		CommonUtils.printArray(array);
		
		System.out.println("\n------------------\n");
		
		int[] heap = createHeap();
		
		int[] sorted = new int[array.length];
		
		for(int i=0; i<array.length; i++) {
			sorted[i] = popRoot(heap, heap.length - i);
		}
				
		CommonUtils.printArray(sorted);
	}
	
	/*
	 * Create a Heap array from give integer array
	 */
	public static int[] createHeap() {
		
		int[] heap = new int[array.length];
		
		int heapLength = 0;
		
		for(int i=0; i<array.length; i++){
			addLeaf(heap, heapLength, array[i]);			
			heapLength++;
		}
		return heap;
	}
	
	/*
	 * Pop the root value, reconstruct the heap
	 */
	
	public static int popRoot(int[] heap, int heapLength) {
		int max =  heap[0];
		
		//1. Swap root value with the last element
		heap[0] = heap[heapLength - 1];
		
		//2. Reconstruct the heap
		int moving = 0;
		while(true) {
			//Compare moving node with its children
			int leftIndex = 2 * moving;
			int rightIndex = 2 * moving + 1;
			
			if(leftIndex > heapLength - 1) {
				//No children, break
				break;
			}
			
			int left = heap[leftIndex];
			
			if(rightIndex < heapLength - 1) {
				//Compare 3
				int right =  heap[rightIndex];
				
				if(heap[moving]>=left && heap[moving]>=right) {
					break;
				} else {
					//Move to left
				   if(heap[moving]<left && heap[moving]>=right){
					   int i = heap[moving];
						heap[moving] = left;
						heap[leftIndex] = i;
						moving = leftIndex; 
				   }
					//Move to right
				   if(heap[moving]>=left && heap[moving]<right){
					   int i = heap[moving];
						heap[moving] = right;
						heap[rightIndex] = i;
						moving = rightIndex; 
				   }	   
				   if(heap[moving]<left && heap[moving]<right){
					   if(right > left){
						   int i = heap[moving];
							heap[moving] = right;
							heap[rightIndex] = i;
							moving = rightIndex; 
					   } else {
						   int i = heap[moving];
							heap[moving] = left;
							heap[leftIndex] = i;
							moving = leftIndex;  
					   }
				   }	   
				}
					
			} else {
				if(left > heap[moving]) {
					int i = heap[moving];
					heap[moving] = left;
					heap[leftIndex] = i;
					moving = leftIndex;
				} else {
					break;
				}
			}			
		}
		
		return max;
	}
	
	/*
	 * Add a leaf to the heap
	 */
	public static void addLeaf(int[] heap, int leaflength, int leafValue) {
		heap[leaflength] = leafValue;
		//this is the root
		if(leaflength == 0) {
			return;
		}
		
		//compare with is parent until to the root
		
		while(true) {
		
			int ip = (int)(leaflength / 2);
			
			//Swap 
			if(heap[ip] < leafValue ) {
				heap[leaflength] = heap[ip];
				heap[ip] = leafValue;
				leaflength = ip;
			} else {
				return;
			}
			if(ip == 0) {
				break;
			}
		}				
	}
	
}
