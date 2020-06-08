package Chap07.practice;

public class SetSample {
	private int max; // 集合の容量
	private int num; // 集合の要素数
	private int[] set; // 集合本体

	// 集合は空であるか
	public boolean isEmpty() {
		return num == 0;
	}

	// 集合は満杯か
	public boolean isFull() {
		return num >= max;
	}

	// 集合を空にする（全要素を削除）
	public void clear() {
		num = 0;
	}
}