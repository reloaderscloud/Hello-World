package com.practice.datastructure;

import com.practice.common.CommonUtils;

public class Triplets {
	
	public static void main(String[] args) {
		
		int[] array = CommonUtils.getIntegarArray(50);
		CommonUtils.printArray(array);
		for(int i=0; i< array.length; i++) {
			for(int j=i+1; j< array.length; j++) {
				for(int k=j+1; k<array.length; k++) {
					if(array[i]==array[j] && array[i] == array[k]) {
						System.out.println("Hit! " + array[k]);
						return;
					}
				}
			}
		}
		System.out.println("No Hit!");
	}

}
