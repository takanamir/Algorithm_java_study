package Chap03;

import java.util.Arrays;
import java.util.Scanner;

//文字列の配列（Javaのキーワード）からの探索
public class StringBinarySearch {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		String[] x = { // Javaのキーワード：アルファベット順
				"abstract", "assert", "boolean", "break", "byte",
				"case", "catch", "char", "class", "const",
				"continue", "default", "do", "double", "else",
				"enum", "extends", "final", "finally", "float",
				"for", "goto", "if", "implements", "import",
				"instanceof", "int", "interface", "long", "native",
				"new", "package", "private", "protected", "public",
				"return", "short", "static", "strictfp", "super",
				"switch", "synchronized", "this", "throw", "throws",
				"transient", "try", "void", "volatile", "while"
		};

		System.out.print("何を探しますか："); // キー値の読込み
		String ky = stdIn.next();

		int idx = Arrays.binarySearch(x, ky); // 配列xから値がkyの要素を探索

		if (idx < 0)
			System.out.println("そのキーワードは存在しません。");
		else
			System.out.println("それはx[" + idx + "]にあります。");
	}
}