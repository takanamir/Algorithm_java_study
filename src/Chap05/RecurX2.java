package Chap05;

import java.util.Scanner;

import Chap04.IntStack;

//再帰に対する理解を深めるための真に再帰的なメソッド（再帰を除去）
public class RecurX2 {
	//--- 再帰を除去したrecur ---//
	static void recur(int n) {
		IntStack s = new IntStack(n);

		while (true) {
			if (n > 0) {
				s.push(n); // nの値をプッシュ
				n = n - 1;
				continue;
			}
			if (s.isEmpty() != true) { // スタックが空でなければ
				n = s.pop(); // 保存していた値をnにポップ
				System.out.println(n);
				n = n - 2;
				continue;
			}
			break;
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("整数を入力せよ：");
		int x = stdIn.nextInt();

		recur(x);
	}
}