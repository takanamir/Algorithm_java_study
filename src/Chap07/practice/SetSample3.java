package Chap07.practice;

public class SetSample3 {
	private int targetMax; // 集合の容量
	private int targetNum; // 集合の要素数
	private int[] targetSet; // 集合本体

	// 集合sの部分集合か
	public boolean isSubsetOf(IntSet s) {
		for (int i = 0; i < targetNum; i++) {
			int j = 0;
			for (; j < s.num; j++)
				if (targetSet[i] == s.set[j])
					break;
			if (j == s.num) // set[i]はsに含まれない
				return false;
		}
		return true;
	}

	// 集合sの真部分集合か
	public boolean isProperSubsetOf(IntSet s) {
		if (targetNum >= s.num) // 要素数がs以上であれば
			return false; // sの真部分集合ではない
		return isSubsetOf(s);
	}
}