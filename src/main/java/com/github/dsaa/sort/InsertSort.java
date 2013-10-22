package com.github.dsaa.sort;

public class InsertSort implements Sort {

	@Override
	public int[] sort(int[] a) {
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
}
