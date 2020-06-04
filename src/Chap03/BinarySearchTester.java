package Chap03;

import java.util.Arrays;
import java.util.Scanner;

//Arrays.binarySearchによる２分探索
public class BinarySearchTester {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("要素数：");
		int num = stdIn.nextInt();
		int[] x = new int[num]; // 要素数numの配列

		System.out.println("昇順に入力してください。");

		System.out.print("x[0]："); // 先頭要素の読込み
		x[0] = stdIn.nextInt();

		for (int i = 1; i < num; i++) {
			do {
				System.out.print("x[" + i + "]：");
				x[i] = stdIn.nextInt();
			} while (x[i] < x[i - 1]); // 一つ前の要素より小さければ再入力
		}

		System.out.print("探す値："); // キー値の読込み
		int ky = stdIn.nextInt();

		int idx = Arrays.binarySearch(x, ky); // 配列xから値がkyの要素を探索

		if (idx < 0)
			System.out.println("その値の要素は存在しません。");
		else
			System.out.println("その値はx[" + idx + "]にあります。");
	}
}