package Chap01;

import java.util.Scanner;

//左下側が直角の二等辺三角形を表示
public class TriangleLB {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n;

		System.out.println("左下直角の二等辺三角形を表示します。");

		do {
			System.out.print("段数は：");
			n = stdIn.nextInt();
		} while (n <= 0);

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++)
				System.out.print('*');
			System.out.println();
		}
	}
}