package com.ai.test.sort;

import java.util.Arrays;

public class SortTest {

	/**
	 * 快速排序
	 * @param data
	 * @param start
	 * @param end
	 */
	public static void quickSort(int[] data, int start, int end) {
		int key = data[start];

		int i = start;
		int j = end;

		while (i < j) {
			while (key < data[j] && i < j) {
				j--;
			}
			data[i] = data[j];

			while (data[i] < key && i < j) {
				i++;
			}
			data[j] = data[i];
		}

		data[i] = key;
		// 递归调用
		if (start < i - 1) {
			// 递归调用，把key前面的完成排序
			quickSort(data, start, i - 1);
		}
		if (i + 1 < end) {
			// 递归调用，把key后面的完成排序
			quickSort(data, i + 1, end);
		}

	}
	
	
	/**
	 * 冒泡法
	 * @param data
	 */
	public static void bubbleSort(int[] data) {
		int length = data.length;
		for (int i = 0; i < length -1; i++) {
			for (int j = 0; j < length - i -1; j++) {
				if (data[j] > data[j+1]) {
					int temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
				}
			}
		}
	}
	
	
	/**
	 * 归并排序
	 * @param data
	 */
	public static int[] mergeSort(int[] data,int low,int high) {
		
		int mid = (low + high)/2;
		if (low < high) {
			mergeSort(data, low, mid);
			mergeSort(data, mid + 1, high);
			merge(data,low,mid,high);
		}
		return data;
	}
	
	

	private static void merge(int[] data,int low,int mid,int high) {
		
		int[] temp = new int[high-low+1];
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
		
		//剩余的未比较的并入
		while (i <= mid) {
			temp[k++] = data[i++];
		}
		
		//剩余的未比较的并入
		while (j <= high) {
			temp[k++] = data[j++];
		}
		
		for (int t = 0;t < temp.length ;t++) {
			data[t + low] = temp[t];
		}
	}
	
	
	//选择排序
	public static void  selectSort(int[] data) {
		for (int i = 0; i < data.length -1; i++) {
			int k = i;
			for (int j = k + 1; j < data.length; j++) {
				if (data[j] < data[k]) {
					k = j;
				}
			}
			if ( k != i) {
				int temp = data[i];
				data[i] = data[k];
				data[k] = temp;
			}
		}
	}
	
	

	/**
	 * 
	 * @param data
	 */
	public static void insertSort(int[] data) {
		int i,j;
		int n = data.length;
		int target;
		
		for (i = 1; i < n; i++) {
			j = i;
			target = data[i];
			while (j > 0 && target < data[j -1]) {
				data[j] = data[j-1];
				j--;
			}
			target = data[j];
		}
	}
	
	/**
	 * 希尔排序
	 * @param data
	 */
	public static void shellSort(int[] data) {
		int j = 0;
		int temp = 0;
		
		for (int increament = data.length / 2 ; increament > 0; increament /= 2) {
			for(int i = increament ; i < data.length ; i++){
				temp = data[i];
				for(j = i; j >= increament ;j -= increament){
					if (temp < data[j - increament]) {
						data[j] = data[j - increament];
					}else {
						break;
					}
				}
				data[j] = temp;
			}
		}
		
	}

	public static void swap(int[] data, int i, int j) {  
        if (i == j) {  
            return;  
        }  
        data[i] = data[i] + data[j];  
        data[j] = data[i] - data[j];  
        data[i] = data[i] - data[j];  
    }  
  
	/**
	 * 堆排序
	 * @param data
	 */
    public static void heapSort(int[] data) {  
        for (int i = 0; i < data.length; i++) {  
            createMaxdHeap(data, data.length - 1 - i);  
            swap(data, 0, data.length - 1 - i);  
            print(data);  
        }  
    }  
  
    public static void createMaxdHeap(int[] data, int lastIndex) {  
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {  
            // 保存当前正在判断的节点  
            int k = i;  
            // 若当前节点的子节点存在  
            while (2 * k + 1 <= lastIndex) {  
                // biggerIndex总是记录较大节点的值,先赋值为当前判断节点的左子节点  
                int biggerIndex = 2 * k + 1;  
                if (biggerIndex < lastIndex) {  
                    // 若右子节点存在，否则此时biggerIndex应该等于 lastIndex  
                    if (data[biggerIndex] < data[biggerIndex + 1]) {  
                        // 若右子节点值比左子节点值大，则biggerIndex记录的是右子节点的值  
                        biggerIndex++;  
                    }  
                }  
                if (data[k] < data[biggerIndex]) {  
                    // 若当前节点值比子节点最大值小，则交换2者得值，交换后将biggerIndex值赋值给k  
                    swap(data, k, biggerIndex);  
                    k = biggerIndex;  
                } else {  
                    break;  
                }  
            }  
        }  
    }  
  
    public static void print(int[] data) {  
        for (int i = 0; i < data.length; i++) {  
            System.out.print(data[i] + "\t");  
        }  
        System.out.println();  
    }  

    
	public static void main(String[] args) {
		
		int[] data = { 34, 21, 54, 18, 23, 76, 38, 98 };
//		quickSort(data, 0, data.length - 1);
//		mergeSort(data, 0, data.length-1);
//		selectSort(data);
		
//		insertSort(data);
		//shellSort(data);
		heapSort(data);
		
		System.out.println(Arrays.toString(data));
	}

}
