package com.example.juegosprite;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import java.util.Random;

public class Sprite {
    private static final int BMP_ROWS = 4;
    private static final int BMP_COLUMNS = 3;
    private int x = 0;
    private int y = 0;
    private int xSpeed = 5;
    private GameView gameView;
    private Bitmap bitmap;
    private int currentFrame = 0;
    private int width;
    private int height;
    private int ySpeed;
    private static final int MAX_SPEED = 10;

    public Sprite(GameView gameView, Bitmap bitmap){
        this.gameView = gameView;
        this.bitmap = bitmap;
        this.width = bitmap.getWidth() / BMP_COLUMNS;
        this.height = bitmap.getHeight() / BMP_ROWS;
        Random rnd = new Random();
        //x = rnd.nextInt(gameView.getWidth() - width);
        //y = rnd.nextInt(gameView.getHeight() - height);
        xSpeed = rnd.nextInt(MAX_SPEED * 2) - MAX_SPEED;
        ySpeed = rnd.nextInt(MAX_SPEED * 2) - MAX_SPEED;
    }

    int[] DIRECTION_TO_ANIMATION_MAP = {3, 1, 0, 2};
    private int getAnimationRow(){
        double dirDouble = (Math.atan2(xSpeed, ySpeed) / (Math.PI / 2) + 2);
        int direction = (int) Math.round(dirDouble) % BMP_ROWS;
        return DIRECTION_TO_ANIMATION_MAP[direction];
    }

    private void update(){
        if(x > gameView.getWidth() - width - xSpeed || x + xSpeed < 0){
            xSpeed = -xSpeed;
        }
        x = x + xSpeed;
        if(y > gameView.getHeight() - height - ySpeed || y + ySpeed < 0){
            ySpeed = -ySpeed;
        }
        y = y + ySpeed;
        currentFrame = ++currentFrame % BMP_COLUMNS;
    }

    public void onDraw(Canvas canvas){
        update();
        int srcX = currentFrame * width;
        int srcY = getAnimationRow() * height;
        Rect src = new Rect(srcX, srcY, srcX + width, srcY + height);
        Rect dst = new Rect(x, y, x + width, y + height);
        canvas.drawBitmap(bitmap, src, dst, null);
    }

    public boolean isCollition(float x2, float y2){
        return x2 > x && x2 < x + width && y2 > y && y2 < y + height;
    }

}
