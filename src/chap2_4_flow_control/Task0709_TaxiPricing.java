package chap2_4_flow_control;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task0709_TaxiPricing {
	/**
	 * ���һ�����⳵�Ʒ�ģ�⹦�ܣ� �ܹ������ܷ��ú��г�����������Ŀ��ϸ���˵���� �������⳵ʦ���ͳ˿��˽�Ʒѱ�׼
	 * 
	 * 3���������շ�	
	 * 		13Ԫ
	 * ��������	
	 * 		2.3Ԫ/ÿ����
	 * ������ʻ�͵Ⱥ��	
	 * 		���ݿͻ�Ҫ��ͣ���Ⱥ�������ڵ�·���ƣ�ʱ�ٵ���12����ʱ��ÿ5��������߷��ڼ����2����������ۣ�������ʻ�ѣ���
	 * 		����ʱ�����1����������ۣ�������ʻ�ѣ�
	 * ԤԼ�г������	
	 * 		����ǰ4Сʱ����ԤԼÿ��6Ԫ��4Сʱ����ԤԼÿ��5Ԫ
	 * ��ʻ��	
	 * 		�����ؿ���ʻ����15���ﲿ�֣��������ۼ���50%�ķ��ã�
	 * 		�����ؿͣ��������յ���2���������Χ���ڣ������տ�ʻ�ѡ�
	 * ҹ���շ�	
	 * 		23��00������������5��00����������Ӫʱ���������ۼ���20%�ķ��á�
	 * ȼ�͸��ӷ�	
	 * 		ÿ�˴μ���1Ԫȼ�ͷѡ�
	 * ��ע
	 * 		1. ��߷�Ϊ7��00������-9��00������������߷�17��00������-19��00����������
	 * 		2. ���⳵������ԪΪ��λ��Ԫ�����������롣
	 * 		3. ��·�����ŷ��ɳ˿͸�����
	 * 
	 * �ܳ���=��̷���+������ʻ�ѣ����ߵȺ�ѣ�+ԤԼ�г������+��ʻ��+ҹ���շ�+ȼ�͸��ӷѡ� 
	 * ��Ҫ�ռ��������У� �������
	 * 				������ʻʱ��������߷�����ʻʱ��������ʱ�����ʻʱ���� �� 
	 * 				�Ƿ�ԤԼ�г�������СʱΪ��׼�� �� 
	 * 				��ʼ�������⳵ʱ�䡢 
	 * 				���⳵�����յ�վʱ�䣬 
	 * �����Щ���ݺͱ����ṩ�ı�׼�Ϳ���ʹ�ó�����м����ܳ����ˡ�
	 * 
	 * 1. �����ó�������ı����� ���ڴ洢���ݣ� ��ע���������͡�
	 * 2. ��ʾ�û�������������� �ܳ˳�ʱ�䡢 �Ƿ�ԤԼ�г��������ԤԼ�г�����Ҫȷ���Ƿ��� 4 Сʱ���ڣ� �� 
	 * 		�Ƿ��е�����ʻ������У� ��ʾ���������ʻʱ�䣬 ��Ҫ��������߷壩 �� 
	 * 		�����̳��� 15 ��� ��Ҫ�����Ƿ����� 2���ﷶΧ�ڣ� ������ʻ�ѡ� 
	 * 		�ֱ���Щ�û������ֵ�� ͨ����ֵ�����Ӧ�ı����С�
	 * 3. ���ݼƷѱ�׼���û���������ݽ����ܷ��ü��㴦��
	 * 4. ����ܷ��ú�ÿ���������õ������ϸ���˵����
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("�����������̣�km��:");//��ʾ���������
		Scanner inputKm = new Scanner(System.in);
		double km = inputKm.nextDouble();//�õ��û�����������
		//���÷�����������̷�
		double kmMoney = 0.0;
		kmMoney = kmDriving(km);

		//���÷���������ҹ����ʻ��
		double nightMoney = 0.0;
		nightMoney = nightDriving(km);
		
		//���÷���������ԤԼ�г������
		double appointmentMoney = 0.0; 
		appointmentMoney = appointmentDriving();
		
		//���÷��������������ʻ��,����ʱ���շѣ�����߷����շ�
		//map�������ض��ֵ
		Map<String, Integer> mapSum = new HashMap<String, Integer>();
		mapSum = slowDriving();
		//��map.get()�õ��շѣ�תΪdouble����
		double noHeightDrivingMoney = (double)mapSum.get("noHeightDrivingMoney");
		double heightDrivingMoney = (double)mapSum.get("heightDrivingMoney");
		double slowDrivingMoney = (double)mapSum.get("slowDrivingMoney");

		//���÷������������ؿͷ���
		double returnDrivingMoney = 0.0;
		returnDrivingMoney = returnDriving(km);
		
		//ȼ�͸��ӷ�
		double olimoney = 1.0;
		
		//�ܳ���=��̷���+������ʻ��+ԤԼ�г������+��ʻ��+ҹ���շ�+ȼ�� ���ӷѡ�
		//�ܳ���
		double moneySum = 0.0;
		moneySum = kmMoney + slowDrivingMoney + appointmentMoney + 
				returnDrivingMoney + nightMoney + olimoney;
		System.out.println("�ܳ��ѣ�"+moneySum+"Ԫ");
		
		System.out.println("---����������Ŀ��ϸ���---");
		//�����̷���
		if (kmMoney>13.0) {
			System.out.println("��̳���3�����̼۸�"+kmMoney);
		}else {
			System.out.println("���С��3�����̼۸�"+kmMoney);
		}
		//���������ʻ��
		if (slowDrivingMoney>0.0) {
			System.out.println("������ʻ��һ����"+slowDrivingMoney+"Ԫ�����У�");
			if (noHeightDrivingMoney>0.0) {
				System.out.println("����ʱ��ε�����ʻ�ѣ�"+noHeightDrivingMoney);
			}
			if (heightDrivingMoney>0.0) {
				System.out.println("����߷�ʱ��ε�����ʻ�ѣ�"+heightDrivingMoney);
			}
		}else {
			System.out.println("�޵�����ʻ��");
		}
		//���ԤԼ�г���
		if (appointmentMoney>0.0) {
			System.out.println("ԤԼ�г�����ѣ�"+appointmentMoney);
		}else {
			System.out.println("��ԤԼ����");
		}
		//�����ʻ�ѣ������ؿͷѣ�
		if (returnDrivingMoney>0) {
		System.out.println("��ʻ��"+returnDrivingMoney);
		}else {
			System.out.println("�޿�ʻ��");
		}
		//���ҹ�����
		if (nightMoney>0.0) {
			System.out.println("ҹ���շ�"+nightMoney);
		}else {
			System.out.println("��ҹ�����");
		}
		//���ȼ�ϸ��ӷ�
		System.out.println("ȼ�͸��ӷѣ�"+olimoney+"Ԫ");
	}
	
	//������̷���
	private static double kmDriving(double km){
		if (km>3.0) {
			//��̷�=(���-3)x��������2.3Ԫ +13Ԫ
			double kmMoney = (km-3.0)*2.3+13.0;
			//��������
			kmMoney = (double) Math.round(kmMoney);

			return kmMoney;
		}else {
			//δ��3������13Ԫ
			double kmMoney = 13.0;

			return kmMoney;
		}
	}
	
	//��������ԤԼ�г���
	public static double appointmentDriving(){
		System.out.print("�������Ƿ�ԤԼ�г�(��|��)?");
		Scanner inputChoose = new Scanner(System.in);
		String choose = inputChoose.next();//ȡ���û�����
		if (choose.equals("��")) {
			System.out.print("ԤԼ�Ƿ���4��Сʱ����(��|��)?");
			Scanner inputAppointment = new Scanner(System.in);
			String appointment = inputAppointment.next();
			
			if (appointment.equals("��")) {
				//ԤԼ�г���Ϊ5Ԫ
				double appointmentMoney = 5.0;
				return appointmentMoney;
					
			}else if (appointment.equals("��")) {
				//ԤԼ�г���Ϊ6Ԫ
				double appointmentMoney = 6.0;
				return appointmentMoney;
			}else {
				//�˳�����
				System.out.println("�������󣬡��Ƿ���4��Сʱ���ڡ������롰�ǡ����ߡ��񡱣�����");
				System.exit(0);
			}
		}else if (choose.equals("��")) {
			double appointmentMoney = 0.0;
			return appointmentMoney;
		}else {
			//�˳�����
			System.out.println("�������󣬡�ԤԼ�г��������롰�ǡ����ߡ��񡱣�����");
			System.exit(0);
		}
		return 0.0;
		
	}
	
	//������ʻ����۸񷽷�
	public static Map<String, Integer> slowDriving(){
		
		System.out.print("�������Ƿ��е�����ʻ(��|��)?");
		Scanner inputChoose = new Scanner(System.in);
		String choose = inputChoose.next();
		
		if (choose.equals("��")) {
			
			System.out.print("�����벻������߷��ڼ������ʻʱ�������ӣ���");
			Scanner noHeight = new Scanner(System.in);
			int noHeightDriving = noHeight.nextInt();
			System.out.print("����������߷��ڼ������ʻʱ�������ӣ���");
			Scanner height = new Scanner(System.in);
			int heightDriving = height.nextInt();
			
			//����߷���ÿ5���Ӽ���4.6Ԫ������ʱ�����2.3Ԫ
			heightDriving = heightDriving/5;
			noHeightDriving = noHeightDriving/5;
			double heightDrivingMoney = heightDriving*4.6;
			double noHeightDrivingMoney = noHeightDriving*2.3;
			//��������
			heightDrivingMoney = Math.round(heightDrivingMoney);
			noHeightDrivingMoney = Math.round(noHeightDrivingMoney);
			double slowDrivingMoney =  heightDrivingMoney+noHeightDrivingMoney;

			//map����������ֵ����map�����ٷ���,�ȴ����ͣ���ȥ�ٸĻ�double
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("noHeightDrivingMoney", (int) noHeightDrivingMoney);
			map.put("heightDrivingMoney", (int) heightDrivingMoney);
			map.put("slowDrivingMoney", (int) slowDrivingMoney);
			return map;
				
		}else if (choose.equals("��")) { //�޵�����ʻ
			int heightDrivingMoney = 0;
			int noHeightDrivingMoney = 0;
			int slowDrivingMoney = 0;
			
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("noHeightDrivingMoney", noHeightDrivingMoney);
			map.put("heightDrivingMoney", heightDrivingMoney);
			map.put("slowDrivingMoney", slowDrivingMoney);
			return map;

		}else {
			System.out.println("���Ƿ������ʻ�������롰�ǡ����ߡ��񡱣�����");
			System.exit(0);
		}
		return null;	
	}
	
	//�����ؿͷ����������ʹ��
	//����������ָ���ǳ˿ͳ������⳵��Ŀ�ĵ�֮�󷵻أ���˳����涨�����֮����Ȼ���ձ�׼�۸��շѣ�
	//��Ϊ���������˾������Ҫ��ʻ���أ���˳˿Ͳ��öฺ��50%�Ļس̷ѡ�
	public static double returnDriving(double km){
		System.out.print("�������Ƿ������ؿ�(��|��)?");
		Scanner inputChoose = new Scanner(System.in);
		String choose = inputChoose.next();
		
		if (choose.equals("��")) {
			//�����ؿͲ���Ҫ��ʻ��
			double returnDrivingMoney = 0.0;
			return returnDrivingMoney;
			
		}else if (choose.equals("��")) {
			
			if (km<=15) {
			//������15���ﲻ��Ҫ��ʻ��
			double returnDrivingMoney = 0.0;
			return returnDrivingMoney;
			
			}else {
				//ֻ�ճ���15���ﲿ�ֵķ���
				double returnDrivingMoney = (km-15)*(2.3*1.5-2.3);//�������ۼ���50%����
				returnDrivingMoney = (double) Math.round(returnDrivingMoney);

				return returnDrivingMoney;
			}

		}else {
			System.out.println("�������󣬡��Ƿ������������롰�ǡ����ߡ��񡱣�����");
			System.exit(0);
		}
		return 0;
		
	}
	
	//ҹ�俪���Ʒ�
	public static double nightDriving(double km) throws Exception{
		System.out.print("�����뿪ʼ�˳�ʱ�䣬24Сʱ�ƣ�hh:mm:ss����");
		Scanner first = new Scanner(System.in);
		String firstTime = first.next();
		System.out.print("����������˳�ʱ�䣬24Сʱ�ƣ�hh:mm:ss����");
		Scanner last = new Scanner(System.in);
		String lastTime = last.next();
		
		//����DateFormat�ķ������ַ�����Ϊʱ���ʽ
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		Date timeFirst = df.parse(firstTime);//��ʼ�˳�ʱ��
		Date timeLast = df.parse(lastTime);//�����˳�ʱ��
		Date nightTime = df.parse("23:00:00");
		Date morningTime = df.parse("05:00:00");
		//��ʼ�˳�ʱ��ͽ����˳�ʱ����5~23��֮������ҹ��˳�

		if (nightTime.getTime() >= timeFirst.getTime() && timeFirst.getTime() > morningTime.getTime() &&
			nightTime.getTime() >= timeLast.getTime() && timeLast.getTime() > morningTime.getTime()) {
			
			double nightMoney = 0.0;
			
			return nightMoney;
			}else {
				//ҹ��˳���=20%�Ļ�������x���
				double nightMoney = 0.0;
				nightMoney = km*2.3*0.2;
				nightMoney = (double) Math.round(nightMoney);
				return nightMoney;	
			}
	}

}
