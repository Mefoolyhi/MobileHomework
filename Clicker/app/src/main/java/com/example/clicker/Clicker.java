package com.example.clicker;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import java.util.LinkedList;
import java.util.Random;

public class Clicker {

    private LinkedList<Rect> list = new LinkedList<>();
    private Random random = new Random();
    private int width = 800, height = 800;

    public Clicker() {
        for (int i = 0; i < 10; i++) {
            add();
        }
    }

    void draw(Canvas canvas) {
        for (Rect r : list) {
            canvas.drawRect(r, new Paint());
        }
    }

    void add(){
        int left = random.nextInt(width);
        int top = random.nextInt(height);
        list.add(new Rect(left, top, left + 200, top + 200));
    }

    void del(int x, int y){
        for (int i = 0; i < list.size(); i++) {
            Rect r = list.get(i);
            if (x > r.left && x < r.right && y > r.top && y < r.bottom){
                list.remove(i);
                i--;
            }
        }
    }
}
