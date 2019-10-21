package com.chel.sangwa_sytles;

import android.content.Context;
import android.widget.ArrayAdapter;


class sangwa_stylesArrayAdapter2 extends ArrayAdapter {
    private Context mContext;
    private String[] mMalls;

    public sangwa_stylesArrayAdapter2( Context context, int resource, String[] mMalls) {
        super(context, resource);
        this.mContext = mContext;
        this.mMalls = mMalls;
    }

    @Override
    public Object getItem(int position) {
        String malls;
        malls = mMalls[position];
        return String.format("%s", malls);
    }

    @Override
    public int getCount() {
        return mMalls.length;
    }
}

