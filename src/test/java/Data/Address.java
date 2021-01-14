package Data;

public class Address {
    private String province;
    private String city;
    private String area;
    private String Detaaddress;

    //获取省
    public String getProvince() {
        return province;
    }

    //获取市
    public String getCity() {
        return city;
    }

    //获取区
    public String getArea() {
        return area;
    }

    //获取详细地址
    public String getDetaaddress() {
        return Detaaddress;
    }

    //设置省
    public void setProvince(String province) {
        this.province = province;
    }

    //设置市
    public void setCity(String city) {
        this.city = city;
    }

    //设置区
    public void setArea(String area) {
        this.area = area;
    }

    //设置详细地址
    public void setDetaaddress(String detaaddress) {
        Detaaddress = detaaddress;
    }
}
