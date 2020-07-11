package chap2_5_Array;

public class FindMaxOrMinValue {

	public static void main(String[] args) {
		int[] nums = {10,30,40,33,22,20,11,0};
		//1.	创建一个变量， 用于存储遍历数组时发现的最大值
		int n = nums[0];
		//2.	循环取出数组中的每一个内容， 从1开始
		for(int i=1;i<nums.length;i++) {
			//将数组中的每一个内容与n比较， 如果比n大， 则将n的值赋值为这个内容。
			n = n<nums[i]?n:nums[i];//利用三目运算符
		}
		System.out.println(n);

	}

}
