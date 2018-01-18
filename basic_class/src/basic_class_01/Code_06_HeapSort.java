package basic_class_01;

public class Code_06_HeapSort {
	public static void heapSort(int[] arr) {
		if (arr == null || arr.length < 2)
			return;
		for (int i = 0; i < arr.length; i++) {
			heapInsert(arr, i);
		}
		int size = arr.length;
		swap(arr, 0, --size);
		while (size > 0) {
			heapify(arr, 0, size);
			swap(arr, 0, --size);
		}
	}

	private static void heapInsert(int[] arr, int index) {
		while (arr[index] > arr[(index - 1) / 2]) {
			swap(arr, index, (index - 1) / 2);
			index = (index - 1) / 2;
		}
	}

	private static void heapify(int[] arr, int index, int size) {
		int left = index * 2 + 1;
		while (left < size) {
			int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
			largest = arr[largest] > arr[index] ? largest : index;
			if (largest == index) {
				break;
			}
			swap(arr, largest, index);
			index = largest;
			left = index * 2 + 1;
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// for test 
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[maxValue];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * maxValue);
		}
		return arr;
	}

	// for test
	public static int[] copy(int[] arr) {
		int[] arr2 = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			arr2[i] = arr[i];
		}
		return arr2;
	}

	// for test
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if (arr1 == null && arr2 != null) {
			return false;
		}
		if (arr1 != null && arr2 == null) {
			return false;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	// for test
	public static void main(String[] args) {
		int testtime = 1000;
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
		System.out.println(flag?"pass":"not pass");
	}

}
