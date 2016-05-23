package agrostar.demoapp.com.agrostar.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import agrostar.demoapp.com.agrostar.R;
import agrostar.demoapp.com.agrostar.view.activities.customviews.HorizontalListView;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Deep Verma on 21-05-2016.
 */
public class ProductsViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.list_products)
    public HorizontalListView mProductList;
    @Bind(R.id.crop_type)
    public TextView productTypeTv;

    public ProductsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

}
