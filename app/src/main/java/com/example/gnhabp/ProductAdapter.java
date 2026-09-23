package com.example.gnhabp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context context;
    private List<Product> productList;

    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);

        if (product != null) {
            // 1. Mã & Tên sản phẩm
            if (holder.tvProductName != null) {
                holder.tvProductName.setText(product.getId() + ": " + product.getName());
            }

            // 2. Kích thước
            if (holder.tvProductDetail != null) {
                if (product.getSize() != null && !product.getSize().isEmpty()) {
                    holder.tvProductDetail.setText("Size: " + product.getSize());
                } else {
                    holder.tvProductDetail.setText("Size: 40 x 10 cm | Longer");
                }
            }

            // 3. Giá tiền định dạng chuẩn VNĐ
            if (holder.tvProductPrice != null) {
                double rawPrice = product.getPrice();
                if (rawPrice > 0 && rawPrice < 100) {
                    rawPrice = rawPrice * 100000;
                } else if (rawPrice >= 100 && rawPrice < 1000) {
                    rawPrice = rawPrice * 1000;
                }
                long price = (long) rawPrice;
                String priceText = String.format("%,d", price).replace(',', '.') + " VNĐ";
                holder.tvProductPrice.setText(priceText);
            }

            // 4. Hình ảnh sản phẩm
            if (holder.imgProduct != null) {
                if (product.getImageRes() != 0) {
                    holder.imgProduct.setImageResource(product.getImageRes());
                } else {
                    String imageName = product.getImageUriStr();
                    if (imageName != null && !imageName.isEmpty()) {
                        imageName = imageName.replace(".png", "").replace(".jpg", "");
                        int resId = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());
                        if (resId != 0) {
                            holder.imgProduct.setImageResource(resId);
                        } else {
                            holder.imgProduct.setImageResource(R.drawable.sp_coi_chay);
                        }
                    } else {
                        holder.imgProduct.setImageResource(R.drawable.sp_coi_chay);
                    }
                }
            }

            // 5. Sự kiện Click chuyển sang ProductDetailActivity
            holder.itemView.setOnClickListener(v -> {
                Intent intent = new Intent(context, ProductDetailActivity.class);
                intent.putExtra("product", product);
                intent.putExtra("id", product.getId());
                intent.putExtra("name", product.getName());
                intent.putExtra("price", product.getPrice());
                intent.putExtra("size", product.getSize());
                intent.putExtra("material", product.getMaterial());
                context.startActivity(intent);
            });
        }
    }

    @Override
    public int getItemCount() {
        return productList != null ? productList.size() : 0;
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView tvProductName, tvProductDetail, tvProductPrice;
        ImageView imgProduct;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            tvProductName = itemView.findViewById(R.id.tvProductName);
            tvProductDetail = itemView.findViewById(R.id.tvProductDetail);
            tvProductPrice = itemView.findViewById(R.id.tvProductPrice);
            imgProduct = itemView.findViewById(R.id.imgProduct);
        }
    }
}