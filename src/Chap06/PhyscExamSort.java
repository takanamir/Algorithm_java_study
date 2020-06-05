package Chap06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//身体検査データ配列のソート
public class PhyscExamSort {
	//--- 身体検査データ ---//
	static class PhyscData {
		String name; // 氏名
		int height; // 身長
		double vision; // 視力

		//--- コンストラクタ ---//
		PhyscData(String name, int height, double vision) {
			this.name = name;
			this.height = height;
			this.vision = vision;
		}

		//--- 文字列化 --//
		public String toString() {
			return name + " " + height + " " + vision;
		}

		//--- 身長昇順用コンパレータ ---//
		static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();

		private static class HeightOrderComparator
				implements Comparator<PhyscData> {
			public int compare(PhyscData d1, PhyscData d2) {
				return (d1.height > d2.height) ? 1 : (d1.height < d2.height) ? -1 : 0;
			}
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		PhyscData[] x = {
				new PhyscData("赤坂忠雄", 162, 0.3),
				new PhyscData("加藤富明", 173, 0.7),
				new PhyscData("斉藤正二", 175, 2.0),
				new PhyscData("武田信也", 171, 1.5),
				new PhyscData("長浜良一", 168, 0.4),
				new PhyscData("浜田哲明", 174, 1.2),
				new PhyscData("松富明雄", 169, 0.8),
		};

		Arrays.sort(x, 	PhyscData.HEIGHT_ORDER); // 配列xを、HEIGHT_ORDERを用いてソート

		System.out.println("■ 身体検査一覧表 ■");
		System.out.println(" 氏名      身長 視力");
		System.out.println("--------------------");
		for (int i = 0; i < x.length; i++)
			System.out.printf("%-8s%3d%5.1f\n",
					x[i].name, x[i].height, x[i].vision);
	}
}