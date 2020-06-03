package Chap02;

import java.util.Scanner;

//配列の要素の最大値を表示する（値を読み込む）
public class MaxOfArray {
	//--- 配列aの最大値を求めて返却 ---//
	static int maxOf(int[] a) {
		int max = a[0];
		for (int i = 1; i < a.length; i++)
			if (a[i] > max)
				max = a[i];
		return max;
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("身長の最大値を求めます。");
		System.out.print("人数は：");
		int num = stdIn.nextInt(); // 配列の要素数を読み込む

		int[] height = new int[num]; // 要素数numの配列を生成

		for (int i = 0; i < num; i++) {
			System.out.print("height[" + i + "]：");
			height[i] = stdIn.nextInt();
		}

		System.out.println("最大値は" + maxOf(height) + "です。");
	}
}