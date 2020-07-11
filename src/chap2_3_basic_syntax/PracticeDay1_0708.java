package chap2_3_basic_syntax;

public class PracticeDay1_0708 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 5;
		int b = 10;
		palindrome(12321);
		palindrome(12345);
		System.out.println("各位数字之和为" + numsum(12345));
		swapValue(a, b);
		helloWorld();

	}

	/**
	 * 1. 定义一个整型变量并赋任意五位正整数作为初始值， 判断它是不是五位回文数 （五位回文数： 个位与万位相同， 十位与千位相同， 例如： 12321） ：
	 * @param num
	 * @author DaveGYLi 0707-李光耀
	 */
	public static void palindrome(int num) {
		int b[] = new int[5]; // 数组存储取得的各位数字
		// 通过取余和除的操作分别获取各位数字
		b[0] = num / 10000; // 万位
		b[1] = num % 10000 / 1000; // 千位
		b[2] = num % 1000 / 100; // 百位
		b[3] = num % 100 / 10; // 十位
		b[4] = num % 10; // 个位
		if (b[0] == b[4] && b[1] == b[3])
			System.out.println(num + "是回文数");
		else
			System.out.println(num + "不是回文数");
	}

	/**
	 * 
	 * 2. 定义一个整型变量并赋任意五位正整数作为初始值， 输出各位数字之和 （例如： 12345 各位之和是： 1+2+3+4+5 。 也就是 15）
	 * 
	 * @author DaveGYLi 0707-李光耀
	 */
	public static int numsum(int num) {
		int b[] = new int[5];
		int sum = 0;
		// 通过取余和除的操作分别获取各位数字
		b[0] = num / 10000;
		b[1] = num % 10000 / 1000;
		b[2] = num % 1000 / 100;
		b[3] = num % 100 / 10;
		b[4] = num % 10;
		// 循环加和
		for (int i = 0; i < b.length; i++)
			sum += b[i];
		return sum;
	}

	/**
	 * 3. 定义整型变量 a、 b， 写出将 a、 b 两个变量值进行互换的程序（要求不能使用第三个变量）
	 * 
	 * @author DaveGYLi 0707-李光耀
	 */
	public static void swapValue(int a, int b) {
		System.out.println("置换前：");
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("置换后：");
		System.out.println("a = " + a);
		System.out.println("b = " + b);
	}

	/**
	 * 4. 请写出一段遵守编码规范的 Hello World 代码（注意， 注释必须有， 也要遵守规范）
	 * 
	 * @author DaveGYLi 0707-李光耀
	 */
	public static void helloWorld() {
		System.out.println("Hello World"); // 输出语句
	}
}
