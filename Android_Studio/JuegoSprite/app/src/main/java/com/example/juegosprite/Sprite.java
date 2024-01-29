package com.example.juegosprite;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Sprite {
    private int x = 0;
    private int xSpeed = 5;
    private GameView gameView;
    private Bitmap bitmap;

    public Sprite(GameView gameView, Bitmap bitmap){
        this.gameView = gameView;
        this.bitmap = bitmap;
    }

    private void update(){
        x = x + xSpeed;
    }

    public void onDraw(Canvas canvas){
        update();
        canvas.drawBitmap(bitmap, x, 10, null);
    }

}
