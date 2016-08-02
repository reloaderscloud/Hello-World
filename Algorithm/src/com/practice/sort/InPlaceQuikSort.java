package com.practice.sort;

import com.practice.common.CommonUtils;

public class InPlaceQuikSort {

	int[] array = null;
	
	public static void main(String[] args) {
		InPlaceQuikSort qs = new InPlaceQuikSort();
		 int[] input = {24,2,45,20,56,75,2,56,99,53,12};
		 qs.sort(CommonUtils.getIntegarArray(20));		
		 //qs.sort(input);
	}
	
	public void sort(int[] array) {
		CommonUtils.printArray(array);
		System.out.println("\n------------------\n");
		this.array = array;
		int length = array.length;
		qsort(0,  length -1);
		CommonUtils.printArray(array);
	}

	public void qsort( int start, int end) {
		if(start>=end) {
			return;
		}
			
		//if array length >= 3, divide 
		int pivot = getPivot(start, end);	
		
		System.out.println("\n-----" + pivot + "---------\n");
		
		int i = start;
		int j = end;
		
		while( i <=  j ) {
							
			while(array[i] > pivot ) {
				i ++;		
			} 
		
			while(array[j] < pivot ) {
				j --;
			}
			
			
			if(i <= j) {
				int d = array[i];
				array[i] = array[j];
				array[j] = d;
				i ++;
				j --;				
			}
		}		
			
		qsort(start, j);
		qsort(i, end);
	}
	
	
	/*
	 * Use 3-point medium to pickup a pivot
	 */
	public int getPivot2(int start, int end) {
		
	
		return array[start + end / 2];
	}

	
	
	/*
	 * Use 3-point medium to pickup a pivot
	 */
	public int getPivot(int start, int end) {
		
		int i1 = array[start];
		int i2 = array[(int)(start + (end - start) /2 )];
		int i3 = array[end];
		
		if(i1 <= i2 && i1 <= i3) {
			if(i2 > i3) {
				return i3;
			} else {
				return i2;
			}
		}
		if(i2 <= i1 && i2 <= i3) {
			if(i1 > i3) {
				return i3;
			} else {
				return i1;
			}
		}		
		if(i3 <= i2 && i2 <= i1) {
			if(i2 > i1) {
				return i1;
			} else {
				return i2;
			}
		}		
		return i1;
	}

}
