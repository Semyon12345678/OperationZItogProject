package com.example.bdtest;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private DrawThread drawThread;
    public int[][] room1;
    public int[][] room2;
    public int[][] room3;
    public int mode;
    public int currentRoom = 1;
    SharedPreferences level;
    String APP_PREFERENCES;
    String APP_PREFERENCES_ROOM1;
    String APP_PREFERENCES_ROOM2;
    String APP_PREFERENCES_ROOM3;

    public GameView(Context context , int[][] room1, int[][] room2, int[][] room3, int mode, SharedPreferences level, String APP_PREFERENCES, String APP_PREFERENCES_ROOM1, String APP_PREFERENCES_ROOM2, String APP_PREFERENCES_ROOM3) {
        super(context);
        getHolder().addCallback(this);
        this.room1 = room1;
        this.room2 = room2;
        this.room3 = room3;
        this.mode = mode;
        this.level = level;
        this.APP_PREFERENCES = APP_PREFERENCES;
        this.APP_PREFERENCES_ROOM1 = APP_PREFERENCES_ROOM1;
        this.APP_PREFERENCES_ROOM2 = APP_PREFERENCES_ROOM2;
        this.APP_PREFERENCES_ROOM3 = APP_PREFERENCES_ROOM3;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        drawThread.setTowardPoint((int)event.getX(),(int)event.getY());
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: // нажатие
                drawThread.setTowardPoint((int)event.getX(),(int)event.getY());
                return true;
            case MotionEvent.ACTION_MOVE: // движение
                return true;

            case MotionEvent.ACTION_UP: // отпускание
                drawThread.setTowardPoint(-2,-2);
                return true;

            case MotionEvent.ACTION_CANCEL:

                break;
        }
        return false;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        // создание SurfaceView
        drawThread = new DrawThread(getContext(), getHolder(), currentRoom, room1, room2, room3, mode, level, APP_PREFERENCES, APP_PREFERENCES_ROOM1, APP_PREFERENCES_ROOM2, APP_PREFERENCES_ROOM3);
        drawThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        // изменение размеров SurfaceView
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        // уничтожение SurfaceView
        drawThread.requestStop();
        boolean retry = true;
        while (retry) {
            try {
                drawThread.join();
                retry = false;
            } catch (InterruptedException e) {
            }
        }
    }
}

