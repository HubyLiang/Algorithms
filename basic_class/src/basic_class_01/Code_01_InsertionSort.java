package basic_class_01;

import java.util.Arrays;

public class Code_01_InsertionSort {

	/**
	 * 平均时间复杂度O(n²) 额外空间复杂度O(1) 具体描述: 1.从第一个元素开始,该元素被认为已被排序
	 * 2.取出下一个元素,在已经排序的元素序列中从后向前扫描 3.如果该元素(已排序)大于新元素,指针向前移动一位
	 * 4.重复步骤3,直到找到已排序元素小于等于新元素的位置 5.将新元素插入到该位置 6.重复步骤2~5
	 * 
	 */
	public static void insertionSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
				swap(arr, j, j + 1);
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
	}

	// for test
	public static int[] generatorRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[maxSize];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// for test
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	// for test
	private static boolean isEquals(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null))
			return false;

		if (arr1.length != arr2.length)
			return false;

		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	// for test
	private static int[] copy(int[] arr1) {
		int[] arr2 = new int[arr1.length];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = arr1[i];
		}
		return arr2;
	}

	// for test
	public static void main(String[] args) {
		int testtime = 100;
		int maxSize = 100;
		int maxValue = 100;
		boolean flag = true;

		int[] arr1 = generatorRandomArray(maxSize, maxValue);
		int[] arr2 = copy(arr1);

		for (int i = 0; i < testtime; i++) {
			insertionSort(arr1);
			comparator(arr2);

			if (!isEquals(arr1, arr2)) {
				flag = false;
				break;
			}
		}
		System.out.println(flag);
	}
}
