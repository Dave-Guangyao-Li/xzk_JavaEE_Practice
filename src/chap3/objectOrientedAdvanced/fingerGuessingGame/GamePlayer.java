package chap3.objectOrientedAdvanced.fingerGuessingGame;
/**
 * ���ڲ�ȭ��Ϸ�û���һϵ����Ϣ�Ͳ���
 * ���ԣ�����ĳ�ȭ������ʯͷ�������û�������ǰ����
 * @author DaveGYLi
 *
 */
public class GamePlayer {

	private String username;//�û���
	private int gesture;//����ĳ�ȭ
	private int score;//��ǰ����
	
	public GamePlayer(String username, int gesture, int score) {
		super();
		this.username = username;
		this.gesture = gesture;
		this.score = score;
	}
	public GamePlayer() {

		super();

	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getGesture() {
		return gesture;
	}
	public void setGesture(int gesture) {
		this.gesture = gesture;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "GamePlayer [username=" + username + ", gesture=" + gesture + ", score=" + score + "]";
	}
	

}
