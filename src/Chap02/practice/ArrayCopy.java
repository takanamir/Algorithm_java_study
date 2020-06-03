package Chap02.practice;

import java.util.Scanner;

//配列の全要素をコピーする
public class ArrayCopy {
	//--- 配列Bの全要素を配列Aにコピー ---//
	private static void copy(int[] a, int[] b) {
		int num = a.length <= b.length ? a.length : b.length;
		for (int i = 0; i < num; i++) {
			a[i] = b[i];
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("Aの要素数は：");
		int numA = stdIn.nextInt(); // 要素数
		int[] a = new int[numA]; // 要素数numAの配列
		for (int i = 0; i < numA; i++) {
			System.out.print("a[" + i + "] : ");
			a[i] = stdIn.nextInt();
		}

		System.out.print("Bの要素数は：");
		int numB = stdIn.nextInt(); // 要素数
		int[] b = new int[numB]; // 要素数numBの配列
		for (int i = 0; i < numB; i++) {
			System.out.print("b[" + i + "] : ");
			b[i] = stdIn.nextInt();
		}

		copy(a, b); // 配列Bの全要素を配列Aにコピー

		System.out.println("配列Bの全要素を配列Aにコピーしました。");
		for (int i = 0; i < numA; i++) {
			System.out.println("a[" + i + "] = " + a[i]);
		}
	}
}