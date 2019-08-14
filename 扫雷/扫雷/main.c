#define _CRT_SECURE_NO_WARNINGS  1
#include<stdio.h>
#include"game.h"
void menu()
{
	printf("********************************\n");
	printf("*************1.开始*************\n");
	printf("*************0.退出*************\n");
	printf("********************************\n");
}
void game()
{
	//存放雷
	char mine[ROWS][COLS] = { 0 };
	//排查雷
	char mineinfo[ROWS][COLS] = { 0 };
	//初始化数组
	initboard(mine, ROWS, COLS, '0');
	initboard(mineinfo, ROWS, COLS, '*');
	//打印二维数组（哈哈哈）
	showboard(mineinfo, ROW, COL);
	//布置雷
	setmine(mine, ROW, COL);
	//找雷
	findmine(mine,mineinfo,ROW,COL);
}
int main()
{
	int input = 0;
	srand((unsigned int)time(NULL));
	do{
		menu();
		printf("请输入你的操作：");
		scanf("%d", &input);
		switch (input)
		{
		case 1:
			game();
			break;
		case 0:
			printf("游戏结束！\n");
			break;
		default:
			printf("您的输入有误，请重新输入。\n");
			break;
		}
	} while (input);
	return 0;
}
