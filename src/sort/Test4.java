package sort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;


public class Test4 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int length1 = input.nextInt();
		int length2 = input.nextInt();
		int count = 0;
		TreeSet<Integer> treeSet1 = new TreeSet<Integer>();
		TreeSet<Integer> treeSet2 = new TreeSet<Integer>();
		for(int i = 0; i < length1; i++){
			treeSet1.add(input.nextInt());
		}
		for(int i = 0; i < length2; i++){
			treeSet2.add(input.nextInt());
		}
		double middle1 = getMiddle(treeSet1);
		double middle2 = getMiddle(treeSet2);
		if(middle1 < middle2){
			Iterator<Integer> it = treeSet2.iterator();
			while(it.hasNext()){
				int temp = it.next();
				if((double)temp>middle1&&(double)temp<=middle2&&!treeSet1.contains(temp)){
					if(count==0&&(double)temp==middle2){
						break;
					}
					treeSet1.add(temp);
					treeSet2.remove(temp);
					count++;
				}
				if((double)temp>middle2){
					break;
				}
			}
		}else if(middle1 > middle2){
			Iterator<Integer> it = treeSet1.iterator();
			while(it.hasNext()){
				int temp = it.next();
				if((double)temp>middle2&&(double)temp<=middle1&&!treeSet2.contains(temp)){
					if(count==0&&(double)temp==middle1){
						break;
					}
					treeSet2.add(temp);
					treeSet1.remove(temp);
					count++;
				}
				if((double)temp>middle1){
					break;
				}
			}
		}else{
			count = 0;
		}
		input.close();
		System.out.println(count);
	}
	private static double getMiddle(TreeSet<Integer> treeSet) {
		int sum = 0;
		Iterator<Integer> it = treeSet.iterator();
		while(it.hasNext()){
			sum+=it.next();
		}
		return sum/(double)treeSet.size();
	}
}
