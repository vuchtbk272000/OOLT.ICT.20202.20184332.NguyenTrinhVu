package lab01;

import java.util.Scanner;



public class DayMonth {
	private static int check(String[] arr, String toCheckValue) 
	{ 
	    int test = 0; 
	    for (String element : arr) { 
	        if (element.equals(toCheckValue)){ 
	            test = 1; 
	            return test;	           
	        } 
	    } 
	    return 0;

	    
	} 

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String[] smonth31= {"January","Jan","Jan.","1","March","Mar.","Mar","3",
							"May","5","July","Jul","7","August","Aug","Aug.","8",
							"October","Oct.","Oct","10","December","Dec.","Dec","12"};
		String[] smonth28 = {"Febuary","Feb","Feb.","2"};
		String[] smonth30 = {"April","Apr","Apr.","4","June","Jun","6","September","Sep","Sep.","9","Nov.","Nov","November","11"};
		System.out.print("year:\n");
		int iyear = keyboard.nextInt();
		String s = keyboard.nextLine();
		String smonth;
		do{
			System.out.print("month:\n");
			smonth= keyboard.nextLine();
//			System.out.print((check(smonth31,smonth))+""+  (check(smonth30,smonth))+""+  (check(smonth28,smonth)));
		}
		while ((check(smonth31,smonth)==0) && (check(smonth30,smonth)==0) && (check(smonth28,smonth)==0));
		if (check(smonth28,smonth)==1) {
			if (iyear%4==0) 
				System.out.print("day: 29\n");
			else System.out.print("day: 28\n");
		}
		else if (check(smonth31,smonth)==1)
			System.out.print("day: 31\n");
		else System.out.print("day: 30\n");
						
	}

}
