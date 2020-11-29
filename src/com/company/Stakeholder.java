package com.company;

public class Stakeholder {
    private String holderID;
    private String holderName;
    private String holderAddress;
    private double holderBalance;

    @Override
    public String toString() {
        return "Stakeholder{" +
                "idNumber=" + holderID +
                ", holderName='" + holderName + '\'' +
                ", holderAddress='" + holderAddress + '\'' +
                ", holderBalance=" + holderBalance +
                '}';
    }

    public String getIdNumber() {
        return holderID;
    }

    public void setIdNumber(String idNumber) {
        this.holderID = idNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getHolderAddress() {
        return holderAddress;
    }

    public void setHolderAddress(String holderAddress) {
        this.holderAddress = holderAddress;
    }

    public double getHolderBalance() {
        return holderBalance;
    }

    public void setHolderBalance(double holderBalance) {
        this.holderBalance = holderBalance;
    }
}
