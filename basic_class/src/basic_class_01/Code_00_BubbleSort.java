package basic_class_01;

import java.util.Arrays;

public class Code_00_BubbleSort {

	/**
	 * 时间复杂度O(n²) 额外空间复杂度O(1)
	 * 具体描述:
	 * 	1.从数组0位置开始,比较相邻元素,如果后一个元素大于前一个元素,则交换两个元素的位置,直到最后一对元素做完比较.
	 * 	2.针对所有元素重复以上步骤,除了最后一个.
	 *  3.持续的对越来越少的元素进行上面的步骤,直到没有一对元素需要比较.
	 *  助记码:
	 *   i∈[0,N-1)               //循环N-1遍
	 *      j∈[0,N-1-i)          //每遍循环要处理的无序部分
	 *         swap(j,j+1)       //两两排序（升序/降序）    
	 */
	public static void bubbleSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}

		// 外层循环遍历数组中所有元素
		for (int i = arr.length - 1; i > 0; i--) {
			// 比较当前数和当前数+1的数的大小,如果逆序,则交换
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
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

	// for test  拷贝数组
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

	// for test 打印数组
	public static void printArray(int[] arr) {
		if (arr == null)
			return;
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for test
	public static void main(String[] args) {
		int testtime = 1000;
		int maxSize = 100;
		int maxValue = 200;
		boolean success = true;
		for (int i = 0; i < testtime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			comparator(arr1);
			bubbleSort(arr2);

			if (!isEqual(arr1, arr2)) {
				success = false;
				break;
			}
		}
		System.out.println(success ? "Pass" : "Not Pass");
	}
}
