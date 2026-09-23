package com.example.gnhabp;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private static final List<Product> productList = new ArrayList<>();

    static {
        // Khởi tạo danh sách sản phẩm mẫu với GIÁ CHUẨN khớp với Trang chủ
        productList.add(new Product("HSML-040a", "Bộ Vá / Môi Múc Canh Gỗ", "Gỗ tự nhiên", "40 x 10 cm | Longer", 1000, 120000, "sp_coi_chay"));
        productList.add(new Product("HSVD-004a", "Bộ Cối Chày Gỗ Cao Cấp", "Gỗ tự nhiên", "40 x 10 cm | Longer", 1000, 220000, "sp_fork"));
        productList.add(new Product("HSVD-003a", "Kẹp Thức Ăn Gỗ Tự Nhiên", "Gỗ tự nhiên", "40 x 10 cm | Longer", 1000, 650000, "sp_ga_lung"));
        productList.add(new Product("HSN-152a", "Cây Cào / Gãi Lưng Gỗ", "Gỗ tự nhiên", "40 x 10 cm | Longer", 1000, 450000, "sp_gao_du"));
        productList.add(new Product("HSN-153a", "Thìa / Muỗng Gỗ Nhỏ", "Gỗ tự nhiên", "40 x 10 cm | Longer", 1000, 35000, "sp_ice_scoop"));
        productList.add(new Product("HSMT-001a", "Bộ Đũa Gỗ Cao Cấp", "Gỗ tự nhiên", "40 x 10 cm | Longer", 1000, 50000, "sp_tea_spoon"));
        productList.add(new Product("HSMT-002a", "Xẻng Gỗ Nấu Ăn", "Gỗ tự nhiên", "40 x 10 cm | Longer", 1000, 85000, "sp_va_canh"));
    }

    public static List<Product> getProducts() {
        return productList;
    }

    public static void addProduct(Product product) {
        productList.add(0, product); // Thêm sản phẩm mới lên đầu danh sách
    }
}