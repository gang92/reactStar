package com.woorifis.reactstar.domain;

public class Restaurant {
    private String id;
    private String name;
    private String addressSi;
    private String addressGu;
    private String addressDong;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddressSi() {
        return addressSi;
    }

    public void setAddressSi(String addressSi) {
        this.addressSi = addressSi;
    }

    public String getAddressGu() {
        return addressGu;
    }

    public void setAddressGu(String addressGu) {
        this.addressGu = addressGu;
    }

    public String getAddressDong() {
        return addressDong;
    }

    public void setAddressDong(String addressDong) {
        this.addressDong = addressDong;
    }
}
