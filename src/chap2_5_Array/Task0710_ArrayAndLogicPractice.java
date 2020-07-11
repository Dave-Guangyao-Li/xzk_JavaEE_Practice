package chap2_5_Array;

import java.util.Scanner;

public class Task0710_ArrayAndLogicPractice {

	public static void main(String[] args) {
		//1.
//		int [] nums = {12,15,27,44,66,88};
//		findMaxOrMinValue(nums);
		//2.
//		findInteger();
		//3.
//		int []nums = {7, 2, 11, 15};
//		Scanner input = new Scanner(System.in);
//		int num = 0;//存储目标数
//		System.out.println("输入目标数：");
//		//接受用户输入之前要先判断输入类型，防止出错
//		if (input.hasNextInt()) {
//			num = input.nextInt();
//			System.out.println("你输入的目标数是：" + num);
//		} else {
//			System.out.println("输入有误，请输入整数！");
//		}
//		twoSum(nums, num);
		//4.
//		int [] nums4 = {1, 3, 9, 6, 7, 15, 4, 8};
//		System.out.println("请输入要查找的目标数：");
//		Scanner myinput = new Scanner(System.in);
//		int mynum = 0;//存储目标数
//		// 接受用户输入之前要先判断输入类型，防止出错
//		if (myinput.hasNextInt()) {
//			mynum = myinput.nextInt();
//			System.out.println("你输入的目标数是：" + mynum);
//		} else {
//			System.out.println("输入有误，请输入整数！");
//		}
//		sortAndSearch(nums4, mynum);
		//5.
		int [] nums5 = {0,1,0,3,12};
		moveZero(nums5);
		
	}
	/**
	 * 1、 查找某个整数
	 * 定义一个长度为 10 的整型数组 nums ， 循环输入 10 个整数。 
	 * 然后将输入一个整数， 查找此整数， 找到输出下标， 没找到给出提示。
	 */
	public static void findInteger() {
		Scanner input = new Scanner(System.in);
		int [] nums = new int[10];//存储整型数组
		int target = 0;//目标值
		boolean result = false;//是否找到目标值
		System.out.println("请依次输入10个整数的值：");
		for(int i =0; i<nums.length; i++) {
			// 接受用户输入之前要先判断输入类型，防止出错
			if (input.hasNextInt()) {
				nums[i] = input.nextInt();
			} else {
				System.out.println("输入有误，请输入整数！");
				System.exit(0);
			}	
		}
		System.out.println("请输入要查找的整数的值：");	
		if (input.hasNextInt()) {
			target = input.nextInt();
		} else {
			System.out.println("输入有误，请输入整数！");
		}
		for(int i =0; i<nums.length; i++) {
			if(nums[i]==target) {
				result = true;
				System.out.println("要找的整数下标为："+i);
			}
		}
		if(!result) {
			System.out.println("没有找到目标数");
		}
		
	}
	
