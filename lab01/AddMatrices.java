package AddMatrices;
import java.util.Scanner;

public class AddMatrices {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		System.out.println("input n:");
		int n= keyboard.nextInt();
		System.out.println("input m:");
		int m= keyboard.nextInt();
		int[][] iMatrix1 = new int[n][m];
		int[][] iMatrix2 = new int[n][m];
		int[][] iMatrixSum = new int[n][m];
		System.out.println("iMatrix1:");
		for (int i=0;i<n;i++) {
			for (int j=0;j<m;j++) {
				System.out.println("iMatrix1[" + i + "][" + j + "]");
				iMatrix1[i][j]= keyboard.nextInt();
			}
		}
		System.out.println("iMatrix1:");
		for (int i=0;i<n;i++) {
			for (int j=0;j<m;j++) {
				System.out.println("iMatrix2[" + i + "][" + j + "]");
				iMatrix2[i][j]= keyboard.nextInt();
				iMatrixSum[i][j]= iMatrix2[i][j] + iMatrix1[i][j];
			}
		}
		System.out.println("Sum of the given matrices:");
		for (int i=0;i<n;i++) {
			for (int j=0;j<m;j++) {
				System.out.print(iMatrixSum[i][j]);
			}
			System.out.println();
		}
	}

}
