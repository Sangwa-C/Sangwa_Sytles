package com.chel.sangwa_sytles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.chel.sangwa_sytles.models.Business;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MallsListAdapter extends RecyclerView.Adapter<MallsListAdapter.MallViewHolder> {

    private List<Business> mMalls;
    private Context mContext;

    public MallsListAdapter(Context context, List<Business> malls) {
        mContext = context;
        mMalls = malls;
    }

    @Override
    public MallViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.malls_list_item, parent, false);
        MallViewHolder viewHolder = new MallViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MallViewHolder holder, int position) {
        holder.bindRestaurant(mMalls.get(position));
    }

    @Override
    public int getItemCount() {
        return mMalls.size();
    }

    public class MallViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.mallImageView) ImageView mMallImageView;
        @BindView(R.id.mallNameTextView) TextView mNameTextView;
        @BindView(R.id.categoryTextView) TextView mCategoryTextView;
        @BindView(R.id.ratingTextView) TextView mRatingTextView;
        private Context mContext;

        public MallViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindRestaurant(Business mall) {
            Picasso.get().load(mall.getImageUrl()).into(mMallImageView);
            mNameTextView.setText(mall.getName());
            mCategoryTextView.setText(mall.getCategories().get(0).getTitle());
            mRatingTextView.setText("Rating: " + mall.getRating() + "/5");
        }
    }
}