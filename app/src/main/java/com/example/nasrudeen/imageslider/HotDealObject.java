package com.example.nasrudeen.imageslider;

/**
 * Created by nasrudeen on 29/7/17.
 */

class HotDealObject {
    private String dealPrice,s1,dealName,dealDescription;

    public String getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(String dealPrice) {
        this.dealPrice = dealPrice;
    }

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public String getDealName() {
        return dealName;
    }

    public void setDealName(String dealName) {
        this.dealName = dealName;
    }

    public String getDealDescription() {
        return dealDescription;
    }

    public void setDealDescription(String dealDescription) {
        this.dealDescription = dealDescription;
    }

    public HotDealObject(String dealPrice, String s1, String dealName, String dealDescription) {
        this.dealPrice = dealPrice;
        this.s1 = s1;
        this.dealName = dealName;
        this.dealDescription = dealDescription;
    }
}
