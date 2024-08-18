// Dogクラス: Animalクラスを継承し、犬の名前を実装
class Dog extends Animal {
	public Dog(String n) {
		super(n);
	}
	
	@Override
	public String name() {
		return "Dog: " + name;
	}
}
