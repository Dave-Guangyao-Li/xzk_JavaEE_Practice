package chap2_3_basic_syntax;

public class PracticeDay1_0708 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 5;
		int b = 10;
		palindrome(12321);
		palindrome(12345);
		System.out.println("��λ����֮��Ϊ" + numsum(12345));
		swapValue(a, b);
		helloWorld();

	}

	/**
	 * 1. ����һ�����ͱ�������������λ��������Ϊ��ʼֵ�� �ж����ǲ�����λ������ ����λ�������� ��λ����λ��ͬ�� ʮλ��ǧλ��ͬ�� ���磺 12321�� ��
	 * @param num
	 * @author DaveGYLi 0707-���ҫ
	 */
	public static void palindrome(int num) {
		int b[] = new int[5]; // ����洢ȡ�õĸ�λ����
		// ͨ��ȡ��ͳ��Ĳ����ֱ��ȡ��λ����
		b[0] = num / 10000; // ��λ
		b[1] = num % 10000 / 1000; // ǧλ
		b[2] = num % 1000 / 100; // ��λ
		b[3] = num % 100 / 10; // ʮλ
		b[4] = num % 10; // ��λ
		if (b[0] == b[4] && b[1] == b[3])
			System.out.println(num + "�ǻ�����");
		else
			System.out.println(num + "���ǻ�����");
	}

	/**
	 * 
	 * 2. ����һ�����ͱ�������������λ��������Ϊ��ʼֵ�� �����λ����֮�� �����磺 12345 ��λ֮���ǣ� 1+2+3+4+5 �� Ҳ���� 15��
	 * 
	 * @author DaveGYLi 0707-���ҫ
	 */
	public static int numsum(int num) {
		int b[] = new int[5];
		int sum = 0;
		// ͨ��ȡ��ͳ��Ĳ����ֱ��ȡ��λ����
		b[0] = num / 10000;
		b[1] = num % 10000 / 1000;
		b[2] = num % 1000 / 100;
		b[3] = num % 100 / 10;
		b[4] = num % 10;
		// ѭ���Ӻ�
		for (int i = 0; i < b.length; i++)
			sum += b[i];
		return sum;
	}

	/**
	 * 3. �������ͱ��� a�� b�� д���� a�� b ��������ֵ���л����ĳ���Ҫ����ʹ�õ�����������
	 * 
	 * @author DaveGYLi 0707-���ҫ
	 */
	public static void swapValue(int a, int b) {
		System.out.println("�û�ǰ��");
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("�û���");
		System.out.println("a = " + a);
		System.out.println("b = " + b);
	}

	/**
	 * 4. ��д��һ�����ر���淶�� Hello World ���루ע�⣬ ע�ͱ����У� ҲҪ���ع淶��
	 * 
	 * @author DaveGYLi 0707-���ҫ
	 */
	public static void helloWorld() {
		System.out.println("Hello World"); // ������
	}
}
