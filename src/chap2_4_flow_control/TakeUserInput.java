package chap2_4_flow_control;

import java.util.Scanner;

public class TakeUserInput {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // 先引入Scanner包才可以使用并且要传入系统控制台用户输入
		// 用于接收各种数据类型
		System.out.println("请输入一个整数：");
		// 接受用户输入之前要先判断输入类型，防止出错
		if (input.hasNextInt()) {
			int num = input.nextInt();
			System.out.println("你输入的是：" + num);
		} else {
			System.out.println("输入有误，请输入整数！");
		}

		// 接收用户输入的方法
		// int i = input.nextInt(); 这种输入要求用户智能输入特定的数据类型
		// System.out.println(i);
		// next和nextLine方法不要同时用
		System.out.println("请输入next接收的内容");
		// next方法回车和空格都算结束，无法接收空格，如果开始输入一堆空格然后才输内容，前面空格不算作输入
		String str1 = input.next();
		// nextLine方法可以接收空格
		System.out.println("请输入nextLine接收的内容");
		String str2 = input.nextLine();

		System.out.println(str1);
		System.out.println(str2);
	}

}
