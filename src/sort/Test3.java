package sort;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	    int length = 0;
	    length = input.nextInt();
	    String[] array = new String[length];
	    for(int i = 0; i < length; i++){
	    	array[i] = input.nextLine();
	    }
	    int index = 0;
	    while(index < length){
	    	char[] arr = array[index].toCharArray();
	    	
	    }
	    
		input.close();
	}
}
