package lab6pack;
import java.util.ArrayList;
import java.util.Arrays;

public class Lab6_Ex2 {

	public static void main(String args[])
	{
		
		ArrayList<String> dictionary = new ArrayList<String>(Arrays.asList("evaH","uoy","reve","draeh","eht","elat","fo","htrad","sieugalp","eht","esiw","?"));
		
		for (int i = 0; i < dictionary.size(); i++) {
			System.out.println(reverse(dictionary.get(i)));
		}
	
	}

	public static String reverse(String ipx)
	{
		String y="";
		if (ipx.length()<=1){  //If the given String is empty or has 1 char,it gives it back, 
			return ipx;		   //because the reverse of those 2 cases are the same as the original String.
		}
		else{	
			for (int i = ipx.length()-1; i >=0; i--) {
				char c=ipx.charAt(i);
				y=y+c;
			}
			return y;
		}
	}


}
