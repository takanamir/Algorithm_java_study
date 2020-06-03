package Chap02.practice;

import java.util.Scanner;

public class CardConvPlus {
	//--- 整数値xをr進数に変換して配列dに下位桁から格納して桁数を返却 ---//
	private static int cardConvEx(int x, int r, char[] d) {
		int n = ((Integer) x).toString().length(); // 変換前の桁数
		int digits = 0; // 変換後の桁数
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		System.out.printf(String.format("%%2d | %%%dd\n", n), r, x);
		do {
			System.out.printf("   +");
			for (int i = 0; i < n + 2; i++) {
				System.out.print('-');
			}
			System.out.println();

			if (x / r != 0) {
				System.out.printf(String.format("%%2d | %%%dd    … %%d\n", n),
						r, x / r, x % r);
			} else {
				System.out.printf(String.format("     %%%dd    … %%d\n", n),
						x / r, x % r);
			}
			d[digits++] = dchar.charAt(x % r); // rで割った剰余を格納
			x /= r;
		} while (x != 0);

		for (int i = 0; i < digits / 2; i++) { // d[0]～d[digits-1]
			char temp = d[i]; // の並びを逆転
			d[i] = d[digits - i - 1];
			d[digits - i - 1] = temp;
		}
		return digits;
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int no; // 変換する整数
		int cd; // 基数
		int dno; // 変換後の桁数
		int retry; // もう一度？
		char[] cno = new char[32]; // 変換後の各桁を格納する文字の配列

		System.out.println("10進数を基数変換します。");
		do {
			do {
				System.out.print("変換する非負の整数：");
				no = stdIn.nextInt();
			} while (no < 0);

			do {
				System.out.print("何進数に変換しますか（2-36）：");
				cd = stdIn.nextInt();
			} while (cd < 2 || cd > 36);

			dno = cardConvEx(no, cd, cno); // noをcd進数に変換

			System.out.print(cd + "進数では");
			for (int i = 0; i < dno; i++) { // 上位桁から順に表示
				System.out.print(cno[i]);
			}
			System.out.println("です。");

			System.out.print("もう一度しますか（1…はい／0…いいえ）：");
			retry = stdIn.nextInt();
		} while (retry == 1);
		
		System.out.println("終了します。");
	}
}