package agrostar.demoapp.com.agrostar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import agrostar.demoapp.com.agrostar.R;
import agrostar.demoapp.com.agrostar.models.ProductsDTO;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Deep Verma on 22/5/16.
 */
public class AgroProductsAdapter extends BaseAdapter {

    private final List<ProductsDTO> mProducts;
    private final Context mContext;
    @Bind(R.id.product_name)
    public TextView productName;

    @Bind(R.id.product_price)
    public TextView productPrice;
    @Bind(R.id.product_image)
    public ImageView imageView;


    public AgroProductsAdapter(List<ProductsDTO> products, Context context) {
        mContext = context;
        mProducts = products;
    }

    @Override
    public int getCount() {
        return mProducts.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext.getApplicationContext());
        convertView = inflater.inflate(R.layout.products_item, null);
        ButterKnife.bind(this, convertView);
        productName.setText(mProducts.get(position).getProductName());
        imageView.setImageResource(mProducts.get(position).getImageIds());
        productPrice.setText(mProducts.get(position).getPrice());
        return convertView;
    }

}
