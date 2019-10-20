package com.chel.sangwa_sytles;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImagesActivity extends AppCompatActivity implements View.OnClickListener  {

    @BindView(R.id.listedButton) Button mListedButton;
    @BindView(R.id.clotheWanted) EditText mClotheWanted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);


        ButterKnife.bind(this);

        mListedButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){

//                Intent cheHome = getIntent();
        String clothType = mClotheWanted.getText().toString();

        Intent cheHome = new Intent(ImagesActivity.this, ClothesActivity.class);
        cheHome.putExtra("clothType", clothType);
        startActivity(cheHome);

    }

}



// Toast.makeText(ImagesActivity.this, "Sangwa", Toast.LENGTH_SHORT).show();
