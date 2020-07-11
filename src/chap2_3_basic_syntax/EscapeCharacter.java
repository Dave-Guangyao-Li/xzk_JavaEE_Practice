package chap2_3_basic_syntax;

public class EscapeCharacter {
	/**
	 * 常见的转义字符的练习
	 * @param args
	 */
	public static void main(String[] args) {
		String text1 = "\"锄\"禾\\日\n\'当午";
		String text2 = "汗\r滴禾\n下\t土";
		System.out.println(text1);
		System.out.println(text2);
	}

}
