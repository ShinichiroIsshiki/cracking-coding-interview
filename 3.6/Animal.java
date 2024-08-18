public abstract class Animal {
    private int order; // その動物がキューに追加された順序を保持
    protected String name; // 動物の名前

    public Animal(String n) {
        name = n;
    }

    public abstract String name();

    public void setOrder(int ord) {
        order = ord;
    }

    public int getOrder() {
        return order;
    }

    public boolean isOlderThan(Animal a) {
        return this.order < a.getOrder();
    }
}
