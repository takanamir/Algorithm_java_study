package Chap01;

import java.util.Scanner;

//三つの整数値を読み込んで中央値を求めて表示
public class Median {

	static int med3(int a, int b, int c) {
		if (a >= b)
			if (b >= c)
				return b;
			else if (a <= c)
				return a;
			else
				return c;
		else if (a > c)
			return a;
		else if (b > c)
			return c;
		else
			return b;
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("三つの整数の中央値を求めます。");
		System.out.print("aの値：");
		int a = stdIn.nextInt();
		System.out.print("bの値：");
		int b = stdIn.nextInt();
		System.out.print("cの値：");
		int c = stdIn.nextInt();

		System.out.println("中央値は" + med3(a, b, c) + "です。");
	}
}