package sort;
/**
 * @time 18.3.24
 * @author 高位鹏
 * @describe 堆排序的简写与优化
 */
public class HeapSort {

	public void getHeapSort(int[] array) {
		// TODO Auto-generated method stub
        getBigHeap(array, array.length);
        getBigHeapSort(array);
	}

	private void getBigHeapSort(int[] array) {
		// TODO Auto-generated method stub
		int end = array.length-1;
		for(int i = 0; i < end; i++){
			swap(array, i, end);
			getBigHeap(array, end);
			end--;
		}
	}

	private void getBigHeap(int[] array, int length) {
		// TODO Auto-generated method stub
		for(int i = (length-2)/2; i >= 0; i--){
			if(array[i] < array[i*2+1] || ((2*i+2) < length && array[i] < array[2*i+2])){
				if((2*i+2) < length){
					if(array[i*2+1] < array[2*i+2]){
						swap(array, 2*i+2, i);
					}else{
						swap(array, 2*i+1, i);
					}
				}else{
					swap(array, i, i*2+1);
				}
			}
		}
	}
	private void swap(int[] array, int x, int y) {
		// TODO Auto-generated method stub
        int temp = 0;
        temp = array[x];
        array[x] = array[y];
        array[y] = temp;
	}
}
