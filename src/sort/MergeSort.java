package sort;

public class MergeSort {

	public static int[] Mergesort(int[] array) {
		if (array != null && array.length > 0) {
			sort(array, 0, array.length - 1);
		}
		return array;
	}

	private static void sort(int[] array, int start, int end) {
		if (start < end) {
			int middle = 0;
			middle = ((start + end) >> 1);
			sort(array, start, middle);
			sort(array, middle + 1, end);
			merge(array, start, middle, end);
		}
	}

	private static void merge(int[] array, int start, int middle, int end) {
		int[] tempArray = new int[array.length];
		int mid = middle + 1;
		int index = start;
		int temp = start;
		while(start <= middle && mid <= end){
			if(array[start] <= array[mid]){
				tempArray[index++] = array[start++];
			}else{
				tempArray[index++] = array[mid++];
			}
		}
		while(mid <= end){
			tempArray[index++] = array[mid++];
		}
		while(start <= middle){
			tempArray[index++] = array[start++];
		}
		while(temp <= end){
			array[temp] = tempArray[temp++];
		}
	}
}
