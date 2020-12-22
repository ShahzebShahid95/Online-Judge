
// Problem URL - Black and White Painting - UVA-11231 : https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=2172

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n , m , c;
		
		while((n=scan.nextInt())!=0 && (m=scan.nextInt())!=0) {
			c = scan.nextInt();
			int rem = c==1 ? 1 : 0;
			System.out.println(((n-7)*(m-7)+rem)/2);
		}
		
	}
	

}
