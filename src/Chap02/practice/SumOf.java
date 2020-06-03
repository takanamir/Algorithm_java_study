package Chap02.practice;

import java.util.Scanner;

//配列の全要素の合計値を求める
public class SumOf {
	//--- 配列aの要素の値を表示 ---//
	private static int sumOf(int[] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++)
			sum += a[i];
		return (sum);
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("要素数は：");
		int num = stdIn.nextInt(); // 要素数

		int[] a = new int[num]; // 要素数numの配列

		for (int i = 0; i < num; i++) {
			System.out.print("a[" + i + "] : ");
			a[i] = stdIn.nextInt();
		}

		System.out.println("全要素の合計は" + sumOf(a) + "です。");
	}
}