package Chap02.practice;

//配列の要素に値を読み込んで並びを反転する
public class ReverseArrayPlus {
	//--- 配列の要素a[idx1]とa[idx2]を交換 ---//
	private static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	//--- 配列aの要素の値を表示 ---//
	private static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	//--- 配列aの要素の並びを逆転 ---//
	private static void reverse(int[] a) {
		print(a);
		for (int i = 0; i < a.length / 2; i++) {
			System.out.println("a[" + i + "]とa[" + (a.length - i - 1) + "]を交換します。");
			swap(a, i, a.length - i - 1);
			print(a);
		}
	}

	public static void main(String[] args) {

		int[] x = new int[6]; // 要素数6の配列
		x[0] = 5;
		x[1] = 10;
		x[2] = 73;
		x[3] = 2;
		x[4] = -5;
		x[5] = 42;

		reverse(x); // 配列aの要素の並びを逆転

		System.out.println("逆転が終了しました。");
		for (int i = 0; i < 6; i++) {
			System.out.println("x[" + i + "] = " + x[i]);
		}
	}
}