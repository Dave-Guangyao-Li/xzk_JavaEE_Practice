package chap2_4_flow_control;

import java.util.Scanner;

public class Task0709_FlowControlPractice {
	/**
	 * @author DaveGYLi 0707-李光耀
	 * @param args
	 */
	public static void main(String[] args) {
		//1.
		System.out.println("请输入本次购买的金额：");
		Scanner scanner = new Scanner(System.in);
		double shoppingSum = scanner.nextDouble();
		System.out.println("请输入您的会员积分（0以上整数）：");
		int membershipPoint = scanner.nextInt();
		countPrice(shoppingSum, membershipPoint);
		System.out.println("-------------------------------");
		//2.
		countDayPerMonth();
		System.out.println("-------------------------------");
		//3.
		printGraphic();
		System.out.println("-------------------------------");
		//4.
		printMultiplicationTable();
		System.out.println("-------------------------------");
		//5.
		Print3DigitNarcissisticNumber();
	}
	/**
	 * 1、 计算应缴金额
	 * 商场根据会员积分打折：
	 * 2000 分以内打 9 折，
	 * 4000 分以内打 8 折，
	 * 8000 分以内打 7.5 折，
	 * 8000 分以上打 7 折， 使用 if-else-if 结构， 实现手动输入购物金额和积分，
	 * 计算出应缴金额
	 *
	 */
	public static void countPrice(double sum, int point) {
		if(point<2000) {
			sum *= 0.9;
			System.out.println("您可以打九折，购物金额折后价格为："+sum);
		}
		else if(point>=2000 && point < 4000) {
			sum *= 0.8;
			System.out.println("您可以打八折，购物金额折后价格为："+sum);
		}
		else if(point>=4000 && point < 8000) {
			sum *= 0.75;
			System.out.println("您可以打七五折，购物金额折后价格为："+sum);
		}
		else if(point>=8000) {
			sum *= 0.7;
			System.out.println("您可以打七折，购物金额折后价格为："+sum);
		}
		else
			System.out.println("输入有误，请输入0以上的整数！");
	}
	/**
	 * 2、 计算该年该月天数一年中有 12 个月， 而每个月的天数是不一样的。 其中大月 31 天， 分别为
	 * 1,3,5,7,8,10,12 月， 小月 30 天， 分别 为 4,6,9,11 月。 还有二月比较特殊， 平年的二月只有 28 天，
	 *  而闰年的二月有 29 天， 由用户在控制台输入年份和月份，程序计算该年该月的天数。
	 * switch判断月份
	 * 1月 3月 5月 7月 8月 10月 12月   都有31天
	 * 4月 6月 9月 11月 都有30天
	 * 2月  判断平年闰年 
	 * 平28天  闰29天 
	 */
	public static void countDayPerMonth() {
		boolean proceed = true;
		while(proceed) {
			int year = 2000;
			int month = 1;
			System.out.println("请输入年份：");
			Scanner input = new Scanner(System.in);
			if (input.hasNextInt()) {//检查必须输入整数
				year = input.nextInt();
			} else {
				System.out.println("输入有误，请输入整数！");
			}
			System.out.println("请输入月份：");
			if (input.hasNextInt()) {//检查必须输入整数
				month = input.nextInt();
				if(month<1||month>12) {
					System.out.println("输入有误，请输入1~12的整数");
				}
			} else {
				System.out.println("输入有误，请输入整数！");
			}
			//switch判断天数
			switch(month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				System.out.println("本月有31天");
				break;
			case 4:
		    case 6:
		    case 9:
		    case 11:
		    	System.out.println("本月有30天");
		    	break;
		    case 2:
		    	if(year%4==0&&year%100!=0||year%400==0) {
		    		System.out.println("本月有29天");
		    	}
		    	else
		    		System.out.println("本月有28天");
		    	break;
			}
			System.out.println("是否继续？(是|否)");
			String choose = input.next();//取得用户输入
			if (choose.equals("是")) {
				proceed = true;
			}
			else if(choose.equals("否")) {
				proceed = false;
			}
			else {
				//退出程序
				System.out.println("输入有误，请输入“是”或者“否”！！！");
			}	
		}
	}
	/**
	 * 3、 图形打印任务
	 */
	public static void printGraphic() {
		System.out.println("-------三角形打印-------");
		for(int i =0;i<5;i++) {
			//i:0 1 2 3 4
			//j空格数 4 3 2 1 0
			for(int j=i+1;j<5;j++) {
				System.out.print(" ");
			}
			//k星号对应i*2+1
			for(int k = 0;k<i*2+1;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("-------直角三角形打印-------");
		for(int i =0;i<5;i++) {
			for(int j =0;j<i+1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("-------倒立直角三角形打印-------");
		for(int i=5;i>0;i--) {
			for(int j=0;j<i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	/**
	 * 4、 打印九九乘法表
	 */
	public static void printMultiplicationTable() {
		for(int i=1; i<=9; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print(j+"*"+i+"="+j*i+"	");
			}
			System.out.println();	
		}
	}
	/**
	 * 5、 打印三位数中的所有水仙花数
	 * 所谓“水仙花数” 即一个整数满足其值等于各个数位的立方和。
	 * 如: 153 是一个水仙花数， 因为 153= 1³+5³+3³
	 */
	public static void Print3DigitNarcissisticNumber() {
		System.out.println("所有的三位数中的水仙花数如下：");
		for(int i=100;i<1000;i++) {//所有的三位数
			int hundreds=i/100;//百位
			int tens=(i%100)/10;//十位
			int ones=i%10;//个位
			if(i==(Math.pow(hundreds, 3)+Math.pow(tens, 3)+Math.pow(ones, 3))) {
				System.out.print(i+" ");
			}
		}
	}

}
