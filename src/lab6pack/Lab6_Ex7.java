package lab6pack;
import java.math.BigInteger;

public class Lab6_Ex7 {

	public static void main(String[] args) {
		for (int i = 0; i < 190; i+=10) {
			System.out.println("!"+i+"=> "+refactorial(i));
			if (i>170){
				System.out.println("!"+i+" with BigInteger=> "+BIrefactorial(i));
			}
		}
	}
	public static BigInteger BIrefactorial(int n){

		BigInteger f = new BigInteger(n+"");
		if (!(n==0 || n==1)){
			return f.multiply(BIrefactorial(n-1));
		}
		else{
			return BigInteger.ONE;
		}
	}
	
	public static double refactorial(double n){

		if (!(n==0 || n==1)){
			return n*(refactorial(n-1));
		}
		else{
			return 1;
		}
	}
}
