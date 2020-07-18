package chap3.objectOrientedAdvanced.fingerGuessingGame;

import java.util.Random;

import java.util.Scanner;
/**
 * 3. ��ȭ��Ϸ
 * ͨ������̨��ʽʵ��һ���˻���ս�Ĳ�ȭ��Ϸ�� �û�ͨ�����루1.���� 2.ʯͷ 3.���� 
 * ����������ɣ�1.���� 2.ʯͷ 3.���� �� ʤ�߻��֣�
 * n ���Ժ�ͨ�����ֵĶ����ж�ʤ����
 * 
 * ��ȭ��Ϸ������������Ϸ������gameFlow()��������Ϸ��ϢչʾgameInfo()���ж���һ�ֽ��roundResult()���ж�����ʤ��FinalResult()��
 * @author DaveGYLi
 */
public class FingerGuessingGame {
	//��Ϸ��ص�����
	Scanner input;
	Random random;
	GamePlayer player;//��ҽ�ɫ
	GamePlayer robot;//���Խ�ɫ
	int totalRound = 0; //�ڼ���
	//����ָ���½��Ķ���
	{
		//��ҵĽ�ɫ
		player = new GamePlayer();
		//���ԵĽ�ɫ
		robot = new GamePlayer();
		
		input = new Scanner(System.in);
		random = new Random();
	}
	
	//��Ϸ����������ʾ
	public void gameFlow() {
		System.out.println("******************");
		System.out.println("*****��ȭ��Ϸ******");
		System.out.println("******************");
		System.out.println("��ȭ����1������    2��ʯͷ     3����");
		//�û��Ľ�ɫ��
		System.out.println("��������Ľ�ɫ����");	
		player.setUsername(input.nextLine());
		//���ԵĽ�ɫ���������
		robot.setUsername("robot"+random.hashCode());
		//����˫����Ϣ
		System.out.println(player.getUsername()+"   VS   "+robot.getUsername());
		
		
		//ѭ�����̽��б���
		while(true) {			
			System.out.println("�����Ƿ�ʼ��Ϸ  Y/N");			
			String s = input.next();			
			if(s.equals("Y") || s.equals("y")) {				
				//������Ϸ				
				System.out.println("������Ϸ");				
				gameInfo();	//�����ȭ��Ϸ��ÿһ��		
				break;			
				}else if(s.equals("N") || s.equals("n")){				
					//��Ϸ���������˳���Ϸ								
					System.out.println("�˳���Ϸ");				
					FinalResult();				
					break;			
				}else {				
						//����ѡ��			
					}		
			}
		}
	
	
	//ÿһ�־������Ϣ
	public void gameInfo() {		
		System.out.println("���ȭ��1������   2��ʯͷ   3�������������Ӧ�����֣�");		
		int go = input.nextInt();		
		//�����ƴ��뵽��ҽ�ɫ�Ķ�����		
		player.setGesture(go);		
		//���Ե�������Ҫ���ѡ��		
		robot.setGesture(random.nextInt(3)+1);		//����������ʾ��Ӧ������1 2 3		
		System.out.println("������ǣ�"+getStringOfgesture(player.getGesture()));		//��ҳ�ȭ
		System.out.println(robot.getUsername()+"��ȭ���ǣ�"+getStringOfgesture(robot.getGesture())); 		
		roundResult();		
		while(true) {			
			System.out.println("�Ƿ�ʼ��һ�֣�Y/N");			
			String s = input.next();			
			if(s.equals("Y") || s.equals("y")) {				
				//�ݹ飬�Լ������Լ���������һ��	
				gameInfo();				
				break;			
				}else if(s.equals("N") || s.equals("n")) {		
					//������Ϸ���������ս��
					FinalResult();				
					break;			
					}		
		}	
	}

	
	private void FinalResult() {
		System.out.println("��Ϸ�������ܽ�����£�");
		System.out.println(player.getUsername()+"   VS   "+robot.getUsername());		
		System.out.println("��ս������"+totalRound+"\n");		
		System.out.println("����\t�÷�");		
		System.out.println(robot.getUsername()+"\t"+robot.getScore());		
		System.out.println(player.getUsername()+"\t"+player.getScore()+"\t");		
		//���		
		if(robot.getScore() == player.getScore()) {			
			System.out.println("���Ǵ��ƽ��");		
			}else if(robot.getScore() < player.getScore()){			
				System.out.println("��һ�ʤ��");		
			}else {			
				System.out.println("���Ի�ʤ��");		
			}
		
	}
	
	
	//ÿ�γ�ȭ�Ľ���ж�
	/*����Ӯ
	 * 1����- 2ʯͷ   ==-1
	 * 2ʯͷ- 3��   ==-1
	 * 3��- 1����   ==2

	 */
	private void roundResult() {
		totalRound++ ;//��������1
		//��ҳ�ȭ-���Գ�ȭ
		//����ҵĳ�ȭ-���Եĳ�ȭ		
		int i = player.getGesture() - robot.getGesture();		
		if(i == -1 || i==2) {			
			System.out.println("��һ���"+robot.getUsername()+"Ӯ��");			
			robot.setScore(robot.getScore()+1);//��ǰ���ּ�һ
			//�ڶ����аѵ��Է���+1		
			}else if(i ==0) {			
				System.out.println("��һ�����ƽ��");		
			}else {			
				System.out.println("��һ���"+player.getUsername()+"Ӯ��");			
				player.setScore(player.getScore()+1);
				//�ڶ����а���ҷ���+1		
				}
	}

	//����int���͵����ַ����ַ������͵�����	
	public String getStringOfgesture(int gesture) {		
		if(gesture == 1) {			
			return "����";		
			}else if(gesture ==2) {			
				return "ʯͷ";		
			}else {			
				return "��";		
				}	
	}
	
	
	
	//����
	public static void main(String[] args) {
		FingerGuessingGame game = new FingerGuessingGame();
		game.gameFlow();

	}

} 
//�ο������һ����ȭ��Ϸ������˻���ȭ������Ϸ�Ŀ����� https://blog.csdn.net/qq_45809896/article/details/107157992
