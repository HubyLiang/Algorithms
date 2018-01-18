package basic_class_01;

/**
 * 求小和问题: 例如 { 4, 1, 3, 5, 0, 6 } 的小和是 22
 */
public class Code_05_SmallSum {

	public static int getSmallSum(int[] arr) {
		if (arr == null || arr.length < 2)
			return 0;
		return mergeSort(arr, 0, arr.length - 1);
	}

	private static int mergeSort(int[] arr, int l, int r) {
		if (l == r)
			return 0;
		int mid = l + ((r - l) >> 1);
		return mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r) + merge(arr, l, mid, r);

	}

	private static int merge(int[] arr, int l, int mid, int r) {
		int[] help = new int[r - l + 1];
		int p1 = l;
		int p2 = mid + 1;
		int i = 0;
		int res = 0;

		while (p1 <= mid && p2 <= r) {
			// 如果左边的数比右边的数小,则累加小和 
			res += arr[p1] < arr[p2] ? arr[p1] * (r - p2 + 1) : 0;
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		while (p1 <= mid) {
			help[i++] = arr[p1++];
		}
		while (p2 <= r) {
			help[i++] = arr[p2++];
		}

		for (i = 0; i < help.length; i++) {
			arr[l + i] = help[i];
		}

		return res;
	}

	// 暴力方法写的对数器
	public static int comparator(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] < arr[i])
					sum += arr[j];
			}
		}
		return sum;
	}

	// for test 随机生成测试数组
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * maxValue);
		}
		return arr;
	}

	// for test
	public static int[] copy(int[] arr) {
		int[] arr2 = new int[arr.length];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = arr[i];
		}
		return arr2;
	}

	public static void main(String[] args) {
		int testtime = 100;
		boolean flag = true;
		for (int i = 0; i < testtime; i++) {
			int[] arr1 = generateRandomArray(100, 1000);
			int[] arr2 = copy(arr1);
			int smallSum = getSmallSum(arr1);
			int comparator = comparator(arr2);
			if (smallSum != comparator) {
				flag = false;
				break;
			}
		}
		System.out.println(flag);

	}

}
