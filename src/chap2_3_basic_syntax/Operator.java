package chap2_3_basic_syntax;

public class Operator {
	/**
	 * �������ʹ����ϰ
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// �������������ֵ���������ϵ��������߼���������ַ������ӷ�����Ŀ�����
		int a = 10;
		int b = 3;
		a += b;
		int i = 5;
		System.out.println(a > b);
		System.out.println(a > b ^ a < b); // ��򣬲�ͬΪ��
		System.out.println(a > b | a < b); // �򣬲�������Ƿ�Ϊ�棬�ұ߶�������
		System.out.println(a > b || a < b); // ��·�����Ϊ�棬�ұ߾Ͳ�������
		System.out.println(a > b & a > b); // �� 
		System.out.println(a < b && a > b); // ��·�룬�����Ϊfalseʱ����ȥ�����ұߵ�ֵ��ֱ�ӷ���false�������Ϊtrueʱ�������ұߵ�ֵ��
		System.out.println(i++); // �ȴ�ӡ������
		System.out.println(++i); // �������ٴ�ӡ
		System.out.println(a % b);
		System.out.println(a);
		
		String text1 = "Hello";
		String text2 = "lgy";
		String text3 = text1+text2;
		String text4 = text3+100;	//100����ַ����������ַ���ƴ��
		System.out.println(text3);
		System.out.println(text4);
		
		//��Ŀ�������boolean������ʽ�����ʽ1�����ʽ2
		System.out.println(a<b?"aС��b":"a����b");
	}

}
