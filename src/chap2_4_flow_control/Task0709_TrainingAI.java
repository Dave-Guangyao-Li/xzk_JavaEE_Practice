package chap2_4_flow_control;

import java.util.Scanner;

public class Task0709_TrainingAI {
	/**
	 * Ĭд���˹����ϴ���
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String question;
		while(true) {
			question = scanner.next();//�õ�����
			question = question.replace("��","");
			question = question.replace("��","��Ҳ");
			question = question.replace("��","��");
			System.out.println(question);
		}

	}

}
