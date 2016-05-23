package agrostar.demoapp.com.agrostar.view.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import agrostar.demoapp.com.agrostar.R;
import agrostar.demoapp.com.agrostar.adapter.ProductListAdapter;
import agrostar.demoapp.com.agrostar.utils.OfflineData;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Deep Verma on 22/5/16.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    @Bind(R.id.trendingListView)
    RecyclerView productsAndOfferList;
    private ProductListAdapter productListAdapter;
    TextView marqueeText;
    LinearLayoutManager mLayoutManager;

    @Override
    public void onClick(View v) {

    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_home, container, false);
        ButterKnife.bind(this, view);
        initProductsList();

        return view;
    }

    private void initProductsList() {
        mLayoutManager = new LinearLayoutManager(getActivity());
        productsAndOfferList.setLayoutManager(mLayoutManager);
        productListAdapter = new ProductListAdapter(getFragmentManager(), OfflineData.getInstance(getActivity()).getProductsMap(), getActivity());
        productsAndOfferList.setAdapter(productListAdapter);
    }

}
