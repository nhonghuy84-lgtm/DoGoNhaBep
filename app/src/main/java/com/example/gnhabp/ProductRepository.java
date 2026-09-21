package com.example.gnhabp;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private static List<Product> productList = new ArrayList<>();

    static {
        // Gán đúng ID ảnh từ thư mục res/drawable
        productList.add(new Product("HSML-040a", "Fried Spoon (Large)", "Longan", "40 x 10 cm", 2000, 2.30, R.drawable.sp_fork));
        productList.add(new Product("HSVD-004a", "Rice Scoop", "Longan", "23 x 7.2 cm", 3000, 0.78, R.drawable.sp_rice_scoop));
        productList.add(new Product("HSVD-003a", "Rice Scoop", "Longan", "21.5 x 7.3 cm", 3000, 0.78, R.drawable.sp_rice_scoop));
        productList.add(new Product("HSN-152a", "Fork", "Longan", "15 x 1 cm", 5000, 0.50, R.drawable.sp_fork));
        productList.add(new Product("HSN-153a", "Fork", "Longan", "19 x 2.5 cm", 5000, 0.55, R.drawable.sp_fork));
        productList.add(new Product("HSMT-001a", "Tea Spoon (Short)", "Longan", "16 x 2.5 cm", 5000, 0.50, R.drawable.sp_tea_spoon));
        productList.add(new Product("HSMT-002a", "Tea Spoon (Long)", "Longan", "20 x 2.5 cm", 5000, 0.55, R.drawable.sp_tea_spoon));
    }

    public static List<Product> getSampleProducts() {
        return productList;
    }

    public static void addProduct(Product product) {
        productList.add(product);
    }
}