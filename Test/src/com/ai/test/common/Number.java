package com.ai.test.common;

public class Number {

	
	public static int  GongBei(int a,int b) {
		return a*b/GongYue(a, b);
	}
	
		
	public static int GongYue(int a ,int b){
		int gongyueshu = 1;
		
		if (a < b) {
			a = a + b;
			b = a - b;
			a = a - b;
		}
		
		if (a % b == 0) {
			gongyueshu = b;
		}
		
		while ( a % b > 0) {
			a = a % b;
			if (a < b) {
				a = a + b;
				b = a - b;
				a = a - b;
			}
			
			if (a % b == 0) {
				gongyueshu = b;
			}
		}
		return gongyueshu;
	}
	
	public static void mergeSort(int[] data,int low,int high){
		int mid = (low + high)/2;
		if (low < high) {
			mergeSort(data, low, mid);
			mergeSort(data, mid + 1, high);
			merge(data, low, mid, high);
		}
	}
	
	
	public static void merge(int[] data, int low,int mid,int high) {
		
		int[] temp = new int[high - low + 1];
		int i = low;
		int j = mid + 1;
		int k = 0;
		
		while (i <= mid && j <= high) {
			if (data[i] < data[j]) {
				temp[k++] = data[i++];
			}else {
				temp[k++] = data[j++];
			}
		}
		
		while (i <= mid) {
			temp[k++] = data[i++];
		}
		
		while (j <= high) {
			temp[k++] = data[j++];
		}
		
		for (int l = 0; l < temp.length; l++) {
			data[l + low] = temp[l];
		}
		
	}
	
	
	
	public static void quickSort (int[] data,int start,int end){
		
		int key = data[start];
		
		int i = start;
		int j = end;
		
		while (i < j) {
			while (key < data[j]) {
				j--;
			}
			data[i] = data[j];
			
			while (key > data[i]) {
				i++;
			}
			data[j] = data[i];
		}
		
		data[i] = key;
		
		if (start < i - 1) {
			quickSort(data, start, i - 1);
		}
		
		if (i + 1 < end) {
			quickSort(data, i + 1, end);
		}
		
	}
	
	public static void  bubbleSort(int[] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length - i - 1; j++) {
				if (data[j] < data[j + 1]) {
					int temp = data[j];
					data[j] = data[j + 1];
					data[j+1] = temp;
				}
			}
		}
	}
	
	
	public static void insertSort(int[] data) {
		int i,j;
		int n = data.length;
		
		for (i = 0 ;i < n; i++) {
			int target = data[i];
			j = i;
			
			while (j > 0 && target < data[j - 1]) {
				data[j] = data[j-1];
				j--;
			}
			
			target = data[j];
			
		}
		
	}
	
	
	
	public static void  selectSort(int[] data) {
		
		for (int i = 0; i < data.length; i++) {
			int k = i;
			
			for (int j = k + 1; j < data.length; j++) {
				if (data[j] < data[k]) {
					k = j;
				}
			}
			
			if (k != i) {
				int temp = data[k];
				data[k] = data[i];
				data[i] = temp;
			}
			
		}
		
	}
	
	
	
}
