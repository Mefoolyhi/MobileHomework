package com.example.graphicsexample;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Example 4 and 6
//    View view = null;
//    int left = 10, top = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Example 1
//        Button button = new Button(this);
//        button.setText("Donate");
//        setContentView(button);

        // Example 2
//        View view = new View(this){
//            @Override
//            protected void onDraw(Canvas canvas) {
//                super.onDraw(canvas);
//                canvas.drawRect(10, 10, 100, 100, new Paint());
//            }
//        };
//        setContentView(view);

        // Example 3
//        Button button = new androidx.appcompat.widget.AppCompatButton(this){
//            @Override
//            protected void onDraw(Canvas canvas) {
//                super.onDraw(canvas);
//                canvas.drawRect(10, 10, 100, 100, new Paint());
//            }
//        };
//        setContentView(button);

        // Example 4
//        view = new View(this){
//
//            @Override
//            protected void onDraw(Canvas canvas) {
//                super.onDraw(canvas);
//                canvas.drawRect(left, top, left+100, top+100, new Paint());
//            }
//        };
//        setContentView(view);

        // Example 5
//        View view = new View(this){
//
//            private int left = 10, top = 10;
//            @Override
//            protected void onDraw(Canvas canvas) {
//                super.onDraw(canvas);
//                canvas.drawRect(left, top, left+100, top+100, new Paint());
//            }
//
//            @Override
//            public boolean onTouchEvent(MotionEvent event) {
//                left = (int) event.getX();
//                top = (int) event.getY();
//                invalidate();
//                return false;
//            }
//        };
//        setContentView(view);

        // Example 6
//        view = new View(this){
//
//            @Override
//            protected void onDraw(Canvas canvas) {
//                super.onDraw(canvas);
//                canvas.drawRect(left, top, left+100, top+100, new Paint());
//            }
//
//            @Override
//            public boolean onTouchEvent(MotionEvent event) {
//                left = (int) event.getX();
//                top = (int) event.getY();
//                invalidate();
//                return true;
//            }
//        };
//        setContentView(view);

        // Example 7-10
//        setContentView(new GameView(this));

        setContentView(R.layout.activity_main);

    }
    // Example 4 and 6
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        left = (int) event.getX();
//        top = (int) event.getY();
//        view.invalidate();
//        return false;
//    }

}