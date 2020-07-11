package chap2_2_build_environment;

import java.io.IOException;

public class AutoShutdown {

	/**
	 * 文档注释，鼠标悬停在方法名上会显示相关信息，编写用于自动关机的程序
	 * @author DaveGYLi
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//单行注释
		/*
		 * 多行注释
		 */
		System.out.println("Demo Test");
		Runtime.getRuntime().exec("shutdown -s -t 3600");	//利用runtime来执行dos命令：3600s之后关机
	}

}
