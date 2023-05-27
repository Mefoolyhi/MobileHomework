package com.example.graphicsexample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.Image;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.LinkedList;

public class GameView extends View {
    int left = 10, top = 10;

    // Example 8 start
//    Paint paint = new Paint();
//
//    public GameView(Context context) {
//        super(context);
//        new CountDownTimer(Integer.MAX_VALUE, 20){
//            private int b = 0;
//
//            @Override
//            public void onTick(long millisUntilFinished) {
//                paint.setColor(Color.rgb(100, 100, b));
//                b++;
//                invalidate();
//            }
//
//            @Override
//            public void onFinish(){
//
//            }
//        }.start();
//    }
    // Example 8 end

    // Example 9
//    Bitmap bird = null;
//    LinkedList<Rect> list = new LinkedList<>();
//    Rect dist = null;

    Bird bird = new Bird(getResources());

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context);
        // Example 9
//        bird = BitmapFactory.decodeResource(getResources(), R.drawable.bird);
//        list.add(new Rect(0,0, bird.getHeight(), bird.getHeight()));
//        list.add(new Rect(1 * bird.getHeight(),0, 2 * bird.getHeight(), bird.getHeight()));
//        list.add(new Rect(2 * bird.getHeight(),0, 3 * bird.getHeight(), bird.getHeight()));
//        list.add(new Rect(3 * bird.getHeight(),0, 4 * bird.getHeight(), bird.getHeight()));
//        dist = new Rect(0, 0, bird.getHeight(), bird.getHeight());
        new CountDownTimer(Integer.MAX_VALUE, 50) {
            @Override
            public void onTick(long millisUntilFinished) {
                bird.move();
                invalidate();
            }

            @Override
            public void onFinish() {
            }
        }.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // Example 9
//        canvas.drawBitmap(bird, list.getFirst(), dist, new Paint());
//        list.addLast(list.getFirst());
//        list.removeFirst();
        bird.draw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // Example 9
//        left = (int) event.getX();
//        top = (int) event.getY();

        // Example 7
//        invalidate();

        bird.setXY((int) event.getX(), (int) event.getY());
        return true;
    }
}

