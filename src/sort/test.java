package sort;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入数组长度：");
		while(sc.hasNextInt()){
			int length = sc.nextInt();
			int[] array = new int[length];
			for(int i = 0; i<length; i++){
				array[i] = (int)(Math.random()*200+1);
			}
			System.out.println("随机生成的数组如下：");
			for(int i: array){
				System.out.print(i+" ");
			}
			new HeapSort().getHeapSort(array);//只修改这里
			System.out.println("");
			System.out.println("排好序的数组如下：");
			for(int i: array){
				System.out.print(i+" ");
			}
			System.out.println("");
			System.out.print("请将箭头移到这里输入数组长度：");
		}
		sc.close();
	}
}
