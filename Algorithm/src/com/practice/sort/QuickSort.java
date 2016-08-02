package com.practice.sort;

import com.practice.common.CommonUtils;

/*
 * Implement quick sort on an array
 */
public class QuickSort {

	static int[] array = CommonUtils.getIntegarArray(120);
	
	public static void main(String[] args) {
		CommonUtils.printArray(array);
		
		int pivot = getPivot(array);
	
		System.out.println("\n------------------\n");
	//	int iPos = inPlaceSwap(array, pivot);
	//	System.out.println("\nPivot : " + pivot + " @ " + iPos + "\n");
	//	CommonUtils.printArray(array);
		
		int[] a = qsort(array);
		
		CommonUtils.printArray(a);
	}

	public static int[] qsort( int[] a ) {
		
		if(a.length == 1 || a.length == 0) {
			return a;
		}
		if( a.length == 2) {
			if(a[1] > a[0]) {
				int i = a[0];
				a[0] = a[1];
				a[1] = i;
			}			
			return a;
		}
		
		//if array length >= 3, divide 
		int pivot = getPivot(a);	
		int iPos = inPlaceSwap(a, pivot);
		
		//Sort left side
		int[] left = new int[iPos];
		int[] right = new int[a.length - iPos];
		for( int i = 0; i< iPos; i++) {
			left[i] = a[i];
		}
		for( int i = 0; i< a.length - iPos; i++) {
			right[i] = a[i + iPos];
		}		
		int[] lsorted =  qsort(left);
		int[] rsorted =  qsort(right);
		
		int[] res = new int[a.length];
		
		for( int i = 0; i< a.length; i++) {
			if(i < iPos) {
				res[i] = lsorted[i];
			} else {
				res[i] = rsorted[ i - iPos];
			}
		}		
		return res;
	}
	
	
	
	/*
	 * In place swap to partition the array 
	 */
	public static int inPlaceSwap(int[] a, int pivot) {
		
		int rightPointer = a.length - 1;
		int leftPointer = 0;
		
		while( leftPointer < rightPointer ) {
							
			while(a[leftPointer] > pivot ) {
				leftPointer ++;		
			} 
			while(a[rightPointer] < pivot ) {
				rightPointer --;
			} 
			if(leftPointer < rightPointer) {
				int d = a[leftPointer];
				a[leftPointer] = a[rightPointer];
				a[rightPointer] = d;
				leftPointer ++;
				rightPointer --;
			}
		}		
	
		return leftPointer;
	}
	
	/*
	 * Use 3-point medium to pickup a pivot
	 */
	public static int getPivot(int[] a) {
		
		int i1 = a[0];
		int i2 = a[(int)(a.length / 2)];
		int i3 = a[a.length - 1];
		
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
