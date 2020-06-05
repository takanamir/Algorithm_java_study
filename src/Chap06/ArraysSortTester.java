package Chap06;

import java.util.Arrays;
import java.util.Scanner;

//Arrays.sortによるソート（クイックソート）
public class ArraysSortTester {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("要素数：");
		int num = stdIn.nextInt();
		int[] x = new int[num]; // 長さnumの配列

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "]：");
			x[i] = stdIn.nextInt();
		}

		Arrays.sort(x); // 配列xをソート

		System.out.println("昇順にソートしました。");
		for (int i = 0; i < num; i++)
			System.out.println("x[" + i + "]＝" + x[i]);
	}
}