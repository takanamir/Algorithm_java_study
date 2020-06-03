package Chap01;

import java.util.Scanner;

//1, 2, …, nの和を求める（do文によって正の整数値のみをnに読み込む）
public class SumForPos {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n;

		System.out.println("1からnまでの和を求めます。");

		do {
			System.out.print("nの値：");
			n = stdIn.nextInt();
		} while (n <= 0);

		int sum = 0;		// 和

		for (int i = 1; i <= n; i++)
			sum += i;					// sumにiを加える

		System.out.println("1から" + n + "までの和は" + sum + "です。");
	}
}