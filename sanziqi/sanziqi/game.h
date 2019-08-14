
#ifndef  __GAME_H__
#define __GAME_H__
#include<string.h>
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
void InitBoard(char board[][3], int row, int col);//初始化棋盘
void ShowBoard(char board[][3], int row, int col);//显示棋盘
void PlayerMove(char board[][3], int row, int col);//玩家操作
void ComputerMove(char board[][3], int row, int col);//电脑操作
char IsWin(char board[][3], int row, int col);//判断输赢
#endif//__GAME_H__