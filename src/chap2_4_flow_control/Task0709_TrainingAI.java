package chap2_4_flow_control;

import java.util.Scanner;

public class Task0709_TrainingAI {
	/**
	 * 默写出人工智障代码
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String question;
		while(true) {
			question = scanner.next();//得到输入
			question = question.replace("吗","");
			question = question.replace("我","我也");
			question = question.replace("？","！");
			System.out.println(question);
		}

	}

}
