package chap2_3_basic_syntax;

public class SwitchValue {
	/**
	 * 任务:通过运算将a,b的值进行调换
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 20;
		int b = 30;
		// 通过第三方变量进行替换
		int c = 0;
		c = a;
		a = b;
		b = c;
		System.out.println(a);
		System.out.println(b);
	}

}
