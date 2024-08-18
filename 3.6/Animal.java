// 抽象クラス Animal: 犬や猫の共通の特徴を定義
abstract class Animal {
	private int order; // その動物がキューに追加された順序を保持
	protected String name; // 動物の名前

	// コンストラクタ: 名前を初期化
	public Animal(String n) {
		name = n;
	}
	
	// 抽象メソッド: 各動物クラスで実装されるべき名前を返すメソッド
	public abstract String name();
	
	// 動物の順序を設定するメソッド
	public void setOrder(int ord) {
		order = ord;
	}
	
	// 動物の順序を取得するメソッド
	public int getOrder() {
		return order;
	}
	
	// 引数の動物よりも順序が早いかどうかを判定するメソッド
	public boolean isOlderThan(Animal a) {
		return this.order < a.getOrder();
	}
}
