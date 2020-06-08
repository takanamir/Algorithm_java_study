package Chap07.practice;

public class SetSample2 {
	// 集合sの全要素を追加する
	public boolean addAll(IntSet s) {
		boolean flag = false;
		for (int i = 0; i < s.num; i++)
			if (s.add(s.set[i]) == true)
				flag = true;
		return flag;
	}

	// 集合sに入っている要素のみを残して入っていない要素を削除する
	public boolean retainAll(IntSet s) {
		boolean flag = false;
		for (int i = 0; i < s.num; i++)
			if (s.contains(s.set[i]) == false) {
				s.remove(s.set[i]);
				flag = true;
			}
		return flag;
	}

	// 集合sに入っている全要素を削除する
	public boolean removeAll(IntSet s) {
		boolean flag = false;
		for (int i = 0; i < s.num; i++)
			if (s.contains(s.set[i]) == true) {
				s.remove(s.set[i]);
				flag = true;
			}
		return flag;
	}
}