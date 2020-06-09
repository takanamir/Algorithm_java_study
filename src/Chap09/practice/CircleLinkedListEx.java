package Chap09.practice;

import java.util.Comparator;

// 循環リストを実現するクラス
public class CircleLinkedListEx<E> {
	//--- ノード ---//
	class Node<E> {
		E data; // データ
		Node<E> next; // 後続ポインタ（後続ノードへの参照）

		//--- コンストラクタ ---//
		Node(E data) {
			this.data = data;
			this.next = this;
		}

		//--- コンストラクタ ---//
		Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node<E> head; // 先頭ノード
	private Node<E> tail; // 末尾ノード
	private Node<E> crnt; // 着目ノード

	//--- コンストラクタ ---//
	public CircleLinkedListEx() {
		head = tail = crnt = null;
	}

	//--- ノードを探索 ---//
	public E search(E o, Comparator<? super E> c) {
		if (head != null) {
			Node<E> ptr = head; // 現在走査中のノード

			do {
				if (c.compare(o, ptr.data) == 0) { // 探索成功
					crnt = ptr;
					return ptr.data;
				}
				ptr = ptr.next; // 後続ノードに着目
			} while (ptr != head);
		}
		return null; // 探索失敗
	}

	//--- 先頭にノードを挿入 ---//
	public void addFirst(E o) {
		if (head == null) {
			head = tail = crnt = new Node<E>(o);
		} else {
			Node<E> ptr = head;
			head = crnt = new Node<E>(o, ptr);
			tail.next = head;
		}
	}

	//--- 末尾にノードを挿入 ---//
	public void addLast(E o) {
		if (head == null) { // リストが空であれば
			addFirst(o); // 先頭に挿入
		} else {
			Node<E> ptr = tail;
			ptr.next = crnt = tail = new Node<E>(o, head);
		}
	}

	//--- 先頭ノードを削除 ---//
	public void removeFirst() {
		if (head != null) { // リストが空でなければ
			if (head == tail) {
				head = tail = crnt = null;
			} else {
				Node<E> ptr = head.next;
				head = crnt = ptr;
				tail.next = head;
			}
		}
	}

	//--- 末尾ノードを削除 ---//
	public void removeLast() {
		if (head != null) {
			if (head == tail) { // ノードが一つだけであれば
				removeFirst(); // 先頭ノードを削除
			} else {
				Node<E> ptr = head; // 走査中のノード
				Node<E> pre = head; // 走査中のノードの先行ノード

				while (ptr.next != head) {
					pre = ptr;
					ptr = ptr.next;
				}
				pre.next = head; // preは削除後の末尾ノード
				tail = crnt = pre;
			}
		}
	}

	//--- ノードpを削除 ---//
	public void remove(Node<E> p) {
		if (head != null) {
			if (p == head) { // pが先頭ノードであれば
				removeFirst(); // 先頭ノードを削除
			} else if (p == tail) { // pが末尾ノードであれば
				removeLast(); // 末尾ノードを削除
			} else {
				Node<E> ptr = head;

				while (ptr.next != p) {
					ptr = ptr.next;
					
					if (ptr == head) {
						return; // pはリスト上に存在しない
					}
				}
				ptr.next = p.next;
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
		while (head != null) { // 空になるまで
			removeFirst(); // 先頭ノードを削除
		}
		crnt = null;
	}

	//--- 着目ノードを一つ後方に進める ---//
	public boolean next() {
		if (crnt == null || crnt.next == head) {
			return false; // 進めることはできなかった
		}
		crnt = crnt.next;
		return true;
	}

	//--- 着目ノードを表示 ---//
	public void printCurrentNode() {
		if (crnt == null) {
			System.out.println("着目ノードはありません。");
		} else {
			System.out.println(crnt.data.toString());
		}
	}

	//--- 全ノードを表示 ---//
	public void dump() {
		if (head != null) {
			Node<E> ptr = head;

			do {
				System.out.println(ptr.data.toString());
				ptr = ptr.next;
			} while (ptr != head);
		}
	}

	//--- コンパレータcによって互いに等しいとみなせる全ノードを削除 ---//
	public void purge(Comparator<? super E> c) {
		if (head == null) {
			return;
		}
		Node<E> ptr = head;

		do {
			int count = 0;
			Node<E> ptr2 = ptr;
			Node<E> pre = ptr;

			while (pre.next != head) {
				ptr2 = pre.next;
				if (c.compare(ptr.data, ptr2.data) == 0) {
					remove(ptr2);
					count++;
				} else {
					pre = ptr2;
				}
			}
			if (count == 0) {
				ptr = ptr.next;
			} else {
				Node<E> temp = ptr;
				remove(ptr);
				ptr = temp.next;
			}
		} while (ptr.next != head);
		crnt = head;
	}

	//--- 先頭からn個後ろのノードのデータへの参照を返却 ---//
	public E retrieve(int n) {
		if (head != null) {
			Node<E> ptr = head;

			while (n >= 0) {
				if (n-- == 0) {
					crnt = ptr;
					return (ptr.data); // 探索成功
				}
				ptr = ptr.next; // 後続ノードに着目
				if (ptr == head) {
					break;
				}
			}
		}
		return (null);
	}
}