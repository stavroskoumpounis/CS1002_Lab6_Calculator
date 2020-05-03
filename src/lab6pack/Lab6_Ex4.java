package lab6pack;
import java.text.DateFormatSymbols;
import java.util.Random;

public class Lab6_Ex4 extends Lab6_Ex3{

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.print(NumOfDays(leapyear(RandomYear()),RandomMonth())+" days\n");
		}
		System.out.println(NumOfDays(leapyear("2000"),2));
	}
	public static String NumOfDays(String year,int month){
		String[] year0 = year.split(" ");
		int days = 30;
		switch (month)
		{case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			days= 31;
			break;
		case 2:
			if(year0[year0.length-2].contains("Leap"))
			{days=29;}
			else
			{days=28;}
			break;     	
		case 4: case 6: case 9: case 11:
			days = 30;
			break;
		}
		if (year0[1].contains("B.C.")){
			year0[0]+=" B.C.";
		}

		System.out.print(getMonth(month)+"-"+year0[0]+"|");
		return days+"";

	}
	public static String getMonth(int month) {
		return new DateFormatSymbols().getMonths()[month-1];
	}
	public static int RandomMonth(){
		Random mon = new Random();
		return (mon.nextInt(12)+1);
	}
}
