package chap2_3_basic_syntax;

public class TypeConversion {
	/**
	 * 一些数据类型定义使用时的注意事项
	 * @param args
	 */
	public static void main(String[] args) {
		//1. float类型变量定义
		//int和float占据存储空间都为4字节，10默认类型未int型，互转时没有强转的问题
		float f1 = 10;
		//float类型定义注意：直接写出的浮点数默认类型是double类，会提示需要强转
		//	解决：在浮点数后面加f表示数字是float型
		//float f2 = 10.1;报错
		float f2 = 10.1f;

		//2. long类型变量定义
		//long l1 = 2200000000; int类型范围差不多为20亿多，当定义范围超过int范围时出错
		//需注意，右边直接写出的整型数字默认为int类型，值过大会报错
		//	解决：在整型数字后加l，表示是long类型的
		long l1 = 2200000000l;
		
		//3. char类型定义 用单引号，只能一个字符
		// char类型也算是数值型的一种，在计算机中是用数值表示的
		char c1 = 'A';
		System.out.println((int)c1);	//变成数字，输出65
		System.out.println(++c1);	//输出B
		System.out.println(++c1);	//输出C
		System.out.println(++c1);	//输出D
	}

}
