package chap3.objectOrientedHigher;

public class ObjectOrientedHigherTask0714_ {

	public static void main(String[] args) {
		//1.
		Book b1 = new Book();
		b1.setTitle("书本1");
		b1.setPageNum(250);
		b1.detail();
		Book b2 = new Book();
		b2.setTitle("书本2");
		b2.setPageNum(100);
		b2.detail();
		//2.
		KaikebaLearner p1 = new KaikebaLearner();
		System.out.println(p1.toString());
		KaikebaLearner p2 = new KaikebaLearner("李四",22,"男","编程");
		System.out.println(p2.toString());
		//3.
		Clothe c1 = new Clothe("衣服1","汉服","红色");
		System.out.println(c1.toString());
		Clothe c2 = new Clothe("衣服2","和服","白色");
		System.out.println(c2.toString());
		Clothe c3 = new Clothe("衣服3","韩服","蓝色");
		System.out.println(c3.toString());
	}

}


/**
 * 1.编写一个类 Book， 代表图书。
 * 具有属性： 名称（title） 、 页数（pageNum） ， 其中页数不能少于 200页， 否则输出错误信息， 并赋予默认值 200。
 * 具有方法: 为各属性设置赋值和取值方法。 detail()方法用来在控制台输出每本图书的名称和页数
 * 编写测试类 BookTest 进行测试： 为 Book 对象的属性赋予初始值， 并调用 Book 对象的 detail 方法， 看看输出是否正确
 * 思考： 请结合 static 修饰属性进行更好的类设计。
 */
class Book{
	//属性 - 特征
	private String title;//名称
	private static int pageNum;//页数，静态变量
	//方法 - 行为
	//赋值和取值方法
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		//页数不能少于 200页
		if(pageNum<200) {
			System.out.println("页数不能少于200！");
			Book.pageNum = 200;//类名.静态属性
		}
		else {
			Book.pageNum = pageNum;
		}
			
	}

	public void detail() {
		System.out.println("书籍信息细节如下\n名称："+title+" , 页数："+pageNum);
	}
}
	
	
/**
 * 2. 通过类描述开课吧的 Java 学员。
 * 具有属性： 姓名， 年龄， 性别， 爱好， 公司（都是： 开课吧） ， 学科（都是： Java 学科） 。
 */
class KaikebaLearner {
//	姓名， 年龄， 性别， 爱好， 公司（都是： 开课吧）， 学科（都是： Java 学科） 。
	private String name ;
	private int age ;
	private String gender;
	private String hobby;
	private static String company;
	private static String subject;
	
	public KaikebaLearner() {
		super();
		this.name = "默认姓名";
		this.age = 20;
		this.gender = "男";
		this.hobby = "默认兴趣";
		KaikebaLearner.company="开课吧";
		KaikebaLearner.subject="Java";
	}
	@Override
	public String toString() {
		return "KaikebaLearner [name=" + name + ", age=" + age + ", gender=" + gender + ", hobby=" + hobby + ", company=" + company + ", sunbject=" + subject +"]";
	}
	public KaikebaLearner(String name, int age, String gender, String hobby) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.hobby = hobby;
		KaikebaLearner.company="开课吧";
		KaikebaLearner.subject="Java";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public static String getCompany() {
		return company;
	}
	public static String getSubject() {
		return subject;
	}
	
}

/**
 * 3. 通过类描述衣服， 每个衣服对象创建时需要自动生成一个序号值。
 * 要求： 每个衣服的序号是不同的， 且是依次递增 1的。
 */
//参考：java统计一个类中创建对象的个数，并使对象id递增---static关键字的使用 https://blog.csdn.net/hju22/article/details/83873941
class Clothe{
	private static int count=0;   //存储创建对象的总数
	private int num;
	private String name;
	private String type;
	private String color;
	
	public int getNum() {
		return this.num;
	}
	public Clothe(String name, String type, String color) {
		super();
		this.num=++count;
		this.name = name;
		this.type = type;
		this.color = color;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "clothe [num=" + num + ", name=" + name + ", type=" + type + ", color=" + color + "]";
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
}
