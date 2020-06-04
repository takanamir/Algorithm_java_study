package Chap03;

import java.util.Scanner;

//線形探索（番兵法）
public class SeqSearchSen {
	//--- 配列aの先頭n個の要素からkeyと一致する要素を線形探索（番兵法）---//
	static int seqSearchSen(int[] a, int n, int key) {
		int i = 0;

		a[n] = key; // 番兵を追加

		while (true) {
			if (a[i] == key) // 探索成功
				break;
			i++;
		}
		return i == n ? -1 : i;
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("要素数：");
		int num = stdIn.nextInt();
		int[] x = new int[num + 1]; // 要素数num + 1の配列

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "]：");
			x[i] = stdIn.nextInt();
		}

		System.out.print("探す値："); // キー値の読込み
		int ky = stdIn.nextInt();

		int idx = seqSearchSen(x, num, ky); // 配列xから値がkyの要素を探索

		if (idx == -1)
			System.out.println("その値の要素は存在しません。");
		else
			System.out.println("その値はx[" + idx + "]にあります。");
	}
}