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
		MyList l1 = new MyList(2);//�½�MyList����
		l1.add(1);
		l1.add(2);
		l1.add(3);
		System.out.println("�б��ȣ�"+l1.getSize());
		System.out.println("�б�Ԫ�أ�");
		for(int i = 0; i<l1.getSize();i++) {
			System.out.println(l1.getElement(i));
		}
		l1.remove(0);
		l1.remove(1);
//		l1.remove(2); �±�Խ���׳��쳣
		System.out.println("�б�Ԫ�أ�");
		for(int i = 0; i<l1.getSize();i++) {
			System.out.println(l1.getElement(i));
		}

	}

}
/**
 * 1. ���⣺ �����û��˺�Ϊ�� admin�� ����Ϊ 123�� ��д�û���½������ 
 * Ҫ�� �뽫��½����Ϊ login ������ ���� login ����д�� UserService ����
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
		System.out.println("��������Ϊ���˺ţ�"+username+"�����룺"+password);
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
			System.out.println("��½�ɹ�������ǰ�˺ţ�"+UserService.correctUsername);
			return true;
		}else {
			System.out.println("��������˺Ż��������������¼�����룡");
			return false;
		}
	}
}

/**
 * 2. ���⣺ ����һ���࣬ ����Ϊ MyList
 * ���а������ԣ� Object[] element
 * ���������¼�����
 * 1. ���ӷ��� add �� �������������������δ洢 Object�� �������ݴ���ʱ�� ��ʵ�ֶ�̬���ݣ���������棩 ��
 * 2. ɾ������ remove �� ���Ը������ݻ��±꣬ ������������ɾ��Object ���ݣ� ɾ���� �������Ԫ����ǰ�ơ�
 * 3. ��ѯ���� get �� ���������±꣬ ����������ָ���±�����ݡ�
 * 4. ��ǰ�洢������ size �� ��ȡ��ǰ�洢����Ч���ݳ���
 * ��̬������⣺ ������������ԭ����������� ֻ�ý�ԭ���ݸ��Ƶ��µĴ����飬 Ȼ����ԭ�����������µ��ڴ����鼴�ɡ�
 * 		����ԭ���������ڶ��У�ʧȥ���ûᱻ GC �Զ����ա�
 */
class MyList{
	private Object[] element;//��������
	private int size;//Ŀǰ������Ԫ�ظ���

	public MyList(int size) {
		this.element = new Object[size];//��ʼ������
	}

	public void add(Object obj) {
		if(this.size>=this.element.length) {//��������������
			Object[] newArray = new Object[this.element.length+10];
			for(int i = 0; i < this.element.length; i++) {
				newArray[i] = this.element[i];//������������
			}
			this.element = newArray;//ָ���µ�����
			newArray[size] = obj;//������Ԫ������������ĩβ
			this.size++;
		}
		else {
			this.element[size] = obj;//������Ԫ������������ĩβ
			this.size++;
		}
	}
	public void remove(int index) {//�Ƴ�ָ��λ��Ԫ��
		if(index<0 || index>this.size){
			throw new ArrayIndexOutOfBoundsException("����Խ���ˣ�������Χ�ǣ�0~"+(size-1));
		}
		System.arraycopy(this.element, index+1, this.element, index, size-index-1);//������������ɾ��Object ���ݣ� ɾ���� �������Ԫ����ǰ�ơ�
		size--;
	}
	public Object getElement(int index) {//���������±꣬ ����������ָ���±�����ݡ�
		if(index<0||index>size){
			throw new ArrayIndexOutOfBoundsException("����Խ���ˣ�������Χ�ǣ�0~"+(size-1));
		}
		return this.element[index];
	}
	public int getSize() {//�õ����鳤��
		return this.size;
	}

	@Override
	public String toString() {
		return "MyList [element=" + Arrays.toString(element) + ", size=" + size + "]";
	}
	
}
//�ο���Java���ݽṹ֮�Զ���ʵ��List���� https://blog.csdn.net/boy1397081650/article/details/89492020
