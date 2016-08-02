package com.practice.common;

import org.apache.commons.lang.RandomStringUtils;

public class CommonUtils {

	/*
	 * Create a integer array with random numbers and given size
	 */
	public static int[] getIntegarArray (int size) {
		int[] numbers = new int[size];
		
		for(int i = 0; i<size; i++) {
			numbers[i] = (int)(Math.random() * size * 100);
			//numbers[i] = (int)(Math.random() * size * 1);
		}
		
		return numbers;
	}
	
	
	public static JellyBean[] getJellyBeanArray ( int size) {
		JellyBean[] beans = new JellyBean[size];
		for(int i = 0; i<size; i++) {
			int key = (int)(Math.random() * size * 100);
			beans[i] = new JellyBean(key, RandomStringUtils.randomAscii(key%10)) ;
		}
		
		return beans;
	}
	
	
	public static void printArray(int[] a) {
		System.out.print("\n---------------\n");
		for(int i=0; i < a.length; i++) {
			System.out.print(a[i] + "  ");
		}
		System.out.print("\n---------------\n");
	}
	
	public static void printArray(JellyBean[] a) {
		System.out.print("\n---------------\n");
		for(int i=0; i < a.length; i++) {
			System.out.print(a[i].key + "  ");
		}
		System.out.print("\n---------------\n");
	}
}
