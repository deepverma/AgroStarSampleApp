package agrostar.demoapp.com.agrostar.view.activities.fragment;

/**
 * Created by Deep Verma on 22/5/16.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import agrostar.demoapp.com.agrostar.R;
import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by Deep Verma on 21/05/16.
 */
public class OfferFragment extends Fragment {

    @Bind(R.id.appScreen)
    ImageView bannerImage;
    private int imageId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View itemView = inflater.inflate(R.layout.fragment_offer, container, false);
        ButterKnife.bind(this, itemView);
        bannerImage.setImageResource(imageId);

        return itemView;
    }

    public static OfferFragment newInstance(int imageId) {
        OfferFragment offerFragment = new OfferFragment();
        offerFragment.imageId = imageId;
        return offerFragment;
    }

}
