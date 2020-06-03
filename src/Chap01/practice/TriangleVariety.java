package Chap01.practice;

import java.util.Scanner;

//四つの直角三角形を表示
public class TriangleVariety {
	//--- 左下側が直角の直角三角形を表示 ---//
	private static void triangleLB(int n) {
		for (int i = 1; i <= n; i++) { // i行（i = 1, 2, … ,n）
			for (int j = 1; j <= i; j++) // i個の'*'を表示
				System.out.print('*');
			System.out.println(); // 改行
		}
	}

	//--- 左上側が直角の直角三角形を表示 ---//
	private static void triangleLU(int n) {
		for (int i = 1; i <= n; i++) { // i行（i = 1, 2, … ,n）
			for (int j = 1; j <= n - i + 1; j++) // n-i+1個の'*'を表示
				System.out.print('*');
			System.out.println(); // 改行
		}
	}

	//--- 右上側が直角の直角三角形を表示 ---//
	private static void triangleRU(int n) {
		for (int i = 1; i <= n; i++) { // i行（i = 1, 2, … ,n）
			for (int j = 1; j <= i - 1; j++) // i-1個の' 'を表示
				System.out.print(' ');
			for (int j = 1; j <= n - i + 1; j++) // n-i+1個の'*'を表示
				System.out.print('*');
			System.out.println(); // 改行
		}
	}

	//--- 右下側が直角の直角三角形を表示 ---//
	private static void triangleRB(int n) {
		for (int i = 1; i <= n; i++) { // i行（i = 1, 2, … ,ln）
			for (int j = 1; j <= n - i; j++) // n-i個の' 'を表示
				System.out.print(' ');
			for (int j = 1; j <= i; j++) // i個の'*'を表示
				System.out.print('*');
			System.out.println(); // 改行
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n;

		System.out.println("三角形を表示します。");

		do {
			System.out.print("段数は：");
			n = stdIn.nextInt();
		} while (n <= 0);

		System.out.println("左下側が直角");
		triangleLB(n); // 左下側が直角の直角三角形

		System.out.println("左上側が直角");
		triangleLU(n); // 左上側が直角の直角三角形

		System.out.println("右上側が直角");
		triangleRU(n); // 右上側が直角の直角三角形

		System.out.println("右下側が直角");
		triangleRB(n); // 右下側が直角の直角三角形
	}
}