package chap2_2_build_environment;

import java.io.IOException;

public class CancelShutdown {
	/**
	 * ȡ���Զ��ػ��ĳ���
	 * @author DaveGYLi
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Runtime.getRuntime().exec("shutdown -a");	//ȡ���Զ��ػ�

	}

}
