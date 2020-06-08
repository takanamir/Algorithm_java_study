package Chap08.practice;

import java.util.Scanner;

// 力まかせ法による文字列探索（照合過程の詳細を表示）
public class BFMatchWithDetail {
	//--- 力まかせ法による文字列探索 ---//
	private static int bfMatch(String txt, String pat) {
		int pt = 0; // テキスト(txt)をなぞるカーソル
		int pp = 0; // パターン(pat)をなぞるカーソル
		int count = 0; // 比較回数
		int k = -1;

		while (pt != txt.length() && pp != pat.length()) {
			if(k == pt - pp) {
				System.out.print("    ");
			} else {
				System.out.printf("%2d  ", pt - pp);
				k = pt - pp;
			}
			for(int i = 0; i < txt.length(); i++) {
				System.out.print(txt.charAt(i) + " ");
			}
			System.out.println();

			for(int i = 0; i < pt * 2 + 4; i++) {
				System.out.print(" ");
			}
			System.out.print(txt.charAt(pt) == pat.charAt(pp) ? '+' : '|');
			System.out.println();

			for(int i = 0; i < (pt - pp) * 2 + 4; i++) {
				System.out.print(" ");
			}

			for(int i = 0; i < pat.length(); i++) {
				System.out.print(pat.charAt(i) + " ");
			}
			System.out.println();
			System.out.println();
			count++;

			if(txt.charAt(pt) == pat.charAt(pp)) {
				pt++;
				pp++;
			} else {
				pt = pt - pp + 1;
				pp = 0;
			}
		}
		System.out.printf("比較は%d回でした。\n", count);
		if(pp == pat.length()) { // 探索成功
			return pt - pp;
		}
		return -1; // 探索失敗
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("テキスト：");
		String s1 = stdIn.next(); // テキスト用文字列

		System.out.print("パターン：");
		String s2 = stdIn.next(); // パターン用文字列

		int idx = bfMatch(s1, s2); // 文字列s1から文字列s2を力まかせ法で探索

		if(idx == -1) {
			System.out.println("テキスト中にパターンは存在しません。");
		} else {
			// マッチ文字の直前までの《半角》での文字数を求める
			int len = 0;
			for(int i = 0; i < idx; i++) {
				len += s1.substring(i, i + 1).getBytes().length;
			}
			len += s2.length();

			System.out.println((idx + 1) + "文字目にマッチします。");
			System.out.println("テキスト：" + s1);
			System.out.printf(String.format("パターン：%%%ds\n", len), s2);
		}
		stdIn.close();
	}
}