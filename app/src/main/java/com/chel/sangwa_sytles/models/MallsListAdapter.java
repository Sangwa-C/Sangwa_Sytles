package com.chel.sangwa_sytles.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chel.sangwa_sytles.R;
import com.chel.sangwa_sytles.userInterface.MallsActivity;

import java.util.List;

public class MallsListAdapter extends RecyclerView.Adapter<MallsListAdapter.ClothesViewHolder> {
    private List<Business> mClothes;
    private Context mContext;

    public MallsListAdapter(Context context, List<Business> clothes) {
        mContext = context;
        mClothes = clothes;
    }

    @Override
    public MallsListAdapter.ClothesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.malls_list_item, parent, false);
        ClothesViewHolder viewHolder = new ClothesViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MallsListAdapter.ClothesViewHolder holder, int position) {
        holder.bindClothes(mClothes.get(position));
    }

    @Override
    public int getItemCount() {
        return mClothes.size();
    }

    public class ClothesViewHolder extends RecyclerView.ViewHolder {
        public ClothesViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bindClothes(Business business) {
        }
    }
}
