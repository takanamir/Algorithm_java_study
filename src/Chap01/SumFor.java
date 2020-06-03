package Chap01;

import java.util.Scanner;

//1, 2, …, nの和を求める（for文）
public class SumFor {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("1からnまでの和を求めます。");
		System.out.print("nの値：");
		int n = stdIn.nextInt();

		int sum = 0; // 和

		for (int i = 1; i <= n; i++)
			sum += i; // sumにiを加える

		System.out.println("1から" + n + "までの和は" + sum + "です。");
	}
}