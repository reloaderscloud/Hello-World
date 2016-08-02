package com.practice.sort;

import com.practice.common.CommonUtils;

/*
 * Impelment top down merge sort
 */
public class MergeSort {

	public static void main(String[] args) {
		 int[] array = CommonUtils.getIntegarArray(50);
		 CommonUtils.printArray(array);
		 MergeSort ms = new MergeSort();
		 
		 int[] sorted = ms.mergeSort(array);
		 
		 CommonUtils.printArray(sorted);
		
	}
	
	public int[] mergeSort( int[] input ) {
		System.out.println(input.length);
		int[] output = new int[input.length];
		
		if(input.length == 1) {
			output[0] = input[0];
			return output;
		}
		
		if(input.length == 2) {
			if(input[0] > input[1]) {
				output[0] = input[0];
				output[1] = input[1];
			} else {
				output[0] = input[1];
				output[1] = input[0];
			}
			return output;
		}
		
		int divPos = input.length / 2;
		
		//Sort both side;
		int[] left = new int[divPos];
		int[] right = new int[input.length - divPos];
		for(int i=0; i<divPos; i++) {
			left[i] = input[i];
		}
		for(int i=0; i<input.length - divPos; i++) {
			right[i] = input[ i + divPos];
		}
		
		left = mergeSort(left);
		right = mergeSort(right);
		
		//Merge
		int leftCounter = 0;
		int rightCounter = 0;
		int mainCounter = 0;
		while(mainCounter < output.length) {
			int value = 0;
			
			if(leftCounter == left.length && rightCounter < right.length) {
				value = right[rightCounter];
				rightCounter++;
			} else if(leftCounter < left.length && rightCounter == right.length){
				value = left[leftCounter];
				leftCounter++;
			} else {
				if(left[leftCounter] > right[rightCounter]) {
					value = left[leftCounter];
					leftCounter++;
				} else {
					value = right[rightCounter];
					rightCounter++;
				}
			}
			
			output[mainCounter] = value;
				
			mainCounter++;
		}
		return output;
 	}

}
