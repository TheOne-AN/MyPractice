
#ifndef  __GAME_H__
#define __GAME_H__
#include<string.h>
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
void InitBoard(char board[][3], int row, int col);//��ʼ������
void ShowBoard(char board[][3], int row, int col);//��ʾ����
void PlayerMove(char board[][3], int row, int col);//��Ҳ���
void ComputerMove(char board[][3], int row, int col);//���Բ���
char IsWin(char board[][3], int row, int col);//�ж���Ӯ
#endif//__GAME_H__