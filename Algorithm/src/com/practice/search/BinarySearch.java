package com.practice.search;

import com.practice.common.CommonUtils;
import com.practice.common.JellyBean;

/*
 * This class implement Binary search
 * 
 */

public class BinarySearch {
	
	static JellyBean[] array = CommonUtils.getJellyBeanArray(100); 

	
	public static void main(String[] args) {
		CommonUtils.printArray(array);
		System.out.println("\n-----------------\n");
		//For binary search, Sort array by key first
		
		BinarySearch bs = new BinarySearch();
		
		JellyBean[] sorted = bs.qsort(array);
		
		CommonUtils.printArray(sorted);
		
		JellyBean rs = bs.binSearch(array[15].key, sorted);
		
		System.out.println("\n\n" + rs.flavor);
	}
	
	/*
	 * Implement Binary Search on sorted array
	 */
	public JellyBean binSearch(int searchFor, JellyBean[] sorted) {
		
		//1. Check the element at the middle
		int middle = (int)(sorted.length / 2);
		JellyBean mbean = sorted[middle];
		if(mbean.key == searchFor) {
			return mbean;
		}
		if(sorted.length == 0 || sorted.length == 1) {
			return null;
		}
		
		//2. Check with half need to go on
		JellyBean[] next = null;
		if(mbean.key > searchFor) {
			next = new JellyBean[sorted.length - middle - 1];
			for(int i=0; i<next.length; i++) {
				next[i] = new JellyBean(sorted[middle + i + 1 ]);
			}
		} else {
			next = new JellyBean[middle];
			for(int i=0; i<middle; i++) {
				next[i] = new JellyBean(sorted[i]);
			}
		}
		
		return binSearch(searchFor, next);
	}
	
	
	//Quick sort algorithm
	public JellyBean[] qsort(JellyBean[] a){
	//	CommonUtils.printArray(a);
	//	System.out.println("\n-----------------\n");
		JellyBean[] sorted = new JellyBean[a.length];
		//Stop Conditions
		if(a.length == 0) {
			return sorted;
		}
		if(a.length == 1) {
			sorted[0] = new JellyBean(a[0]);
			return sorted;
		}
		if(a.length == 2) {
			if(a[0].key > a[1].key) {
				sorted[0] = new JellyBean(a[0]);
				sorted[1] = new JellyBean(a[1]);
			} else {
				sorted[0] = new JellyBean(a[1]);
				sorted[1] = new JellyBean(a[0]);
			}
			return sorted;
		}
		
		//1. Find a pivot key, for simplicity, use the first bean as pivot
		
		int pivot = a[0].key;
		
		JellyBean b1 = a[0];
		JellyBean b2 = a[a.length - 1];
		JellyBean b3 = a[(int)(a.length / 2)];
		
		if(b1.key >= b2.key && b1.key >= b3.key ) {
			if(b2.key > b3.key ) {
				pivot = b2.key;
			} else {
				pivot = b3.key;
			}
		}
		if(b2.key >= b1.key && b2.key >= b3.key ) {
			if(b1.key > b3.key ) {
				pivot = b1.key;
			} else {
				pivot = b3.key;
			}
		}		
		if(b3.key >= b2.key && b3.key >= b1.key ) {
			if(b2.key > b1.key ) {
				pivot = b2.key;
			} else {
				pivot = b1.key;
			}
		}		
		
		//System.out.println(pivot);
		//2. Swap array based on pivot
		int leftPointer = 0;
		int rightPointer = a.length - 1;
	
		
		while(leftPointer < rightPointer) {
		
			//System.out.println(leftPointer + "  " + rightPointer);
			
			while(a[leftPointer].key > pivot ) {
				leftPointer ++;			
			} 
			
			while(a[rightPointer].key < pivot ) {
				rightPointer --;		
			}
			
			if(leftPointer < rightPointer) {
				//swap element
				JellyBean b = new JellyBean(a[leftPointer]);
				a[leftPointer] = new JellyBean(a[rightPointer]);
				a[rightPointer] = new JellyBean(b);
				leftPointer ++;
				rightPointer --;	
			}
		}
		//CommonUtils.printArray(a);
		//3. Split array at the pointer location and go on
		JellyBean[] left = new JellyBean[leftPointer];
		JellyBean[] right = new JellyBean[a.length - leftPointer];
		
		for(int i=0; i<leftPointer; i++) {
			left[i] = new JellyBean(a[i]);
		}
		for(int i=0; i<a.length - leftPointer; i++) {
			right[i] = new JellyBean(a[leftPointer + i]);
		}
		JellyBean[] leftSorted =  qsort(left);
		JellyBean[] rightSorted =  qsort(right);
		
		//4. Combine the results
		for(int i=0; i<sorted.length; i++) {
			if(i < leftPointer ) {
				sorted[i] = new JellyBean(leftSorted[i]);
			} else {
				sorted[i] = new JellyBean(rightSorted[i - leftPointer]);
			}
		}
		
		return sorted;
	}
}
