package Chap03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//身体検査データ配列からの探索
public class PhysExamSearch {
	//--- 身体検査データ ---//
	static class PhyscData {
		private String name; // 氏名
		private int height; // 身長
		private double vision; // 視力

		//--- コンストラクタ ---//
		public PhyscData(String name, int height, double vision) {
			this.name = name;
			this.height = height;
			this.vision = vision;
		}

		//--- 文字列化 --//
		public String toString() {
			return name + " " + height + " " + vision;
		}

		//--- 身長昇順用コンパレータ ---//
		public static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();

		private static class HeightOrderComparator
				implements Comparator<PhyscData> {
			public int compare(PhyscData d1, PhyscData d2) {
				return (d1.height > d2.height) ? 1 : (d1.height < d2.height) ? -1 : 0;
			}
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		PhyscData[] x = { // 配列の要素は身長順でなければならない
				new PhyscData("赤坂忠雄", 162, 0.3),
				new PhyscData("長浜良一", 168, 0.4),
				new PhyscData("松富明雄", 169, 0.8),
				new PhyscData("武田信也", 171, 1.5),
				new PhyscData("加藤富明", 173, 0.7),
				new PhyscData("浜田哲明", 174, 1.2),
				new PhyscData("斉藤正二", 175, 2.0),
		};
		System.out.print("何cmの人を探しますか：");
		int height = stdIn.nextInt(); // キー値の読込み
		int idx = Arrays.binarySearch(
				x, // 配列xから
				new PhyscData("", height, 0.0), // 身長がheightの要素を
				PhyscData.HEIGHT_ORDER // HEIGHT_ORDERによって探索
		);

		if (idx < 0)
			System.out.println("その値の要素は存在しません。");
		else {
			System.out.println("その値はx[" + idx + "]にあります。");
			System.out.println("データ：" + x[idx]);
		}
	}
}