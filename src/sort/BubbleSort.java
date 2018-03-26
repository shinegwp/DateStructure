package sort;
/**
 * @time 18.3.21
 * @author 高位鹏
 * @describe 冒泡排序的复习与优化
 */
/*
 * 基本冒泡排序  O（n^2）  稳定  属于交换排序的一种
 */
public class BubbleSort {
	public void getBubbleSort1(int[] array){
		for(int i = 0; i<array.length-1; i++){
			int temp = 0;
			for(int j = 0; j<array.length-1-i; j++){
				if(array[j]>array[j+1]){//将大的元素放在末尾
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}
	/*
	 * 冒泡排序的优化
	 */
	public void getBubbleSort2(int[] array){
		int index = array.length-1;//第二次循环要比较到的位置
		int pos = 0, flag = 0, temp = 0;//pos记录最后一次比较的位置，flag记录本次循环是否发生了交换
		for(int i=0; i<array.length-1; i++){
			flag = 0;
			for(int j=0; j<index; j++){
				if(array[j]>array[j+1]){
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					flag=1;//发生交换，flag=1；
					pos = j;//记录最后一次发生比较时的小标位置
				}
			}
			index = pos;//将上次循环最后一次比较的位置复制给本次循环的结束点
			if(flag==0){//如果上次循环没有发生交换，说明数组已经排序好，退出程序
				return;
			}
		}
	}
}
