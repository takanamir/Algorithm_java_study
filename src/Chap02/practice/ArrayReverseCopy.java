package Chap02.practice;

import java.util.Scanner;

//配列の全要素を逆順にコピーする
public class ArrayReverseCopy {
	//--- 配列bの全要素を配列aに逆順にコピー ---//
	static void rCopy(int[] a, int[] b) {
		int num = a.length <= b.length ? a.length : b.length;
		for (int i = 0; i < num; i++) {
			a[i] = b[b.length - i - 1];
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("aの要素数は：");
		int numa = stdIn.nextInt(); // 要素数
		int[] a = new int[numa]; // 要素数numaの配列
		for (int i = 0; i < numa; i++) {
			System.out.print("a[" + i + "] : ");
			a[i] = stdIn.nextInt();
		}

		System.out.print("bの要素数は：");
		int numb = stdIn.nextInt(); // 要素数
		int[] b = new int[numb]; // 要素数numbの配列
		for (int i = 0; i < numb; i++) {
			System.out.print("b[" + i + "] : ");
			b[i] = stdIn.nextInt();
		}

		rCopy(a, b); // 配列bの全要素を配列aに逆順にコピー

		System.out.println("配列bの全要素を配列aに逆順にコピーしました。");
		for (int i = 0; i < numa; i++) {
			System.out.println("a[" + i + "] = " + a[i]);
		}
	}
}