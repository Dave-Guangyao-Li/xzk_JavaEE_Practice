package chap2_6_IntegratedProject;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BallLottery {
	/**
	 * 双色球彩票程序。
	 * 玩法规则： “双色球” 每注投注号码由 6 个红色球号码和 1 个蓝色球号码组成。 
	 * 		红色球号码从 1—33 中选择， 蓝色球号码从 1—16 中选择。
	 * 		球的数字匹配数量和颜色决定了是否中奖， 
	 * 
	 * 1. 系统随机生成 6 个 1—33 的数字（代表红色球） +1 个 1—16 数字（代表蓝色球） 。
	 * 2. 请用户输入 6 个不重复的 1—33 数字（代表红色球） +1 个 1—16 数字（代表蓝色球） 。
	 * 3. 对比确认获得几等奖。
	 * @param args
	 * @author DaveGYLi 0707-李光耀
	 */
	public static void main(String[] args) {
		//生成中奖红蓝球数字
		ArrayList<Integer> redPrizeNums = new ArrayList<Integer>(); //存储红色中奖号
		int bluePrizeNum; //存储蓝色中奖号
		Random ran = new Random();
		//生成指定区间6个不重复的随机数
		while(redPrizeNums.size()<6) {
			int randRedPrizeNum = ran.nextInt(33)+1;//生成[1,34)之间随机数，红色球
			boolean addFlag = true; //确保重复元素不加入
			for(int i=0; i<redPrizeNums.size();i++) {
				int item = redPrizeNums.get(i);
				if(item == randRedPrizeNum) {
					addFlag = false;//集合中已经有重复元素则置为false
				}
			}
			if(addFlag) {
				redPrizeNums.add(randRedPrizeNum);
			}
		}
		bluePrizeNum = ran.nextInt(16)+1;//生成[1,17)之间随机数，蓝色球中奖号
		//得到用户输入的猜测号码
		System.out.println("请输入无重复的对6个红色球的猜测号码：（1-33）");
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> userRedGuess = new ArrayList<Integer>(); //存储猜测的红色中奖号
		while(userRedGuess.size()<6) {
			if (input.hasNextInt()) {
				int guess = input.nextInt();
				//不符合数字范围
				if(guess<1||guess>33) {
					System.out.println("输入有误，请输入1-33之间的一个整数");
				}
				else {
					//防止输入重复
					boolean addFlag = true; //确保重复元素不加入
					for(int i=0; i<userRedGuess.size();i++) {
						int item = userRedGuess.get(i);
						if(item == guess) {
							addFlag = false;//集合中已经有重复元素则置为false
							System.out.println("错误，输入重复" + guess);
						}
					}
					if(addFlag) {
						userRedGuess.add(guess);
						System.out.println("你输入了：" + guess);
					}
				}
			} else {
				System.out.println("输入有误，请输入整数！");
			}
		}
		System.out.println("请输入对1个蓝色球的猜测号码：（1-36）");
		int blueGuess = 1;
		if (input.hasNextInt()) {
			blueGuess = input.nextInt();
		} 
		else {
			System.out.println("输入有误，请输入整数！");
		}
		
		//比对抽奖情况
		System.out.println("---------输入完毕，您本次抽奖情况如下------------");
		int countRed = 0; //红色中奖号码猜中数存储
		boolean blueResult = false; //蓝色球是否猜中
		for(int i=0; i<userRedGuess.size();i++) {
			int num = userRedGuess.get(i);
			//比对是否猜测数字在中奖号码之中
			if(redPrizeNums.contains(num)) {
				countRed++; //猜中一个countRed则自增
			}
		}
		if(blueGuess == bluePrizeNum) {
			blueResult = true;//猜中置为true
		}
		//中奖情况描述
		int grade = 0; //中奖，0为未中奖，1~6分别代表1-6等奖
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
		
		System.out.println("本次红色球中奖号码如下：");
		for(int i = 0;i<redPrizeNums.size();i++) {
			int itemnum = redPrizeNums.get(i);
			System.out.print(itemnum+" ");
		}
		System.out.println();
		System.out.println("本次蓝色球中奖号码是："+bluePrizeNum);
		
		System.out.println("您输入的红色球猜测结果如下：");
		for(int i = 0;i<userRedGuess.size();i++) {
			int itemnum = userRedGuess.get(i);
			System.out.print(itemnum+" ");
		}
		System.out.println();
		System.out.println("红色球共猜中了"+ countRed + "个");
		
		System.out.println("您输入的蓝色球猜测号码是："+ blueGuess);
		if(blueResult)
		{
			System.out.println("蓝色球猜测结果正确");
		}
		else {
			System.out.println("蓝色球猜测结果错误");
		}
		//结果揭晓
		
		switch(grade) {
		case 1:
			System.out.println("恭喜您，获得一等奖");
			break;
		case 2:
			System.out.println("恭喜您，获得二等奖");
			break;
		case 3:
			System.out.println("恭喜您，获得三等奖");
			break;
		case 4:
			System.out.println("恭喜您，获得四等奖");
			break;
		case 5:
			System.out.println("恭喜您，获得五等奖");
			break;
		case 6:
			System.out.println("恭喜您，获得六等奖");
			break;
		default:
			System.out.println("很遗憾，您本次未中奖");
			break;
		}
	}

}
//参考： java生成指定区间随机数，以及生成指定个数不重复的随机数 https://blog.csdn.net/weixin_37861326/article/details/80227898
