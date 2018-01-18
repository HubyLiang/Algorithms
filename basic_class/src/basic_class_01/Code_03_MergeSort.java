package basic_class_01;

import java.util.Arrays;

/**
 * 采用分治法的典型应用 递归法: 1.将序列每相邻两个数字做归并操作,形成ceil(n/2)个序列,排序后每个序列包含两/一个元素
 * 2.若此时序列数不是1个则继续归并,形成ceil(n/4)个序列,每个序列包含四/三个元素 3.重复步骤2，直到所有元素排序完毕，即序列数为1
 */
public class Code_03_MergeSort {

	public static void mergeSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		mergeSort(arr, 0, arr.length - 1);
	}

	private static void mergeSort(int[] arr, int l, int r) {
		if (l == r) {
			return;
		}
		int mid = l + ((r - l) >> 1);
		mergeSort(arr, l, mid);
		mergeSort(arr, mid + 1, r);
		merge(arr, l, mid, r);
	}

	private static void merge(int[] arr, int l, int mid, int r) {
		int[] help = new int[r - l + 1];
		int i = 0;
		int p1 = l;
		int p2 = mid + 1;

		while (p1 <= mid && p2 <= r) {
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}

		// 只会进入一个while循环
		while (p1 <= mid) {
			help[i++] = arr[p1++];
		}
		while (p2 <= r) {
			help[i++] = arr[p2++];
		}

		for (i = 0; i < help.length; i++) {
			arr[i + l] = help[i];
		}
	}

	// for test
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[maxSize];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) Math.random() * (maxValue + 1) - (int) Math.random() * maxValue;
		}
		return arr;
	}

	// for test
	public static int[] copy(int[] arr1) {
		int[] arr2 = new int[arr1.length];
		for (int i = 0; i < arr1.length; i++) {
			arr2[i] = arr1[i];
		}
		return arr2;
	}

	// for  test
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if (arr1 == null && arr2 != null)
			return false;
		if (arr2 == null && arr1 != null)
			return false;
		if (arr1.length != arr2.length)
			return false;
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i])
				return false;
		}
		return true;
	}

	// for test
	public static void main(String[] args) {
		int maxSize = 10;
		int maxValue = 1000;
		int testtimes = 1;
		boolean flag = true;

		for (int i = 0; i < testtimes; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copy(arr1);
			mergeSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2))
				flag = false;
		}
		System.out.println(flag);
	}
}
