package com.example.bdtest;

public class Crosspiece {
    int topBtnX1;
    int topBtnX2;
    int topBtnY1;
    int topBtnY2;



    int rightBtnX1;
    int rightBtnX2;
    int rightBtnY1;
    int rightBtnY2;



    int leftBtnX1;
    int leftBtnX2;
    int leftBtnY1;
    int leftBtnY2;



    int bottomBtnX1;
    int bottomBtnX2;
    int bottomBtnY1;
    int bottomBtnY2;

    public Crosspiece(int canvasHeight, int canvasWidth) {
        int heightHalf = canvasHeight/2;
        topBtnY1 = heightHalf;
        topBtnY2 = heightHalf/3+heightHalf;
        rightBtnY1 = topBtnY2;
        rightBtnY2 = heightHalf/3*2+heightHalf;
        leftBtnY1 = rightBtnY1;
        leftBtnY2 = rightBtnY2;
        bottomBtnY1 = rightBtnY2;
        bottomBtnY2 = canvasHeight;

        topBtnX1 = 0;
        topBtnX2 = canvasWidth/4;
        rightBtnX1 = canvasWidth/4/2;
        rightBtnX2 = canvasWidth/4;
        leftBtnX1 = 0;
        leftBtnX2 = canvasWidth/4/2;
        bottomBtnX1 = 0;
        bottomBtnX2 = canvasWidth/4;
    }
    public int getDirection(int x, int y){
        if (x>topBtnX1 && x<topBtnX2 && y>topBtnY1 && y<topBtnY2) return 1;
        else if (x>rightBtnX1 && x<rightBtnX2 && y>rightBtnY1 && y<rightBtnY2) return 2;
        else if (x>leftBtnX1 && x<leftBtnX2 && y>leftBtnY1 && y<leftBtnY2) return 4;
        else if (x>bottomBtnX1 && x<bottomBtnX2 && y>bottomBtnY1 && y<bottomBtnY2) return 3;
        else return 0;
    }
}
