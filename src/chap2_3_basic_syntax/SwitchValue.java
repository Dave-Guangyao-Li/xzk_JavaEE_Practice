package chap2_3_basic_syntax;

public class SwitchValue {
	/**
	 * ����:ͨ�����㽫a,b��ֵ���е���
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 20;
		int b = 30;
		// ͨ�����������������滻
		int c = 0;
		c = a;
		a = b;
		b = c;
		System.out.println(a);
		System.out.println(b);
	}

}
