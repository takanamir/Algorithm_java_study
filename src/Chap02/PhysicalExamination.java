package Chap02;

import java.util.Scanner;

//身体検査データ用クラスの配列から平均身長と視力の分布を求める
public class PhysicalExamination {
	static final int VMAX = 21; // 視力の分布（0.0から0.1刻みで21個）

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
	}

	//--- 身長の平均値を求める ---//
	static double aveHeight(PhyscData[] dat) {
		double sum = 0;

		for (int i = 0; i < dat.length; i++)
			sum += dat[i].height;

		return sum / dat.length;
	}

	//--- 視力の分布を求める ---//
	static void distVision(PhyscData[] dat,
			int[] dist) {
		int i = 0;

		dist[i] = 0;
		for (i = 0; i < dat.length; i++)
			if (dat[i].vision >= 0.0 && dat[i].vision <= VMAX / 10.0)
				dist[(int) (dat[i].vision * 10)]++;
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
		int[] vdist = new int[VMAX]; // 視力の分布

		System.out.println("■ 身体検査一覧表 ■");
		System.out.println(" 氏名      身長 視力");
		System.out.println("--------------------");
		for (int i = 0; i < x.length; i++)
			System.out.printf("%-8s%3d%5.1f\n",
					x[i].name, x[i].height, x[i].vision);

		System.out.printf("\n平均身長：%5.1fcm\n", aveHeight(x));

		distVision(x, vdist); // 視力の分布を求める

		System.out.println("\n視力の分布");
		for (int i = 0; i < VMAX; i++)
			System.out.printf("%3.1f～：%2d人\n", i / 10.0, vdist[i]);
	}
}