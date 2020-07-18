package chap3.objectBrientedBasic;

public class Task0713_Object_Oriented_Basics {

	public static void main(String[] args) {
		//1.
		Car car1 = new Car();
		car1.show();
		Car car2 = new Car("����","��ɫ");
		car2.show();
		Car car3 = new Car();
		car3.setBrand("����");
		car3.setColor("��ɫ");
		car3.show();
		//2.
		System.out.println("----------------");
		Game game1 = new Game();
		System.out.println(game1.toString());
		Game game2 = new Game("��Ұ����","���","3GB","PG-13","һ�����������Ϸ");
		System.out.println(game2.toString());
		//3.
		System.out.println("----------------");
		Employee e1 = new Employee("����","001",5000,0.15);
		System.out.println(e1.toString());
		System.out.println("Ա����"+e1.getName()+", ��ţ�"+e1.getNumber()+"��нˮ������Ϊ��"+e1.calcPayRiseAmount());
		System.out.println("Ա����"+e1.getName()+", ��ţ�"+e1.getNumber()+"�������нˮ�ܶ�Ϊ��"+e1.calcPaycheckAfterRise());
		
	}

}
/**
 * 1. ��д Car �࣬ ������Ʒ�ƣ�brand�� ����ɫ��color�� �� show ������ӡ�������ԡ�
 */
class Car{
	//��Ա����
	private String brand;
	private String color;
	//��Ա����
	public Car() {
		this.brand="Ĭ��Ʒ��";
		this.color="Ĭ����ɫ";
	}
	
	public Car(String brand, String color) {
		this.brand=brand;
		this.color=color;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public void show() {
		System.out.println("Car [brand=" + brand + ", color=" + color + "]");
	}
}
/**
 * 2. ����һ����Ϸ�࣬ ������Ϸ�����԰����� ��Ϸ���� ���͡� ��С�� �Ǽ������ܵȣ� ���Ե��÷��������Ϸ�Ľ��ܡ�
 */
class Game{
	//��Ϸ���� ���͡� ��С�� �Ǽ�������
	private static String name ;
	private static String type ;
	private static String size ;
	private static String rating ;
	private static String intro ;
	
	public Game() {
		Game.name = "Ĭ������";
		Game.type = "Ĭ������";
		Game.size = "Ĭ�ϴ�С";
		Game.rating = "Ĭ���Ǽ�";
		Game.intro = "Ĭ�Ͻ���";
	}
	
	public Game(String name, String type, String size, String rating, String intro) {
		Game.name = name;
		Game.type = type;
		Game.size = size;
		Game.rating = rating;
		Game.intro = intro;
	}

	@Override
	public String toString() {
		return "Game [name=" + Game.name+ ", type=" + Game.type + ", "
				+ "size=" + Game.size + ", rating=" + Game.rating + ", "
						+ "intro=" + Game.intro + "]";
	}
	
	
}
/**
 * 3. ���岢����һ������Ա���� Employee �ࡣ �������԰�����Ա�������� ����Ա�����롱 �� ��Ա������нˮ�� ��
 *  ��Ա��нˮ�����ʡ� �� ���ķ������������췽���� �� ����ȡԱ�������� �� ����ȡԱ�����롱 �� ����ȡԱ������нˮ�� ��
 *  ������нˮ����� ��������������Ĺ����ܶ
 */
class Employee{
	//���� ��Ա�������� ����Ա�����롱 �� ��Ա������нˮ�� ��*  ��Ա��нˮ�����ʡ�
	private String name ;
	private String number ;
	private double basicSalary ;
	private static final double payRiseRate = 0.25 ; //��н�ʹ̶�
	//�������������췽���� �� ����ȡԱ�������� �� ����ȡԱ�����롱 �� ����ȡԱ������нˮ�� �� ������нˮ����� ��������������Ĺ����ܶ
	public Employee(String name, String number, double basicSalary, double payRiseRate) {
		this.name = name;
		this.number = number;
		this.basicSalary = basicSalary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public double getBasicSalary() {
		return this.basicSalary;
	}
	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}
	public static double getPayRiseRate() {
		return payRiseRate;
	}
	public double calcPayRiseAmount() {
		return Employee.getPayRiseRate()*this.getBasicSalary();
	}
	public double calcPaycheckAfterRise() {
		return this.getBasicSalary()*(1+Employee.getPayRiseRate());
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", number=" + number + ", basicSalary=" + basicSalary + ", payRiseRate="+ payRiseRate+"]";
	}














}