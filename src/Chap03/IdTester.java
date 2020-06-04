package Chap03;

//連番クラス
class Id {
	private static int counter = 0;		// 何番までの識別番号を与えたか

	private int id;							// 識別番号

	//-- コンストラクタ --//
	public Id() { id = ++counter; }

	//--- 識別番号を取得 ---//
	public int getId() { return id; }

	//--- 最大の識別番号を取得 ---//
	public static int getCounter() { return counter; }
}

public class IdTester {

	public static void main(String[] args) {
		Id a = new Id();		// 識別番号１番
		Id b = new Id();		// 識別番号２番

		System.out.println("aの識別番号：" + a.getId());
		System.out.println("bの識別番号：" + b.getId());

		System.out.println("最後に与えた識別番号 = " + Id.getCounter());
	}
}