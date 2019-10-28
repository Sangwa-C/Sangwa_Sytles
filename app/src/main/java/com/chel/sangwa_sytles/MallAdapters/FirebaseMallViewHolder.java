package com.chel.sangwa_sytles.MallAdapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.chel.sangwa_sytles.Constants;
import com.chel.sangwa_sytles.R;
import com.chel.sangwa_sytles.models.Mall;
import com.chel.sangwa_sytles.ui.MallsDetailActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

public class FirebaseMallViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    View mView;
    Context mContext;

    public FirebaseMallViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindMall(Mall mall) {
        ImageView mallImageView = (ImageView) mView.findViewById(R.id.mallImageView);
        TextView nameTextView = (TextView) mView.findViewById(R.id.mallNameTextView);
        TextView categoryTextView = (TextView) mView.findViewById(R.id.categoryTextView);
        TextView ratingTextView = (TextView) mView.findViewById(R.id.ratingTextView);

        Picasso.get().load(mall.getImageUrl()).into(mallImageView);

        nameTextView.setText(mall.getName());
        categoryTextView.setText(mall.getCategories().get(0));
        ratingTextView.setText("Rating: " + mall.getRating() + "/5");
    }

    @Override
    public void onClick(View view) {
        final ArrayList<Mall> malls = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_Malls);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    malls.add(snapshot.getValue(Mall.class));
                }

                int itemPosition = getLayoutPosition();

                Intent chehome = new Intent(mContext, MallsDetailActivity.class);
                chehome.putExtra("position", itemPosition + "");
                chehome.putExtra("malls", Parcels.wrap(malls));

                mContext.startActivity(chehome);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}

