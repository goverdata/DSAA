package com.github.dsaa.sort;

import java.util.Arrays;

import com.github.dsaa.sort.heapsort.HeapSort;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] datas = { 5, 1, 3, 4, 9, 2, 7, 6, 5 };
		// {2, 9, 3, 7, 8, 6, 4, 5, 0, 1};
		HeapSort sorter = new HeapSort();
		datas = sorter.sort(datas);
		System.out.println(Arrays.toString(datas));

		// datas = SortUtil.randomDates(10);
		// datas = sorter.sort(datas);
		// System.out.println(Arrays.toString(datas));
	}
}