	/**
	 * 2、 找出数组的最值
	 * 定义一个长度为 10 的整型数组 nums ， 循环输入 10 个整数。 输出数组的最大值、 最小值。
	 */
	public static void findMaxOrMinValue(int nums[]) {
		System.out.println("请问是要求最大值还是最小值？求最大值请输入0，求最小值请输入1。");
		Scanner input = new Scanner(System.in);
		String choose = input.next();
		if(choose.equals("0")) {
			//求最小值
			//1.	创建一个变量， 用于存储遍历数组时发现的最小值
			int n = nums[0];
			//2.	循环取出数组中的每一个内容， 从1开始
			for(int i=1;i<nums.length;i++) {
				//将数组中的每一个内容与n比较， 如果比n小， 则将n的值赋值为这个内容。
				n = n<nums[i]?n:nums[i];//利用三目运算符
			}
			System.out.println("此数组最小值为："+n);
		}else if(choose.equals("1")) {
			//求最大值
			//1.	创建一个变量， 用于存储遍历数组时发现的最大值
			int n = nums[0];
			//2.	循环取出数组中的每一个内容， 从1开始
			for(int i=1;i<nums.length;i++) {
				//将数组中的每一个内容与n比较， 如果比n大， 则将n的值赋值为这个内容。
				n = n>nums[i]?n:nums[i];//利用三目运算符
			}
			System.out.println("此数组最大值为："+n);
		}
		else {
			System.out.println("输入有误，请输入1或0！");
		}
	}
	/**
	 * 3、 两数之和
	 * 给定一个整数数组 nums 和一个目标值 target， 请你在该数组中找出和为目标值的那两个整数， 并输出他们的数组下标
	 * 假设每种输入只会对应一个答案， 不能重复利用这个数组中同样的元素。
	 * 		示例:
	 * 		给定 nums = [2, 7, 11, 15], target = 9
	 * 		因为 nums[0] + nums[1] = 2 + 7 = 9
	 * 		所以输出 0， 1
	 */
	public static void twoSum(int[] nums, int target){
		//首先冒泡排序从小到大排序
		int temp;
		//外层循环控制的是， 比较的轮数。
		//外层循环次数： length-1
		for(int i=0;i<nums.length-1;i++) {
			//内层循环控制的是，每轮比较的次数
			//第i轮（i从0开始计算）， 比较次数为：length-i-1
			for(int j=0;j<nums.length-i-1;j++) {
				if(nums[j]>nums[j+1]) {
					//两两相比， 满足移动条件
					temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
			}
		}
		//排序已经完成。 下面是遍历打印查看的过程
		for(int i=0;i<nums.length;i++) {
			System.out.print(nums[i]+" ");
			System.out.println();
		}
		//循环每一个元素，作为第一个和数
		//利用二分查找思想尝试找第二个和数
		int num1 = 0;//第一个和数
		int num2 = 0;//第二个和数
		int found = -1;//找到的第二个和数的下标
		for(int i=0; i<nums.length; i++) {
			
			//二分查找num2
			num1 = nums[i];
			num2 = target- num1;
			
			//1.	最小范围下标
			int minIndex = 0; 
			//2.	最大范围下标
			int maxIndex = nums.length-1;
			//3.	中间数据下标
			int centerIndex = (minIndex+maxIndex)/2;
			while(true) {
				if(nums[centerIndex]>num2) {
					//中间数据较大
					maxIndex = centerIndex-1;
				}else if(nums[centerIndex]<num2) {
					//中间数据较小
					minIndex = centerIndex+1;
				}else {
					//找到了数据  数据位置：centerIndex
					break;
				}
				//没有找到数据
				if(minIndex > maxIndex) {
					centerIndex = -1;
					break;
				}
				//当边界发生变化， 需要更新中间下标
				centerIndex = (minIndex+maxIndex)/2;
			}
			found = centerIndex; //num2的下标
			if(found!=-1) {
				System.out.println("两个和数的下标为："+i + ", "+ found);
				break;
			}
		}
		if(found==-1){//循环完成还是没有找到
			System.out.println("数组中不存在两个数加和刚好等于"+target);
		}
	}
		
		
	
	/**
	 * 4、 排序并查找
	 * 对数组{1， 3， 9， 5， 6， 7， 15， 4， 8}进行排序， 然后使用二分查找 6并输出排序后的下标。
	 */
	public static int sortAndSearch(int [] nums, int target) {
		//首先冒泡排序从小到大排序
		int temp;
		//外层循环控制的是， 比较的轮数。
		//外层循环次数： length-1
		for(int i=0;i<nums.length-1;i++) {
			//内层循环控制的是，每轮比较的次数
			//第i轮（i从0开始计算）， 比较次数为：length-i-1
			for(int j=0;j<nums.length-i-1;j++) {
				if(nums[j]>nums[j+1]) {
					//两两相比， 满足移动条件
					temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
			}
		}
		
		//排序已经完成。 下面是遍历打印查看的过程
		for(int i=0;i<nums.length;i++) {
			System.out.print(nums[i]+" ");
			System.out.println();
		}
		//二分查找目标数
		//关键的三个变量：
		//1.	最小范围下标
		int minIndex = 0; 
		//2.	最大范围下标
		int maxIndex = nums.length-1;
		//3.	中间数据下标
		int centerIndex = (minIndex+maxIndex)/2;
		while(true) {
			System.out.println("循环了一次");
			if(nums[centerIndex]>target) {
				//中间数据较大
				maxIndex = centerIndex-1;
			}else if(nums[centerIndex]<target) {
				//中间数据较小
				minIndex = centerIndex+1;
			}else {
				//找到了数据  数据位置：centerIndex
				break;
			}
			//没有找到数据
			if(minIndex > maxIndex) {
				centerIndex = -1;
				System.out.println("没有找到数据");
				break;
			}
			//当边界发生变化， 需要更新中间下标
			centerIndex = (minIndex+maxIndex)/2;
		}
		
		System.out.println("目标位置为："+centerIndex);
		return centerIndex;
	}
	
	/**
	 * 5、 移动零
	 * 给定一个数组 nums， 编写一个函数将所有 0 移动到数组的末尾， 同时保持非零元素的相对顺序。
	 * 		示例:
	 * 		输入: [0,1,0,3,12] 
	 * 		输出: [1,3,12,0,0]
	 */
	public static void moveZero(int [] nums) {
		System.out.println("输入数组：");
		for(int i=0;i<nums.length;i++) {
        	System.out.print(nums[i]+" ");
        }
		int zeroNum=0;//用来计算0的个数
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){//如果nums[i]=0,zeroNum个数加一
                zeroNum++;
            }
            else if(zeroNum!=0){//如果nums[i]不等于0,将nums[i]跟前zeroNum个交换，并且将nums[i]赋值为0
                nums[i-zeroNum]=nums[i];  
                nums[i]=0;
            }
        }
        System.out.println();
        System.out.println("移动0后：");
        for(int i=0;i<nums.length;i++) {
        	System.out.print(nums[i]+" ");
        }

	}
		

}
