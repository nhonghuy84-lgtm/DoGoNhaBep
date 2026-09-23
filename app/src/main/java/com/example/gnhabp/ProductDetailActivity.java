package com.example.gnhabp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailActivity extends AppCompatActivity {

    private TextView tvDetailId, tvDetailName, tvDetailPrice, tvDetailSize, tvDetailMaterial;
    private ImageView imgDetailProduct;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        // 1. Ánh xạ View an toàn
        tvDetailId = findViewById(R.id.tvDetailId);
        tvDetailName = findViewById(R.id.tvDetailName);
        tvDetailPrice = findViewById(R.id.tvDetailPrice);
        tvDetailSize = findViewById(R.id.tvDetailSize);         // Nếu XML chưa có sẽ trả về null
        tvDetailMaterial = findViewById(R.id.tvDetailMaterial); // Nếu XML chưa có sẽ trả về null
        imgDetailProduct = findViewById(R.id.imgDetailProduct); // Nếu XML chưa có sẽ trả về null
        btnBack = findViewById(R.id.btnBack);

        // 2. Lấy dữ liệu truyền từ Intent
        Product product = (Product) getIntent().getSerializableExtra("product");

        String id = getIntent().getStringExtra("id");
        String name = getIntent().getStringExtra("name");
        double price = getIntent().getDoubleExtra("price", 0);
        String size = getIntent().getStringExtra("size");
        String material = getIntent().getStringExtra("material");

        if (product != null) {
            if (id == null) id = product.getId();
            if (name == null) name = product.getName();
            if (price == 0) price = product.getPrice();
            if (size == null) size = product.getSize();
            if (material == null) material = product.getMaterial();
        }

        // 3. Gán dữ liệu lên TextView
        if (tvDetailId != null) {
            tvDetailId.setText("Mã sản phẩm: " + (id != null ? id : "N/A"));
        }

        if (tvDetailName != null) {
            tvDetailName.setText("Tên sản phẩm: " + (name != null ? name : "N/A"));
        }

        if (tvDetailPrice != null) {
            double rawPrice = price;
            if (rawPrice > 0 && rawPrice < 100) {
                rawPrice = rawPrice * 100000;
            } else if (rawPrice >= 100 && rawPrice < 1000) {
                rawPrice = rawPrice * 1000;
            }
            long formattedPrice = (long) rawPrice;
            String priceText = String.format("%,d", formattedPrice).replace(',', '.') + " VNĐ";
            tvDetailPrice.setText("Giá sản phẩm: " + priceText);
        }

        if (tvDetailSize != null) {
            if (size != null && !size.isEmpty()) {
                tvDetailSize.setVisibility(View.VISIBLE);
                tvDetailSize.setText("Kích thước: " + size);
            } else {
                tvDetailSize.setVisibility(View.GONE);
            }
        }

        if (tvDetailMaterial != null) {
            if (material != null && !material.isEmpty()) {
                tvDetailMaterial.setVisibility(View.VISIBLE);
                tvDetailMaterial.setText("Chất liệu: " + material);
            } else {
                tvDetailMaterial.setVisibility(View.GONE);
            }
        }

        // 4. Hiển thị hình ảnh
        if (imgDetailProduct != null && product != null) {
            if (product.getImageRes() != 0) {
                imgDetailProduct.setImageResource(product.getImageRes());
            } else if (product.getImageUriStr() != null && !product.getImageUriStr().isEmpty()) {
                String imageName = product.getImageUriStr().replace(".png", "").replace(".jpg", "");
                int resId = getResources().getIdentifier(imageName, "drawable", getPackageName());
                if (resId != 0) {
                    imgDetailProduct.setImageResource(resId);
                } else {
                    imgDetailProduct.setImageResource(R.drawable.sp_coi_chay);
                }
            }
        }

        // 5. Nút Quay lại
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }
    }
}