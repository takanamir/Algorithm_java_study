package Chap04.practice;

// 一つの配列を共有して二つのスタックを実現するint型データ用のクラス
public class IntStack2 {
	private int max; // スタックの容量（Ａ・Ｂの合計）
	private int ptrA; // スタックポインタＡ
	private int ptrB; // スタックポインタＢ
	private int[] stk; // スタックの本体

	public enum A_or_B {
		StackA, StackB
	};

	//--- 実行時例外：スタックが空 ---//
	public class EmptyIntStack2Exception extends RuntimeException {
		public EmptyIntStack2Exception() {
		}
	}

	//--- 実行時例外：スタックが満杯 ---//
	public class OverflowIntStack2Exception extends RuntimeException {
		public OverflowIntStack2Exception() {
		}
	}

	//--- コンストラクタ ---//
	public IntStack2(int capacity) {
	      ptrA = 0;
	      ptrB = capacity - 1;
	      max  = capacity;
	      try {
	         stk = new int[max];         // スタック本体用の配列を生成
	      } catch (OutOfMemoryError e) {   // 生成できなかった
	         max = 0;
	      }
	   }

	//--- スタックにxをプッシュ ---//
	public int push(A_or_B sw, int x) throws OverflowIntStack2Exception {
		if (ptrA >= ptrB + 1) { // スタックは満杯
			throw new OverflowIntStack2Exception();
		}
		switch (sw) {
		case StackA:
			stk[ptrA++] = x;
			break;
		case StackB:
			stk[ptrB--] = x;
			break;
		}
		return x;
	}

	//--- スタックからデータをポップ（頂上のデータを取り出す） ---//
	public int pop(A_or_B sw) throws EmptyIntStack2Exception {
		int x = 0;
		switch (sw) {
		case StackA:
			if (ptrA <= 0) { // スタックＡは空
				throw new EmptyIntStack2Exception();
			}
			x = stk[--ptrA];
			break;
		case StackB:
			if (ptrB >= max - 1) { // スタックＢは空
				throw new EmptyIntStack2Exception();
			}
			x = stk[++ptrB];
			break;
		}
		return x;
	}

	//--- スタックからデータをピーク（頂上のデータを覗き見） ---//
	public int peek(A_or_B sw) throws EmptyIntStack2Exception {
		int x = 0;
		switch (sw) {
		case StackA:
			if (ptrA <= 0) { // スタックＡは空
				throw new EmptyIntStack2Exception();
			}
			x = stk[ptrA - 1];
			break;
		case StackB:
			if (ptrB >= max - 1) { // スタックＢは空
				throw new EmptyIntStack2Exception();
			}
			x = stk[ptrB + 1];
			break;
		}
		return x;
	}

	//--- スタックからxを探してインデックス（見つからなければ-1）を返す ---//
	public int indexOf(A_or_B sw, int x) {
		switch (sw) {
		case StackA:
			for (int i = ptrA - 1; i >= 0; i--) { // 頂上側から線形探索
				if (stk[i] == x) {
					return i; // 探索成功
				}
			}
			break;
		case StackB:
			for (int i = ptrB + 1; i < max; i++) { // 頂上側から線形探索
				if (stk[i] == x) {
					return i; // 探索成功
				}
			}
			break;
		}
		return -1; // 探索失敗
	}

	//--- スタックを空にする ---//
	public void clear(A_or_B sw) {
		switch (sw) {
		case StackA:
			ptrA = 0;
			break;
		case StackB:
			ptrB = max - 1;
			break;
		}
	}

	//--- スタックの容量を返す（ＡとＢの合計） ---//
	public int capacity() {
		return max;
	}

	//--- スタックに積まれているデータ数を返す ---//
	public int size(A_or_B sw) {
		switch (sw) {
		case StackA:
			return ptrA;
		case StackB:
			return max - ptrB - 1;
		}
		return 0;
	}

	//--- スタックは空であるか ---//
	public boolean isEmpty(A_or_B sw) {
		switch (sw) {
		case StackA:
			return ptrA <= 0;
		case StackB:
			return ptrB >= max - 1;
		}
		return true;
	}

	//--- スタックは満杯であるか ---//
	public boolean isFull() {
		return ptrA >= ptrB + 1;
	}

	//--- スタック内の全データを底→頂上の順に表示 ---//
	public void dump(A_or_B sw) {
		switch (sw) {
		case StackA:
			if (ptrA <= 0) {
				System.out.println("スタックは空です。");
			} else {
				for (int i = 0; i < ptrA; i++) {
					System.out.print(stk[i] + " ");
				}
				System.out.println();
			}
			break;
		case StackB:
			if (ptrB >= max - 1) {
				System.out.println("スタックは空です。");
			} else {
				for (int i = max - 1; i > ptrB; i--) {
					System.out.print(stk[i] + " ");
				}
				System.out.println();
			}
			break;
		}
	}
}