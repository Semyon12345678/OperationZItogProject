package com.example.bdtest;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

public class DrawThread  extends Thread{
    private SurfaceHolder surfaceHolder;
    public volatile boolean running = true; //флаг для остановки потока
    private Paint backgroundPaint = new Paint();
    //переменные
    public int towardPointX;
    public int towardPointY;

    private Bitmap soldierUp;
    private Bitmap soldierUpS;

    private Bitmap soldierRight;
    private Bitmap soldierRightS;

    private Bitmap soldierBottom;
    private Bitmap soldierBottomS;

    private Bitmap soldierLeft;
    private Bitmap soldierLeftS;

    private Bitmap block;
    private Bitmap blockS;

    private Bitmap LeftExit;
    private Bitmap LeftExitS;

    private Bitmap RightExit;
    private Bitmap RightExitS;

    private Bitmap mine;
    private Bitmap mineS;

    private Bitmap turel1;
    private Bitmap turel1S;

    private Bitmap turel2;
    private Bitmap turel2S;

    private Bitmap turel3;
    private Bitmap turel3S;

    private Bitmap turel4;
    private Bitmap turel4S;

    private Bitmap wonBitmap;
    private Bitmap wonBitmapS;

    private Bitmap diedBitmap;
    private Bitmap diedBitmapS;

    private Bitmap doc;
    private Bitmap docS;

    private int currentRoom;

    private int[][] room1;
    private int[][] room2;
    private int[][] room3;

    private boolean haveDoc = false;
    private boolean haveNoDoc = true;

    public int mode;
    Context context;

    Crosspiece crosspiece;

    Hero hero;
    int heroX = 0;
    int heroY = 0;
    int heroBitmapDirection = 2;
    int direction = 0;

    SharedPreferences level;
    String APP_PREFERENCES;
    String APP_PREFERENCES_ROOM1;
    String APP_PREFERENCES_ROOM2;
    String APP_PREFERENCES_ROOM3;

    //переменные
    {
        backgroundPaint.setColor(Color.GRAY);
        backgroundPaint.setStyle(Paint.Style.FILL);
    }
    public void setTowardPoint(int x, int y) {
        towardPointX = x;
        towardPointY = y;
    }
    //конструктор
    public DrawThread(Context context, SurfaceHolder surfaceHolder, int currentRoom, int[][] room1, int[][] room2, int[][] room3, int mode, SharedPreferences level, String APP_PREFERENCES, String APP_PREFERENCES_ROOM1, String APP_PREFERENCES_ROOM2, String APP_PREFERENCES_ROOM3) {
        this.currentRoom = currentRoom;
        this.surfaceHolder = surfaceHolder;
        this.room1 = room1;
        this.room2 = room2;
        this.room3 = room3;
        this.mode = mode;
        this.level = level;
        this.APP_PREFERENCES = APP_PREFERENCES;
        this.APP_PREFERENCES_ROOM1 = APP_PREFERENCES_ROOM1;
        this.APP_PREFERENCES_ROOM2 = APP_PREFERENCES_ROOM2;
        this.APP_PREFERENCES_ROOM3 = APP_PREFERENCES_ROOM3;

        this.context = context;

        soldierUpS = BitmapFactory.decodeResource(context.getResources(), R.drawable.soldier1);
        soldierRightS = BitmapFactory.decodeResource(context.getResources(), R.drawable.soldier2);
        soldierBottomS = BitmapFactory.decodeResource(context.getResources(), R.drawable.soldier3);
        soldierLeftS = BitmapFactory.decodeResource(context.getResources(), R.drawable.soldier4);
        blockS = BitmapFactory.decodeResource(context.getResources(), R.drawable.block);
        RightExitS = BitmapFactory.decodeResource(context.getResources(), R.drawable.rightexit);
        LeftExitS = BitmapFactory.decodeResource(context.getResources(), R.drawable.leftexit);
        mineS = BitmapFactory.decodeResource(context.getResources(), R.drawable.mine);
        turel1S = BitmapFactory.decodeResource(context.getResources(), R.drawable.turel1);
        turel2S = BitmapFactory.decodeResource(context.getResources(), R.drawable.turel2);
        turel3S = BitmapFactory.decodeResource(context.getResources(), R.drawable.turel3);
        turel4S = BitmapFactory.decodeResource(context.getResources(), R.drawable.turel4);
        wonBitmapS = BitmapFactory.decodeResource(context.getResources(), R.drawable.won);
        diedBitmapS = BitmapFactory.decodeResource(context.getResources(), R.drawable.died);
        docS = BitmapFactory.decodeResource(context.getResources(), R.drawable.doc);

    }
    //конструктор
    public void requestStop() {
        running = false;
    }

