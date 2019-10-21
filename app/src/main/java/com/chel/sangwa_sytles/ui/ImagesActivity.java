package com.chel.sangwa_sytles.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.chel.sangwa_sytles.R;
import com.chel.sangwa_sytles.ui.ClothesActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImagesActivity extends AppCompatActivity implements View.OnClickListener  {

    @BindView(R.id.listedButton) Button mListedButton;
    @BindView(R.id.clotheWanted) EditText mClotheWanted;
    @BindView(R.id.findMallButton) Button mFindMallButton;
    @BindView(R.id.locationEditText) EditText mLocationEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);


        ButterKnife.bind(this);

        mListedButton.setOnClickListener(this);
        mFindMallButton.setOnClickListener(this);
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
            String rwanda = mLocationEditText.getText().toString();
            Intent cheHome = new Intent(ImagesActivity.this, MallsActivity.class);
           cheHome.putExtra("kigali", rwanda);
            startActivity(cheHome);
        }


    }

}



// Toast.makeText(ImagesActivity.this, "Sangwa", Toast.LENGTH_SHORT).show();
