package chap2_6_IntegratedProject;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BallLottery {
	/**
	 * ˫ɫ���Ʊ����
	 * �淨���� ��˫ɫ�� ÿעͶע������ 6 ����ɫ������ 1 ����ɫ�������ɡ� 
	 * 		��ɫ������ 1��33 ��ѡ�� ��ɫ������ 1��16 ��ѡ��
	 * 		�������ƥ����������ɫ�������Ƿ��н��� 
	 * 
	 * 1. ϵͳ������� 6 �� 1��33 �����֣������ɫ�� +1 �� 1��16 ���֣�������ɫ�� ��
	 * 2. ���û����� 6 �����ظ��� 1��33 ���֣������ɫ�� +1 �� 1��16 ���֣�������ɫ�� ��
	 * 3. �Ա�ȷ�ϻ�ü��Ƚ���
	 * @param args
	 * @author DaveGYLi 0707-���ҫ
	 */
	public static void main(String[] args) {
		//�����н�����������
		ArrayList<Integer> redPrizeNums = new ArrayList<Integer>(); //�洢��ɫ�н���
		int bluePrizeNum; //�洢��ɫ�н���
		Random ran = new Random();
		//����ָ������6�����ظ��������
		while(redPrizeNums.size()<6) {
			int randRedPrizeNum = ran.nextInt(33)+1;//����[1,34)֮�����������ɫ��
			boolean addFlag = true; //ȷ���ظ�Ԫ�ز�����
			for(int i=0; i<redPrizeNums.size();i++) {
				int item = redPrizeNums.get(i);
				if(item == randRedPrizeNum) {
					addFlag = false;//�������Ѿ����ظ�Ԫ������Ϊfalse
				}
			}
			if(addFlag) {
				redPrizeNums.add(randRedPrizeNum);
			}
		}
		bluePrizeNum = ran.nextInt(16)+1;//����[1,17)֮�����������ɫ���н���
		//�õ��û�����Ĳ²����
		System.out.println("���������ظ��Ķ�6����ɫ��Ĳ²���룺��1-33��");
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> userRedGuess = new ArrayList<Integer>(); //�洢�²�ĺ�ɫ�н���
		while(userRedGuess.size()<6) {
			if (input.hasNextInt()) {
				int guess = input.nextInt();
				//���������ַ�Χ
				if(guess<1||guess>33) {
					System.out.println("��������������1-33֮���һ������");
				}
				else {
					//��ֹ�����ظ�
					boolean addFlag = true; //ȷ���ظ�Ԫ�ز�����
					for(int i=0; i<userRedGuess.size();i++) {
						int item = userRedGuess.get(i);
						if(item == guess) {
							addFlag = false;//�������Ѿ����ظ�Ԫ������Ϊfalse
							System.out.println("���������ظ�" + guess);
						}
					}
					if(addFlag) {
						userRedGuess.add(guess);
						System.out.println("�������ˣ�" + guess);
					}
				}
			} else {
				System.out.println("��������������������");
			}
		}
		System.out.println("�������1����ɫ��Ĳ²���룺��1-36��");
		int blueGuess = 1;
		if (input.hasNextInt()) {
			blueGuess = input.nextInt();
		} 
		else {
			System.out.println("��������������������");
		}
		
		//�ȶԳ齱���
		System.out.println("---------������ϣ������γ齱�������------------");
		int countRed = 0; //��ɫ�н�����������洢
		boolean blueResult = false; //��ɫ���Ƿ����
		for(int i=0; i<userRedGuess.size();i++) {
			int num = userRedGuess.get(i);
			//�ȶ��Ƿ�²��������н�����֮��
			if(redPrizeNums.contains(num)) {
				countRed++; //����һ��countRed������
			}
		}
		if(blueGuess == bluePrizeNum) {
			blueResult = true;//������Ϊtrue
		}
		//�н��������
		int grade = 0; //�н���0Ϊδ�н���1~6�ֱ����1-6�Ƚ�
		if(countRed == 6 && blueResult == true) {
			grade = 1;
		}
		else if(countRed == 6 && blueResult == false) {
			grade = 2;
		}
		else if(countRed == 5 && blueResult == true) {
			grade = 3;
		}
		else if(countRed == 5 && blueResult == false || countRed == 4 && blueResult == true) {
			grade = 4;
		}
		else if(countRed == 4 && blueResult == false || countRed == 3 && blueResult == true) {
			grade = 5;
		}
		else if(countRed == 2 && blueResult == true || countRed == 1 && blueResult == true || countRed == 0 && blueResult == false) {
			grade = 6;
		}
		
		System.out.println("���κ�ɫ���н��������£�");
		for(int i = 0;i<redPrizeNums.size();i++) {
			int itemnum = redPrizeNums.get(i);
			System.out.print(itemnum+" ");
		}
		System.out.println();
		System.out.println("������ɫ���н������ǣ�"+bluePrizeNum);
		
		System.out.println("������ĺ�ɫ��²������£�");
		for(int i = 0;i<userRedGuess.size();i++) {
			int itemnum = userRedGuess.get(i);
			System.out.print(itemnum+" ");
		}
		System.out.println();
		System.out.println("��ɫ�򹲲�����"+ countRed + "��");
		
		System.out.println("���������ɫ��²�����ǣ�"+ blueGuess);
		if(blueResult)
		{
			System.out.println("��ɫ��²�����ȷ");
		}
		else {
			System.out.println("��ɫ��²�������");
		}
		//�������
		
		switch(grade) {
		case 1:
			System.out.println("��ϲ�������һ�Ƚ�");
			break;
		case 2:
			System.out.println("��ϲ������ö��Ƚ�");
			break;
		case 3:
			System.out.println("��ϲ����������Ƚ�");
			break;
		case 4:
			System.out.println("��ϲ��������ĵȽ�");
			break;
		case 5:
			System.out.println("��ϲ���������Ƚ�");
			break;
		case 6:
			System.out.println("��ϲ����������Ƚ�");
			break;
		default:
			System.out.println("���ź���������δ�н�");
			break;
		}
	}

}
//�ο��� java����ָ��������������Լ�����ָ���������ظ�������� https://blog.csdn.net/weixin_37861326/article/details/80227898
