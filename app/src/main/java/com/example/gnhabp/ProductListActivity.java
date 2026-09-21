package com.example.gnhabp;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class ProductListActivity extends AppCompatActivity {

    private ListView lvProducts;
    private List<Product> productList;
    private ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        lvProducts = findViewById(R.id.lvProducts);

        // Lấy danh sách sản phẩm chuẩn từ ProductRepository
        productList = ProductRepository.getSampleProducts();

        // Đổ dữ liệu vào Adapter
        adapter = new ProductAdapter(this, productList);
        lvProducts.setAdapter(adapter);
    }
}