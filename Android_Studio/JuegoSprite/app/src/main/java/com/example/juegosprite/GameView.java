package com.example.juegosprite;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;


public class GameView extends SurfaceView implements SurfaceHolder.Callback{

    private GameThread gameThread;
    private Bitmap bitmap;
    private Sprite sprite;
    private List<Sprite> sprites = new ArrayList<Sprite>();
    private List<TempSprite> temps = new ArrayList<TempSprite>();
    private long lastClick;
    private Bitmap bmpBlood;

    private void createSprites(){
        sprites.add(createSprite(R.drawable.bad1));
        sprites.add(createSprite(R.drawable.bad2));
        sprites.add(createSprite(R.drawable.bad3));
        sprites.add(createSprite(R.drawable.bad4));
        sprites.add(createSprite(R.drawable.bad5));
        sprites.add(createSprite(R.drawable.bad6));
        sprites.add(createSprite(R.drawable.good1));
        sprites.add(createSprite(R.drawable.good2));
        sprites.add(createSprite(R.drawable.good3));
        sprites.add(createSprite(R.drawable.good4));
        sprites.add(createSprite(R.drawable.good5));
        sprites.add(createSprite(R.drawable.good6));
    }

    private Sprite createSprite(int resouce){
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), resouce);
        return new Sprite(this, bmp);
    }

    public GameView(Context context){
        super(context);

        setBackgroundColor(Color.BLACK);
        getHolder().addCallback(this);

        createSprites();
    }

    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawColor(Color.BLACK);
        for (Sprite sprite: sprites){
            sprite.onDraw(canvas);
        }
        for(int i = temps.size() - 1; i >= 0; i--){
            temps.get(i).onDraw(canvas);
        }
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        boolean muerto = false;
        if(System.currentTimeMillis() - lastClick > 500){
            lastClick = System.currentTimeMillis();

            synchronized (getHolder()){
                for(int i = sprites.size()-1; i>=0  && !muerto; i--){
                    Sprite sprite = sprites.get(i);
                    if(sprite.isCollition(event.getX(), event.getY())){
                        sprites.remove(sprite);
                        temps.add(new TempSprite(temps, this, event.getX(), event.getY(), bmpBlood));
                        muerto = true;
                    }
                }
            }
        }

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_CANCEL:

                break;
            case MotionEvent.ACTION_UP:

        }
        return true;
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        gameThread = new GameThread(getHolder(), this);
        gameThread.setRunning(true);
        gameThread.start();

        bmpBlood = BitmapFactory.decodeResource(getResources(), R.drawable.blood1);
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        boolean retry = true;
        gameThread.setRunning(false);
        while(retry){
            try{
                gameThread.join();
                retry = false;
            }
            catch (InterruptedException e){

            }
        }
    }

}
