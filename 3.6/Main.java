// メインクラス: プログラムのエントリーポイント
public class Main {

	// メインメソッド: プログラムの実行開始点
	public static void main(String[] args) {
		AnimalQueue animals = new AnimalQueue(); // 動物のキューを作成
		animals.enqueue(new Cat("Callie")); // 猫をキューに追加
		animals.enqueue(new Cat("Kiki")); // 猫をキューに追加
		animals.enqueue(new Dog("Fido")); // 犬をキューに追加
		animals.enqueue(new Dog("Dora")); // 犬をキューに追加
		animals.enqueue(new Cat("Kari")); // 猫をキューに追加
		animals.enqueue(new Dog("Dexter")); // 犬をキューに追加
		animals.enqueue(new Dog("Dobo")); // 犬をキューに追加
		animals.enqueue(new Cat("Copa")); // 猫をキューに追加
		
		// 最も古い動物を取り出して名前を表示
		System.out.println(animals.dequeueAny().name());	
		System.out.println(animals.dequeueAny().name());	
		System.out.println(animals.dequeueAny().name());	
		
		// 新しい動物をキューに追加
		animals.enqueue(new Dog("Dapa"));
		animals.enqueue(new Cat("Kilo"));
		
		// キューが空になるまで最も古い動物を取り出して名前を表示
		while (animals.size() != 0) {
			System.out.println(animals.dequeueAny().name());	
		}
	}
}
