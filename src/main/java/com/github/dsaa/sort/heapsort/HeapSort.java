package com.github.dsaa.sort.heapsort;

import com.github.dsaa.sort.Sort;
import com.github.dsaa.sort.SortUtil;

/**
 * 堆排序.
 * @author hadoopor@yahoo.com
 */
// TODO: 1. 根据条件建立大/小堆 2. 简化代码
public class HeapSort implements Sort {

	private static int parentIdx(int childIdx) {
		return (childIdx - 1) / 2; // 索引从0开始, 注意childIdx=0时返回0
	}

	private static int leftChildIdx(int parentIdx) {
		return parentIdx * 2 + 1;
	}

	/**
	 * 构建大顶堆.
	 * @author hadoopor@yahoo.com
	 */
	private static void buildMaxHeap(int[] datas) {
		int lastIdx = datas.length - 1;
		for (int i = parentIdx(lastIdx); i >= 0; i--) {
			int k = i;
			while (leftChildIdx(k) <= lastIdx) {
				int j = leftChildIdx(k);
				if (j < lastIdx) { // 有两个孩子
					if (datas[j] <= datas[j + 1]) { // j+1 比较大, 选择大的
						j++;
					}
				}

				if (datas[k] > datas[j]) { 
					// 父的比较大
					break;
				} else {
					SortUtil.swap(datas, k, j);
					k = j;
				}
			}
		}
	}

	/**
	 * 堆顶改变, 要维护大顶堆.
	 * @author hadoopor@yahoo.com
	 */
	private static void maintainMaxHeap(int[] datas, int lastIdx) {
		int k = 0;
		while (k <= parentIdx(lastIdx)) {
			int j = leftChildIdx(k);
			if (j < lastIdx) { // 有两个孩子
				if (datas[j] <= datas[j + 1]) { // j+1 比较大, 选择大的
					j++;
				}
			}
			if (datas[k] < datas[j]) { // 父结点比较小
				SortUtil.swap(datas, k, j);
				k = j;
			} else {
				break;
			}
		}
	}

	@Override
	public int[] sort(int[] datas) {
		buildMaxHeap(datas);
		//此时，堆顶（即datas[0]）是数组的最大值
		int lastIdx = datas.length - 1;
		while (lastIdx > 0) {
			//将最大值与最后一个值互换
			SortUtil.swap(datas, 0, lastIdx);
			lastIdx--;
			if (lastIdx > 0) {
				//对除了最末数值外的其它数值重新建堆
				maintainMaxHeap(datas, lastIdx);
				//此时，堆顶又成是最大值了，进行下一轮循环
			}
		}
		return datas;
	}
}