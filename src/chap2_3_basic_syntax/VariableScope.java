package chap2_3_basic_syntax;

public class VariableScope {
	int member = 40; //һ����Ա����
	// ������������
	// �����Ϊ�ṹ�������͹���ִ����䣬����ִ���������ԷֺŽ�β
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		int c = a + b;
		{
			System.out.println(c);
			say(c);
			//System.out.println(member); ��Ȼ���������ڲ������㣬�������Ҳ���member����Ϊmember��һ����Ա����
		}	//��Ȼ�����������һ����Χ�У����������Χ��cͬ����main���������÷�Χ���ڲ���Է������ı���
	}	//һ��������

	public static void say(int c) {
		int a = 20;
		System.out.println(c); // ��Ҫ����main�����е�c,��Ҫ�������
	}	//��һ��������

}
