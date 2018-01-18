package basic_class_01;

import java.util.Arrays;

public class Code_04_QuickSort {

	public static void quickSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		quickSort(arr, 0, arr.length - 1);
	}

	private static void quickSort(int[] arr, int l, int r) {
		if (l < r) {
			swap(arr, (int) (Math.random() * (r - l + 1)), r);
			int[] p = partition(arr, l, r);
			quickSort(arr, l, p[0] - 1);
			quickSort(arr, p[1] + 1, r);
		}
	}

	private static int[] partition(int[] arr, int l, int r) {
		int less = l - 1;
		int more = r;
		while (l < more) {
			if (arr[l] < arr[r]) {
				//如果当前数小于基准数,交换"小于区"后一个数和当前数,"小于区"范围扩大1,当前数位置+1
				swap(arr, ++less, l++);
			} else if (arr[r] < arr[l]) {
				//如果当前数大于基准数,交换"大于区"前一个数和当前数,"大于区"范围扩大1,当前数位置不变
				swap(arr, l, --more);
			} else {
				//如果当前数等于基准数,当前数位置+1
				l++;
			}
		}
		swap(arr, r, more);
		return new int[] { less + 1, more };
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// for test
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	// for test 
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[maxSize];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * maxValue);
		}
		return arr;
	}

	// for test
	public static int[] copy(int[] arr1) {
		int[] arr2 = new int[arr1.length];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = arr1[i];
		}
		return arr2;
	}

	// for test
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if (arr1 == null && arr2 != null)
			return false;
		if (arr2 == null && arr1 != null)
			return false;
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	// for test
	public static void main(String[] args) {
		int testtime = 100;
		int maxValue = 1000;
		int maxSize = 1000;
		boolean flag = true;

		for (int i = 0; i < testtime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copy(arr1);
			if (!isEqual(arr1, arr2)) {
				flag = false;
				break;
			}
		}
		System.out.println(flag);
	}

}
