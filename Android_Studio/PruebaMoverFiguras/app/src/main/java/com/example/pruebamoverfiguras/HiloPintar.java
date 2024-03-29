package com.example.pruebamoverfiguras;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class HiloPintar extends Thread{

    private SurfaceHolder sh;
    private MoverFiguras view;
    private boolean run;

    public HiloPintar(SurfaceHolder sh, MoverFiguras view){
        this.sh = sh;
        this.view = view;
        run = false;
    }

    public void setRunning(boolean run){
        this.run = run;
    }

    public void run(){
        Canvas canvas;

        while(run){
            canvas = null;
            try {
                canvas = sh.lockCanvas(null);
                if(canvas != null){
                    synchronized (sh){
                        //view.postInvalidate();
                        view.draw(canvas);
                    }
                }
            }
            finally {
                if(canvas != null){
                    sh.unlockCanvasAndPost(canvas);
                }

            }
        }
    }




}
