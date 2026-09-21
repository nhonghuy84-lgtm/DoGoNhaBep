package com.example.gnhabp;

public class Product {
    private String id;
    private String name;
    private String material;
    private String size;
    private int moq;
    private double price;
    private int imageResId;
    private String imageUri;

    // Constructor cho sản phẩm mặc định (dùng imageResId trong drawable)
    public Product(String id, String name, String material, String size, int moq, double price, int imageResId) {
        this.id = id;
        this.name = name;
        this.material = material;
        this.size = size;
        this.moq = moq;
        this.price = price;
        this.imageResId = imageResId;
        this.imageUri = null;
    }

    // Constructor cho sản phẩm thêm mới (dùng imageUri chọn từ máy)
    public Product(String id, String name, String material, String size, int moq, double price, String imageUri) {
        this.id = id;
        this.name = name;
        this.material = material;
        this.size = size;
        this.moq = moq;
        this.price = price;
        this.imageResId = R.drawable.ic_store_logo; // Ảnh mặc định nếu không chọn URI
        this.imageUri = imageUri;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getMaterial() { return material; }
    public String getSize() { return size; }
    public int getMoq() { return moq; }
    public double getPrice() { return price; }
    public int getImageResId() { return imageResId; }
    public String getImageUri() { return imageUri; }
}