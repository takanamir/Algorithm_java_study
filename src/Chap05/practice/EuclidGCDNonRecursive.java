package Chap05.practice;

import java.util.Scanner;

// ユークリッドの互除法によって最大公約数を非再帰的に求める
public class EuclidGCDNonRecursive {
	//--- 整数値x, yの最大公約数を非再帰的に求めて返却 ---//
	private static int gcd(int x, int y) {
		while (y != 0) {
			int temp = y;
			y = x % y;
			x = temp;
		}
		return x;
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("二つの整数の最大公約数を求めます。");

		System.out.print("1つ目の整数を入力せよ：");
		int x = stdIn.nextInt();
		System.out.print("2つ目の整数を入力せよ：");
		int y = stdIn.nextInt();

		System.out.println("最大公約数は" + gcd(x, y) + "です。");
		stdIn.close();
	}
}