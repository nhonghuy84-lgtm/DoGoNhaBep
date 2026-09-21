package com.example.gnhabp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnProductList, btnAddProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ ID các nút bấm từ layout activity_main.xml
        btnProductList = findViewById(R.id.btnProductList); // Hoặc ID tương ứng nút DS Sản phẩm
        btnAddProduct = findViewById(R.id.btnAddProduct);   // Hoặc ID tương ứng nút Thêm Sản phẩm

        // 1. Sự kiện bấm nút "Danh sách sản phẩm"
        btnProductList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProductListActivity.class);
                startActivity(intent);
            }
        });

        // 2. BƯỚC 4: Sự kiện bấm nút "Thêm sản phẩm" dán vào đây
        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddProductActivity.class);
                startActivity(intent);
            }
        });
    }
}