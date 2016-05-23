package agrostar.demoapp.com.agrostar.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import agrostar.demoapp.com.agrostar.view.activities.fragment.OfferFragment;

/**
 * Created by Deep Verma on 22/5/16.
 */
public class OfferAdapter extends FragmentPagerAdapter {
    List<Integer> bannerDTOList;

    public OfferAdapter(FragmentManager fm, List<Integer> bannerDTOs) {
        super(fm);
        bannerDTOList = bannerDTOs;
    }

    public int getCount() {

        return bannerDTOList.size();
    }

    @Override
    public Fragment getItem(int arg0) {
        switch (arg0) {

            default:
                return OfferFragment.newInstance(bannerDTOList.get(arg0));
        }
    }
}