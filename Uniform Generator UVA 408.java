


import java.util.Arrays;
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		while(scan.hasNext()) {
			int step = scan.nextInt();
			int mod = scan.nextInt();
			
			int index = 0;
			boolean bad = false;
			
			String result = "Good Choice";
			
			int arr[] = new int[mod];
			Arrays.fill(arr, 0);
			
			for(int i=0; i<mod; i++) {
				int gen = (index+step)%mod;
				
				if(arr[gen]==1) {
					bad = true;
					break;
				}
				
				arr[gen] = 1;
				
				index = gen;
			}
			
			if(bad) {
				result = "Bad Choice";
			}
			
			
			System.out.printf("%10d%10d    %s%n",step,mod,result);
			System.out.println();
					
		}
		
	}
	

}
