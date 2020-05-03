package lab6pack;
import java.util.Random;

public class Lab6_Ex3 {

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			
			System.out.println(leapyear(RandomYear()));
		}
		System.out.println(leapyear("2000"));
	}

	public static String leapyear(String year){
		if (Integer.valueOf(year)==0){
			year="-1";
		}
		int g=Integer.valueOf(year);
		
		if (!(g%4==0)){
			if (g<0){
				year=Math.abs(g)+" B.C.";
			}
			return (year+" is a Common Year");
		}
		else if(!(g%100==0)){
			if (g<0){
				year=Math.abs(g)+" B.C.";
			}
			return (year+" is a Leap Year");
		}
		else if(!(g%400==0)){
			if (g<0){
				year=Math.abs(g)+" B.C.";
			}
			return (year+" is a Common Year");
		}
		else{
			if (g<0){
				year=Math.abs(g)+" B.C.";
			}
			return (year+" is a Leap Year");
		}
	}

	public static String RandomYear(){

		Random ra= new Random();
		String e= ra.nextInt(21)+"";
		if(e.length()==1){
			e="0"+e;
		}
		String s=ra.nextInt(41)-20+"";

		String year=s+e;
		
		return year;
	}
}