package Chap05.practice;

import java.util.Scanner;

// ハノイの塔（軸名を文字列で表示）
public class HanoiByString {
	static String[] axis = { "A軸", "B軸", "C軸" };

	//--- 円盤をx軸からy軸へ移動 ---//
	private static void move(int no, int x, int y) {
		if (no > 1) {
			move(no - 1, x, 6 - x - y);
		}

		System.out.println("円盤[" + no + "]を" + axis[x - 1] + "から" + axis[y - 1] + "へ移動");

		if (no > 1) {
			move(no - 1, 6 - x - y, y);
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