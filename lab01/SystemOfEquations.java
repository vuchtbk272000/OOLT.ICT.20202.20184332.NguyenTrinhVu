package lab01;

import java.util.Scanner;
import java.lang.Math;
public class SystemOfEquations {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("1. SystemOfEquation/ 2. SecondDegreeEquation");
		int x = keyboard.nextInt();
		if (x==1) {
			System.out.println("input a11:");
			double a11 = keyboard.nextDouble();
			System.out.println("input a12:");
			double a12 = keyboard.nextDouble();
			System.out.println("input b1:");
			double b1 = keyboard.nextDouble();
			System.out.println("input a21:");
			double a21 = keyboard.nextDouble();
			System.out.println("input a22:");
			double a22 = keyboard.nextDouble();
			System.out.println("input b2:");
			double b2 = keyboard.nextDouble();
			
			
			double d = a11*a22 - a12*a21;
			double d1=b1*a22-b2*a12;
			double d2=a11*b2-a21*b1;
			if (d!=0) {
				double x1=d1/d;
				double x2=d2/d;
				System.out.println(x1);
				System.out.println(x2);
			}
			else if ((d1==0)&&(d2==0)) {
				System.out.println("infinity solution");
			}
			else System.out.println("no solution");
		}
		else if (x==2) {
			System.out.println("input a:");
			double a = keyboard.nextDouble();
			System.out.println("input b:");
			double b = keyboard.nextDouble();
			System.out.println("input c:");
			double c = keyboard.nextDouble();
			double d=b*b-4*a*c;
			if (d<0){
				System.out.println("no solution");
			}
			else if(d==0) {
				double x1=-b/2/a;
				System.out.println("x="+x1);
			}
			else {
				double x1= (-b+Math.sqrt(d))/2/a;
				double x2= (-b-Math.sqrt(d))/2/a;
				System.out.println("x1="+x1);
				System.out.println("x2="+x2);
			}
		}
		
	}

}
