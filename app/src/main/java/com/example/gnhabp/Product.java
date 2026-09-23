package com.example.gnhabp;

import java.io.Serializable;

public class Product implements Serializable {

    private String id;
    private String name;
    private String material;
    private String size;
    private int moq;
    private double price;
    private String imageUriStr;
    private int imageRes;

    public Product() {
    }

    public Product(String id, String name, String material, String size, int moq, double price, String imageUriStr) {
        this.id = id;
        this.name = name;
        this.material = material;
        this.size = size;
        this.moq = moq;
        this.price = price;
        this.imageUriStr = imageUriStr;
        this.imageRes = 0;
    }

    public Product(String id, String name, String size, double price, String imageUriStr) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.price = price;
        this.imageUriStr = imageUriStr;
    }

    public Product(String id, String name, String size, double price, int imageRes) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.price = price;
        this.imageRes = imageRes;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    public int getMoq() { return moq; }
    public void setMoq(int moq) { this.moq = moq; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getImageUriStr() { return imageUriStr; }
    public void setImageUriStr(String imageUriStr) { this.imageUriStr = imageUriStr; }

    public int getImageRes() { return imageRes; }
    public void setImageRes(int imageRes) { this.imageRes = imageRes; }
}