package chap2_4_flow_control;

import java.util.Scanner;

public class TakeUserInput {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // ������Scanner���ſ���ʹ�ò���Ҫ����ϵͳ����̨�û�����
		// ���ڽ��ո�����������
		System.out.println("������һ��������");
		// �����û�����֮ǰҪ���ж��������ͣ���ֹ����
		if (input.hasNextInt()) {
			int num = input.nextInt();
			System.out.println("��������ǣ�" + num);
		} else {
			System.out.println("��������������������");
		}

		// �����û�����ķ���
		// int i = input.nextInt(); ��������Ҫ���û����������ض�����������
		// System.out.println(i);
		// next��nextLine������Ҫͬʱ��
		System.out.println("������next���յ�����");
		// next�����س��Ϳո���������޷����տո������ʼ����һ�ѿո�Ȼ��������ݣ�ǰ��ո���������
		String str1 = input.next();
		// nextLine�������Խ��տո�
		System.out.println("������nextLine���յ�����");
		String str2 = input.nextLine();

		System.out.println(str1);
		System.out.println(str2);
	}

}
