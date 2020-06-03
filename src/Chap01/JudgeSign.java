package Chap01;

import java.util.Scanner;

//読み込んだ整数値の正／負／０を判定
public class JudgeSign {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("整数を入力せよ：");
		int n = stdIn.nextInt();

		if (n > 0)
			System.out.println("それは正です。");
		else if (n < 0)
			System.out.println("それは負です。");
		else
			System.out.println("それは０です。");
	}
}