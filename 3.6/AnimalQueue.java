import java.util.LinkedList;

// AnimalQueueクラス: 犬と猫を管理するキューを実装
class AnimalQueue {
	LinkedList<Dog> dogs = new LinkedList<Dog>(); // 犬のキュー
	LinkedList<Cat> cats = new LinkedList<Cat>(); // 猫のキュー
	private int order = 0; // 動物が追加される順序を管理
	
	// 動物をキューに追加するメソッド
	public void enqueue(Animal a) {
		a.setOrder(order); // 動物に順序を設定
		order++; // 次の順序に進める
		if (a instanceof Dog) { // もし動物が犬なら
			dogs.addLast((Dog) a); // 犬のキューに追加
		} else if (a instanceof Cat) { // もし動物が猫なら
			cats.addLast((Cat)a); // 猫のキューに追加
		}
	}
	
	// 最も古い動物を取り出すメソッド
	public Animal dequeueAny() {
		if (dogs.size() == 0) { // 犬のキューが空なら
			return dequeueCats(); // 猫のキューから取り出す
		} else if (cats.size() == 0) { // 猫のキューが空なら
			return dequeueDogs(); // 犬のキューから取り出す
		}
		Dog dog = dogs.peek(); // 最古の犬を取得
		Cat cat = cats.peek(); // 最古の猫を取得
		if (dog.isOlderThan(cat)) { // 犬が猫より古ければ
			return dogs.poll(); // 犬を取り出す
		} else {
			return cats.poll(); // そうでなければ猫を取り出す
		}
	}
	
	// 最も古い動物を確認するメソッド（取り出さない）
	public Animal peek() {
		if (dogs.size() == 0) { // 犬のキューが空なら
			return cats.peek(); // 猫のキューを確認
		} else if (cats.size() == 0) { // 猫のキューが空なら
			return dogs.peek(); // 犬のキューを確認
		}
		Dog dog = dogs.peek(); // 最古の犬を取得
		Cat cat = cats.peek(); // 最古の猫を取得
		if (dog.isOlderThan(cat)) { // 犬が猫より古ければ
			return dog; // 犬を返す
		} else {
			return cat; // そうでなければ猫を返す
		}
	}
	
	// 全体のサイズを取得するメソッド
	public int size() {
		return dogs.size() + cats.size(); // 犬と猫のキューの合計サイズを返す
	}
	
	// 最も古い犬を取り出すメソッド
	public Dog dequeueDogs() {
		return dogs.poll();
	}
	
	// 最も古い犬を確認するメソッド（取り出さない）
	public Dog peekDogs() {
		return dogs.peek();
	}
	
	// 最も古い猫を取り出すメソッド
	public Cat dequeueCats() {
		return cats.poll();
	}
	
	// 最も古い猫を確認するメソッド（取り出さない）
	public Cat peekCats() {
		return cats.peek();
	}
}
