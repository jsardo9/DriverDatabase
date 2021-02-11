public class Swift implements Truck {
    public static final String MODEL = "Swift";
    private int weight;
    private String goods;

    public Swift(int weight, String goods) {
        this.weight = weight;
        this.goods = goods;
    }

    public String getModel() {
        return MODEL;
    }

    public int getWeight() {
        return weight;
    }

    public String goodsType() {
        return goods;
    }
}
