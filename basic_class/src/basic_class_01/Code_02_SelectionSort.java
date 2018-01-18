package basic_class_01;

import java.util.Arrays;

/**
 * 选择排序工作原理: 1.在未排序列表中找到最小元素 2.存放在排序列表的起始位置 3.从剩余未排序序列中继续寻找最小元素 4.放在已排序序列的末尾
 * 5.以此类推,直到所有元素均排序完毕
 */
public class Code_02_SelectionSort {
	public static void selectSort(int[] arr) {
		if (arr == null || arr.length < 2)
			return;
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				minIndex = arr[minIndex] < arr[j] ? minIndex : j;
			}
			swap(arr, minIndex, i);
		}
	}

	private static void swap(int[] arr, int minIndex, int i) {
		arr[i] = arr[i] ^ arr[minIndex];
		arr[minIndex] = arr[i] ^ arr[minIndex];
		arr[i] = arr[i] ^ arr[minIndex];
	}

	// for test JDK提供的排序算法
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	// for test 随机生成测试数组
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * maxValue);
		}
		return arr;
	}

	// for test 拷贝数组
	public static int[] copyArray(int[] arr) {
		if (arr == null)
			return null;

		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	// for test 判断两个数组是否相等
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 != null && arr2 == null) || (arr1 == null && arr2 != null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i])
				return false;
		}
		return true;
	}

	// for test  打印数组
	public static void printArray(int[] arr) {
		if (arr == null)
			return;
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int maxSize = 100;
		int maxValue = 100;

		int[] arr = generateRandomArray(maxSize, maxValue);
		int[] arr2 = copyArray(arr);
		printArray(arr);
		selectSort(arr);
		comparator(arr2);

		System.out.println();
		printArray(arr);
		System.out.println();
		printArray(arr2);
		boolean equal = isEqual(arr, arr2);
		System.out.println(equal);
	}
}
