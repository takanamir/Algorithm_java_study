package Chap03.practice;

import java.util.Scanner;

//線形探索（探索過程を詳細に表示）
public class SeqSearchWithDetail {
	//--- 配列aの先頭n個の要素からkeyと一致する要素を線形探索（番兵法）---//
	private static int seqSearchEx(int[] a, int n, int key) {
		System.out.print("   |");
		for (int k = 0; k < n; k++) {
			System.out.printf("%4d", k);
		}
		System.out.println();

		System.out.print("---+");
		for (int k = 0; k < 4 * n + 2; k++) {
			System.out.print("-");
		}
		System.out.println();

		for (int i = 0; i < n; i++) {
			System.out.print("   |");
			System.out.printf(String.format("%%%ds*\n", (i * 4) + 3), "");
			System.out.printf("%3d|", i);
			for (int k = 0; k < n; k++) {
				System.out.printf("%4d", a[k]);
			}
			System.out.println("\n   |");
			if (a[i] == key) {
				return i; // 探索成功
			}
		}
		return -1; // 探索失敗
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		int[] x = new int[7]; // 要素数7の配列
		x[0] = 6;
		x[1] = 4;
		x[2] = 3;
		x[3] = 2;
		x[4] = 1;
		x[5] = 9;
		x[6] = 8;

		System.out.print("探す値："); // キー値の読込み
		int ky = stdIn.nextInt();

		int idx = seqSearchEx(x, 7, ky); // 配列xから値がkyの要素を探索

		if (idx == -1) {
			System.out.println("その値の要素は存在しません。");
		} else {
			System.out.println("その値は" + "x[" + idx + "]にあります。");
		}
		
		stdIn.close();
	}
}