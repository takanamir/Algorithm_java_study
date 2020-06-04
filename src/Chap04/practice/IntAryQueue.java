package Chap04.practice;

//int型キュー（リングバッファを用いない）
public class IntAryQueue {
	//--- 実行時例外：キューが空 ---//
	public class EmptyIntAryQueueException extends RuntimeException {
		public EmptyIntAryQueueException() {
		}
	}

	//--- 実行時例外：キューが満杯 ---//
	public class OverflowIntAryQueueException extends RuntimeException {
		public OverflowIntAryQueueException() {
		}
	}

	private int max; // キューの容量
	private int num; // 現在のデータ数
	private int[] que; // キューの本体

	//--- コンストラクタ ---//
	public IntAryQueue(int capacity) {
		num = 0;
		max = capacity;
		
		try {
			que = new int[max]; // キュー本体用の配列を生成
		} catch (OutOfMemoryError e) { // 生成できなかった
			max = 0;
		}
	}

	//--- キューにデータをエンキュー ---//
	public int enque(int x) throws OverflowIntAryQueueException {
		if (num >= max) {
			throw new OverflowIntAryQueueException(); // キューは満杯
		}
		que[num++] = x;
		return x;
	}

	//--- キューからデータをデキュー ---//
	public int deque() throws EmptyIntAryQueueException {
		if (num <= 0) {
			throw new EmptyIntAryQueueException(); // キューは空
		}
		
		int x = que[0];
		
		for (int i = 0; i < num - 1; i++) {
			que[i] = que[i + 1];
		}
		num--;
		return x;
	}

	//--- キューからデータをピーク（先頭データを覗く） ---//
	public int peek() throws EmptyIntAryQueueException {
		if (num <= 0) {
			throw new EmptyIntAryQueueException(); // キューは空
		}
		return que[num - 1];
	}

	//--- キューからxを探してインデックス（見つからなければ-1）を返す ---//
	public int indexOf(int x) {
		for (int i = 0; i < num; i++) {
			if (que[i] == x) { // 探索成功
				return i;
			}
		}
		return -1; // 探索失敗
	}

	//--- キューを空にする ---//
	public void clear() {
		num = 0;
	}

	//--- キューの容量を返す ---//
	public int capacity() {
		return max;
	}

	//--- キューに蓄えられているデータ数を返す ---//
	public int size() {
		return num;
	}

	//--- キューは空であるか ---//
	public boolean isEmpty() {
		return num <= 0;
	}

	//--- キューは満杯であるか ---//
	public boolean isFull() {
		return num >= max;
	}

	//--- キュー内の全データを先頭→末尾の順に表示 ---//
	public void dump() {
		if (num <= 0) {
			System.out.println("キューは空です。");
		} else {
			for (int i = 0; i < num; i++) {
				System.out.print(que[i] + " ");
			}
			System.out.println();
		}
	}
}