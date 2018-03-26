package sort;
/**
 * @time 18.03.22
 * @author 高伟鹏
 * @describe 直接插入排序的复习与优化  时间复杂度O（n^2）  稳定 
 */
public class InsertionSort {
    /*
     * 最直接的插入排序，暴力求解
     */
//	public void getInsertionSort(int[] array){
//		if(array!=null&&array.length>1){
//			for(int i = 1; i < array.length; i++){
//				for(int j = i; j > 0; j--){
//					if(array[j]<array[j-1]){
//						swap(array, j, j-1);
//					}
//				}
//			}
//		}
//	}
//	public void swap(int[] array, int a, int b){
//		int temp = array[a];
//		array[a] = array[b];
//		array[b] = temp;
//	}
	/*
	 * 优化1,减少不必要的交换
	 */
//	public void getInsertionSort(int[] array){
//		if(array!=null&&array.length>1){
//			for(int i = 1; i < array.length; i++){
//				int temp = array[i], j = i;
//				for(j = i; j>0&&temp<array[j-1]; j--){
//					array[j] = array[j-1];
//				}
//				array[j] = temp;
//			}
//		}
//	}
	/*
	 * 优化2，使用二分查找定位插入位置
	 */
	public void getInsertionSort(int[] array){
		if(array!=null&&array.length>1){
			for(int i = 1; i<array.length; i++){
				int index = getBinarySearch(array, i-1, array[i]);//寻找需要进行插入的位置
				for(int j = i; j>index; j--){//直接循环定位到该位置
					array[j-1] = array[j];
				}
				array[index] = array[i];
			}
		}
	}
	/*
	 * 类似于二分查找方法
	 */
	public int getBinarySearch(int[] array, int last, int target){
		int start = 0, end = last, middle = 0;
		while(start <= end){
			middle = (start+end)/2;
			if(array[middle]>target){
				end = middle - 1;
			}else{
				start = middle + 1;
			}
		}
		return start;//最后一次是循环start与end是相等的，即若array【middle】>target,应插入start位置，array【middle】<=target，也应该在start位置
	}
}
