package com.example.projectapp.Domain;

import java.io.Serializable;

public class GunDomain implements Serializable {
    private String title;
    private String pic;
    private String description;
    private Double fee;
    private int star;
    private int caliber;
    private int ammunition;
    private int numberInCart;

    public GunDomain(String title, String pic, String description, Double fee, int star, int caliber, int ammunition) {
        this.title = title;
        this.pic = pic;
        this.description = description;
        this.fee = fee;
        this.star = star;
        this.caliber = caliber;
        this.ammunition = ammunition;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getCaliber() {
        return caliber;
    }

    public void setCaliber(int caliber) {
        this.caliber = caliber;
    }

    public int getAmmunition() {
        return ammunition;
    }

    public void setAmmunition(int ammunition) {
        this.ammunition = ammunition;
    }
}
