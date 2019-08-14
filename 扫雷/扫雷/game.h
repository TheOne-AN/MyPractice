#ifndef _GAME_H_
#define _GAME_H_

#include<string.h>
#include<stdio.h>
#include<stdlib.h>
#include<time.h>

#define ROW 9
#define COL 9

#define ROWS ROW+2
#define COLS COL+2
#define MINE_NUM 10

void initboard(char board[][COLS], int row, int col, char set);
void showboard(char board[][COLS], int row, int col);
void setmine(char mine[][COLS], int row, int col);
void findmine(char mine[][COLS], char mineinfo[][COLS], int row, int col);


#endif//__GAME_H__

