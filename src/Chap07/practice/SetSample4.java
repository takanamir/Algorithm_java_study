package Chap07.practice;

public class SetSample4 {
	SetSample setSample = new SetSample();
	IntSet intSet = new IntSet(0);
	
	// 集合s1とs2の積集合をコピー
	public void intersectionOf(IntSet s1, IntSet s2) {
		setSample.clear();
		for (int i = 0; i < s1.num; i++)
			if (s2.contains(s1.set[i]))
				intSet.add(s1.set[i]);
	}

	// 集合s1とs2の差集合をコピー
	public void differenceOf(IntSet s1, IntSet s2) {
		setSample.clear();
		for (int i = 0; i < s1.num; i++)
			if (!s2.contains(s1.set[i]))
				intSet.add(s1.set[i]);
	}
}