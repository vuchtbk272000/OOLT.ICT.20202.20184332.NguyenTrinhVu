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
			System.out.println("___" + smonth + "____");
		}
		while ((smonth.equal('Jan.')) && (smonth.equal( 'Feb.')) && (smonth.equal( 'Mar.')) && (smonth.equal( 'Apr.')) && (smonth.equal( 'May')) && (smonth.equal( 'June')) && (smonth.equal( 'July')) && (smonth.equal( 'Aug.')) && (smonth.equal( 'Sep.')) && (smonth.equal( 'Oct.')) && (smonth.equal( 'Nov.')) && (smonth.equal( 'Dec.')))
//				(smonth .equal( "Jan")) && (smonth .equal( "Feb")) && (smonth .equal( "Mar")) && (smonth .equal( "Apr")) && (smonth .equal( "May")) && (smonth .equal( "Jun")) && (smonth .equal( "Jul")) && (smonth .equal( "Aug")) && (smonth .equal( "Sep")) && (smonth .equal( "Oct")) && (smonth .equal( "Nov")) && (smonth .equal( "Dec")) &&
//				(smonth .equal( "1")) && (smonth .equal( "2")) && (smonth .equal( "3")) && (smonth .equal( "4")) && (smonth .equal( "5")) && (smonth .equal( "6")) && (smonth .equal( "7")) && (smonth .equal( "8")) && (smonth .equal( "9")) && (smonth .equal( "10")) && (smonth .equal( "11")) && (smonth .equal( "12")));
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
