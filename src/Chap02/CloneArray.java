package Chap02;

//配列の複製を作る
public class CloneArray {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
		int[] b = a.clone(); // bはaの複製を参照

		b[3] = 0; // １要素だけ落書き

		System.out.print("a =");
		for (int i = 0; i < a.length; i++)
			System.out.print(" " + a[i]);

		System.out.print("\nb =");
		for (int i = 0; i < b.length; i++)
			System.out.print(" " + b[i]);
	}
}