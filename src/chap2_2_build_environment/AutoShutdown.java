package chap2_2_build_environment;

import java.io.IOException;

public class AutoShutdown {

	/**
	 * �ĵ�ע�ͣ������ͣ�ڷ������ϻ���ʾ�����Ϣ����д�����Զ��ػ��ĳ���
	 * @author DaveGYLi
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//����ע��
		/*
		 * ����ע��
		 */
		System.out.println("Demo Test");
		Runtime.getRuntime().exec("shutdown -s -t 3600");	//����runtime��ִ��dos���3600s֮��ػ�
	}

}
