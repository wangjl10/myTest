package com.ai.test.sort;

import java.util.Arrays;




public class CopyOfHeapSort {
	
	public static void main(String[] args) {
		int[] data = { 1, 3, 4, 5, 2, 6, 9, 7, 8, 0 };
		heapSort(data);
		System.out.println(Arrays.toString(data));
	}
	
	
	public static void heapSort(int[] data) {
		
		for (int i = data.length; i > 0; i--) {
			maxHeap(data, i);
			int temp = data[0];
			data[0] = data[i-1];
			data[i-1] = temp;
		}
	}
	
	public static void  maxHeap(int[] data,int limit) {
		if (data.length <= 0 || data.length < limit) {
			return;
		}
		int parent = limit / 2;
		for( ;parent >= 0; parent--){
			if (parent * 2 >= limit) {
				continue;
			}
			int left = parent * 2;
			int right = (left + 1) >= limit ? left : (left + 1);
			int maxChild = data[left] >= data[right] ? left : right;
			if (data[maxChild] > data[parent]) {
				int tmp = data[maxChild];
				data[maxChild] = data[parent];
				data[parent] = tmp;
			}
		}
	}
	
	
}