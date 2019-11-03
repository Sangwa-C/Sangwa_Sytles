package com.chel.sangwa_sytles.ui;

import android.view.GestureDetector;
import android.view.MotionEvent;

public class DetectSwipeGestureListener extends GestureDetector.SimpleOnGestureListener{

    private static int MIN_SWIPE_DISTANCE_X = 100;
    private static int MIN_SWIPE_DISTANCE_Y = 100;

    private static int MAX_SWIPE_DISTANCE_X = 1000;
    private static int MAX_SWIPE_DISTANCE_Y = 1000;

    private TipsActivity activity = null;

    public TipsActivity getActivity(){
        return activity;
    }

    public void setActivity(TipsActivity activity){
        this.activity = activity;
    }

    @Override
    public boolean onFling(MotionEvent e1 , MotionEvent e2 , float velocityX , float velocityY) {

        float deltaX = e1.getX() - e2.getX();
        float deltaY = e1.getY() - e2.getY();

        float deltaXAbs = Math.abs(deltaX);
        float deltaYAbs = Math.abs(deltaY);

        // swipe left or right detector
        if (deltaXAbs >= MIN_SWIPE_DISTANCE_X && deltaXAbs <= MAX_SWIPE_DISTANCE_X){
            if(deltaX > 0){
                this.activity.displayMessage( "*Match the color of your socks to the color of your trousers.*\n\n" +
                        "Most of the time. When you want to be daring, wear a bright, contrasting color instead." );
            } else {
                this.activity.displayMessage( "*Iron your own shirts.*\n\n" +
                        "It’s a useful skill for traveling, and it’ll save you money at home." );
            }
        }

        //swipe up or down detector
        if (deltaYAbs >= MIN_SWIPE_DISTANCE_Y && deltaYAbs <= MAX_SWIPE_DISTANCE_Y){
            if(deltaY > 0){
                this.activity.displayMessage( "*Wear something really small with something really big* \n\n" + " Not just big with small, but also hard with soft, tight with loose, and heavy with light." );
            } else {
                this.activity.displayMessage( "*Do a half-assed tuck job*\n\n" +
                        "just grab that middle front piece, tuck it down, and watch your style cred increase instantaneously by a factor of 10.");
            }
        }

        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        this.activity.displayMessage("*Add a motorcycle jacket*\n\n" +
                "A good motorcycle jacket improves every outfit.");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        this.activity.displayMessage( "*Wear the wrong shoes*\n\n" +
                "Trade your high heels for flat booties, your sneakers for high heels, and your sandals for sneakers." +
                " The more wrong it feels, the more right it is." );
        return true;
    }


}
