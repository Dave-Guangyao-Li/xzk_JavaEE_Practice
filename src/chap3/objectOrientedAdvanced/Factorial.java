package chap3.objectOrientedAdvanced;

public class Factorial {
	/**
	 * µİ¹éÊµÏÖ5µÄ½×³Ë
	 * @param args
	 */
	public static void main(String[] args) {
		int n = fact(5);
		System.out.println(n);

	}
	public static int fact(int n) {
		if(n==1) {
			return 1;
		}
		else {
			return n*fact(n-1);
		}
	}

}
