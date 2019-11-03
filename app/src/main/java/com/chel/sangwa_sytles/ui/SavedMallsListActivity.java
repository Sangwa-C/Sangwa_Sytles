package com.chel.sangwa_sytles.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chel.sangwa_sytles.Constants;
import com.chel.sangwa_sytles.MallAdapters.FirebaseMallViewHolder;
import com.chel.sangwa_sytles.R;
import com.chel.sangwa_sytles.models.Mall;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedMallsListActivity extends AppCompatActivity {
    private DatabaseReference mMallReference;
    private FirebaseRecyclerAdapter<Mall, FirebaseMallViewHolder> mFirebaseAdapter;

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malls);
        ButterKnife.bind(this);

        mMallReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_Malls);
        setUpFirebaseAdapter();
    }

    private void setUpFirebaseAdapter(){
        FirebaseRecyclerOptions<Mall> options =
                new FirebaseRecyclerOptions.Builder<Mall>()
                        .setQuery(mMallReference, Mall.class)
                        .build();

        mFirebaseAdapter = new FirebaseRecyclerAdapter<Mall, FirebaseMallViewHolder>(options) {

            @Override
            protected void onBindViewHolder(@NonNull FirebaseMallViewHolder firebaseMallViewHolder, int position, @NonNull Mall Mall) {
                firebaseMallViewHolder.bindMall(Mall);
            }

            @NonNull
            @Override
            public FirebaseMallViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.malls_list_item, parent, false);
                return new FirebaseMallViewHolder(view);
            }
        };

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mFirebaseAdapter!= null) {
            mFirebaseAdapter.stopListening();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
