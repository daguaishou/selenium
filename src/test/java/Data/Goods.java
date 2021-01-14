package Data;

public class Goods {
    //商品名
    private String goodsName;
    //供应商名
    private String conmpanyName;
    //规格型号
    private String Model;

    public String getGoodsName() {
        return goodsName;
    }

    public String getConmpanyName() {
        return conmpanyName;
    }

    public String getModel() {
        return Model;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public void setConmpanyName(String conmpanyName) {
        this.conmpanyName = conmpanyName;
    }

    public void setModel(String model) {
        Model = model;
    }
}
