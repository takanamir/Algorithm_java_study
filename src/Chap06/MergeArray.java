package Chap06;

import java.util.Scanner;

//ソートずみ配列のマージ
public class MergeArray {
	//--- ソートずみ配列aとbをマージしてcに格納 ---//
	static void merge(int[] a, int na, int[] b, int nb, int[] c) {
		int pa = 0;
		int pb = 0;
		int pc = 0;

		while (pa < na && pb < nb) // 小さいほうを格納
			c[pc++] = (a[pa] <= b[pb]) ? a[pa++] : b[pb++];

		while (pa < na) // aに残った要素をコピー
			c[pc++] = a[pa++];

		while (pb < nb) // bに残った要素をコピー
			c[pc++] = b[pb++];
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int[] a = { 2, 4, 6, 8, 11, 13 };
		int[] b = { 1, 2, 3, 4, 9, 16, 21 };
		int[] c = new int[13];

		System.out.println("二つの配列のマージ");

		merge(a, a.length, b, b.length, c); // 配列aとbをマージしてcに格納

		System.out.println("配列aとbをマージして配列cに格納しました。");
		System.out.println("配列a：");
		for (int i = 0; i < a.length; i++)
			System.out.println("a[" + i + "] = " + a[i]);

		System.out.println("配列b：");
		for (int i = 0; i < b.length; i++)
			System.out.println("b[" + i + "] = " + b[i]);

		System.out.println("配列c：");
		for (int i = 0; i < c.length; i++)
			System.out.println("c[" + i + "] = " + c[i]);
	}
}