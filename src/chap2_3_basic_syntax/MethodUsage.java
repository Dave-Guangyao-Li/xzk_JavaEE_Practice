package chap2_3_basic_syntax;

public class MethodUsage {
	/**
	 * ���巽����ִ�з���
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ע�⣺��static���εķ������رȽ���,������static���εķ����е��÷�static���εķ���
		//ִ�з�����������();
		say();
		System.out.println("------------------");
		say();
		//���ܷ���ֵ
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
