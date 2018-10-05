public abstract class Item {

    private String name;
    private int weight;

    public Item() {

    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String printItem() {
        String itemStr;
        itemStr = String.format("Item: %s \n Weight: %d", name, weight);

        return itemStr;

    }

}
