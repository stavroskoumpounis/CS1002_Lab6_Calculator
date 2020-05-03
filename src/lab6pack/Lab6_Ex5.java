package lab6pack;
import java.math.BigInteger;

public class Lab6_Ex5 {

	public static void main(String[] args) {
		for (int i = 0; i < 190; i+=10) {
			System.out.println("!"+i+"=> "+factorial(i));
			if (i>170){
				System.out.println("!"+i+" with BigInteger=> "+BIfactorial(i));
			}
		}

	}
	public static double factorial(double n) {
		double f = 1.0;

		for(int i=1;i<=Math.abs(n);i++) { //absolute is handling negative numbers that would make the loop not to work properly
			f =f*i;
		}
		return f;
	}
	public static BigInteger BIfactorial(int n){
		BigInteger bf=new BigInteger("1");

		for(int i=1;i<=Math.abs(n);i++) { //absolute is handling negative numbers that would make the loop not to work properly
			bf =bf.multiply(BigInteger.valueOf(i));
		}
		return bf;
	}
}
// The int primitive data type is of 32 bit capacity in Java,therefore if any value to be represented over 32 bits
// is assigned to int,it will be "rolled over" the minimum limit -2^31 and "continue" from there.
// This is a handling for overflow and its called integer-wraparound 
// (https://www.baeldung.com/java-overflow-underflow)

// Likewise with the data type long which has the capacity of 64 bits
// Still in this case of !40 we will get an overflow error if long is used.

// So in cases of quite large numbers if precision is not important we can use the data type double
// This data type uses a different bit pattern than int and long in order to widen its range
// Representing in scientific notation form ,according to the IEEE754 Standard for Floating-Point Arithmetic
// 1 bit is allocated for sign ,11 for the exponent and 52 for the mantissa
// So while a larger number can be represented; the precision/exactness of that number
// is limited within the 52-53 bits of the mantissa, making double less precise but with a wider range than long.