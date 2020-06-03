package Chap01.practice;

import java.util.Scanner;

//ガウスの公式によって1, 2, …, nの和を求める
public class SumGauss {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("1からnまでの和を求めます。");
		System.out.print("nの値：");
		int n = stdIn.nextInt();

		int sum = (n + 1) * (n / 2) + (n % 2 == 1 ? (n + 1) / 2 : 0); // 和

		System.out.println("1から" + n + "までの和は" + sum + "です。");
	}
}