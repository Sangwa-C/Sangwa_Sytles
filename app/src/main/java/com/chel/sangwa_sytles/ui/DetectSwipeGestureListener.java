package com.chel.sangwa_sytles.ui;

import android.view.GestureDetector;

public class DetectSwipeGestureListener extends GestureDetector.SimpleOnGestureListener{

//    private static int MIN_SWIPE_DISTANCE_X = 100;
//    private static int MIN_SWIPE_DISTANCE_Y = 100;
//
//    private static int MAX_SWIPE_DISTANCE_X = 1000;
//    private static int MAX_SWIPE_DISTANCE_Y = 1000;
//
//    private TipsActivity activity = null;
//
//    public TipsActivity getActivity(){
//        return activity;
//    }
//
//    public void setActivity(TipsActivity activity){
//        this.activity = activity;
//    }
//
//    @Override
//    public boolean onFling(MotionEvent e1 , MotionEvent e2 , float velocityX , float velocityY) {
//
//        float deltaX = e1.getX() - e2.getX();
//        float deltaY = e1.getY() - e2.getY();
//
//        float deltaXAbs = Math.abs(deltaX);
//        float deltaYAbs = Math.abs(deltaY);
//
//        // swipe left or right detector
//        if (deltaXAbs >= MIN_SWIPE_DISTANCE_X && deltaXAbs <= MAX_SWIPE_DISTANCE_X){
//            if(deltaX > 0){
//                this.activity.displayMessage( "Swipe To Left" );
//            } else {
//                this.activity.displayMessage( "Swipe To Right" );
//            }
//        }
//
//        //swipe up or down detector
//        if (deltaYAbs >= MIN_SWIPE_DISTANCE_Y && deltaYAbs <= MAX_SWIPE_DISTANCE_Y){
//            if(deltaY > 0){
//                this.activity.displayMessage( "Swipe Up" );
//            } else {
//                this.activity.displayMessage( "Swipe Down" );
//            }
//        }
//
//        return true;
//    }
//
//    @Override
//    public boolean onSingleTapConfirmed(MotionEvent e) {
//        this.activity.displayMessage("Single Tap");
//        return true;
//    }
//
//    @Override
//    public boolean onDoubleTap(MotionEvent e) {
//        this.activity.displayMessage( "Double Tap" );
//        return true;
//    }


}
