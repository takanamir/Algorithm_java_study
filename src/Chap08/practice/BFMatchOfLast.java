package Chap08.practice;

import java.util.Scanner;

// 力まかせ法による文字列探索(一致する末尾側を探索)
public class BFMatchOfLast {
	//--- 力まかせ法による文字列探索（一致する末尾側を探索） ---//
	private static int bfMatchLast(String txt, String pat) {
		int pt = txt.length() - 1; // txtをなぞるカーソル
		int pp = pat.length() - 1; // patをなぞるカーソル

		while (pt >= 0 && pp >= 0) {
			if (txt.charAt(pt) == pat.charAt(pp)) {
				pt--;
				pp--;
			} else {
				pt = pt + (pat.length() - pp) - 2;
				pp = pat.length() - 1;
			}
		}
		if (pp < 0) // 探索成功
			return pt + 1;
		return -1; // 探索失敗
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("テキスト：");
		String s1 = stdIn.next(); // テキスト用文字列

		System.out.print("パターン：");
		String s2 = stdIn.next(); // パターン用文字列

		int idx = bfMatchLast(s1, s2); // 文字列s1から文字列s2を力まかせ法で探索

		if (idx == -1) {
			System.out.println("テキスト中にパターンは存在しません。");
		} else {
			// マッチ文字の直前までの《半角》での文字数を求める
			int len = 0;
			for (int i = 0; i < idx; i++) {
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