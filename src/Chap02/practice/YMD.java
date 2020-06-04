package Chap02.practice;

import java.util.Scanner;

//日付クラス
public class YMD {
	private int y; // 西暦年
	private int m; // 月（1～12）
	private int d; // 日（1～31）

	//--- 各月の日数 ---//
	private static int[][] mdays = {
			{ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }, // 平年
			{ 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }, // 閏年
	};

	//--- 西暦year年は閏年か（閏年：1／平年：0） ---//
	private static int isLeap(int year) {
		return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
	}

	//--- コンストラクタ（与えられた日付に設定）---//
	YMD(int y, int m, int d) {
		this.y = y;
		this.m = m;
		this.d = d;
	}

	//--- n日後の日付を返す ---//
	private YMD after(int n) {
		YMD temp = new YMD(this.y, this.m, this.d);
		if (n < 0)
			return (before(-n));

		temp.d += n;

		while (temp.d > mdays[isLeap(temp.y)][temp.m - 1]) {
			temp.d -= mdays[isLeap(temp.y)][temp.m - 1];
			if (++temp.m > 12) {
				temp.y++;
				temp.m = 1;
			}
		}
		return temp;
	}

	//--- n日前の日付を返す ---//
	private YMD before(int n) {
		YMD temp = new YMD(this.y, this.m, this.d);
		if (n < 0)
			return (after(-n));

		temp.d -= n;

		while (temp.d < 1) {
			if (--temp.m < 1) {
				temp.y--;
				temp.m = 12;
			}
			temp.d += mdays[isLeap(temp.y)][temp.m - 1];
		}
		return temp;
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("日付を入力してください。\n");
		System.out.print("年：");
		int y = stdIn.nextInt();
		System.out.print("月：");
		int m = stdIn.nextInt();
		System.out.print("日：");
		int d = stdIn.nextInt();
		YMD date = new YMD(y, m, d);

		System.out.print("何日前／後の日付を求めますか：");
		int n = stdIn.nextInt();

		YMD d1 = date.after(n);
		System.out.printf("%d日後の日付は%d年%d月%d日です。\n", n, d1.y, d1.m, d1.d);

		YMD d2 = date.before(n);
		System.out.printf("%d日前の日付は%d年%d月%d日です。\n", n, d2.y, d2.m, d2.d);
	}
}