package chap2_3_basic_syntax;

public class TypeConversion {
	/**
	 * һЩ�������Ͷ���ʹ��ʱ��ע������
	 * @param args
	 */
	public static void main(String[] args) {
		//1. float���ͱ�������
		//int��floatռ�ݴ洢�ռ䶼Ϊ4�ֽڣ�10Ĭ������δint�ͣ���תʱû��ǿת������
		float f1 = 10;
		//float���Ͷ���ע�⣺ֱ��д���ĸ�����Ĭ��������double�࣬����ʾ��Ҫǿת
		//	������ڸ����������f��ʾ������float��
		//float f2 = 10.1;����
		float f2 = 10.1f;

		//2. long���ͱ�������
		//long l1 = 2200000000; int���ͷ�Χ���Ϊ20�ڶ࣬�����巶Χ����int��Χʱ����
		//��ע�⣬�ұ�ֱ��д������������Ĭ��Ϊint���ͣ�ֵ����ᱨ��
		//	��������������ֺ��l����ʾ��long���͵�
		long l1 = 2200000000l;
		
		//3. char���Ͷ��� �õ����ţ�ֻ��һ���ַ�
		// char����Ҳ������ֵ�͵�һ�֣��ڼ������������ֵ��ʾ��
		char c1 = 'A';
		System.out.println((int)c1);	//������֣����65
		System.out.println(++c1);	//���B
		System.out.println(++c1);	//���C
		System.out.println(++c1);	//���D
	}

}
