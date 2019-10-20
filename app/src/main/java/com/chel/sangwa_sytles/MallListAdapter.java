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

public class MallListAdapter extends RecyclerView.Adapter<MallListAdapter.MallsViewHolder> {
    private List<Business> mMall;
    private Context mContext;

    public MallListAdapter(Context context, List<Business> mall) {
        mContext = context;
        mMall = mall;
    }

    @Override
    public MallListAdapter.MallsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.malls_list_item, parent, false);
        MallsViewHolder viewHolder = new MallsViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MallListAdapter.MallsViewHolder holder, int position) {
        holder.bindMall(mMall.get(position));
    }

    @Override
    public int getItemCount() {
        return mMall.size();
    }

    public class MallsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.mallImageView) ImageView mRestaurantImageView;
        @BindView(R.id.mallNameTextView) TextView mNameTextView;
        @BindView(R.id.categoryTextView) TextView mCategoryTextView;
        @BindView(R.id.ratingTextView) TextView mRatingTextView;
        private Context mContext;

        public MallsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindMall(Business mall) {
            Picasso.get().load(mall.getImageUrl()).into(mRestaurantImageView);
            mNameTextView.setText(mall.getName());
            mCategoryTextView.setText(mall.getCategories().get(0).getTitle());
            mRatingTextView.setText("Rating: " + mall.getRating() + "/5");
        }
    }
}
