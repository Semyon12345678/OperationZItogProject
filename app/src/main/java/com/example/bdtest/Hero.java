package com.example.bdtest;

public class Hero {
    public int heroX;
    public int heroY;

    int blockHeight;
    int blockWidth;

    int[][] room1;
    int[][] room2;
    int[][] room3;

    int enemyX;
    int enemyY;

    int bitmapDirection;

    boolean isKilled = false;

    public Hero(int blockHeight, int blockWidth, int[][] room1, int[][] room2, int[][] room3, int heroXCanv, int heroYCanv, int bitmapDirection) {
        this.blockHeight = blockHeight;
        this.blockWidth = blockWidth;
        this.room1 = room1;
        this.room2 = room2;
        this.room3 = room3;
        heroX = heroXCanv/blockWidth;
        heroY = heroYCanv/blockHeight;
        this.bitmapDirection = bitmapDirection;
    }

    public int getAim(int direction, int currentRoom) {

        //currentRoom == 1
        if (currentRoom == 1) {



//            enemyX = heroX;
//            enemyY = heroY;
//            while (enemyY != 0 && room1[enemyY - 1][enemyX] != 1 && room1[enemyY][enemyX] != 7) {
//                heroY--;
//            }
//            if(room1[enemyY][enemyX] == 7) isKilled=true;
//
//            enemyX = heroX;
//            enemyY = heroY;
//            while (enemyX != 21 && room1[enemyY][enemyX + 1] != 1 && room1[enemyY][enemyX] != 8) {
//                heroX++;
//            }
//            if(room1[enemyY][enemyX] == 8) isKilled=true;
//
//            enemyX = heroX;
//            enemyY = heroY;
//            while (enemyY != 9 && room1[enemyY + 1][enemyX] != 1 && room1[enemyY][enemyX] != 5) {
//                heroY++;
//            }
//            if(room1[enemyY][enemyX] == 5) isKilled=true;
//
//            enemyX = heroX;
//            enemyY = heroY;
//            while (enemyX != 0 && room1[enemyY][enemyX - 1] != 1 && room1[enemyY][enemyX] != 6) {
//                heroX--;
//            }
//            if(room1[enemyY][enemyX] == 6) isKilled=true;
//
//
//            if(isKilled)return -4;
            if (room1[heroY][heroX] == 3 && direction == 2) {
                return -3;
            }
            else if (room1[heroY][heroX] == 2 && bitmapDirection == 4) {
                return -6;
            }else if (room1[heroY][heroX] == 4)
                return -4;
            else if (direction == 1 && heroY != 0) {
                while (heroY != 0 && room1[heroY - 1][heroX] != 1 && room1[heroY][heroX] != 4) {
                    heroY--;
                }
                return heroY * blockHeight;
            } else if (direction == 2 && heroX != 21) {
                while (heroX != 21 && room1[heroY][heroX + 1] != 1 && room1[heroY][heroX] != 4) {
                    heroX++;
                }
                return heroX * blockWidth;
            } else if (direction == 3 && heroY != 9) {
                while (heroY != 9 && room1[heroY + 1][heroX] != 1 && room1[heroY][heroX] != 4) {
                    heroY++;
                }
                return heroY * blockHeight;
            } else if (direction == 4 && heroX != 0) {
                while (heroX != 0 && room1[heroY][heroX - 1] != 1 && room1[heroY][heroX] != 4) {
                    heroX--;
                }
                return heroX * blockWidth;
            } else if (direction == 1 && heroY == 0) return heroY * blockHeight;
            else if (direction == 2 && heroX == 21) return heroX * blockWidth;
            else if (direction == 3 && heroY == 9) return heroY * blockHeight;
            else if (direction == 4 && heroX == 0) return heroX * blockWidth;
            else return -1;
        }
        //currentRoom == 1


        //currentRoom == 2
        else if (currentRoom == 2) {
            if (room2[heroY][heroX] == 2 && direction == 4) {
                return -2;
            } else if (room2[heroY][heroX] == 3 && direction == 2) {
                return -3;
            } else if (room2[heroY][heroX] == 4)
                return -4;
            else if (direction == 1 && heroY != 0) {
                while (heroY != 0 && room2[heroY - 1][heroX] != 1 && room2[heroY][heroX] != 4) {
                    heroY--;
                }
                return heroY * blockHeight;
            } else if (direction == 2 && heroX != 21) {
                while (heroX != 21 && room2[heroY][heroX + 1] != 1 && room2[heroY][heroX] != 4) {
                    heroX++;
                }
                return heroX * blockWidth;
            } else if (direction == 3 && heroY != 9) {
                while (heroY != 9 && room2[heroY + 1][heroX] != 1 && room2[heroY][heroX] != 4) {
                    heroY++;
                }
                return heroY * blockHeight;
            } else if (direction == 4 && heroX != 0) {
                while (heroX != 0 && room2[heroY][heroX - 1] != 1 && room2[heroY][heroX] != 4) {
                    heroX--;
                }
                return heroX * blockWidth;
            } else if (direction == 1 && heroY == 0) return heroY * blockHeight;
            else if (direction == 2 && heroX == 21) return heroX * blockWidth;
            else if (direction == 3 && heroY == 9) return heroY * blockHeight;
            else if (direction == 4 && heroX == 0) return heroX * blockWidth;
            else return -1;
        }
        //currentRoom == 2


        //currentRoom == 3
        else if (currentRoom == 3) {
            if (room3[heroY][heroX] == 2 && direction == 4) {
                return -2;
            }
            else if (room3[heroY][heroX] == 3&& (direction==2||direction==3)) {
                return -5;
            }
            else if (room3[heroY][heroX] == 4)
                return -4;
            else if (direction == 1 && heroY != 0) {
                while (heroY != 0 && room3[heroY - 1][heroX] != 1 && room3[heroY][heroX] != 4) {
                    heroY--;
                }
                return heroY * blockHeight;
            } else if (direction == 2 && heroX != 21) {
                while (heroX != 21 && room3[heroY][heroX + 1] != 1 && room3[heroY][heroX] != 4) {
                    heroX++;
                }
                return heroX * blockWidth;
            } else if (direction == 3 && heroY != 9) {
                while (heroY != 9 && room3[heroY + 1][heroX] != 1 && room3[heroY][heroX] != 4) {
                    heroY++;
                }
                return heroY * blockHeight;
            } else if (direction == 4 && heroX != 0) {
                while (heroX != 0 && room3[heroY][heroX - 1] != 1 && room3[heroY][heroX] != 4) {
                    heroX--;
                }
                return heroX * blockWidth;
            } else if (direction == 1 && heroY == 0) return heroY * blockHeight;
            else if (direction == 2 && heroX == 21) return heroX * blockWidth;
            else if (direction == 3 && heroY == 9) return heroY * blockHeight;
            else if (direction == 4 && heroX == 0) return heroX * blockWidth;
            else return -1;
        }
        //currentRoom == 3


        return -1;
    }
}
