package lab01;

import java.util.Scanner;

public class DaysOfMonth {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("input year");
		int iyear = keyboard.nextInt();
		String s;
		s = keyboard.nextLine();
		int day=0;
		String smonth;
		do{
			System.out.println("input month");
			smonth= keyboard.nextLine();
			System.out.println("___"+smonth+"____");
		}
		while ((smonth != "Jan.") && (smonth != "Feb.") && (smonth != "Mar.") && (smonth != "Apr.") && (smonth != "May") && (smonth != "June") && (smonth != "July") && (smonth != "Aug.") && (smonth != "Sep.") && (smonth != "Oct.") && (smonth != "Nov.") && (smonth != "Dec.") &&
				(smonth != "Jan") && (smonth != "Feb") && (smonth != "Mar") && (smonth != "Apr") && (smonth != "May") && (smonth != "Jun") && (smonth != "Jul") && (smonth != "Aug") && (smonth != "Sep") && (smonth != "Oct") && (smonth != "Nov") && (smonth != "Dec") &&
				(smonth != "1") && (smonth != "2") && (smonth != "3") && (smonth != "4") && (smonth != "5") && (smonth != "6") && (smonth != "7") && (smonth != "8") && (smonth != "9") && (smonth != "10") && (smonth != "11") && (smonth != "12"));
		if ((smonth == "Feb") ||(smonth == "Feb.") || (smonth == "2")) {
			if (iyear%4 == 0) {
				day = 29;}
				else day = 28;
			System.out.println(day);
		}
		else if ((smonth == "Apr.") || (smonth == "Apr") || (smonth == "4") || (smonth == "Jun.") || (smonth == "Jun") || (smonth == "6") || (smonth == "Sep.") || (smonth == "Sep") || (smonth == "9") || (smonth == "Nov.") || (smonth == "Nov") || (smonth == "11") ) {
			day = 30;
			System.out.println(day);
		}
		else {System.out.println(smonth);
		day =31;}
		
		
		System.out.println(day);
	}
		
}
