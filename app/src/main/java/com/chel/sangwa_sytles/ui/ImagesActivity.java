package com.chel.sangwa_sytles.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.chel.sangwa_sytles.Constants;
import com.chel.sangwa_sytles.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImagesActivity extends AppCompatActivity implements View.OnClickListener  {

    private DatabaseReference mSearchedMallLocationReference;
    private ValueEventListener mSearchedLocationReferenceListener;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @BindView(R.id.listedButton) Button mListedButton;
    @BindView(R.id.clotheWanted) EditText mClotheWanted;
    @BindView(R.id.findMallButton) Button mFindMallButton;
    @BindView(R.id.locationEditText) EditText mLocationEditText;
    @BindView(R.id.wordsTextView) TextView mWordsTextView;
    @BindView(R.id.image1) ImageView image1;
    @BindView(R.id.image2) ImageView image2;
    @BindView(R.id.image3) ImageView image3;
    @BindView(R.id.image4) ImageView image4;
    @BindView(R.id.image5) ImageView image5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mSearchedMallLocationReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_SEARCHED_LOCATION);

        mSearchedLocationReferenceListener = mSearchedMallLocationReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot locationSnapshot : dataSnapshot.getChildren()) {
                    String kigali = locationSnapshot.getValue().toString();
                    Log.d("Locations updated", "location: " + kigali);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);
        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance();
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    getSupportActionBar().setTitle("hello, " + user.getDisplayName() + " !" );
                } else {

                }
            }
        };
        mListedButton.setOnClickListener(this);
        mFindMallButton.setOnClickListener(this);


        image1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation fa= AnimationUtils.loadAnimation(ImagesActivity.this,R.anim.sample_anim);
                image1.startAnimation(fa);
            }
        } );

        image2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation fa= AnimationUtils.loadAnimation(ImagesActivity.this,R.anim.sample_anim);
                image2.startAnimation(fa);
            }
        } );

        image3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation fa= AnimationUtils.loadAnimation(ImagesActivity.this,R.anim.sample_anim);
                image3.startAnimation(fa);
            }
        } );

        image4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation fa= AnimationUtils.loadAnimation(ImagesActivity.this,R.anim.sample_anim);
                image4.startAnimation(fa);
            }
        } );

        image5.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation fa= AnimationUtils.loadAnimation(ImagesActivity.this,R.anim.sample_anim);
                image5.startAnimation(fa);
            }
        } );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSearchedMallLocationReference.removeEventListener(mSearchedLocationReferenceListener);
    }



    @Override
    public void onClick(View v){

        if(v == mListedButton) {
            String clothType = mClotheWanted.getText().toString();
            Intent cheHome = new Intent(ImagesActivity.this, ClothesActivity.class);
            cheHome.putExtra("clothType", clothType);
            startActivity(cheHome);
        }

        if(v == mFindMallButton) {
            String location = mLocationEditText.getText().toString();
            saveLocationToFirebase(location);
            Intent cheHome = new Intent(ImagesActivity.this, MallsActivity.class);
           cheHome.putExtra("kigali", location);
            startActivity(cheHome);
        }

        if(v == mWordsTextView) {
            Intent cheHome = new Intent(ImagesActivity.this, TipsActivity.class);
            startActivity(cheHome);
        }
    }



    public void saveLocationToFirebase(String location) {
        mSearchedMallLocationReference.push().setValue(location);
//        Toast.makeText(this, "I am blessed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

}



// Toast.makeText(ImagesActivity.this, "Sangwa", Toast.LENGTH_SHORT).show();
