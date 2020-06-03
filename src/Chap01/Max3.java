package Chap01;

import java.util.Scanner;

//三つの整数値を読み込んで最大値を求めて表示
public class Max3 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("三つの整数の最大値を求めます。");
		System.out.print("aの値：");
		int a = stdIn.nextInt();
		System.out.print("bの値：");
		int b = stdIn.nextInt();
		System.out.print("cの値：");
		int c = stdIn.nextInt();

		int max = a;
		if (b > max)
			max = b;
		if (c > max)
			max = c;

		System.out.println("最大値は" + max + "です。");
	}
}