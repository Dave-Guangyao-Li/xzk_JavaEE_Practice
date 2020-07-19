package chap3.deliveryManagement.bean;

import java.util.Objects;

/**
 * @Author: 0707-李光耀 Dave_GY_Li
 * @Description:封装描述快递的信息，没有任何业务逻辑，所有属性全部私有，提供构造器，getter/setter方法
 * @Date Created in 2020-07-19 19:25
 * @Modified By:
 */
public class Express {
    //单号
    private String number;
    //快递公司
    private String company;
    //取件码
    private int code;

    public Express(String number, String company, int code) {
        this.number = number;
        this.company = company;
        this.code = code;
    }

    public Express() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Express{" +
                "number='" + number + '\'' +
                ", company='" + company + '\'' +
                ", code=" + code +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Express express = (Express) o;
        return number.equals(express.number);//
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
