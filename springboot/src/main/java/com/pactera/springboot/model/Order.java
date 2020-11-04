package com.pactera.springboot.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * @Author Karen
 * @Date 2020/10/30 16:21
 * @DoSomeThing
 */
@TableName("demo_order")
public class Order {

    @TableId
    private String orderNo;
    private String name;
    private String productCode;
    private String productName;
    private Integer number;
    private Date dateTime;
    private String memberCode;
    private String memberName;
    private String mobile;
    private String address;
    private String remark;

    public Order() {
    }

    public Order(String orderNo, String name, String productCode, String productName, Integer number, Date dateTime, String memberCode, String memberName, String mobile, String address, String remark) {
        this.orderNo = orderNo;
        this.name = name;
        this.productCode = productCode;
        this.productName = productName;
        this.number = number;
        this.dateTime = dateTime;
        this.memberCode = memberCode;
        this.memberName = memberName;
        this.mobile = mobile;
        this.address = address;
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNo='" + orderNo + '\'' +
                ", name='" + name + '\'' +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", number=" + number +
                ", dateTime=" + dateTime +
                ", memberCode='" + memberCode + '\'' +
                ", memberName='" + memberName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
