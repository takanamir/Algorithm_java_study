package Chap02;

//1,000以下の素数を列挙
public class PrimeNumber1 {
	public static void main(String[] args) {
		int counter = 0; // 除算の回数

		for (int n = 2; n <= 1000; n++) {
			int i;
			for (i = 2; i < n; i++) {
				counter++;
				if (n % i == 0) // 割り切れると素数ではない
					break; // それ以上の繰返しは不要
			}
			if (n == i) // 最後まで割り切れなかった
				System.out.println(n);
		}

		System.out.println("除算を行った回数：" + counter);
	}
}