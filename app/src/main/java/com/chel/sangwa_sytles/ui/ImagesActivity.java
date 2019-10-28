package com.chel.sangwa_sytles.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.chel.sangwa_sytles.Constants;
import com.chel.sangwa_sytles.R;
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

    @BindView(R.id.listedButton) Button mListedButton;
    @BindView(R.id.clotheWanted) EditText mClotheWanted;
    @BindView(R.id.findMallButton) Button mFindMallButton;
    @BindView(R.id.locationEditText) EditText mLocationEditText;

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

        mListedButton.setOnClickListener(this);
        mFindMallButton.setOnClickListener(this);
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
            String kigali = mLocationEditText.getText().toString();
            saveLocationToFirebase(kigali);
            Intent cheHome = new Intent(ImagesActivity.this, MallsActivity.class);
           cheHome.putExtra("kigali", kigali);
            startActivity(cheHome);
        }
    }



    public void saveLocationToFirebase(String kigali) {
        mSearchedMallLocationReference.push().setValue(kigali);
        Toast.makeText(this, "I am blessed", Toast.LENGTH_SHORT).show();
    }

}



// Toast.makeText(ImagesActivity.this, "Sangwa", Toast.LENGTH_SHORT).show();
