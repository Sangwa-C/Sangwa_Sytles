package com.chel.sangwa_sytles.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.chel.sangwa_sytles.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mGalleryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGalleryButton = (Button) findViewById(R.id.galleryButton);
        mGalleryButton.setOnClickListener (this);
    }


    @Override
    public void onClick(View v) {

        Intent cheHome = new Intent(MainActivity.this, ImagesActivity.class);
        startActivity(cheHome);

    }

}

// Toast.makeText(MainActivity.this, "Sangwa", Toast.LENGTH_SHORT).show();
