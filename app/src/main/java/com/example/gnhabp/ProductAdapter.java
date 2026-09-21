package com.example.gnhabp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class ProductAdapter extends BaseAdapter {

    private Context context;
    private List<Product> productList;

    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @Override
    public int getCount() { return productList.size(); }

    @Override
    public Object getItem(int position) { return productList.get(position); }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false);
        }

        Product product = productList.get(position);

        ImageView imgProduct = convertView.findViewById(R.id.imgProduct);
        TextView tvProductName = convertView.findViewById(R.id.tvProductName);
        TextView tvProductDetail = convertView.findViewById(R.id.tvProductDetail);
        TextView tvProductPrice = convertView.findViewById(R.id.tvProductPrice);

        // Đổ dữ liệu từ Product vào giao diện
        imgProduct.setImageResource(product.getImageResId());
        tvProductName.setText(product.getId() + ": " + product.getName());
        tvProductDetail.setText("Size: " + product.getSize() + " | " + product.getMaterial());
        tvProductPrice.setText("FOB price: $" + String.format("%.2f", product.getPrice()) + " USD");

        return convertView;
    }
}