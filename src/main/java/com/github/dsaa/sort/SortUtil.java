package com.github.dsaa.sort;

import com.github.dsaa.sort.heapsort.HeapSort;

public class SortUtil {

	public final static int INSERT = 1;
	public final static int BUBBLE = 2;
	public final static int SELECTION = 3;
	public final static int SHELL = 4;
	public final static int QUICK = 5;
	public final static int IMPROVED_QUICK = 6;
	public final static int MERGE = 7;
	public final static int IMPROVED_MERGE = 8;
	public final static int HEAP = 9;

	public static void sort(int[] data) {
		sort(data, IMPROVED_QUICK);
	}

	private static String[] name = {

	"insert", "bubble", "selection", "shell", "quick", "improved_quick",
			"merge", "improved_merge", "heap"

	};

	private static Sort[] impl = new Sort[]

	{

	// new InsertSort(),
	//
	// new BubbleSort(),
	//
	// new SelectionSort(),
	//
	// new ShellSort(),
	//
	// new QuickSort(),
	//
	// new ImprovedQuickSort(),
	//
	// new MergeSort(),
	//
	// new ImprovedMergeSort(),

	new HeapSort()

	};

	public static String toString(int algorithm) {
		return name[algorithm - 1];
	}

	public static void sort(int[] data, int algorithm) {
		impl[algorithm - 1].sort(data);
	}

	public static void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	public static int[] insertSort(int[] a) {
		int temp;
		for (int i = 1; i < a.length; i++) {
			int j = i - 1;
			temp = a[i];
			for (; j >= 0 && temp < a[j]; j--) {
				a[j + 1] = a[j]; // 将大于temp的值整体后移一个单位
			}
			a[j + 1] = temp;
		}
		return a;
	}

	public class selectSort {
		public selectSort() {
			int a[] = { 1, 54, 6, 3, 78, 34, 12, 45 };
			int position = 0;
			for (int i = 0; i < a.length; i++) {

				int j = i + 1;
				position = i;
				int temp = a[i];
				for (; j < a.length; j++) {
					if (a[j] < temp) {
						temp = a[j];
						position = j;
					}
				}
				a[position] = a[i];
				a[i] = temp;
			}
			for (int i = 0; i < a.length; i++)
				System.out.println(a[i]);
		}
	}

	public class shellSort {
		public shellSort() {
			int a[] = { 1, 54, 6, 3, 78, 34, 12, 45, 56, 100 };
			double d1 = a.length;
			int temp = 0;
			while (true) {
				d1 = Math.ceil(d1 / 2);
				int d = (int) d1;
				for (int x = 0; x < d; x++) {
					for (int i = x + d; i < a.length; i += d) {
						int j = i - d;
						temp = a[i];
						for (; j >= 0 && temp < a[j]; j -= d) {
							a[j + d] = a[j];
						}
						a[j + d] = temp;
					}
				}
				if (d == 1)
					break;
			}
			for (int i = 0; i < a.length; i++)
				System.out.println(a[i]);
		}
	}

	public bubbleSort() {
		int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62,
				99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51 };
		int temp = 0;
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		for (int i = 0; i < a.length; i++)
			System.out.println(a[i]);
	}

	public quickSort() {
		quick(a);
		for (int i = 0; i < a.length; i++)
			System.out.println(a[i]);
	}

	public int getMiddle(int[] list, int low, int high) {
		int tmp = list[low]; // 数组的第一个作为中轴
		while (low < high) {
			while (low < high && list[high] >= tmp) {

				high--;
			}
			list[low] = list[high]; // 比中轴小的记录移到低端
			while (low < high && list[low] <= tmp) {
				low++;
			}
			list[high] = list[low]; // 比中轴大的记录移到高端
		}
		list[low] = tmp; // 中轴记录到尾
		return low; // 返回中轴的位置
	}

	public void _quickSort(int[] list, int low, int high) {
		if (low < high) {
			int middle = getMiddle(list, low, high); // 将list数组进行一分为二
			_quickSort(list, low, middle - 1); // 对低字表进行递归排序
			_quickSort(list, middle + 1, high); // 对高字表进行递归排序
		}
	}

	public void quick(int[] a2) {
		if (a2.length > 0) { // 查看数组是否为空
			_quickSort(a2, 0, a2.length - 1);
		}
	}
}
