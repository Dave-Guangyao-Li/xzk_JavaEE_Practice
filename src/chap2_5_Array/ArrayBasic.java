package chap2_5_Array;

public class ArrayBasic {

	public static void main(String[] args) {
		//创建数组的格式
		//常用格式1.创建数组的同时，制定数组中的内容。
		//	数据类型[] 数组名称 = {数据1,数据2,数据3...数据n};
		int[] ages = {10,11,12,13,14};
		//常用格式2.创建数组， 并指定长度， 不指定数组中的内容。
		//	数据类型[] 数组名称 = new 数据类型[数组长度];
		//	数组长度通过int数据指定
		int[] ages2 = new int[10];
		
		//通过下标操作数组数据的方式：
		//1.	给数组某个下标 赋值：   数组名称[下标] = 值;
		ages[0] = 100;
		//2.	从数组某个下标 取值： 数组名称[下标]
		System.out.println(ages[0]);
		ages2[0] = 99;
		System.out.println(ages2[0]);
		
		
		System.out.println("------------------------");
		
		//如何获取数组的长度：  数组名称.length
		//数组的遍历
		for(int index=0;index<ages.length;index++) {
			//index: 0 1 2 3 4 
			System.out.println(ages[index]);
		}
		
		//常见问题：
		//	1.	数组下标越界问题：
		//int[] nums = {10,11,12,13,14};
		//System.out.println(nums[5]);
		//	2.	空指针问题
		int[] nums = null;
		System.out.println(nums[1]);
	}

}
