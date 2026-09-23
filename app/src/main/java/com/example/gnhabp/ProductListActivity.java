package com.example.gnhabp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends AppCompatActivity {

    private RecyclerView rvAdminProductList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        rvAdminProductList = findViewById(R.id.rvAdminProductList);

        // Hiển thị danh sách dạng Dòng (Vertical List)
        rvAdminProductList.setLayoutManager(new LinearLayoutManager(this));

        // Dữ liệu sản phẩm mẫu giống trong Ảnh 2
        List<Product> list = new ArrayList<>();
        list.add(new Product("1", "HSML-040a: Fried Spoon (Large)", "Size: 40 x 10 cm | Longer", 2.30, R.drawable.sp_va_canh));
        list.add(new Product("2", "HSVD-004a: Rice Scoop", "Size: 23 x 7.2 cm | Longer", 0.78, R.drawable.sp_coi_chay));
        list.add(new Product("3", "HSVD-003a: Rice Scoop", "Size: 21.5 x 7.3 cm | Longer", 0.78, R.drawable.sp_coi_chay));
        list.add(new Product("4", "HSN-152a: Fork", "Size: 15 x 1 cm | Longer", 0.50, R.drawable.sp_fork));
        list.add(new Product("5", "HSN-153a: Fork", "Size: 15 x 2.5 cm | Longer", 0.55, R.drawable.sp_fork));
        list.add(new Product("6", "HSMT-001a: Tea Spoon (Short)", "Size: 9 x 2.6 cm | Short", 0.30, R.drawable.sp_gap_da));
        list.add(new Product("7", "HSMT-002a: Tea Spoon (Long)", "Size: 16 x 2.5 cm | Long", 0.35, R.drawable.sp_gap_da));

        ProductAdapter adapter = new ProductAdapter(this, list);
        rvAdminProductList.setAdapter(adapter);
    }
}