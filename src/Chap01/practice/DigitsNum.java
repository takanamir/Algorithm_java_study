package Chap01.practice;

import java.util.Scanner;

//正の整数値の桁数を表示
public class DigitsNum {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("正の整数値の桁数を求めます。");

		int n;
		do {
			System.out.print("整数値：");
			n = stdIn.nextInt();
		} while (n <= 0);

		int no = 0; // 桁数
		while (n > 0) {
			n /= 10; // nを10で割る
			no++;
		}

		System.out.println("その数は" + no + "桁です。");
	}
}