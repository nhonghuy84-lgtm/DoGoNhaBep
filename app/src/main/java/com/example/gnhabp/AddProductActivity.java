package com.example.gnhabp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class AddProductActivity extends AppCompatActivity {

    // === BỔ SUNG 2 DÒNG NÀY ĐỂ KHỦNG LỖI ===
    private ImageView imgPreview;
    private Button btnSelectImage;
    // ======================================

    private Button btnAddProductSubmit;
    private EditText etProductId, etProductName, etMaterial, etSize, etMoq, etPrice;
    private Uri selectedImageUri = null;

    private final ActivityResultLauncher<Intent> imagePickerLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    selectedImageUri = result.getData().getData();
                    if (selectedImageUri != null && imgPreview != null) {
                        imgPreview.setImageURI(selectedImageUri);
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        // Ánh xạ View
        imgPreview = findViewById(R.id.imgPreview);
        btnSelectImage = findViewById(R.id.btnSelectImage);
        btnAddProductSubmit = findViewById(R.id.btnAddProductSubmit);

        etProductId = findViewById(R.id.etProductId);
        etProductName = findViewById(R.id.etProductName);
        etMaterial = findViewById(R.id.etMaterial);
        etSize = findViewById(R.id.etSize);
        etMoq = findViewById(R.id.etMoq);
        etPrice = findViewById(R.id.etPrice);

        btnSelectImage.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            imagePickerLauncher.launch(intent);
        });

        btnAddProductSubmit.setOnClickListener(v -> saveProduct());
    }

    private void saveProduct() {
        String id = etProductId.getText().toString().trim();
        String name = etProductName.getText().toString().trim();
        String material = etMaterial.getText().toString().trim();
        String size = etSize.getText().toString().trim();
        String moqStr = etMoq.getText().toString().trim();
        String priceStr = etPrice.getText().toString().trim();

        if (TextUtils.isEmpty(id) || TextUtils.isEmpty(name) || TextUtils.isEmpty(priceStr)) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ Mã, Tên và Giá!", Toast.LENGTH_SHORT).show();
            return;
        }

        int moq = moqStr.isEmpty() ? 1000 : Integer.parseInt(moqStr);
        double price = Double.parseDouble(priceStr);

        String imageUriStr = (selectedImageUri != null) ? selectedImageUri.toString() : null;

        Product newProduct = new Product(id, name, material, size, moq, price, imageUriStr);
        ProductRepository.addProduct(newProduct);

        Toast.makeText(this, "Thêm sản phẩm thành công!", Toast.LENGTH_SHORT).show();
        finish();
    }
}