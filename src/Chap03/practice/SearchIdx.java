package Chap03.practice;

import java.util.Scanner;

// ある値をもつ配列中の全要素を別の配列にコピー
public class SearchIdx {
	//--- 配列aの先頭n個の要素からkeyと一致する全要素のインデックスを
	//--- 配列idxの先頭から順に格納して一致した要素数を返す
	private static int searchIdx(int[] a, int n, int key, int[] idx) {
		int count = 0; // keyと一致する要素数
		for (int i = 0; i < n; i++)
			if (a[i] == key)
				idx[count++] = i;
		return count;
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("要素数：");
		int num = stdIn.nextInt();
		int[] x = new int[num]; // 要素数numの配列
		int[] y = new int[num]; // 要素数numの配列

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "]：");
			x[i] = stdIn.nextInt();
		}
		System.out.print("探す値："); // キー値の読込み
		int ky = stdIn.nextInt();

		int count = searchIdx(x, num, ky, y); // 配列x中の値がkyの要素をyにコピー

		if (count == 0) {
			System.out.println("その値の要素は存在しません。");
		} else {
			for (int i = 0; i < count; i++) {
				System.out.println("その値は" + "x[" + y[i] + "]にあります。");
			}
		}
		stdIn.close();
	}
}