package sort;
/**
 * @time 18.03.21
 * @author 高伟鹏
 * @describe 快速排序的优化算法；属于交换排序，不稳定，时间空间复杂度都是O（nlogn）;
 */
public class QuickSort {
    /*
     * 正常快排
     */
//	public void getQuickSort(int[] array){
//	    if(array.length>0){
//	    	getSort(array, 0, array.length-1);
//	    }
//	}
//
//	private void getSort(int[] array, int start, int end) {
//		if(start<end){
//			int middle = getMiddle(array, start, end);
//			getSort(array, start, middle-1);
//			getSort(array, middle+1, end);
//		}
//	}
//
//	private int getMiddle(int[] array, int start, int end) {
//		int target = array[start];
//		while(start<end){
//			while(start<end&&array[end]>target){
//				end--;
//			}
//			array[start] = array[end];
//			while(start<end&&array[start]<target){
//				start++;
//			}
//			array[end] = array[start];
//		}
//		array[start] = target;
//		return start;
//	}
	
	
	
	/*
	 * 快排的优化算法（只优化了选择基准，相同元素去重。
	 * 没有优化小数组时的排序方案（感觉这个优化就不是快排了），没有优化递归操作（优化递归操作比不优化递归操作在大量数据处理下要慢））
	 */
	public void getQuickSort(int[] array){
		if(array!=null&&array.length>0){
			getSort(array, 0, array.length-1);
		}
	}
	
    private void getSort(int[] array, int start, int end) {
		if(start<end){
			/*
			 * target是通过三数取中法选出的基准；first记录开始位置,last记录结束位置
			 * leftLength记录左边与基准元素相同元素的个数，RightLength记录右边与基准元素相同元素的个数；
			 * left下标表示的数会与 和基准元素相同的数进行交换，使它的位置的数与基准元素相等，然后+1，准备接收下一个与基准元素相同的数；right记录右边相同的
			 */
			int target = getTarget(array, start, end), first = start, last = end;
			int leftLength = 0, rightLength = 0, left = start, right = end;
			while(start<end){
				while(start<end&&array[end]>=target){//右边的数大于基准元素不发生交换，下标递减，直至找到小于基准的数
					if(array[end] == target){//如果和基准元素相同，则将该数与right指定位置的数进行交换，交换完成之后，right左移，长度加1
						swap(array, end, right);
						right--;
						rightLength++;
					}
					end--;
				}
				array[start] = array[end];//找到小于基准元素的数，将他放入基准元素的位置（此时基准元素没有放入数组，该end位置为空，你也可以认为他们两个进行了交换）
				while(start<end&&array[start]<=target){//左边的数小于基准元素不发生交换，下标递减，直至找到大于基准的数
					if(array[start] == target){//如果和基准元素相同，咋发生交换
						swap(array, start, left);
						left++;
						leftLength++;
					}
					start++;
				}
				array[end] = array[start];//找到大于基准元素的位置，将他放入空位置
			}
			array[end] = target;//最后end==start，他们指向的位置为空位置，将基准元素放入
			int i = first, j = end-1; 
			while(i<left && array[j]!=array[end]){//将基准元素左面与他相同的数放到他的旁边
				swap(array, i, j);
				i++;
				j--;
			}
			i = last; j = end+1;
			while(i>right && array[j]!=array[end]){//将基准元素右面与他相同的数放到他的右面
				swap(array, i, j);
				i--;
				j++;
			}
			getSort(array, start, end-leftLength-1);//递归时，将与基准元素相同的数据下标移除，不参与下一次递归
			getSort(array, end+rightLength+1, last);
		}
	}

	private int getTarget(int[] array, int start, int end){//三数取中法来选择基数，就是将中位数放到第一个位置
		int middle = start + (int)((end - start)/2);
		/*
		 * 通过三次交换，保证第一个数大于中间的数，小于右边的数
		 */
		if(array[start]>array[end]){
			swap(array, start, end);
		}
		if(array[middle]>array[end]){
			swap(array, middle, end);
		}
		if(array[start]<array[middle]){
			swap(array, start, middle);
		}
		return array[start];
	}
	
	/*
	 * 将数组中指定的两个元素进行交换
	 */
    private void swap(int[] array, int start, int end){
    	int temp = array[start];
    	array[start] = array[end];
    	array[end] = temp;
    }
}
