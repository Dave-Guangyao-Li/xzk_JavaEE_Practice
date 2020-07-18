package chap3.objectOrientedAdvanced;

import java.util.Arrays;

public class ObjectOrientedAdvancedTask07150716 {

	public static void main(String[] args) {
		//1.
		UserService u1 = new UserService("xxx","12345");
		u1.login();
		UserService u2 = new UserService("admin","123");
		u2.login();
		UserService u3 = new UserService("random","123456");
		u3.setUsername("user3");
		u3.setPassword("33333");
		u3.login();
		//2.
		System.out.println("-----------------");
		MyList l1 = new MyList(2);//新建MyList对象
		l1.add(1);
		l1.add(2);
		l1.add(3);
		System.out.println("列表长度："+l1.getSize());
		System.out.println("列表元素：");
		for(int i = 0; i<l1.getSize();i++) {
			System.out.println(l1.getElement(i));
		}
		l1.remove(0);
		l1.remove(1);
//		l1.remove(2); 下标越界抛出异常
		System.out.println("列表元素：");
		for(int i = 0; i<l1.getSize();i++) {
			System.out.println(l1.getElement(i));
		}

	}

}
/**
 * 1. 试题： 假设用户账号为： admin， 密码为 123， 编写用户登陆案例。 
 * 要求： 请将登陆定义为 login 方法， 并将 login 方法写在 UserService 类中
 */
class UserService{
	private static final String correctUsername = "admin";
	private static final String correctPassword = "123";
	
	private String username;
	private String password;
	
	public UserService(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		System.out.println("您的输入为：账号："+username+"，密码："+password);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	@Override
	public String toString() {
		return "UserService [username=" + username + ", password=" + password + "]";
	}

	public boolean login() {
		System.out.println(this.toString());
		if(this.password==UserService.correctPassword && this.username==UserService.correctUsername) {
			System.out.println("登陆成功！，当前账号："+UserService.correctUsername);
			return true;
		}else {
			System.out.println("您输入的账号或密码有误，请重新检查输入！");
			return false;
		}
	}
}

/**
 * 2. 试题： 设置一个类， 命名为 MyList
 * 类中包含属性： Object[] element
 * 方法有如下几个：
 * 1. 增加方法 add ： 可以向数组属性中依次存储 Object， 数组内容存满时， 需实现动态扩容（详解在下面） 。
 * 2. 删除方法 remove ： 可以根据数据或下标， 从数组属性中删除Object 数据， 删除后， 数组后续元素需前移。
 * 3. 查询方法 get ： 方法传入下标， 返回数组中指定下标的数据。
 * 4. 当前存储数据量 size ： 获取当前存储的有效数据长度
 * 动态扩容详解： 无需真正增加原数组的容量， 只用将原内容复制到新的大数组， 然后让原数组名称重新等于大数组即可。
 * 		由于原数组数据在堆中，失去引用会被 GC 自动回收。
 */
class MyList{
	private Object[] element;//代表数组
	private int size;//目前的数组元素个数

	public MyList(int size) {
		this.element = new Object[size];//初始化数组
	}

	public void add(Object obj) {
		if(this.size>=this.element.length) {//数组满了则扩容
			Object[] newArray = new Object[this.element.length+10];
			for(int i = 0; i < this.element.length; i++) {
				newArray[i] = this.element[i];//拷贝到新数组
			}
			this.element = newArray;//指向新的数组
			newArray[size] = obj;//新增的元素添加在数组的末尾
			this.size++;
		}
		else {
			this.element[size] = obj;//新增的元素添加在数组的末尾
			this.size++;
		}
	}
	public void remove(int index) {//移除指定位置元素
		if(index<0 || index>this.size){
			throw new ArrayIndexOutOfBoundsException("数组越界了，索引范围是：0~"+(size-1));
		}
		System.arraycopy(this.element, index+1, this.element, index, size-index-1);//从数组属性中删除Object 数据， 删除后， 数组后续元素需前移。
		size--;
	}
	public Object getElement(int index) {//方法传入下标， 返回数组中指定下标的数据。
		if(index<0||index>size){
			throw new ArrayIndexOutOfBoundsException("数组越界了，索引范围是：0~"+(size-1));
		}
		return this.element[index];
	}
	public int getSize() {//得到数组长度
		return this.size;
	}

	@Override
	public String toString() {
		return "MyList [element=" + Arrays.toString(element) + ", size=" + size + "]";
	}
	
}
//参考：Java数据结构之自定义实现List集合 https://blog.csdn.net/boy1397081650/article/details/89492020
