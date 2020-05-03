package lab6pack;

public class Lab6_Ex8 {

	public static void main(String[] args) {
		System.out.println(palindrome("anna"));
		System.out.println(palindrome("a toyota"));
	}

	public static boolean palindrome(String a){
		String ar=RecReverse(a);
		return (ar.contentEquals(a))?true:false;
	}
	public static String RecReverse(String str)
	{
		if (str.isEmpty())
			return str;

		return RecReverse(str.substring(1)) + str.charAt(0);
	}
}