    @Override
    public void run() {
        Canvas canvas;
        while (running) {
            canvas = surfaceHolder.lockCanvas();
            if (canvas != null) {
                try {
                    int blockHeight = canvas.getHeight()/10;
                    int blockWidth = canvas.getWidth()/22;

                    Paint paint = new Paint();
                    // рисование на canvas
                    canvas.drawRGB(223, 223, 223);
                    level = context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);





                    //mode play
                    if(mode==1) {
                        block = Bitmap.createScaledBitmap(blockS, blockWidth, blockHeight, false);
                        soldierUp = Bitmap.createScaledBitmap(soldierUpS, blockWidth, blockHeight, false);
                        soldierRight = Bitmap.createScaledBitmap(soldierRightS, blockWidth, blockHeight, false);
                        soldierBottom = Bitmap.createScaledBitmap(soldierBottomS, blockWidth, blockHeight, false);
                        soldierLeft = Bitmap.createScaledBitmap(soldierLeftS, blockWidth, blockHeight, false);
                        RightExit = Bitmap.createScaledBitmap(RightExitS, blockWidth, blockHeight, false);
                        LeftExit = Bitmap.createScaledBitmap(LeftExitS, blockWidth, blockHeight, false);
                        mine = Bitmap.createScaledBitmap(mineS, blockWidth, blockHeight, false);
                        turel1 = Bitmap.createScaledBitmap(turel1S, blockWidth, blockHeight, false);
                        turel2 = Bitmap.createScaledBitmap(turel2S, blockWidth, blockHeight, false);
                        turel3 = Bitmap.createScaledBitmap(turel3S, blockWidth, blockHeight, false);
                        turel4 = Bitmap.createScaledBitmap(turel4S, blockWidth, blockHeight, false);
                        wonBitmap = Bitmap.createScaledBitmap(wonBitmapS, canvas.getWidth(), canvas.getHeight(), false);
                        diedBitmap = Bitmap.createScaledBitmap(diedBitmapS, canvas.getWidth(), canvas.getHeight(), false);
                        doc = Bitmap.createScaledBitmap(docS, blockWidth, blockHeight, false);


                        //room1play
                        if (currentRoom == 1) {
                            for (int i = 0; i < 10; i++) {
                                for (int j = 0; j < 22; j++) {
                                    if (room1[i][j] == 1) canvas.drawBitmap(block, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room1[i][j] == 2) canvas.drawBitmap(LeftExit, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room1[i][j] == 3) canvas.drawBitmap(RightExit, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room1[i][j] == 4) canvas.drawBitmap(mine, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room1[i][j] == 5) canvas.drawBitmap(turel1, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room1[i][j] == 6) canvas.drawBitmap(turel2, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room1[i][j] == 7) canvas.drawBitmap(turel3, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room1[i][j] == 8) canvas.drawBitmap(turel4, blockWidth * j, blockHeight * i, backgroundPaint);
                                }
                            }
                        }
                        //room1play


                        //room2play
                        else if (currentRoom == 2) {
                            for (int i = 0; i < 10; i++) {
                                for (int j = 0; j < 22; j++) {
                                    if (room2[i][j] == 1) canvas.drawBitmap(block, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room2[i][j] == 3) canvas.drawBitmap(RightExit, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room2[i][j] == 2) canvas.drawBitmap(LeftExit, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room2[i][j] == 4) canvas.drawBitmap(mine, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room2[i][j] == 5) canvas.drawBitmap(turel1, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room2[i][j] == 6) canvas.drawBitmap(turel2, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room2[i][j] == 7) canvas.drawBitmap(turel3, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room2[i][j] == 8) canvas.drawBitmap(turel4, blockWidth * j, blockHeight * i, backgroundPaint);

                                }
                            }
                        }
                        //room2play


                        //room3play
                        else if (currentRoom == 3) {
                            for (int i = 0; i < 10; i++) {
                                for (int j = 0; j < 22; j++) {
                                    if (room3[i][j] == 1) canvas.drawBitmap(block, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room3[i][j] == 2) canvas.drawBitmap(LeftExit, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room3[i][j] == 3&&haveNoDoc) canvas.drawBitmap(doc, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room3[i][j] == 4) canvas.drawBitmap(mine, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room3[i][j] == 5) canvas.drawBitmap(turel1, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room3[i][j] == 6) canvas.drawBitmap(turel2, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room3[i][j] == 7) canvas.drawBitmap(turel3, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room3[i][j] == 8) canvas.drawBitmap(turel4, blockWidth * j, blockHeight * i, backgroundPaint);
                                }
                            }
                        }
                        //room3play

                        hero = new Hero(blockHeight, blockWidth, room1, room2, room3, heroX, heroY, heroBitmapDirection);
                        crosspiece = new Crosspiece(canvas.getHeight(), canvas.getWidth());
                        direction = crosspiece.getDirection(towardPointX, towardPointY);
                        if (direction != 0) heroBitmapDirection = direction;

                        if (heroBitmapDirection == 1)
                            canvas.drawBitmap(soldierUp, heroX, heroY, backgroundPaint);
                        else if (heroBitmapDirection == 2)
                            canvas.drawBitmap(soldierRight, heroX, heroY, backgroundPaint);
                        else if (heroBitmapDirection == 3)
                            canvas.drawBitmap(soldierBottom, heroX, heroY, backgroundPaint);
                        else if (heroBitmapDirection == 4)
                            canvas.drawBitmap(soldierLeft, heroX, heroY, backgroundPaint);

                        int aim = hero.getAim(direction, currentRoom);

                        if(aim == -2){
                            currentRoom--;
                            heroX = blockWidth*21;
                            heroY = blockHeight*9;
                        }
                        else if(aim == -3){
                            currentRoom++;
                            heroX = 0;
                            heroY = 0;
                        }
                        else if (direction == 1 && aim>=0) {
                            while (aim != heroY) {
                                heroY--;
                                canvas.drawBitmap(soldierUp, heroX, heroY, backgroundPaint);
                            }
                        }
                        else if (direction == 2 && aim>=0) {
                            while (aim != heroX) {
                                heroX++;
                                canvas.drawBitmap(soldierRight, heroX, heroY, backgroundPaint);
                            }
                        }
                        else if(direction==3 && aim>=0) {
                            while (aim != heroY) {
                                heroY++;
                                canvas.drawBitmap(soldierBottom, heroX, heroY, backgroundPaint);
                            }
                        }
                        else if(direction==4 && aim>=0) {
                            while (aim != heroX) {
                                heroX--;
                                canvas.drawBitmap(soldierLeft, heroX, heroY, backgroundPaint);
                            }
                        }
                        else if(aim == -4){
                            canvas.drawBitmap(diedBitmap, 0, 0, backgroundPaint);
                        }
                        else if(aim == -5 && haveNoDoc){
                            haveDoc=true;
                            haveNoDoc=false;

                            //canvas.drawBitmap(wonBitmap, 0, 0, backgroundPaint);
                        }
                        else if(aim == -6&& haveDoc){

                            canvas.drawBitmap(wonBitmap, 0, 0, backgroundPaint);
                        }
                    }
                    //mode play






                    //mode edit
                    else {
                        block = Bitmap.createScaledBitmap(blockS, blockWidth, blockHeight, false);
                        RightExit = Bitmap.createScaledBitmap(RightExitS, blockWidth, blockHeight, false);
                        LeftExit = Bitmap.createScaledBitmap(LeftExitS, blockWidth, blockHeight, false);
                        mine = Bitmap.createScaledBitmap(mineS, blockWidth, blockHeight, false);
                        turel1 = Bitmap.createScaledBitmap(turel1S, blockWidth, blockHeight, false);
                        turel2 = Bitmap.createScaledBitmap(turel2S, blockWidth, blockHeight, false);
                        turel3 = Bitmap.createScaledBitmap(turel3S, blockWidth, blockHeight, false);
                        turel4 = Bitmap.createScaledBitmap(turel4S, blockWidth, blockHeight, false);
                        //room1Edit
                        if(currentRoom == 1){
                            for (int i = 0; i < 10; i++) {
                                for (int j = 0; j < 22; j++) {
                                    if (room1[i][j] == 1) canvas.drawBitmap(block, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room1[i][j] == 3) canvas.drawBitmap(RightExit, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room1[i][j] == 4) canvas.drawBitmap(mine, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room1[i][j] == 5) canvas.drawBitmap(turel1, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room1[i][j] == 6) canvas.drawBitmap(turel2, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room1[i][j] == 7) canvas.drawBitmap(turel3, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room1[i][j] == 8) canvas.drawBitmap(turel4, blockWidth * j, blockHeight * i, backgroundPaint);
                                }
                            }

                            if(towardPointX>=0 && towardPointY>=0){
                                int j = towardPointX/blockWidth;
                                int i = towardPointY/blockHeight;
                                if(room1[i][j] == 0){
                                    room1[i][j] = 1;
                                    try {
                                        Thread.sleep(200);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                //mine
                                else if(room1[i][j] == 1){
                                    room1[i][j] = 4;
                                    try {
                                        Thread.sleep(200);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                // turel1
                                else if(room1[i][j] == 4){
                                    room1[i][j] = 0;
                                    try {
                                        Thread.sleep(200);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                // turel2
                                else if(room1[i][j] == 5){
                                    room1[i][j] = 6;
                                    try {
                                        Thread.sleep(200);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                // turel3
                                else if(room1[i][j] == 6){
                                    room1[i][j] = 7;
                                    try {
                                        Thread.sleep(200);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                // turel4
                                else if(room1[i][j] == 7){
                                    room1[i][j] = 8;
                                    try {
                                        Thread.sleep(200);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }

                                // to 0
                                else if(room1[i][j] == 8){
                                    room1[i][j] = 0;
                                    try {
                                        Thread.sleep(200);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }



                                //exites
                                else if(room1[i][j]==3){
                                    currentRoom = 2;
                                    try {
                                        Thread.sleep(200);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }

                        }
                        //room1Edit

                        //room2Edit
                        else if(currentRoom == 2){
                            for (int i = 0; i < 10; i++) {
                                for (int j = 0; j < 22; j++) {
                                    if (room2[i][j] == 1) canvas.drawBitmap(block, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room2[i][j] == 3) canvas.drawBitmap(RightExit, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room2[i][j] == 2) canvas.drawBitmap(LeftExit, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room2[i][j] == 4) canvas.drawBitmap(mine, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room2[i][j] == 5) canvas.drawBitmap(turel1, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room2[i][j] == 6) canvas.drawBitmap(turel2, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room2[i][j] == 7) canvas.drawBitmap(turel3, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room2[i][j] == 8) canvas.drawBitmap(turel4, blockWidth * j, blockHeight * i, backgroundPaint);
                                }
                            }

                            if(towardPointX>=0 && towardPointY>=0){
                                int j = towardPointX/blockWidth;
                                int i = towardPointY/blockHeight;
                                if(room2[i][j] == 0){
                                    room2[i][j] = 1;
                                    try {
                                        Thread.sleep(200);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }

                                //mine
                                else if(room2[i][j] == 1){
                                    room2[i][j] = 4;
                                    try {
                                        Thread.sleep(200);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                // turel1
                                else if(room2[i][j] == 4){
                                    room2[i][j] = 0;
                                    try {
                                        Thread.sleep(200);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                // turel2
                                else if(room2[i][j] == 5){
                                    room2[i][j] = 6;
                                    try {
                                        Thread.sleep(200);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                // turel3
                                else if(room2[i][j] == 6){
                                    room2[i][j] = 7;
                                    try {
                                        Thread.sleep(200);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                // turel4
                                else if(room2[i][j] == 7){
                                    room2[i][j] = 8;
                                    try {
                                        Thread.sleep(200);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }

                                // to 0
                                else if(room2[i][j] == 8){
                                    room2[i][j] = 0;
                                    try {
                                        Thread.sleep(200);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }



                                //exites
                                else if(room2[i][j]==2){
                                    currentRoom = 1;
                                    try {
                                        Thread.sleep(200);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }

                                else if(room2[i][j]==3){
                                    currentRoom = 3;
                                    try {
                                        Thread.sleep(200);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }

                        }
                        //room2Edit

                        //room3Edit
                        else if(currentRoom == 3){
                            for (int i = 0; i < 10; i++) {
                                for (int j = 0; j < 22; j++) {
                                    if (room3[i][j] == 1) canvas.drawBitmap(block, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room3[i][j] == 2) canvas.drawBitmap(LeftExit, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room3[i][j] == 3) canvas.drawBitmap(RightExit, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room3[i][j] == 4) canvas.drawBitmap(mine, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room3[i][j] == 5) canvas.drawBitmap(turel1, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room3[i][j] == 6) canvas.drawBitmap(turel2, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room3[i][j] == 7) canvas.drawBitmap(turel3, blockWidth * j, blockHeight * i, backgroundPaint);
                                    else if (room3[i][j] == 8) canvas.drawBitmap(turel4, blockWidth * j, blockHeight * i, backgroundPaint);
                                }
                            }

                            if(towardPointX>=0 && towardPointY>=0){
                                int j = towardPointX/blockWidth;
                                int i = towardPointY/blockHeight;
                                if(room3[i][j] == 0){
                                    room3[i][j] = 1;
                                    try {
                                        Thread.sleep(200);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }

                                //mine
                                else if(room3[i][j] == 1){
                                    room3[i][j] = 4;
                                    try {
                                        Thread.sleep(200);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                // turel1
                                else if(room3[i][j] == 4){
                                    room3[i][j] = 0;
                                    try {
                                        Thread.sleep(200);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                // turel2
                                else if(room3[i][j] == 5){
                                    room3[i][j] = 6;
                                    try {
                                        Thread.sleep(200);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                // turel3
                                else if(room3[i][j] == 6){
                                    room3[i][j] = 7;
                                    try {
                                        Thread.sleep(200);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                // turel4
                                else if(room3[i][j] == 7){
                                    room3[i][j] = 8;
                                    try {
                                        Thread.sleep(200);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }

                                // to 0
                                else if(room3[i][j] == 8){
                                    room3[i][j] = 0;
                                    try {
                                        Thread.sleep(200);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }



                                //exites
                                else if(room3[i][j]==2){
                                    currentRoom = 2;
                                    try {
                                        Thread.sleep(200);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }

                            }

                        }
                        //room3Edit

                    }
                    //mode edit





                    // рисование на canvas
                } finally {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }



}
