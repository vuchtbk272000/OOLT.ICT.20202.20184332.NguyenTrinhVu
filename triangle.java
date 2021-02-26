package lab01;
import java.util.Scanner;

public class triangle {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("input n");
		int n = keyboard.nextInt();
		int i=0,j=0;
		for (i=1;i<=n;i++) {
			for (j=0;j<n-i;j++) {
				System.out.print(" ");
			}
			for (j=0;j< (2* i-1);j++) {
				System.out.print("*");
			}
			System.out.println();
		}		
	}

}
