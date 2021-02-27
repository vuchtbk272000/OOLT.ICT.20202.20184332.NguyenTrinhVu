package SortArray;
import java.util.Scanner;

public class SortArray {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("input n:");
		int n= keyboard.nextInt();
		int[] iArr= new int[n];
		for(int i=0;i<n;i++) {
			System.out.println("iArr["+ i + "]");
			iArr[i] = keyboard.nextInt();
		}
		for (int i=0;i<n;i++) {
			for (int j=i;j<n;j++) {
				if (iArr[j]<iArr[i]) {
					int tmp= iArr[i];
					iArr[i]=iArr[j];
					iArr[j]=tmp;
				}					
			}
		}
		for(int i=0;i<n;i++) {
			System.out.print(iArr[i]);
		}
	}
}
