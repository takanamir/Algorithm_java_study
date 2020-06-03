package Chap02;

//構成要素型がint型の配列（構成要素数は５：newによって本体を生成）
public class IntArray {
	public static void main(String[] args) {
		int[] a = new int[5]; // 配列の宣言

		a[1] = 37; // a[1]に37を代入
		a[2] = 51; // a[2]に51を代入
		a[4] = a[1] * 2; // a[4]にa[1] * 2すなわち74を代入

		for (int i = 0; i < a.length; i++) // 各要素の値を表示
			System.out.println("a[" + i + "] = " + a[i]);
	}
}