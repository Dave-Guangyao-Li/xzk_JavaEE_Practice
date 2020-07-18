package chap3.objectBrientedBasic;

public class Task0713_Object_Oriented_Basics {

	public static void main(String[] args) {
		//1.
		Car car1 = new Car();
		car1.show();
		Car car2 = new Car("奔驰","黑色");
		car2.show();
		Car car3 = new Car();
		car3.setBrand("宝马");
		car3.setColor("白色");
		car3.show();
		//2.
		System.out.println("----------------");
		Game game1 = new Game();
		System.out.println(game1.toString());
		Game game2 = new Game("荒野求生","射击","3GB","PG-13","一款射击竞技游戏");
		System.out.println(game2.toString());
		//3.
		System.out.println("----------------");
		Employee e1 = new Employee("张三","001",5000,0.15);
		System.out.println(e1.toString());
		System.out.println("员工："+e1.getName()+", 编号："+e1.getNumber()+"的薪水增长额为："+e1.calcPayRiseAmount());
		System.out.println("员工："+e1.getName()+", 编号："+e1.getNumber()+"增长后的薪水总额为："+e1.calcPaycheckAfterRise());
		
	}

}
/**
 * 1. 编写 Car 类， 属性有品牌（brand） 和颜色（color） ， show 方法打印所有属性。
 */
class Car{
	//成员属性
	private String brand;
	private String color;
	//成员方法
	public Car() {
		this.brand="默认品牌";
		this.color="默认颜色";
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
 * 2. 定义一个游戏类， 包括游戏的属性包括： 游戏名、 类型、 大小、 星级、介绍等， 可以调用方法输出游戏的介绍。
 */
class Game{
	//游戏名、 类型、 大小、 星级、介绍
	private static String name ;
	private static String type ;
	private static String size ;
	private static String rating ;
	private static String intro ;
	
	public Game() {
		Game.name = "默认名称";
		Game.type = "默认类型";
		Game.size = "默认大小";
		Game.rating = "默认星级";
		Game.intro = "默认介绍";
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
 * 3. 定义并测试一个代表员工的 Employee 类。 它的属性包括“员工姓名” 、“员工号码” 、 “员工基本薪水” 、
 *  “员工薪水增长率” ； 他的方法包括“构造方法” 、 “获取员工姓名” 、 “获取员工号码” 、 “获取员工基本薪水” 、
 *  “计算薪水增长额” 及“计算增长后的工资总额”
 */
class Employee{
	//属性 “员工姓名” 、“员工号码” 、 “员工基本薪水” 、*  “员工薪水增长率”
	private String name ;
	private String number ;
	private double basicSalary ;
	private static final double payRiseRate = 0.25 ; //涨薪率固定
	//方法包括“构造方法” 、 “获取员工姓名” 、 “获取员工号码” 、 “获取员工基本薪水” 、 “计算薪水增长额” 及“计算增长后的工资总额”
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