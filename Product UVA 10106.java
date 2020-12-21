
// Problem URL - Product - UVA-10106 : https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1047
// This Problem can also be done using Big Integer

import java.util.Arrays;
import java.util.Scanner;

public class Solve {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//Because in the statement, each input is in the range from 1 to 10^250 (250 digits).
		//For max inputs, x & y will be both 250 digits, and the multiplication would result in 500 digits
		int max = 600;
		
		while(scan.hasNext()) {
			String s = scan.nextLine();
			String t = scan.nextLine();
			char as[] = reverse(s);
			char at[] = reverse(t);
			
			int a[] = new int[max];
			Arrays.fill(a, 0);
			
			
			/*
			75 * 324 = ?
		index   -  3    2    1    0
			
			                 7    5
				              
			            3    2    4
			       -----------------
			      all elements are zeros in start
			              (0)    (0)   		 (0)  		 (0)  
			      indexes (-)   (0+2)		(0+1)  		(0+0)
			              (-)    (0)  		(4*7)  		(4*5) 
			     	      (0)    (0)   		(28)   		(20) 
			      indexes (-)   (1+1)  		(1+0)  		 (-) 
			              (-) (0+(2*7)) 	(28+(2*5)) 	(20)
			              (0)    (14)   	(38)   		(20)
			      indexes (2+1)   (2+0)  	(1+0)  		 (-) 
			             (3*7) (14+(3*5)) 	(38) 		(20)
			             (21)    (29)   	(38)   		(20)
			             
			      final result after first operation (21)   (29)   (38)   (20)
			*/
			
			for(int i=0; i<as.length; i++) {
				for(int j=0; j<at.length; j++) {
					a[i+j] += (as[i] - '0')*(at[j] - '0');
				}
			}
			
			/*
			  Propagating the carry
			  For num = 20
			  num%10 = 0, num/10 = 2 
			  
			  (21)   (29)   (38)   (20)
			  					
			+2=2	 +3=24	  +4=33   +2=40	
			(2)	  	  (4)	   	(3)   	(0)   	(0)
			
			final result  - (2)	  	  (4)	   	(3)   	(0)   	(0)
			 
			 */
			
			for(int i=0; i<max-1; i++) {
				a[i+1] += a[i]/10;
				a[i] %= 10;
			}
			
			
			int i = max-1;
			
			while(i>0 && a[i]==0) {
				i--;
			}
			
			for(; i>=0; i--) {
				System.out.print(a[i]);
			}
			System.out.println();
			
		}
		
		
	}
	
	public static char[] reverse(String s) {
		
		int i = 0;
		int j = s.length()-1;
		
		char arr[] = s.toCharArray();
		
		while(i<=j) {
			char temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			
			i++;
			j--;
		}
		
		return arr;
		
	}

}
