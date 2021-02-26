package lab01;

import java.util.Scanner;

public class TwoDoubles {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		double d1 = keyboard.nextDouble();
		double d2 = keyboard.nextDouble();
		double dsum, ddif, dpro, dquo;
		dsum= d1+d2;
		System.out.println("sum:" + dsum);
		ddif=d1-d2;
		System.out.println("difference:" + ddif);
		dpro=d1*d2;
		System.out.println("product:" + dpro);
		if (d2==0) {
			System.out.println("there is no quotient");
		}
		else {
			dquo=d1/d2;
			System.out.println("quotient:" + dquo);
		}
	}

}
