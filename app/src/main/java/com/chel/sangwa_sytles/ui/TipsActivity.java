package com.chel.sangwa_sytles.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import com.chel.sangwa_sytles.R;

public class TipsActivity extends AppCompatActivity {

    TextView FirstTextView;

    private GestureDetectorCompat gestureDetectorCompat = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_tips );

        Intent cheHome = getIntent();

        FirstTextView = findViewById( R.id.FirstTextView);

        DetectSwipeGestureListener gestureListener = new DetectSwipeGestureListener();
        gestureListener.setActivity( this );
        gestureDetectorCompat = new GestureDetectorCompat( this, gestureListener );
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorCompat.onTouchEvent( event );
        return true;
    }

    public void displayMessage(String message){
        FirstTextView.setText(message);
    }

}
