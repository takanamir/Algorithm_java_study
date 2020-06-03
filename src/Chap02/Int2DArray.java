package Chap02;

//２行４列の２次元配列
public class Int2DArray {
	public static void main(String[] args) {
		int[][] x = new int[2][4]; // ２次元配列を宣言

		x[0][1] = 37; // x[0][1]に37を代入
		x[0][3] = 54; // x[0][3]に54を代入
		x[1][2] = 65; // x[1][2]に65を代入

		for (int i = 0; i < 2; i++) // 各要素の値を表示
			for (int j = 0; j < 4; j++)
				System.out.println("x[" + i + "][" + j + "] = " + x[i][j]);
	}
}