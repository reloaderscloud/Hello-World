package com.practice.sort;

import com.practice.common.CommonUtils;

/*
 * This class implements insert sort
 */
public class InsertSort {
	
	static int[] array = CommonUtils.getIntegarArray(20);
	public static void main(String[] args) {
		
		for(int i=1; i<array.length; i++) {
			int iPos = getInsertLocation(i);
						
			//Swap small value with i
			int d = array[i];
			array[i] = array[iPos];
			array[iPos] = d;
		}
		CommonUtils.printArray(array);
	}
	
	public static int getInsertLocation(int start) {
		int iPos = start;
		
		//Compare elements at the left, find the location
		for(int i=0; i<start; i++) {
			if(array[start] < array[i] ) {
				iPos = i;
				break;
			}
		}
		
		return iPos;
	}

}
