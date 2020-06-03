package Chap01.practice;

import java.util.Scanner;

//1, 2, …, nの和を求める
public class SumForOther {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("1からnまでの和を求めます。");
		System.out.print("nの値：");
		int n = stdIn.nextInt();

		int sum = 0; // 和

		for (int i = 1; i < n; i++) {
			System.out.print(i + " + ");
			sum += i; // sumにiを加える
		}
		System.out.print(n + " ");
		sum += n; // sumにnを加える
		System.out.println("= " + sum);
	}
}