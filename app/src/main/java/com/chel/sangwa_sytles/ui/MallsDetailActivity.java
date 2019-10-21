package com.chel.sangwa_sytles.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.chel.sangwa_sytles.MallPagerAdapter;
import com.chel.sangwa_sytles.R;
import com.chel.sangwa_sytles.models.Business;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MallsDetailActivity extends AppCompatActivity {
    @BindView(R.id.viewPager) ViewPager mViewPager;
    private MallPagerAdapter adapterViewPager;
    List<Business> mMalls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malls_detail);
        ButterKnife.bind(this);

        mMalls = Parcels.unwrap(getIntent().getParcelableExtra("malls"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new MallPagerAdapter(getSupportFragmentManager(), mMalls);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}
