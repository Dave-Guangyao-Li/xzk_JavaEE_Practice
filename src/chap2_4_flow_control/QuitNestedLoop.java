package chap2_4_flow_control;

public class QuitNestedLoop {
	/**
	 * ����˳�����ѭ��
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// ��������ѭ����һ������
		loopOutside: for (int i = 0; i < 10; i++) {
			loopInside: for (int j = 0; j < 10; j++) {
				System.out.println("i=" + i + ", " + "j=" + j);
				if (i == 5 && j == 5) {
					break loopOutside;
				}
			}
		}

	}

}
