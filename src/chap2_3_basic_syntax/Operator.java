package chap2_3_basic_syntax;

public class Operator {
	/**
	 * 运算符的使用练习
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 算术运算符、赋值运算符、关系运算符、逻辑运算符、字符串连接符、三目运算符
		int a = 10;
		int b = 3;
		a += b;
		int i = 5;
		System.out.println(a > b);
		System.out.println(a > b ^ a < b); // 异或，不同为真
		System.out.println(a > b | a < b); // 或，不管左边是否为真，右边都会运算
		System.out.println(a > b || a < b); // 短路或，左边为真，右边就不计算了
		System.out.println(a > b & a > b); // 与 
		System.out.println(a < b && a > b); // 短路与，当左边为false时，不去计算右边的值而直接返回false；当左边为true时，计算右边的值。
		System.out.println(i++); // 先打印再自增
		System.out.println(++i); // 先自增再打印
		System.out.println(a % b);
		System.out.println(a);
		
		String text1 = "Hello";
		String text2 = "lgy";
		String text3 = text1+text2;
		String text4 = text3+100;	//100变成字符串，进行字符串拼接
		System.out.println(text3);
		System.out.println(text4);
		
		//三目运算符，boolean结果表达式？表达式1：表达式2
		System.out.println(a<b?"a小于b":"a大于b");
	}

}
