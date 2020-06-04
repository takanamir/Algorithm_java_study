package Chap03.practice;

import java.util.Scanner;

//2分探索（探索過程の詳細を表示）
public class BinSearchWithDetail {
	//--- 配列aの先頭n個の要素からkeyと一致する要素を線形探索（番兵法）---//
	static int binSearchEx(int[] a, int n, int key) {
		System.out.print("   |");
		for (int k = 0; k < n; k++)
			System.out.printf("%4d", k);
		System.out.println();

		System.out.print("---+");
		for (int k = 0; k < 4 * n + 2; k++)
			System.out.print("-");
		System.out.println();

		int pl = 0; // 探索範囲先頭のインデックス
		int pr = n - 1; // 探索範囲末尾のインデックス

		do {
			int pc = (pl + pr) / 2; // 中央要素のインデックス
			System.out.print("   |");
			if (pl != pc) {
				System.out.printf(String.format("%%%ds<-%%%ds+",
						(pl * 4) + 1, (pc - pl) * 4),
						"", "");
			} else {
				System.out.printf(String.format("%%%ds<-+", pc * 4 + 1), "");
			}
			
			if (pc != pr) {
				System.out.printf(String.format("%%%ds->\n",
						(pr - pc) * 4 - 2), "");
			} else {
				System.out.println("->");
			}
			System.out.printf("%3d|", pc);
			
			for (int k = 0; k < n; k++) {
				System.out.printf("%4d", a[k]);
			}
			System.out.println("\n   |");
			
			if (a[pc] == key) {
				return pc; // 探索成功
			} else if (a[pc] < key) {
				pl = pc + 1; // 探索範囲を後半に絞り込む
			} else {
				pr = pc - 1; // 探索範囲を前半に絞り込む
			}
		} while (pl <= pr);
		return -1; // 探索失敗
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("要素数：");
		int num = stdIn.nextInt();
		int[] x = new int[num]; // 要素数numの配列

		System.out.println("昇順に入力してください。");

		System.out.print("x[0]："); // 先頭要素の読込み
		x[0] = stdIn.nextInt();

		for (int i = 1; i < num; i++) {
			do {
				System.out.print("x[" + i + "]：");
				x[i] = stdIn.nextInt();
			} while (x[i] < x[i - 1]); // 一つ前の要素より小さければ再入力
		}

		System.out.print("探す値："); // キー値の読込み
		int ky = stdIn.nextInt();

		int idx = binSearchEx(x, num, ky); // 配列xから値がkyの要素を探索

		if (idx == -1) {
			System.out.println("その値の要素は存在しません。");
		} else {
			System.out.println("その値はx[" + idx + "]にあります。");
		}
		stdIn.close();
	}
}