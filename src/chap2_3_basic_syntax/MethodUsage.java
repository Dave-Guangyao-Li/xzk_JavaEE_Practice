package chap2_3_basic_syntax;

public class MethodUsage {
	/**
	 * 定义方法，执行方法
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//注意：用static修饰的方法加载比较早,不能在static修饰的方法中调用非static修饰的方法
		//执行方法：方法名();
		say();
		System.out.println("------------------");
		say();
		//接受返回值
		int num = sum(10,20);
		System.out.println(num);
	}
	public static void say() {
		System.out.println("abcde");
		System.out.println("fghij");
	}
	public static int sum(int x, int y) {
		int s = x+y;
		return s;
	}
}
