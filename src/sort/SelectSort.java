package sort;
/**
 * @time 18.3.24
 * @author 高位鹏
 * @describe 直接选择排序简写与优化  时间复杂度O(n^2)  不稳定
 */
public class SelectSort {
    /*
     * 直接选择排序简写
     */
//	public void getSelectSort(int[] array) {
//		for(int i = 0; i < array.length-1; i++){
//			int max = array[i];
//			for(int j = i+1; j < array.length; j++){
//				if(max < array[j]){
//					swap(array, i, j);
//				}
//			}
//		}
//	}
//	private void swap(int[] array, int x, int y) {
//		int temp = array[x];
//		array[x] = array[y];
//		array[y] = temp;
//	}
	/*
	 * 直接选择排序优化
	 */
	public void getSelectSort(int[] array) {
		for(int i = 0; i < array.length-1; i++){
			int max = array[i], index = i;
			for(int j = i+1; j < array.length; j++){
				if(max < array[j]){
					index = j;
					max = array[j];
				}
			}
			if(index != i){
				array[index] = array[i];
				array[i] = max;
			}
		}
	}
}
