package com.example.clicker;

import android.content.Context;
import android.graphics.Canvas;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;

public class GameField extends View{

    private final Clicker clicker;
    private class Timer extends CountDownTimer{
        int st = 0;
        long cDI;

        public Timer(long countDownInterval){
            super(Integer.MAX_VALUE, countDownInterval);
            this.cDI = countDownInterval;
        }

        @Override
        public void onTick(long l) {
            st += cDI;
            if (st % 1000 == 0){
                clicker.add();
            }
            invalidate();
        }

        @Override
        public void onFinish() {

        }
    }

    public GameField(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        clicker = new Clicker();
        new Timer(50).start();
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        clicker.draw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        clicker.del((int)event.getX(), (int)event.getY());
        return false;
    }
}