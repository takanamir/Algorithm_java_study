package Chap02;

//要素型がint型の配列（要素数は５：配列初期化子によって生成）
public class IntArrayInit {
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5};	// 配列初期化子によって生成

		for (int i = 0; i < a.length; i++)
			System.out.println("a[" + i + "] = " + a[i]);
	}
}