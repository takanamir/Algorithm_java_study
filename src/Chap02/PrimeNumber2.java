package Chap02;

//1,000以下の素数を列挙
public class PrimeNumber2 {
	public static void main(String[] args) {
		int counter = 0; // 除算の回数
		int ptr = 0; // 得られた素数の個数
		int[] prime = new int[500]; // 素数を格納する配列

		prime[ptr++] = 2; // ２は素数である

		for (int n = 3; n <= 1000; n += 2) { // 対象は奇数のみ
			int i;
			for (i = 1; i < ptr; i++) { // 既に得られた素数で割ってみる
				counter++;
				if (n % prime[i] == 0) // 割り切れると素数ではない
					break; // それ以上の繰返しは不要
			}
			if (ptr == i) // 最後まで割り切れなかったら
				prime[ptr++] = n; // 素数として配列に登録
		}

		for (int i = 0; i < ptr; i++) // 求めたptr個の素数を表示
			System.out.println(prime[i]);

		System.out.println("除算を行った回数：" + counter);
	}
}