package Chap07.practice;

// int型の集合（要素を常に昇順にソート）
public class IntSortedSet {
	private int max; // 集合の容量
	private int num; // 集合の要素数
	private int[] set; // 集合本体

	//--- コンストラクタ ---//
	public IntSortedSet(int capacity) {
		num = 0;
		max = capacity;
		try {
			set = new int[max]; // 集合本体用の配列を生成
		} catch (OutOfMemoryError e) { // 配列の生成に失敗
			max = 0;
		}
	}

	//--- 集合からnを探索してインデックスを返す ---//
	//--- 見つからない場合は(-挿入ポイント-1)を返す ---//
	public int indexOf(int n) {
		int pl = 0; // 探索範囲先頭のインデックス
		int pr = n - 1; // 探索範囲末尾のインデックス

		do {
			int pc = (pl + pr) / 2; // 中央要素のインデックス
			if (set[pc] == n)
				return pc; // 探索成功
			else if (set[pc] < n)
				pl = pc + 1; // 探索範囲を前半に絞り込む
			else
				pr = pc - 1; // 探索範囲を後半に絞り込む
		} while (pl <= pr);

		return -pl - 1; // 探索失敗
	}

	//--- 集合にnが入っているか ---//
	public boolean contains(int n) {
		return (indexOf(n) >= 0) ? true : false;
	}

	//--- 集合にnを追加 ---//
	public boolean add(int n) {
		int idx;
		if (num >= max || (idx = indexOf(n)) >= 0) // 満杯 or 含まれている
			return false;
		else {
			idx = -(idx + 1);
			num++;
			for (int i = num - 1; i > idx; i--)
				set[i] = set[i - 1];
			set[idx] = n;
			return true;
		}
	}

	//--- 集合からnを削除 ---//
	public boolean remove(int n) {
		int idx; // nが格納されている要素のインデックス

		if (num <= 0 || (idx = indexOf(n)) == -1) // 空 or 含まれていない
			return false;
		else {
			num--;
			for (int i = idx; i < num; i++) // set[idx]を削除して
				set[i] = set[i + 1]; // それ以降の要素をずらす
			return true;
		}
	}

	//--- 集合の容量 ---//
	public int capacity() {
		return max;
	}

	//--- 集合の要素数 ---//
	public int size() {
		return num;
	}

	//--- 集合sにコピー（s ← this）---//
	public void copyTo(IntSortedSet s) {
		int n = (s.max < num) ? s.max : num; // コピーする要素数
		for (int i = 0; i < n; i++)
			s.set[i] = set[i];
		s.num = n;
	}

	//--- 集合sをコピー（this ← s）---//
	public void copyFrom(IntSortedSet s) {
		int n = (max < s.num) ? max : s.num; // コピーする要素数
		for (int i = 0; i < n; i++)
			set[i] = s.set[i];
		num = n;
	}

	//--- 集合sと等しいか ---//
	public boolean equals(IntSortedSet s) {
		if (num != s.num) // 要素数が等しくなければ
			return false; // 集合も等しくない

		for (int i = 0; i < num; i++)
			if (set[i] == s.set[i])
				return false;
		return true;
	}

	//--- 集合s1とs2の和集合をコピー ---//
	public void unionOf(IntSortedSet s1, IntSortedSet s2) {
		copyFrom(s1); // 集合s1をコピー
		for (int i = 0; i < s2.num; i++) // 集合s2の要素を追加
			add(s2.set[i]);
	}

	//--- "{ a b c }"形式の文字列表現に変換 ---//
	public String toString() {
		StringBuffer temp = new StringBuffer("{ ");
		for (int i = 0; i < num; i++)
			temp.append(set[i] + " ");
		temp.append("}");
		return temp.toString();
	}

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

	// 集合sとの和集合にする
	public boolean addAll(IntSortedSet s) {
		boolean flag = false;
		for (int i = 0; i < s.num; i++)
			if (add(s.set[i]) == true)
				flag = true;
		return flag;
	}

	// 集合sとの積集合にする
	public boolean retainAll(IntSortedSet s) {
		boolean flag = false;
		for (int i = 0; i < num; i++)
			if (s.contains(set[i]) == false) {
				remove(set[i]);
				flag = true;
			}
		return flag;
	}

	// 集合sとの差集合にする
	public boolean removeAll(IntSortedSet s) {
		boolean flag = false;
		for (int i = 0; i < num; i++)
			if (s.contains(set[i]) == true) {
				remove(set[i]);
				flag = true;
			}
		return flag;
	}

	// 集合sの部分集合か
	public boolean isSubsetOf(IntSortedSet s) {
		for (int i = 0; i < num; i++) {
			int j = 0;
			for (; j < s.num; j++)
				if (set[i] == s.set[j])
					break;
			if (j == s.num) // set[i]はsに含まれない
				return false;
		}
		return true;
	}

	// 集合sの真部分集合か
	public boolean isProperSubsetOf(IntSortedSet s) {
		if (num >= s.num) // 要素数がs以上であれば
			return false; // sの真部分集合ではない
		return s.isSubsetOf(s);
	}

	// 集合s1とs2の積集合をコピー
	public void intersectionOf(IntSortedSet s1, IntSortedSet s2) {
		clear();
		for (int i = 0; i < s1.num; i++)
			if (s2.contains(s1.set[i]))
				add(s1.set[i]);
	}

	// 集合s1とs2の差集合をコピー
	public void differenceOf(IntSortedSet s1, IntSortedSet s2) {
		clear();
		for (int i = 0; i < s1.num; i++)
			if (!s2.contains(s1.set[i]))
				add(s1.set[i]);
	}
}