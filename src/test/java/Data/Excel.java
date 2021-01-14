package Data;

import java.util.List;

public class Excel {
    //浏览器
    private String borwser;
    //浏览器驱动
    private String borwserAdd;
    //打开的网址
    private String borwserUrl;
    //用户
    private User user;
    //交货地址List
    private Address deliveryAdd;
    //付款方式
    private Pay pay;
    //商品
    private Goods goods;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public User getUser() {
        return user;
    }

    public Address getDeliveryAdd() {
        return deliveryAdd;
    }

    public Pay getPay() {
        return pay;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setDeliveryAdd(Address deliveryAdd) {
        this.deliveryAdd = deliveryAdd;
    }

    public void setPay(Pay pay) {
        this.pay = pay;
    }

    public String getBorwser() {
        return borwser;
    }

    public String getBorwserAdd() {
        return borwserAdd;
    }

    public String getBorwserUrl() {
        return borwserUrl;
    }

    public void setBorwser(String borwser) {
        this.borwser = borwser;
    }

    public void setBorwserAdd(String borwserAdd) {
        this.borwserAdd = borwserAdd;
    }

    public void setBorwserUrl(String borwserUrl) {
        this.borwserUrl = borwserUrl;
    }
}
