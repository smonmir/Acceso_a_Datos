package com.example.juegosprite;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class GameThread extends Thread{

    private SurfaceHolder sh;
    private GameView gameView;
    private boolean run;

    private static final long FPS = 10;

    public GameThread(SurfaceHolder sh, GameView gameView){
        this.sh = sh;
        this.gameView = gameView;
        run = false;
    }

    public void setRunning(boolean run){
        this.run = run;
    }

    @Override
    public void run(){
        long ticksPS = 1000 / FPS;
        long startTime;
        long sleepTime;

        while(run){
            Canvas canvas = null;
            startTime = System.currentTimeMillis();
            try {
                canvas = gameView.getHolder().lockCanvas();
                synchronized (sh){
                    gameView.draw(canvas);
                }
            }
            finally {
                if(canvas != null){
                    gameView.getHolder().unlockCanvasAndPost(canvas);
                }
            }
            sleepTime = ticksPS-(System.currentTimeMillis() - startTime);
            try{
                if(sleepTime > 0){
                    sleep(sleepTime);
                }
                else {
                    sleep(10);
                }
            }
            catch (Exception e){

            }
        }
    }



}
