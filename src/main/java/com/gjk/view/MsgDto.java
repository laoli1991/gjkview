package com.gjk.view;

/**
 * @Author: liyang117
 * @Date: 2018/5/13 15:36
 * @Description:
 */
public class MsgDto {
    private String voucherName;
    private String typeDesc;
    private String nowTime;
    private String amount;
    private String key1;
    private String value1;
    private String key2;
    private String value2;
    private String commonInfo;

    public MsgDto() {
        this.voucherName = "" ;
        this.typeDesc = "" ;
        this.nowTime = "" ;
        this.amount = "" ;
        this.key1 = "" ;
        this.value1 = "" ;
        this.key2 = "" ;
        this.value2 = "" ;
        this.commonInfo = "" ;
    }

    public String getVoucherName() {
        return voucherName;
    }

    public void setVoucherName(String voucherName) {
        this.voucherName = voucherName;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public String getNowTime() {
        return nowTime;
    }

    public void setNowTime(String nowTime) {
        this.nowTime = nowTime;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getKey2() {
        return key2;
    }

    public void setKey2(String key2) {
        this.key2 = key2;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String getCommonInfo() {
        return commonInfo;
    }

    public void setCommonInfo(String commonInfo) {
        this.commonInfo = commonInfo;
    }
}
