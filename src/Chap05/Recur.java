package Chap05;

import java.util.Scanner;

//再帰に対する理解を深めるための真に再帰的なメソッド
public class Recur {
	//--- 真に再帰的なメソッド ---//
	static void recur(int n) {
		if (n > 0) {
			recur(n - 1);
			System.out.println(n);
			recur(n - 2);
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("整数を入力せよ：");
		int x = stdIn.nextInt();

		recur(x);
	}
}