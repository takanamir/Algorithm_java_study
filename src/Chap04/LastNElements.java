package Chap04;

import java.util.Scanner;

//好きな個数だけ値を読み込んで要素数Nの配列に最後のN個を格納
public class LastNElements {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		final int N = 10;
		int[] a = new int[N]; // 読み込んだ値を格納
		int cnt = 0; // 読み込んだ個数
		int retry; // もう一度？

		System.out.println("整数を入力してください。");

		do {
			System.out.printf("%d個目の整数：", cnt + 1);
			a[cnt++ % N] = stdIn.nextInt();

			System.out.print("続けますか？（Yes…1／No…0）：");
			retry = stdIn.nextInt();
		} while (retry == 1);

		int i = cnt - N;
		if (i < 0)
			i = 0;

		for (; i < cnt; i++)
			System.out.printf("%2d個目＝ %d\n", i + 1, a[i % N]);
	}
}