package Chap09.practice;

import java.util.Comparator;

// 循環リストを実現する配列カーソル版のクラス
public class AryCircleLinkedList<E> {
	//--- ノード ---//
	class Node<E> {
		private E data; // データ
		private int next; // リストの後続ポインタ（後続ノードのインデックス）
		private int dnext; // フリーリストの後続ポインタ（後続ノードのインデックス）

		//--- dataとnextを設定 ---//
		void set(E data, int next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node<E>[] n; // リスト本体
	private int size; // リストの容量（最大データ数）
	private int max; // 利用中の末尾レコード
	private int head; // 先頭ノード
	private int tail; // 末尾ノード
	private int crnt; // 着目ノード
	private int deleted; // フリーリストの先頭ノード
	private static final int NULL = -1; // 後続ノードは存在しない／リストが満杯

	//--- コンストラクタ ---//
	public AryCircleLinkedList(int capacity) {
		head = tail = crnt = max = deleted = NULL;
		try {
			n = new Node[capacity];
			for (int i = 0; i < capacity; i++) {
				n[i] = new Node<E>();
			}
			size = capacity;
		} catch (OutOfMemoryError e) { // 配列の生成に失敗
			size = 0;
		}
	}

	//--- 次に挿入するレコードのインデックスを求める ---//
	private int getInsertIndex() {
		if (deleted == NULL) { // 削除レコードは存在しない
			if (max < size) {
				return ++max; // 新しいレコードを利用
			} else {
				return NULL; // 容量オーバ
			}
		} else {
			int rec = deleted; // フリーリストから
			deleted = n[rec].dnext; // 先頭recを取り出す
			return rec;
		}
	}

	//--- レコードidxをフリーリストに登録 ---//
	private void deleteIndex(int idx) {
		if (deleted == NULL) { // 削除レコードは存在しない
			deleted = idx; // idxをフリーリストの
			n[idx].dnext = NULL; // 先頭に登録
		} else {
			int rec = deleted; // idxをフリーリストの
			deleted = idx; // 先頭に挿入
			n[idx].dnext = rec;
		}
	}

	//--- ノードを探索 ---//
	public E search(E o, Comparator<? super E> c) {
		if (head != NULL) {
			int ptr = head; // 現在走査中のノード

			do {
				if (c.compare(o, n[ptr].data) == 0) {
					crnt = ptr;
					return n[ptr].data; // 探索成功
				}
				ptr = n[ptr].next; // 後続ノードに着目
			} while (ptr != head);
		}
		return null; // 探索失敗
	}

	//--- 先頭にノードを挿入 ---//
	public void addFirst(E o) {
		if (head == NULL) {
			int rec = getInsertIndex();
			if (rec != NULL) {
				head = tail = crnt = rec;
				n[head].set(o, rec);
			}
		} else {
			int ptr = head; // 挿入前の先頭ノード
			int rec = getInsertIndex();
			if (rec != NULL) {
				head = crnt = rec; // 第recレコードに挿入
				n[head].set(o, ptr);
				n[tail].next = head;
			}
		}
	}

	//--- 末尾にノードを挿入 ---//
	public void addLast(E o) {
		if (head == NULL) { // リストが空であれば
			addFirst(o); // 先頭に挿入
		} else {
			int rec = getInsertIndex();
			if (rec != NULL) {
				n[tail].next = crnt = rec;
				n[rec].set(o, head);
				tail = rec;
			}
		}
	}

	//--- 先頭ノードを削除 ---//
	public void removeFirst() {
		if (head != NULL) { // リストが空でなければ
			if (head == tail) {
				deleteIndex(head);
				head = tail = crnt = NULL;
			} else {
				int ptr = n[head].next;
				deleteIndex(head);
				head = crnt = ptr;
				n[tail].next = head;
			}
		}
	}

	//--- 末尾ノードを削除 ---//
	public void removeLast() {
		if (head != NULL) {
			if (head == tail) { // ノードが一つだけであれば
				removeFirst(); // 先頭ノードを削除
			} else {
				int ptr = head; // 走査中のノード
				int pre = head; // 走査中のノードの先行ノード

				while (n[ptr].next != head) {
					pre = ptr;
					ptr = n[ptr].next;
				}
				n[pre].next = head; // preは削除後の末尾ノード
				deleteIndex(ptr);
				tail = crnt = pre;
			}
		}
	}

	//--- レコードpを削除 ---//
	public void remove(int p) {
		if (head != NULL) {
			if (p == head) { // pが先頭ノードであれば
				removeFirst(); // 先頭ノードを削除
			} else if (p == tail) { // pが末尾ノードであれば
				removeLast(); // 末尾ノードを削除
			} else {
				int ptr = head;

				while (n[ptr].next != p) {
					ptr = n[ptr].next;
					if (ptr == head) {
						return; // pはリスト上に存在しない
					}
				}
				n[ptr].next = n[p].next;
				deleteIndex(p);
				crnt = ptr;
			}
		}
	}

	//--- 着目ノードを削除 ---//
	public void removeCurrentNode() {
		remove(crnt);
	}

	//--- 全ノードを削除 ---//
	public void clear() {
		while (head != NULL) { // 空になるまで
			removeFirst(); // 先頭ノードを削除
		}
		crnt = NULL;
	}

	//--- 着目ノードを一つ後方に進める ---//
	public boolean next() {
		if (crnt == NULL || n[crnt].next == head) {
			return false; // 進めることはできなかった
		}
		crnt = n[crnt].next;
		return true;
	}

	//--- 着目ノードを表示 ---//
	public void printCurrentNode() {
		if (crnt == NULL) {
			System.out.println("着目ノードはありません。");
		} else {
			System.out.println(n[crnt].data.toString());
		}
	}

	//--- 全ノードを表示 ---//
	public void dump() {
		if (head != NULL) {
			int ptr = head;

			do {
				System.out.println(n[ptr].data.toString());
				ptr = n[ptr].next;
			} while (ptr != head);
		}
	}

	//--- コンパレータcによって互いに等しいとみなせる全ノードを削除 ---//
	public void purge(Comparator<? super E> c) {
		if (head == NULL) {
			return;
		}
		int ptr = head;

		do {
			int count = 0;
			int ptr2 = ptr;
			int pre = ptr;

			while (n[pre].next != head) {
				ptr2 = n[pre].next;
				
				if (c.compare(n[ptr].data, n[ptr2].data) == 0) {
					remove(ptr2);
					count++;
				} else {
					pre = ptr2;
				}
			}
			
			if (count == 0) {
				ptr = n[ptr].next;
			} else {
				int temp = n[ptr].next;
				remove(ptr);
				ptr = temp;
			}
		} while (n[ptr].next != head);
		crnt = head;
	}

	//--- 先頭からn個後ろのノードのデータへの参照を返却 ---//
	public E retrieve(int n) {
		if (head != NULL) {
			int ptr = head;

			while (n >= 0) {
				if (n-- == 0) {
					crnt = ptr;
					return this.n[ptr].data; // 探索成功
				}
				
				ptr = this.n[ptr].next; // 後続ノードに着目
				
				if (ptr == head) {
					break;
				}
			}
		}
		return (null);
	}
}