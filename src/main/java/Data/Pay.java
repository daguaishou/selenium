package Data;

public class Pay {
    //付款方式
    private String payWay;
    //单选付款方式
    private String payWayRadio;
    //业务形式
    private String Businessform;
    //零库存
    private boolean ZeroStock;
    //合同签订预付
    private float prePay;
    //排产、发货
    private String prePayframe;
    //发货前、货到后
    private String Delivergoods;
    //付款1
    private float payment1;
    //货到后
    private String Receivinggoods;
    //月份
    private String month;
    //付款2
    private float payment2;
    //质保期
    private int WarrantyPeriod;
    //质保金
    private float Premium;
    //付款补充说明
    private String payExplain;

    public String getPayExplain() {
        return payExplain;
    }

    public void setPayExplain(String payExplain) {
        this.payExplain = payExplain;
    }

    public String getPayWay() {
        return payWay;
    }

    public String getPayWayRadio() {
        return payWayRadio;
    }

    public String getBusinessform() {
        return Businessform;
    }

    public boolean isZeroStock() {
        return ZeroStock;
    }

    public float getPrePay() {
        return prePay;
    }

    public String getPrePayframe() {
        return prePayframe;
    }

    public String getDelivergoods() {
        return Delivergoods;
    }

    public float getPayment1() {
        return payment1;
    }

    public String getReceivinggoods() {
        return Receivinggoods;
    }

    public String getMonth() {
        return month;
    }

    public float getPayment2() {
        return payment2;
    }

    public int getWarrantyPeriod() {
        return WarrantyPeriod;
    }

    public float getPremium() {
        return Premium;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public void setPayWayRadio(String payWayRadio) {
        this.payWayRadio = payWayRadio;
    }

    public void setBusinessform(String businessform) {
        Businessform = businessform;
    }

    public void setZeroStock(boolean zeroStock) {
        ZeroStock = zeroStock;
    }

    public void setPrePay(float prePay) {
        this.prePay = prePay;
    }

    public void setPrePayframe(String prePayframe) {
        this.prePayframe = prePayframe;
    }

    public void setDelivergoods(String delivergoods) {
        Delivergoods = delivergoods;
    }

    public void setPayment1(float payment1) {
        this.payment1 = payment1;
    }

    public void setReceivinggoods(String receivinggoods) {
        Receivinggoods = receivinggoods;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setPayment2(float payment2) {
        this.payment2 = payment2;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        WarrantyPeriod = warrantyPeriod;
    }

    public void setPremium(float premium) {
        Premium = premium;
    }
}
