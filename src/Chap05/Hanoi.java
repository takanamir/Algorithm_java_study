package Chap05;

import java.util.Scanner;

//ハノイの塔
public class Hanoi {
	//--- no枚の円盤をx軸からy軸へ移動 ---//
	static void move(int no, int x, int y) {
		if (no > 1)
			move(no - 1, x, 6 - x - y);

		System.out.println("円盤[" + no + "]を" + x + "軸から" + y + "軸へ移動");

		if (no > 1)
			move(no - 1, 6 - x - y, y);
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("ハノイの塔");
		System.out.print("円盤の枚数：");
		int n = stdIn.nextInt();

		move(n, 1, 3); // 第1軸に積まれたn枚を第3軸に移動
	}
}