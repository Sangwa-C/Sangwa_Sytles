package com.chel.sangwa_sytles;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ImagesActivity extends AppCompatActivity  {
    private Button mListedButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        mListedButton = (Button) findViewById(R.id.listedButton);
        mListedButton.setOnClickListener ( new View.OnClickListener(){
            @Override
            public void onClick(View V){
                Intent cheHome= getIntent();

                 Toast.makeText(ImagesActivity.this, "Sangwa", Toast.LENGTH_SHORT).show();

            }
        });
    }

}
