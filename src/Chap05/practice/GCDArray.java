package Chap05.practice;

import java.util.Scanner;

// 配列の全要素の最大公約数を求める
public class GCDArray {
	//--- 整数値x, yの最大公約数を非再帰的に求めて返却 ---//
	private static int gcd(int x, int y) {
		while (y != 0) {
			int temp = y;
			y = x % y;
			x = temp;
		}
		return x;
	}

	/*--- 要素数nの配列aの全要素の最大公約数を求める ---*/
	private static int gcdArray(int a[], int start, int no) {
		if (no == 1) {
			return a[start];
		} else if (no == 2) {
			return gcd(a[start], a[start + 1]);
		} else {
			return gcd(a[start], gcdArray(a, start + 1, no - 1));
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("何個の整数の最大公約数を求めますか：");
		int num;
		do {
			num = stdIn.nextInt();
		} while (num <= 1);

		int[] x = new int[num]; // 長さnumの配列

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "]：");
			x[i] = stdIn.nextInt();
		}

		System.out.println("最大公約数は" + gcdArray(x, 0, num) + "です。");
		stdIn.close();
	}
}