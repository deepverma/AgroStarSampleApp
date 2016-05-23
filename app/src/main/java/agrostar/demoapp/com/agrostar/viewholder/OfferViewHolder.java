package agrostar.demoapp.com.agrostar.viewholder;

import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.viewpagerindicator.CirclePageIndicator;

import agrostar.demoapp.com.agrostar.R;
import butterknife.Bind;
import butterknife.ButterKnife;
import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

/**
 * Created by Deep Verma on 21-05-2016.
 */
public class OfferViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.offerPager)
    public AutoScrollViewPager autoScrollViewPager;

    @Bind(R.id.marqueeText)
    public TextView marqueeText;
    @Bind(R.id.indicator)
    public CirclePageIndicator mIndicator;

    public OfferViewHolder(FragmentManager fragmentManager, View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
