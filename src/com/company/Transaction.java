package com.company;

import java.time.LocalDateTime;

public class Transaction {
    private Artifact artifact;
    private int timestamp;
    private Stakeholder seller;
    private Stakeholder buyer;
    private Stakeholder auctionHouse;
    private double price;

    @Override
    public String toString() {
        return "Transaction{" +
                "artifact=" + artifact +
                ", timestamp=" + timestamp +
                ", seller=" + seller +
                ", buyer=" + buyer +
                ", auctionHouse=" + auctionHouse +
                ", price=" + price +
                '}';
    }

    public Artifact getArtifact() {
        return artifact;
    }

    public void setArtifact(Artifact artifact) {
        this.artifact = artifact;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public Stakeholder getSeller() {
        return seller;
    }

    public void setSeller(Stakeholder seller) {
        this.seller = seller;
    }

    public Stakeholder getBuyer() {
        return buyer;
    }

    public void setBuyer(Stakeholder buyer) {
        this.buyer = buyer;
    }

    public Stakeholder getAuctionHouse() {
        return auctionHouse;
    }

    public void setAuctionHouse(Stakeholder auctionHouse) {
        this.auctionHouse = auctionHouse;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
