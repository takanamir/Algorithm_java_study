package Chap01.practice;

import java.util.Scanner;

public class Max4 {
	//--- a, b, c, dの最大値を求めて返却 ---//
	private static int max4(int a, int b, int c, int d) {
		int max = a; // 最大値
		if (b > max)
			max = b;
		if (c > max)
			max = c;
		if (d > max)
			max = d;

		return max;
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int a;
		int b;
		int c;
		int d;

		System.out.println("四つの整数の最大値を求めます。");
		System.out.print("aの値：");
		a = stdIn.nextInt();
		System.out.print("bの値：");
		b = stdIn.nextInt();
		System.out.print("cの値：");
		c = stdIn.nextInt();
		System.out.print("dの値：");
		d = stdIn.nextInt();

		int max = max4(a, b, c, d); // a, b, c, dの最大値

		System.out.println("最大値は" + max + "です。");
	}
}