package chap2_5_Array;

import java.util.Scanner;

public class Task0710_PickLeaderGame {
	/**
	 * ����ͬѧ����Լһ����ɽ���棬 Ϊ�˸��õĽ����ⳡ��� ���׼���ƾ�һ������Ϊ���ε���ʱ�ӳ��� Ϊ�����ֺ���ƽ�� ��������һ���Ƚ���Ȥ�Ĺ���
	 * ������Χ��һȦ�� ˳���źš� �ӵ�һ���˿�ʼ�������� 1 �� 3 ������ �������� 3 �����˳�Ȧ�ӣ� ʣ�µ��˼��������� ������µĵ�ѡΪ�ӳ���
	 * ����ͨ����д���� ���һ�����еĶӳ���ԭ���ڼ�λͬѧ��
	 * @author DaveGYLi 0707-���ҫ
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("�������ж��ٸ�ͬѧ��");
		Scanner input = new Scanner(System.in);
		int total = input.nextInt();
		int[] people = new int[total];// �洢ͬѧ���
		int leader = 0;
		for (int i = 0; i < total; i++) {
			people[i] = i + 1;// ��ʼ��Ϊ1~N�ı��
		}
		int remain = people.length;
		int count = 0;// ��������3�޳�
		while (remain > 1) {// ѭ��ֱ�����ֻʣһ�� 
			for (int i = 0; i < total; i++) {
				if (people[i] != 0) {// �������Ѿ��޳�����0����Ԫ��
					count++;
					if (count % 3 == 0) {// ��3��̭һ��
						people[i] = 0; // ��Ϊ0��ʾ��ǰλ�����޳�
						System.out.println("ԭ" + (i + 1) + "����̭");
						remain--;// ��������һ
					}
				}
			}
		}
		for (int i = 0; i < total; i++) {
			System.out.println(people[i] + " ");
			if (people[i] != 0) {
				leader = people[i];//�ӳ�Ϊ���ʣ�µĲ�Ϊ0��
			}
		}
		System.out.println("��������ѡ����Ϊԭ����" + leader + "��");

	}

}
