// Catクラス: Animalクラスを継承し、猫の名前を実装
class Cat extends Animal {
	public Cat(String n) {
		super(n);
	}
	
	@Override
	public String name() {
		return "Cat: " + name;
	}
}
