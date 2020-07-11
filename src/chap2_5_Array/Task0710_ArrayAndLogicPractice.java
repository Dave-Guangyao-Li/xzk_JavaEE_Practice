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
//		int num = 0;//�洢Ŀ����
//		System.out.println("����Ŀ������");
//		//�����û�����֮ǰҪ���ж��������ͣ���ֹ����
//		if (input.hasNextInt()) {
//			num = input.nextInt();
//			System.out.println("�������Ŀ�����ǣ�" + num);
//		} else {
//			System.out.println("��������������������");
//		}
//		twoSum(nums, num);
		//4.
//		int [] nums4 = {1, 3, 9, 6, 7, 15, 4, 8};
//		System.out.println("������Ҫ���ҵ�Ŀ������");
//		Scanner myinput = new Scanner(System.in);
//		int mynum = 0;//�洢Ŀ����
//		// �����û�����֮ǰҪ���ж��������ͣ���ֹ����
//		if (myinput.hasNextInt()) {
//			mynum = myinput.nextInt();
//			System.out.println("�������Ŀ�����ǣ�" + mynum);
//		} else {
//			System.out.println("��������������������");
//		}
//		sortAndSearch(nums4, mynum);
		//5.
		int [] nums5 = {0,1,0,3,12};
		moveZero(nums5);
		
	}
	/**
	 * 1�� ����ĳ������
	 * ����һ������Ϊ 10 ���������� nums �� ѭ������ 10 �������� 
	 * Ȼ������һ�������� ���Ҵ������� �ҵ�����±꣬ û�ҵ�������ʾ��
	 */
	public static void findInteger() {
		Scanner input = new Scanner(System.in);
		int [] nums = new int[10];//�洢��������
		int target = 0;//Ŀ��ֵ
		boolean result = false;//�Ƿ��ҵ�Ŀ��ֵ
		System.out.println("����������10��������ֵ��");
		for(int i =0; i<nums.length; i++) {
			// �����û�����֮ǰҪ���ж��������ͣ���ֹ����
			if (input.hasNextInt()) {
				nums[i] = input.nextInt();
			} else {
				System.out.println("��������������������");
				System.exit(0);
			}	
		}
		System.out.println("������Ҫ���ҵ�������ֵ��");	
		if (input.hasNextInt()) {
			target = input.nextInt();
		} else {
			System.out.println("��������������������");
		}
		for(int i =0; i<nums.length; i++) {
			if(nums[i]==target) {
				result = true;
				System.out.println("Ҫ�ҵ������±�Ϊ��"+i);
			}
		}
		if(!result) {
			System.out.println("û���ҵ�Ŀ����");
		}
		
	}
	
	/**
	 * 2�� �ҳ��������ֵ
	 * ����һ������Ϊ 10 ���������� nums �� ѭ������ 10 �������� �����������ֵ�� ��Сֵ��
	 */
	public static void findMaxOrMinValue(int nums[]) {
		System.out.println("������Ҫ�����ֵ������Сֵ�������ֵ������0������Сֵ������1��");
		Scanner input = new Scanner(System.in);
		String choose = input.next();
		if(choose.equals("0")) {
			//����Сֵ
			//1.	����һ�������� ���ڴ洢��������ʱ���ֵ���Сֵ
			int n = nums[0];
			//2.	ѭ��ȡ�������е�ÿһ�����ݣ� ��1��ʼ
			for(int i=1;i<nums.length;i++) {
				//�������е�ÿһ��������n�Ƚϣ� �����nС�� ��n��ֵ��ֵΪ������ݡ�
				n = n<nums[i]?n:nums[i];//������Ŀ�����
			}
			System.out.println("��������СֵΪ��"+n);
		}else if(choose.equals("1")) {
			//�����ֵ
			//1.	����һ�������� ���ڴ洢��������ʱ���ֵ����ֵ
			int n = nums[0];
			//2.	ѭ��ȡ�������е�ÿһ�����ݣ� ��1��ʼ
			for(int i=1;i<nums.length;i++) {
				//�������е�ÿһ��������n�Ƚϣ� �����n�� ��n��ֵ��ֵΪ������ݡ�
				n = n>nums[i]?n:nums[i];//������Ŀ�����
			}
			System.out.println("���������ֵΪ��"+n);
		}
		else {
			System.out.println("��������������1��0��");
		}
	}
	/**
	 * 3�� ����֮��
	 * ����һ���������� nums ��һ��Ŀ��ֵ target�� �����ڸ��������ҳ���ΪĿ��ֵ�������������� ��������ǵ������±�
	 * ����ÿ������ֻ���Ӧһ���𰸣� �����ظ��������������ͬ����Ԫ�ء�
	 * 		ʾ��:
	 * 		���� nums = [2, 7, 11, 15], target = 9
	 * 		��Ϊ nums[0] + nums[1] = 2 + 7 = 9
	 * 		������� 0�� 1
	 */
	public static void twoSum(int[] nums, int target){
		//����ð�������С��������
		int temp;
		//���ѭ�����Ƶ��ǣ� �Ƚϵ�������
		//���ѭ�������� length-1
		for(int i=0;i<nums.length-1;i++) {
			//�ڲ�ѭ�����Ƶ��ǣ�ÿ�ֱȽϵĴ���
			//��i�֣�i��0��ʼ���㣩�� �Ƚϴ���Ϊ��length-i-1
			for(int j=0;j<nums.length-i-1;j++) {
				if(nums[j]>nums[j+1]) {
					//������ȣ� �����ƶ�����
					temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
			}
		}
		//�����Ѿ���ɡ� �����Ǳ�����ӡ�鿴�Ĺ���
		for(int i=0;i<nums.length;i++) {
			System.out.print(nums[i]+" ");
			System.out.println();
		}
		//ѭ��ÿһ��Ԫ�أ���Ϊ��һ������
		//���ö��ֲ���˼�볢���ҵڶ�������
		int num1 = 0;//��һ������
		int num2 = 0;//�ڶ�������
		int found = -1;//�ҵ��ĵڶ����������±�
		for(int i=0; i<nums.length; i++) {
			
			//���ֲ���num2
			num1 = nums[i];
			num2 = target- num1;
			
			//1.	��С��Χ�±�
			int minIndex = 0; 
			//2.	���Χ�±�
			int maxIndex = nums.length-1;
			//3.	�м������±�
			int centerIndex = (minIndex+maxIndex)/2;
			while(true) {
				if(nums[centerIndex]>num2) {
					//�м����ݽϴ�
					maxIndex = centerIndex-1;
				}else if(nums[centerIndex]<num2) {
					//�м����ݽ�С
					minIndex = centerIndex+1;
				}else {
					//�ҵ�������  ����λ�ã�centerIndex
					break;
				}
				//û���ҵ�����
				if(minIndex > maxIndex) {
					centerIndex = -1;
					break;
				}
				//���߽緢���仯�� ��Ҫ�����м��±�
				centerIndex = (minIndex+maxIndex)/2;
			}
			found = centerIndex; //num2���±�
			if(found!=-1) {
				System.out.println("�����������±�Ϊ��"+i + ", "+ found);
				break;
			}
		}
		if(found==-1){//ѭ����ɻ���û���ҵ�
			System.out.println("�����в������������Ӻ͸պõ���"+target);
		}
	}
		
		
	
	/**
	 * 4�� ���򲢲���
	 * ������{1�� 3�� 9�� 5�� 6�� 7�� 15�� 4�� 8}�������� Ȼ��ʹ�ö��ֲ��� 6������������±ꡣ
	 */
	public static int sortAndSearch(int [] nums, int target) {
		//����ð�������С��������
		int temp;
		//���ѭ�����Ƶ��ǣ� �Ƚϵ�������
		//���ѭ�������� length-1
		for(int i=0;i<nums.length-1;i++) {
			//�ڲ�ѭ�����Ƶ��ǣ�ÿ�ֱȽϵĴ���
			//��i�֣�i��0��ʼ���㣩�� �Ƚϴ���Ϊ��length-i-1
			for(int j=0;j<nums.length-i-1;j++) {
				if(nums[j]>nums[j+1]) {
					//������ȣ� �����ƶ�����
					temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
			}
		}
		
		//�����Ѿ���ɡ� �����Ǳ�����ӡ�鿴�Ĺ���
		for(int i=0;i<nums.length;i++) {
			System.out.print(nums[i]+" ");
			System.out.println();
		}
		//���ֲ���Ŀ����
		//�ؼ�������������
		//1.	��С��Χ�±�
		int minIndex = 0; 
		//2.	���Χ�±�
		int maxIndex = nums.length-1;
		//3.	�м������±�
		int centerIndex = (minIndex+maxIndex)/2;
		while(true) {
			System.out.println("ѭ����һ��");
			if(nums[centerIndex]>target) {
				//�м����ݽϴ�
				maxIndex = centerIndex-1;
			}else if(nums[centerIndex]<target) {
				//�м����ݽ�С
				minIndex = centerIndex+1;
			}else {
				//�ҵ�������  ����λ�ã�centerIndex
				break;
			}
			//û���ҵ�����
			if(minIndex > maxIndex) {
				centerIndex = -1;
				System.out.println("û���ҵ�����");
				break;
			}
			//���߽緢���仯�� ��Ҫ�����м��±�
			centerIndex = (minIndex+maxIndex)/2;
		}
		
		System.out.println("Ŀ��λ��Ϊ��"+centerIndex);
		return centerIndex;
	}
	
	/**
	 * 5�� �ƶ���
	 * ����һ������ nums�� ��дһ������������ 0 �ƶ��������ĩβ�� ͬʱ���ַ���Ԫ�ص����˳��
	 * 		ʾ��:
	 * 		����: [0,1,0,3,12] 
	 * 		���: [1,3,12,0,0]
	 */
	public static void moveZero(int [] nums) {
		System.out.println("�������飺");
		for(int i=0;i<nums.length;i++) {
        	System.out.print(nums[i]+" ");
        }
		int zeroNum=0;//��������0�ĸ���
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){//���nums[i]=0,zeroNum������һ
                zeroNum++;
            }
            else if(zeroNum!=0){//���nums[i]������0,��nums[i]��ǰzeroNum�����������ҽ�nums[i]��ֵΪ0
                nums[i-zeroNum]=nums[i];  
                nums[i]=0;
            }
        }
        System.out.println();
        System.out.println("�ƶ�0��");
        for(int i=0;i<nums.length;i++) {
        	System.out.print(nums[i]+" ");
        }

	}
		

}
