package com.example.gnhabp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView rvHomeProducts;
    private TextView btnAccount, tvResultCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rvHomeProducts = findViewById(R.id.rvHomeProducts);
        btnAccount = findViewById(R.id.btnAccount);
        tvResultCount = findViewById(R.id.tvResultCount);

        // Bấm nút Đăng nhập góc trên bên phải -> Mở LoginActivity
        if (btnAccount != null) {
            btnAccount.setOnClickListener(v -> {
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
            });
        }

        // Tạo danh sách dữ liệu mẫu
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("1", "Bộ Vá / Môi Múc Canh Gỗ", "Đồ Gỗ Gia Dụng", 120000.0, R.drawable.sp_va_canh));
        productList.add(new Product("2", "Bộ Cối Chày Gỗ Cao Cấp", "Đồ Gỗ Bếp", 220000.0, R.drawable.sp_coi_chay));
        productList.add(new Product("3", "Kẹp Thức Ăn Gỗ Tự Nhiên", "Đồ Gỗ Bếp", 65000.0, R.drawable.sp_gap_da));
        productList.add(new Product("4", "Cây Cào / Gãi Lưng Gỗ", "Đồ Gỗ Gia Dụng", 45000.0, R.drawable.sp_gai_lung));

        if (tvResultCount != null) {
            tvResultCount.setText("Hiển thị 1–" + productList.size() + " của " + productList.size() + " kết quả");
        }

        if (rvHomeProducts != null) {
            rvHomeProducts.setLayoutManager(new GridLayoutManager(this, 2));
            ProductAdapter adapter = new ProductAdapter(this, productList);
            rvHomeProducts.setAdapter(adapter);
        }
    }
}