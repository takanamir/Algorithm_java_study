package Chap04.practice;

import java.util.Scanner;

public class IntStackTester2 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		IntStack2 s = new IntStack2(10); // 最大10個プッシュできる両頭スタック

		while (true) {
			System.out.println("現在のデータ数：" +
					"A：" + s.size(IntStack2.A_or_B.StackA) + " " +
					"B：" + s.size(IntStack2.A_or_B.StackB));
			System.out.print("(1)Aにプッシュ (2)Aからポップ (3)Aからピーク " +
					"(4)Aをダンプ (5)Aから探索 (6)Aを空にする\n" +
					"(7)Bにプッシュ (8)Bからポップ (9)Bからピーク " +
					"(10)Bをダンプ (11)Bから探索 (12)Bを空にする\n" +
					"(13)情報表示 (0)終了：");

			int menu = stdIn.nextInt();
			if (menu == 0) {
				break;
			}

			int n, x = 0;
			switch (menu) {
			case 1: // Aにプッシュ
				System.out.print("データ：");
				x = stdIn.nextInt();
				try {
					s.push(IntStack2.A_or_B.StackA, x);
				} catch (IntStack2.OverflowIntStack2Exception e) {
					System.out.println("スタックが満杯です。");
				}
				break;

			case 2: // Aからポップ
				try {
					x = s.pop(IntStack2.A_or_B.StackA);
					System.out.println("ポップしたデータは" + x + "です。");
				} catch (IntStack2.EmptyIntStack2Exception e) {
					System.out.println("スタックが空です。");
				}
				break;

			case 3: // Aからピーク
				try {
					x = s.peek(IntStack2.A_or_B.StackA);
					System.out.println("ピークしたデータは" + x + "です。");
				} catch (IntStack2.EmptyIntStack2Exception e) {
					System.out.println("スタックが空です。");
				}
				break;

			case 4: // Aをダンプ
				s.dump(IntStack2.A_or_B.StackA);
				break;

			case 5: // Aから探索
				System.out.print("探索するデータ：");
				x = stdIn.nextInt();
				n = s.indexOf(IntStack2.A_or_B.StackA, x);
				if (n >= 0) {
					System.out.println("頂上から" + (s.size(IntStack2.A_or_B.StackA) - n) + "番目に存在します。");
				} else {
					System.out.println("そのデータはありません。");
				}
				break;

			case 6: // 空にする
				s.clear(IntStack2.A_or_B.StackA);
				break;

			case 7: // Bにプッシュ
				System.out.print("データ：");
				x = stdIn.nextInt();
				try {
					s.push(IntStack2.A_or_B.StackB, x);
				} catch (IntStack2.OverflowIntStack2Exception e) {
					System.out.println("スタックが満杯です。");
				}
				break;

			case 8: // Bからポップ
				try {
					x = s.pop(IntStack2.A_or_B.StackB);
					System.out.println("ポップしたデータは" + x + "です。");
				} catch (IntStack2.EmptyIntStack2Exception e) {
					System.out.println("スタックが空です。");
				}
				break;

			case 9: // Bからピーク
				try {
					x = s.peek(IntStack2.A_or_B.StackB);
					System.out.println("ピークしたデータは" + x + "です。");
				} catch (IntStack2.EmptyIntStack2Exception e) {
					System.out.println("スタックが空です。");
				}
				break;

			case 10: // Bをダンプ
				s.dump(IntStack2.A_or_B.StackB);
				break;

			case 11: // Bから探索
				System.out.print("探索するデータ：");
				x = stdIn.nextInt();
				n = s.indexOf(IntStack2.A_or_B.StackB, x);
				if (n >= 0) {
					System.out.println("頂上から" + (s.size(IntStack2.A_or_B.StackB) - (s.capacity() - n) + 1) + "番目に存在します。");
				} else {
					System.out.println("そのデータはありません。");
				}
				break;

			case 12: // 空にする
				s.clear(IntStack2.A_or_B.StackB);
				break;

			case 13: // 情報表示
				System.out.println("容量：" + s.capacity());
				System.out.println("Aのデータ数：" + s.size(IntStack2.A_or_B.StackA));
				System.out.println("Bのデータ数：" + s.size(IntStack2.A_or_B.StackB));
				System.out.println("Aは空" + (s.isEmpty(IntStack2.A_or_B.StackA) ? "です。" : "ではありません。"));
				System.out.println("Bは空" + (s.isEmpty(IntStack2.A_or_B.StackB) ? "です。" : "ではありません。"));
				System.out.println("満杯" + (s.isFull() ? "です。" : "ではありません。"));
				break;
			}
		}
		stdIn.close();
		System.out.println("終了します");
	}
}