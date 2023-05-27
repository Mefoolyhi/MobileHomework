package com.example.graphicsexample;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.LinkedList;

public class Bird {
    private Bitmap bird = null;
    private LinkedList<Rect> list = new LinkedList<>();
    private Rect dist;
    private int x = 0, y = 0;

    public Bird(Resources res) {
        this.bird = BitmapFactory.decodeResource(res, R.drawable.bird);
        list.add(new Rect(0, 0, bird.getHeight(), bird.getHeight()));
        list.add(new Rect(1 * bird.getHeight(), 0, 2 * bird.getHeight(), bird.getHeight()));
        list.add(new Rect(2 * bird.getHeight(), 0, 3 * bird.getHeight(), bird.getHeight()));
        list.add(new Rect(3 * bird.getHeight(), 0, 4 * bird.getHeight(), bird.getHeight()));
        dist = new Rect(0, 0, bird.getHeight(), bird.getHeight());
        setXY(dist.centerX(), dist.centerY());
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(bird, list.getFirst(), dist, new Paint());
        list.addLast(list.getFirst());
        list.removeFirst();
    }

    public void move() {
        moveX();
        moveY();
    }

    public void moveX() {
        if (Math.abs(dist.centerX() - x) < 6) return;
        if (dist.centerX() > x) {
            dist.left -= 10;
            dist.right -= 10;
        } else {
            dist.left += 10;
            dist.right += 10;
        }
    }

    public void moveY() {
        if (Math.abs(dist.centerY() - y) < 6) return;
        if (dist.centerY() > y) {
            dist.top -= 10;
            dist.bottom -= 10;
        } else {
            dist.top += 10;
            dist.bottom += 10;
        }
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
