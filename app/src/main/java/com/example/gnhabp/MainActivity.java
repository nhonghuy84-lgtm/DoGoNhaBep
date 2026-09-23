package com.example.gnhabp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnProductList, btnAddProduct, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ ID trùng khớp 100% với file XML
        btnProductList = findViewById(R.id.btnProductList);
        btnAddProduct = findViewById(R.id.btnAddProduct);
        btnLogout = findViewById(R.id.btnLogout);

        // 1. Mở DANH SÁCH SẢN PHẨM (Ảnh 4)
        if (btnProductList != null) {
            btnProductList.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, ProductListActivity.class);
                startActivity(intent);
            });
        }

        // 2. Mở THÊM SẢN PHẨM
        if (btnAddProduct != null) {
            btnAddProduct.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, AddProductActivity.class);
                startActivity(intent);
            });
        }

        // 3. THOÁT -> Quay về Trang chủ (HomeActivity)
        if (btnLogout != null) {
            btnLogout.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            });
        }
    }
}