package com.practice.sort;

import com.practice.common.CommonUtils;

/*
 * Implement select sort
 */

public class SelectSort {
	static int[] array = CommonUtils.getIntegarArray(20);
	
	public static void main(String[] args) {
		
		for(int i=0; i<array.length; i++) {
			int iPos = getSmallest(i);
			//Swap small value with i
			int d = array[i];
			array[i] = array[iPos];
			array[iPos] = d;
		}
		CommonUtils.printArray(array);
	}
	
	public static int getSmallest(int start) {
		int iPos = start;
		int small = array[start];
		for(int i=start; i<array.length; i++ ) {
			if(array[i]<small) {
				iPos = i;
				small = array[i];
			}
		}
		return iPos;
	}

}
