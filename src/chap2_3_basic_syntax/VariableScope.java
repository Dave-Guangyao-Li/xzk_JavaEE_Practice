package chap2_3_basic_syntax;

public class VariableScope {
	int member = 40; //一个成员变量
	// 变量的作用域
	// 代码分为结构定义语句和功能执行语句，功能执行语句必须以分号结尾
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		int c = a + b;
		{
			System.out.println(c);
			say(c);
			//System.out.println(member); 虽然看起来是内层调用外层，但报错找不到member，因为member是一个成员变量
		}	//虽然两个语句在另一个范围中，但是这个范围和c同属与main方法的作用范围，内层可以访问外层的变量
	}	//一个作用域

	public static void say(int c) {
		int a = 20;
		System.out.println(c); // 想要调用main方法中的c,需要传入参数
	}	//另一个作用域

}
