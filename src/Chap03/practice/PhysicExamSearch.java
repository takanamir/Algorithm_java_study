package Chap03.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 視力検査データ配列からの探索
public class PhysicExamSearch {
	//--- 身体検査データ ---//
	private static class PhysicalData {
		private String name; // 氏名
		private int height; // 身長
		private double vision; // 視力

		//--- コンストラクタ ---//
		public PhysicalData(String name, int height, double vision) {
			this.name = name;
			this.height = height;
			this.vision = vision;
		}

		//--- 文字列化 --//
		public String toString() {
			return name + " " + height + " " + vision;
		}

		//--- 視力降順用コンパレータ ---//
		public static final Comparator<PhysicalData> VISION_ORDER = new VisionOrderComparator();

		private static class VisionOrderComparator implements Comparator<PhysicalData> {
			public int compare(PhysicalData d1, PhysicalData d2) {
				return (d1.vision > d2.vision) ? 1 : (d1.vision < d2.vision) ? -1 : 0;
			}
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		PhysicalData[] x = { // 配列の要素は視力順でなければならない
				new PhysicalData("赤坂忠雄", 162, 0.3),
				new PhysicalData("長浜良一", 168, 0.4),
				new PhysicalData("加藤富明", 173, 0.7),
				new PhysicalData("松富明雄", 169, 0.8),
				new PhysicalData("浜田哲明", 174, 1.2),
				new PhysicalData("武田信也", 171, 1.5),
				new PhysicalData("斉藤正二", 175, 2.0),
		};
		System.out.print("探す視力は：");
		double vision = stdIn.nextDouble(); // キー値の読込み
		int idx = Arrays.binarySearch(
				x, // 配列xから
				new PhysicalData("", 0, vision), // 身長がvisionの要素を
				PhysicalData.VISION_ORDER // VISION_ORDERを用いて探索
		);

		if (idx < 0) {
			System.out.println("その値の要素は存在しません。");
		} else {
			System.out.println("その値は" + "x[" + idx + "]にあります。");
			System.out.println("データ：" + x[idx]);
		}
		stdIn.close();
	}
}