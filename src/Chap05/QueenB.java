package Chap05;

//各列に１個の王妃を配置する組合せを再帰的に列挙
public class QueenB {
	static int[] pos = new int[8]; // 各列の王妃の位置

	//--- 盤面（各列の王妃の位置）を出力 ---//
	static void print() {
		for (int i = 0; i < 8; i++)
			System.out.printf("%2d", pos[i]);
		System.out.println();
	}

	//--- i列目に王妃を配置 ---//
	static void set(int i) {
		for (int j = 0; j < 8; j++) {
			pos[i] = j; // 王妃をj行に配置
			if (i == 7) // 全列に配置終了
				print();
			else
				set(i + 1); // 次の列に王妃を配置
		}
	}

	public static void main(String[] args) {
		set(0); // 0列目に王妃を配置
	}
}