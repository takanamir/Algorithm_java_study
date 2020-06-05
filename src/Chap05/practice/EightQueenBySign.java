package Chap05.practice;

// 8王妃問題を解く（盤面を記号文字で表示）
public class EightQueenBySign {
	static boolean[] flag_a = new boolean[8]; // 各行に王妃が配置済みか
	static boolean[] flag_b = new boolean[15]; // ／対角線に王妃が配置済みか
	static boolean[] flag_c = new boolean[15]; // ＼対角線に王妃が配置済みか
	static int[] pos = new int[8]; // 各列の王妃の位置

	//--- 盤面（各列の王妃の位置）を出力 ---//
	private static void print() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.printf("%s", j == pos[i] ? "■" : "□");
			}
			System.out.println();
		}
		System.out.println();
	}

	//--- i列目の適切な位置に王妃を配置 ---//
	private static void set(int i) {
		for (int j = 0; j < 8; j++) {
			if (flag_a[j] == false && // 横（j行）に未配置
					flag_b[i + j] == false && // ／対角線に未配置
					flag_c[i - j + 7] == false) { // ＼対角線に未配置
				pos[i] = j; // 王妃をj行に配置
				if (i == 7) { // 全列に配置終了
					print();
				} else {
					flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = true;
					set(i + 1);
					flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = false;
				}
			}
		}
	}

	public static void main(String[] args) {
		set(0);
	}
}