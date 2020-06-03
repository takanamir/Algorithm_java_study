package Chap02;

import java.util.Random;
import java.util.Scanner;

//配列の要素の最大値を表示する（値は乱数で生成）
public class MaxOfArrayRand {
	//--- 配列aの最大値を求めて返却 ---//
	static int maxOf(int[] a) {
		int max = a[0];
		for (int i = 1; i < a.length; i++)
			if (a[i] > max)
				max = a[i];
		return max;
	}

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner stdIn = new Scanner(System.in);

		System.out.println("身長の最大値を求めます。");
		System.out.print("人数は：");
		int num = stdIn.nextInt(); // 配列の要素数を読み込む

		int[] height = new int[num]; // 要素数numの配列を生成

		System.out.println("身長は次のようになっています。");
		for (int i = 0; i < num; i++) {
			height[i] = 100 + rand.nextInt(90); // 要素の値を乱数で決定
			System.out.println("height[" + i + "]：" + height[i]);
		}

		System.out.println("最大値は" + maxOf(height) + "です。");
	}
}