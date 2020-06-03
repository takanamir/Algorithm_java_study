package Chap01.practice;

import java.util.Scanner;

public class Min4 {
	//--- a, b, c, dの最小値を求めて返却 ---//
	private static int min4(int a, int b, int c, int d) {
		int min = a; // 最小値
		if (b < min)
			min = b;
		if (c < min)
			min = c;
		if (d < min)
			min = d;

		return min;
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int a, b, c, d;

		System.out.println("四つの整数の最小値を求めます。");
		System.out.print("aの値：");
		a = stdIn.nextInt();
		System.out.print("bの値：");
		b = stdIn.nextInt();
		System.out.print("cの値：");
		c = stdIn.nextInt();
		System.out.print("dの値：");
		d = stdIn.nextInt();

		int min = min4(a, b, c, d); // a, b, c, dの最小値

		System.out.println("最小値は" + min + "です。");
	}
}