package com.chel.sangwa_sytles;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.chel.sangwa_sytles.models.Business;
import com.chel.sangwa_sytles.models.Category;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class MallDetailFragment extends Fragment  implements View.OnClickListener {

    @BindView(R.id.mallImageView) ImageView mImageLabel;
    @BindView(R.id.mallNameTextView) TextView mNameLabel;
    @BindView(R.id.cuisineTextView) TextView mCategoriesLabel;
    @BindView(R.id.ratingTextView) TextView mRatingLabel;
    @BindView(R.id.websiteTextView) TextView mWebsiteLabel;
    @BindView(R.id.phoneTextView) TextView mPhoneLabel;
    @BindView(R.id.addressTextView) TextView mAddressLabel;



    private Business mMall;

    public MallDetailFragment() {
        // Required empty public constructor
    }

    public static MallDetailFragment newInstance(Business restaurant) {
        MallDetailFragment restaurantDetailFragment = new MallDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("mall", Parcels.wrap(restaurant));
        restaurantDetailFragment.setArguments(args);
        return restaurantDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMall = Parcels.unwrap(getArguments().getParcelable("mall"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mall_detail, container, false);
        ButterKnife.bind(this, view);

        Picasso.get().load(mMall.getImageUrl()).into(mImageLabel);

        List<String> categories = new ArrayList<>();

        for (Category category: mMall.getCategories()) {
            categories.add(category.getTitle());
        }

        mNameLabel.setText(mMall.getName());
        mCategoriesLabel.setText(TextUtils.join(", ", categories));
        mRatingLabel.setText(Double.toString(mMall.getRating()) + "/5");
        mPhoneLabel.setText(mMall.getPhone());
        mAddressLabel.setText(mMall.getLocation().toString());

        mWebsiteLabel.setOnClickListener(this);
        mPhoneLabel.setOnClickListener(this);
        mAddressLabel.setOnClickListener(this);

        return view;
    }
    @Override
    public void onClick(View v) {
        if (v == mWebsiteLabel) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(mMall.getUrl()));
            startActivity(webIntent);
        }
        if (v == mPhoneLabel) {
            Intent phoneIntent = new Intent(Intent.ACTION_DIAL,
                    Uri.parse("tel:" + mMall.getPhone()));
            startActivity(phoneIntent);
        }
        if (v == mAddressLabel) {
            Intent mapIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("geo:" + mMall.getCoordinates().getLatitude()
                            + "," + mMall.getCoordinates().getLongitude()
                            + "?q=(" + mMall.getName() + ")"));
            startActivity(mapIntent);
        }
    }

}
