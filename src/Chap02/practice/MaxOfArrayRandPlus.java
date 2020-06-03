package Chap02.practice;

import java.util.Random;

public class MaxOfArrayRandPlus {
	//--- 配列aの最大値を求めて返却 ---//
	private static int maxOf(int[] a) {
		int max = a[0];
		for (int i = 1; i < a.length; i++)
			if (a[i] > max)
				max = a[i];
		return max;
	}

	public static void main(String[] args) {
		Random rand = new Random();

		System.out.println("身長の最大値を求めます。");
		int num = 1 + rand.nextInt(30); // 人数を1～30の乱数とする
		int[] height = new int[num]; // 要素数numの配列を生成

		System.out.println("人数は" + num + "人です。");
		System.out.println("身長は次のようになっています。");
		for (int i = 0; i < num; i++) {
			height[i] = 100 + rand.nextInt(90); // 要素の値を乱数で決定
			System.out.println("height[" + i + "]：" + height[i]);
		}

		System.out.println("最大値は" + maxOf(height) + "です。");
	}
}