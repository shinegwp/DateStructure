package sort;

import java.util.Arrays;

import java.util.Scanner;


public class Test1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int length = 0;
		byte target = 0;
		length = in.nextInt();
		target = in.nextByte();
		int[] arr = new int[length];
		int count=0;
		for(int i = 0; i<length; i++){
			arr[i] = in.nextInt();
		}
		Arrays.sort(arr);
		int begin = 0;
		while(begin<arr.length-1){
			for(int i = begin+1; i<arr.length; i++){
				if(Math.abs(arr[begin]-arr[i])==target){
					count++;
					break;
				}else if(Math.abs(arr[begin]-arr[i])>target){
					break;
				}	
			}
			while(arr[begin]==arr[begin+1]){
				begin++;
			}
			begin++;
		}
		in.close();
		System.out.println(count);
	}
}
