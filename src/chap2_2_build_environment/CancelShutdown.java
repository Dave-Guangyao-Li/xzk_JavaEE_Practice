package chap2_2_build_environment;

import java.io.IOException;

public class CancelShutdown {
	/**
	 * 取消自动关机的程序
	 * @author DaveGYLi
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Runtime.getRuntime().exec("shutdown -a");	//取消自动关机

	}

}
