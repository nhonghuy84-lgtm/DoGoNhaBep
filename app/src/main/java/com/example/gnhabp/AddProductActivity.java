package com.example.gnhabp;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddProductActivity extends AppCompatActivity {

    private EditText etId;
    private EditText etName;
    private EditText etMaterial;
    private EditText etSize;
    private EditText etMoq;
    private EditText etPrice;
    private Button btnSave;
    private Button btnBack;

    private Uri selectedImageUri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        etId = findViewById(R.id.etId);
        etName = findViewById(R.id.etName);
        etMaterial = findViewById(R.id.etMaterial);
        etSize = findViewById(R.id.etSize);
        etMoq = findViewById(R.id.etMoq);
        etPrice = findViewById(R.id.etPrice);
        btnSave = findViewById(R.id.btnSave);
        btnBack = findViewById(R.id.btnBack);

        if (btnSave != null) {
            btnSave.setOnClickListener(v -> saveProduct());
        }

        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }
    }

    private void saveProduct() {
        String id = etId != null ? etId.getText().toString().trim() : "";
        String name = etName != null ? etName.getText().toString().trim() : "";
        String material = etMaterial != null ? etMaterial.getText().toString().trim() : "";
        String size = etSize != null ? etSize.getText().toString().trim() : "";
        String moqStr = etMoq != null ? etMoq.getText().toString().trim() : "";
        String priceStr = etPrice != null ? etPrice.getText().toString().trim() : "";

        if (TextUtils.isEmpty(id) || TextUtils.isEmpty(name) || TextUtils.isEmpty(priceStr)) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ Mã, Tên và Giá!", Toast.LENGTH_SHORT).show();
            return;
        }

        int moq = 1000;
        if (!moqStr.isEmpty()) {
            try {
                moq = Integer.parseInt(moqStr);
            } catch (Exception e) {
                moq = 1000;
            }
        }

        double price = 0;
        try {
            price = Double.parseDouble(priceStr);
        } catch (Exception e) {
            price = 0;
        }

        String imageUriStr = selectedImageUri != null ? selectedImageUri.toString() : null;

        Product newProduct = new Product(id, name, material, size, moq, price, imageUriStr);
        ProductRepository.addProduct(newProduct);

        Toast.makeText(this, "Thêm sản phẩm thành công!", Toast.LENGTH_SHORT).show();
        finish();
    }
}