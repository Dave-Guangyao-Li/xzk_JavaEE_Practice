package chap2_4_flow_control;

public class QuitNestedLoop {
	/**
	 * 如何退出多重循环
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 方法：给循环起一个别名
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
