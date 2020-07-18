package chap3.objectOrientedHigher;

public class ObjectOrientedHigherTask0714_ {

	public static void main(String[] args) {
		//1.
		Book b1 = new Book();
		b1.setTitle("�鱾1");
		b1.setPageNum(250);
		b1.detail();
		Book b2 = new Book();
		b2.setTitle("�鱾2");
		b2.setPageNum(100);
		b2.detail();
		//2.
		KaikebaLearner p1 = new KaikebaLearner();
		System.out.println(p1.toString());
		KaikebaLearner p2 = new KaikebaLearner("����",22,"��","���");
		System.out.println(p2.toString());
		//3.
		Clothe c1 = new Clothe("�·�1","����","��ɫ");
		System.out.println(c1.toString());
		Clothe c2 = new Clothe("�·�2","�ͷ�","��ɫ");
		System.out.println(c2.toString());
		Clothe c3 = new Clothe("�·�3","����","��ɫ");
		System.out.println(c3.toString());
	}

}


/**
 * 1.��дһ���� Book�� ����ͼ�顣
 * �������ԣ� ���ƣ�title�� �� ҳ����pageNum�� �� ����ҳ���������� 200ҳ�� �������������Ϣ�� ������Ĭ��ֵ 200��
 * ���з���: Ϊ���������ø�ֵ��ȡֵ������ detail()���������ڿ���̨���ÿ��ͼ������ƺ�ҳ��
 * ��д������ BookTest ���в��ԣ� Ϊ Book ��������Ը����ʼֵ�� ������ Book ����� detail ������ ��������Ƿ���ȷ
 * ˼���� ���� static �������Խ��и��õ�����ơ�
 */
class Book{
	//���� - ����
	private String title;//����
	private static int pageNum;//ҳ������̬����
	//���� - ��Ϊ
	//��ֵ��ȡֵ����
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
		//ҳ���������� 200ҳ
		if(pageNum<200) {
			System.out.println("ҳ����������200��");
			Book.pageNum = 200;//����.��̬����
		}
		else {
			Book.pageNum = pageNum;
		}
			
	}

	public void detail() {
		System.out.println("�鼮��Ϣϸ������\n���ƣ�"+title+" , ҳ����"+pageNum);
	}
}
	
	
/**
 * 2. ͨ�����������ΰɵ� Java ѧԱ��
 * �������ԣ� ������ ���䣬 �Ա� ���ã� ��˾�����ǣ� ���ΰɣ� �� ѧ�ƣ����ǣ� Java ѧ�ƣ� ��
 */
class KaikebaLearner {
//	������ ���䣬 �Ա� ���ã� ��˾�����ǣ� ���ΰɣ��� ѧ�ƣ����ǣ� Java ѧ�ƣ� ��
	private String name ;
	private int age ;
	private String gender;
	private String hobby;
	private static String company;
	private static String subject;
	
	public KaikebaLearner() {
		super();
		this.name = "Ĭ������";
		this.age = 20;
		this.gender = "��";
		this.hobby = "Ĭ����Ȥ";
		KaikebaLearner.company="���ΰ�";
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
		KaikebaLearner.company="���ΰ�";
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
 * 3. ͨ���������·��� ÿ���·����󴴽�ʱ��Ҫ�Զ�����һ�����ֵ��
 * Ҫ�� ÿ���·�������ǲ�ͬ�ģ� �������ε��� 1�ġ�
 */
//�ο���javaͳ��һ�����д�������ĸ�������ʹ����id����---static�ؼ��ֵ�ʹ�� https://blog.csdn.net/hju22/article/details/83873941
class Clothe{
	private static int count=0;   //�洢�������������
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
