package Chap01;

import java.util.Scanner;

//1, 2, …, nの和を求める（while文）
public class SumWhile {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("1からnまでの和を求めます。");
		System.out.print("nの値：");
		int n = stdIn.nextInt();

		int sum = 0; // 和
		int i = 1;

		while (i <= n) { // iがn以下であれば繰り返す
			sum += i; // sumにiを加える
			i++; // iの値をインクリメント
		}
		System.out.println("1から" + n + "までの和は" + sum + "です。");
	}
}