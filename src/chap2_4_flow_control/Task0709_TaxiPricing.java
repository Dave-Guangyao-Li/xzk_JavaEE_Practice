package chap2_4_flow_control;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task0709_TaxiPricing {
	/**
	 * 完成一个出租车计费模拟功能， 能够计算总费用和列出产生费用项目详细情况说明， 帮助出租车师傅和乘客了解计费标准
	 * 
	 * 3公里以内收费	
	 * 		13元
	 * 基本单价	
	 * 		2.3元/每公里
	 * 低速行驶和等候费	
	 * 		根据客户要求停车等候或者由于道路限制，时速低于12公里时，每5分钟早晚高峰期间加收2公里基本单价（不含空驶费），
	 * 		其他时间加收1公里基本单价（不含空驶费）
	 * 预约叫车服务费	
	 * 		提提前4小时以上预约每次6元，4小时以内预约每次5元
	 * 空驶费	
	 * 		单程载客行驶超过15公里部分，基本单价加收50%的费用；
	 * 		往返载客（即起点和终点在2公里（含）范围以内）不加收空驶费。
	 * 夜间收费	
	 * 		23：00（含）至次日5：00（不含）运营时，基本单价加收20%的费用。
	 * 燃油附加费	
	 * 		每运次加收1元燃油费。
	 * 备注
	 * 		1. 早高峰为7：00（含）-9：00（不含）；晚高峰17：00（含）-19：00（不含）。
	 * 		2. 出租车结算以元为单位，元以下四舍五入。
	 * 		3. 过路、过桥费由乘客负担。
	 * 
	 * 总车费=里程费用+低速行驶费（或者等候费）+预约叫车服务费+空驶费+夜间收费+燃油附加费。 
	 * 需要收集的数据有： 里程数、
	 * 				低速行驶时长（早晚高峰期行驶时长和其他时间段行驶时长） 、 
	 * 				是否预约叫车（按四小时为标准） 、 
	 * 				开始乘坐出租车时间、 
	 * 				出租车到达终点站时间， 
	 * 结合这些数据和表中提供的标准就可以使用程序进行计算总车费了。
	 * 
	 * 1. 声明好程序所需的变量， 用于存储数据， 请注意数据类型。
	 * 2. 提示用户输入总里程数、 总乘车时间、 是否预约叫车（如果是预约叫车还需要确认是否在 4 小时以内） 、 
	 * 		是否有低速行驶（如果有， 提示输入低速行驶时间， 需要考虑早晚高峰） ， 
	 * 		如果里程超过 15 公里， 需要输入是否往返 2公里范围内， 决定空驶费。 
	 * 		分别将这些用户输入的值， 通过赋值存入对应的变量中。
	 * 3. 根据计费标准和用户输入的数据进行总费用计算处理。
	 * 4. 输出总费用和每个产生费用单项的详细情况说明。
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("请输入打车总里程（km）:");//提示输入里程数
		Scanner inputKm = new Scanner(System.in);
		double km = inputKm.nextDouble();//得到用户输入的里程数
		//调用方法，计算里程费
		double kmMoney = 0.0;
		kmMoney = kmDriving(km);

		//调用方法，计算夜间行驶费
		double nightMoney = 0.0;
		nightMoney = nightDriving(km);
		
		//调用方法，计算预约叫车服务费
		double appointmentMoney = 0.0; 
		appointmentMoney = appointmentDriving();
		
		//调用方法，计算低速行驶费,其他时间收费，早晚高峰期收费
		//map方法返回多个值
		Map<String, Integer> mapSum = new HashMap<String, Integer>();
		mapSum = slowDriving();
		//用map.get()得到收费，转为double类型
		double noHeightDrivingMoney = (double)mapSum.get("noHeightDrivingMoney");
		double heightDrivingMoney = (double)mapSum.get("heightDrivingMoney");
		double slowDrivingMoney = (double)mapSum.get("slowDrivingMoney");

		//调用方法计算往返载客费用
		double returnDrivingMoney = 0.0;
		returnDrivingMoney = returnDriving(km);
		
		//燃油附加费
		double olimoney = 1.0;
		
		//总车费=里程费用+低速行驶费+预约叫车服务费+空驶费+夜间收费+燃油 附加费。
		//总车费
		double moneySum = 0.0;
		moneySum = kmMoney + slowDrivingMoney + appointmentMoney + 
				returnDrivingMoney + nightMoney + olimoney;
		System.out.println("总车费："+moneySum+"元");
		
		System.out.println("---产生费用项目详细情况---");
		//输出里程费用
		if (kmMoney>13.0) {
			System.out.println("里程超过3公里，里程价格："+kmMoney);
		}else {
			System.out.println("里程小于3公里，里程价格："+kmMoney);
		}
		//输出低速行驶费
		if (slowDrivingMoney>0.0) {
			System.out.println("低速行驶费一共："+slowDrivingMoney+"元，其中：");
			if (noHeightDrivingMoney>0.0) {
				System.out.println("其他时间段低速行驶费："+noHeightDrivingMoney);
			}
			if (heightDrivingMoney>0.0) {
				System.out.println("早晚高峰时间段低速行驶费："+heightDrivingMoney);
			}
		}else {
			System.out.println("无低速行驶费");
		}
		//输出预约叫车费
		if (appointmentMoney>0.0) {
			System.out.println("预约叫车服务费："+appointmentMoney);
		}else {
			System.out.println("无预约费用");
		}
		//输出空驶费（往返载客费）
		if (returnDrivingMoney>0) {
		System.out.println("空驶费"+returnDrivingMoney);
		}else {
			System.out.println("无空驶费");
		}
		//输出夜间费用
		if (nightMoney>0.0) {
			System.out.println("夜间收费"+nightMoney);
		}else {
			System.out.println("无夜间费用");
		}
		//输出燃料附加费
		System.out.println("燃油附加费："+olimoney+"元");
	}
	
	//计算里程费用
	private static double kmDriving(double km){
		if (km>3.0) {
			//里程费=(里程-3)x基本单价2.3元 +13元
			double kmMoney = (km-3.0)*2.3+13.0;
			//保留整数
			kmMoney = (double) Math.round(kmMoney);

			return kmMoney;
		}else {
			//未满3公里收13元
			double kmMoney = 13.0;

			return kmMoney;
		}
	}
	
	//方法计算预约叫车费
	public static double appointmentDriving(){
		System.out.print("请输入是否预约叫车(是|否)?");
		Scanner inputChoose = new Scanner(System.in);
		String choose = inputChoose.next();//取得用户输入
		if (choose.equals("是")) {
			System.out.print("预约是否在4个小时以内(是|否)?");
			Scanner inputAppointment = new Scanner(System.in);
			String appointment = inputAppointment.next();
			
			if (appointment.equals("是")) {
				//预约叫车费为5元
				double appointmentMoney = 5.0;
				return appointmentMoney;
					
			}else if (appointment.equals("否")) {
				//预约叫车费为6元
				double appointmentMoney = 6.0;
				return appointmentMoney;
			}else {
				//退出程序
				System.out.println("输入有误，“是否在4个小时以内”请输入“是”或者“否”！！！");
				System.exit(0);
			}
		}else if (choose.equals("否")) {
			double appointmentMoney = 0.0;
			return appointmentMoney;
		}else {
			//退出程序
			System.out.println("输入有误，“预约叫车”请输入“是”或者“否”！！！");
			System.exit(0);
		}
		return 0.0;
		
	}
	
	//低速行驶计算价格方法
	public static Map<String, Integer> slowDriving(){
		
		System.out.print("请输入是否有低速行驶(是|否)?");
		Scanner inputChoose = new Scanner(System.in);
		String choose = inputChoose.next();
		
		if (choose.equals("是")) {
			
			System.out.print("请输入不含早晚高峰期间低速行驶时长（分钟）：");
			Scanner noHeight = new Scanner(System.in);
			int noHeightDriving = noHeight.nextInt();
			System.out.print("请输入早晚高峰期间低速行驶时长（分钟）：");
			Scanner height = new Scanner(System.in);
			int heightDriving = height.nextInt();
			
			//早晚高峰期每5分钟加收4.6元，其它时间加收2.3元
			heightDriving = heightDriving/5;
			noHeightDriving = noHeightDriving/5;
			double heightDrivingMoney = heightDriving*4.6;
			double noHeightDrivingMoney = noHeightDriving*2.3;
			//保留整数
			heightDrivingMoney = Math.round(heightDrivingMoney);
			noHeightDrivingMoney = Math.round(noHeightDrivingMoney);
			double slowDrivingMoney =  heightDrivingMoney+noHeightDrivingMoney;

			//map方法把三个值存入map命名再返回,先传整型，出去再改回double
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("noHeightDrivingMoney", (int) noHeightDrivingMoney);
			map.put("heightDrivingMoney", (int) heightDrivingMoney);
			map.put("slowDrivingMoney", (int) slowDrivingMoney);
			return map;
				
		}else if (choose.equals("否")) { //无低速行驶
			int heightDrivingMoney = 0;
			int noHeightDrivingMoney = 0;
			int slowDrivingMoney = 0;
			
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("noHeightDrivingMoney", noHeightDrivingMoney);
			map.put("heightDrivingMoney", heightDrivingMoney);
			map.put("slowDrivingMoney", slowDrivingMoney);
			return map;

		}else {
			System.out.println("“是否低速行驶”请输入“是”或者“否”！！！");
			System.exit(0);
		}
		return null;	
	}
	
	//往返载客方法，计算空使费
	//“往返”：指的是乘客乘坐出租车到目的地之后返回，因此超过规定的里程之后依然按照标准价格收费，
	//因为这种情况下司机不需要空驶返回，因此乘客不用多负担50%的回程费。
	public static double returnDriving(double km){
		System.out.print("请输入是否往返载客(是|否)?");
		Scanner inputChoose = new Scanner(System.in);
		String choose = inputChoose.next();
		
		if (choose.equals("是")) {
			//往返载客不需要空驶费
			double returnDrivingMoney = 0.0;
			return returnDrivingMoney;
			
		}else if (choose.equals("否")) {
			
			if (km<=15) {
			//不超过15公里不需要空驶费
			double returnDrivingMoney = 0.0;
			return returnDrivingMoney;
			
			}else {
				//只收超过15公里部分的费用
				double returnDrivingMoney = (km-15)*(2.3*1.5-2.3);//基本单价加收50%费用
				returnDrivingMoney = (double) Math.round(returnDrivingMoney);

				return returnDrivingMoney;
			}

		}else {
			System.out.println("输入有误，“是否往返”请输入“是”或者“否”！！！");
			System.exit(0);
		}
		return 0;
		
	}
	
	//夜间开车计费
	public static double nightDriving(double km) throws Exception{
		System.out.print("请输入开始乘车时间，24小时制（hh:mm:ss）：");
		Scanner first = new Scanner(System.in);
		String firstTime = first.next();
		System.out.print("请输入结束乘车时间，24小时制（hh:mm:ss）：");
		Scanner last = new Scanner(System.in);
		String lastTime = last.next();
		
		//调用DateFormat的方法把字符串变为时间格式
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		Date timeFirst = df.parse(firstTime);//开始乘车时间
		Date timeLast = df.parse(lastTime);//结束乘车时间
		Date nightTime = df.parse("23:00:00");
		Date morningTime = df.parse("05:00:00");
		//开始乘车时间和结束乘车时间在5~23点之间则不算夜间乘车

		if (nightTime.getTime() >= timeFirst.getTime() && timeFirst.getTime() > morningTime.getTime() &&
			nightTime.getTime() >= timeLast.getTime() && timeLast.getTime() > morningTime.getTime()) {
			
			double nightMoney = 0.0;
			
			return nightMoney;
			}else {
				//夜间乘车费=20%的基本单价x里程
				double nightMoney = 0.0;
				nightMoney = km*2.3*0.2;
				nightMoney = (double) Math.round(nightMoney);
				return nightMoney;	
			}
	}

}
