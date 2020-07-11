package chap2_5_Array;

import java.util.Scanner;

public class Task0710_PickLeaderGame {
	/**
	 * 今天同学们相约一起爬山游玩， 为了更好的进行这场活动， 大家准备推举一个人作为出游的临时队长。 为了体现合理公平， 大家提出了一个比较有趣的规则。
	 * 所有人围成一圈， 顺序排号。 从第一个人开始报数（从 1 到 3 报数） ，凡报到 3 的人退出圈子， 剩下的人继续报数， 最后留下的当选为队长。
	 * 请你通过编写程序， 求出一组人中的队长是原来第几位同学。
	 * @author DaveGYLi 0707-李光耀
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("请输入有多少个同学：");
		Scanner input = new Scanner(System.in);
		int total = input.nextInt();
		int[] people = new int[total];// 存储同学编号
		int leader = 0;
		for (int i = 0; i < total; i++) {
			people[i] = i + 1;// 初始化为1~N的编号
		}
		int remain = people.length;
		int count = 0;// 计数，到3剔除
		while (remain > 1) {// 循环直至最后只剩一人 
			for (int i = 0; i < total; i++) {
				if (people[i] != 0) {// 不遍历已经剔除（置0）的元素
					count++;
					if (count % 3 == 0) {// 逢3淘汰一个
						people[i] = 0; // 置为0表示当前位置已剔除
						System.out.println("原" + (i + 1) + "号淘汰");
						remain--;// 总人数减一
					}
				}
			}
		}
		for (int i = 0; i < total; i++) {
			System.out.println(people[i] + " ");
			if (people[i] != 0) {
				leader = people[i];//队长为最后剩下的不为0的
			}
		}
		System.out.println("留下来当选的人为原来的" + leader + "号");

	}

}
