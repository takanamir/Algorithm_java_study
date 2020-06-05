package Chap05.practice;

// 8王妃問題を非再帰的に解く
public class EightQueenNonRecursive {
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
		int j;
		int[] jstk = new int[8];

		Start: while (true) {
			j = 0;
			while (true) {
				while (j < 8) {
					if (!flag_a[j] && !flag_b[i + j] && !flag_c[i - j + 7]) {
						pos[i] = j;
						if (i == 7) { // 全列に配置終了
							print();
						} else {
							flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = true;
							jstk[i++] = j; // i列目の行をPush
							continue Start;
						}
					}
					j++;
				}
				if (--i == -1) {
					return;
				}
				j = jstk[i]; // i列目の行をPop
				flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = false;
				j++;
			}
		}
	}

	public static void main(String[] args) {
		set(0);
	}
}