package Chap05.practice;

import java.util.Scanner;

//ハノイの塔（非再帰的に実現）
public class HanoiNonRecursive {
	//--- 円盤をx軸からy軸へ移動 ---//
	static void move(int no, int x, int y) {
		int[] xstk = new int[100];
		int[] ystk = new int[100];
		int[] sstk = new int[100]; // スタック
		int ptr = 0; // スタックポインタ
		int sw = 0;

		while (true) {
			if (sw == 0 && no > 1) {
				xstk[ptr] = x; // xの値をプッシュ
				ystk[ptr] = y; // yの値をプッシュ
				sstk[ptr] = sw; // swの値をプッシュ
				ptr++;
				no = no - 1;
				y = 6 - x - y;
				continue;
			}

			System.out.printf("[%d]を%d軸から%d軸へ移動\n", no, x, y);

			if (sw == 1 && no > 1) {
				xstk[ptr] = x; // xの値をプッシュ
				ystk[ptr] = y; // yの値をプッシュ
				sstk[ptr] = sw; // swの値をプッシュ
				ptr++;
				no = no - 1;
				x = 6 - x - y;
				if (++sw == 2) {
					sw = 0;
				}
				continue;
			}
			do {
				if (ptr-- == 0) { // スタックが空になったら
					return;
				}
				x = xstk[ptr]; // 値を保存していたxをポップ
				y = ystk[ptr]; // 値を保存していたyをポップ
				sw = sstk[ptr] + 1; // 値を保存していたswをポップ
				no++;
			} while (sw == 2);
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("ハノイの塔");
		System.out.print("円盤の枚数：");
		int n = stdIn.nextInt();

		move(n, 1, 3); // 第1軸に積まれたn枚を第3軸に移動
		stdIn.close();
	}
}