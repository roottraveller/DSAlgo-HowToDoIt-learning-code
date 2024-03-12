import java.util.*;
import java.io.*;

/* 
 * author: roottraveller November 2017
 *
 */

class ConditionalPermutationOfIntArr {
	static List<String> alist = new ArrayList<>();
	
	public static void main(String[] args) {
		getAltPermu(new int[]{1,2,3,4,5}, 0, 5);
		
		
	return;
	}
	
	public static void getAltPermu(int[] str, int idx, int length) {
		 if (idx == length-1 || idx > length-1) {
			for(int data : str) 
				System.out.print(data);
				System.out.println();
				return;
		}
		

		
		//swap i to i+1
		swap(str, idx, idx+1, length);
		getAltPermu(str, idx+2, length);
		swap(str, idx, idx+1, length);
		
				//dont swap
		getAltPermu(str, idx+1, length);
	}
	
	public static void swap(int[] str, int i, int j, int length)  {
		if(j > length-1)
			return;
		int ch = str[i];
		str[i] = str[j];
		str[j] = ch;
		return;
	}
}
