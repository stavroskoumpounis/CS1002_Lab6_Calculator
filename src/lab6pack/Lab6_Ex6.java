package lab6pack;

public class Lab6_Ex6 {

	public static void main(String[] args) {
		
		System.out.println(charcount("blabalbalbalbablablabalb", 'a')+" times");
		
	}
	public static int charcount(String ipx,char c){
		if (ipx.isEmpty()){
			System.out.println("String is empty");
			return -1;
		}
		int chcount = 0;
		for (int i = 0; i < ipx.length(); i++) {
			if(ipx.charAt(i)==c){
				chcount++;
			}
		}
		System.out.print("'"+c+"'"+" apears in "+ipx+" ");
		return chcount;
	}
}