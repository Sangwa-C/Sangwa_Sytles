package com.chel.sangwa_sytles.MallAdapters;

import android.content.Context;
import android.widget.ArrayAdapter;

public class sangwa_stylesArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mClothes;
    private String[] mPrices;

    public sangwa_stylesArrayAdapter(Context context, int resource , String[] mClothes, String[] mPrices) {
        super(context, resource);
        this.mContext = mContext;
        this.mClothes = mClothes;
        this.mPrices = mPrices;
    }

    @Override
    public Object getItem(int position) {
        String clothes = mClothes[position];
        String prices = mPrices[position];
        return String.format("%s \nPrice: %s", clothes, prices);
    }

    @Override
    public int getCount() {
        return mClothes.length;
    }
}
