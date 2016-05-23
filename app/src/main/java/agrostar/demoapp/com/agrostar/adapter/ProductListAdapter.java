package agrostar.demoapp.com.agrostar.adapter;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import agrostar.demoapp.com.agrostar.R;
import agrostar.demoapp.com.agrostar.models.ProductsDTO;
import agrostar.demoapp.com.agrostar.utils.Constant;
import agrostar.demoapp.com.agrostar.viewholder.OfferViewHolder;
import agrostar.demoapp.com.agrostar.viewholder.ProductsViewHolder;

/**
 * Created by Deep Verma on 22/5/16.
 */
public class ProductListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Map<String, List<ProductsDTO>> mProductListMap;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private Iterator entries;

    interface ProductType {
        int OFFER_HEADER = 1;
        int PRODUCTS = 2;

    }

    public ProductListAdapter(FragmentManager fragmentManager, Map<String, List<ProductsDTO>> productListMap, Context context) {
        mProductListMap = productListMap;
        mFragmentManager = fragmentManager;
        mContext = context;
        entries = mProductListMap.entrySet().iterator();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = null;

        switch (viewType) {
            case ProductType.OFFER_HEADER: {
                OfferViewHolder offerViewHolder;
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.include_offer, parent, false);
                offerViewHolder = new OfferViewHolder(mFragmentManager, v);
                return offerViewHolder;
            }
            case ProductType.PRODUCTS: {
                ProductsViewHolder productsViewHolder;
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.products_list, parent, false);
                productsViewHolder = new ProductsViewHolder(v);
                return productsViewHolder;
            }
        }
        return null;
    }

    private void setOfferView(final OfferViewHolder offerViewHolder) {
        offerViewHolder.marqueeText.setSelected(true);
        offerViewHolder.autoScrollViewPager.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    offerViewHolder.autoScrollViewPager.stopAutoScroll();
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    offerViewHolder.autoScrollViewPager.startAutoScroll();
                }

                return false;
            }
        });
        List<Integer> bannerIds = new ArrayList<>();
        bannerIds.add(R.drawable.banner1);
        bannerIds.add(R.drawable.banner2);
        OfferAdapter offerAdapter = new OfferAdapter(mFragmentManager, bannerIds);
        if (offerViewHolder.autoScrollViewPager != null) {
            offerViewHolder.autoScrollViewPager.setInterval(Constant.AutoScrollConstants.SLEEP_DURATION);
            offerViewHolder.autoScrollViewPager.setAdapter(offerAdapter);
            offerViewHolder.autoScrollViewPager.startAutoScroll();
            offerViewHolder.autoScrollViewPager.startAutoScroll(Constant.AutoScrollConstants.SLEEP_DURATION);
            offerViewHolder.mIndicator.setViewPager(offerViewHolder.autoScrollViewPager);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof OfferViewHolder) {
            setOfferView((OfferViewHolder) holder);

        } else {
            ProductsViewHolder productsViewHolder = (ProductsViewHolder) holder;
            Map.Entry productsMapEntry = (Map.Entry) entries.next();
            List<ProductsDTO> products = (List<ProductsDTO>) productsMapEntry.getValue();
            AgroProductsAdapter agroProductsAdapter = new AgroProductsAdapter(products, mContext);
            productsViewHolder.mProductList.setAdapter(agroProductsAdapter);

            productsViewHolder.productTypeTv.setText((String) productsMapEntry.getKey());

        }
    }

    @Override
    public int getItemCount() {
        return mProductListMap.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        int viewType = 0;
        if (position == 0) {
            viewType = ProductType.OFFER_HEADER;
        } else {
            viewType = ProductType.PRODUCTS;
        }
        return viewType;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }
}
