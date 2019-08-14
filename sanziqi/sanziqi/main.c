#define _CRT_SECURE_NO_WARNINGS  1
#include "game.h"

void Menu()
{
	printf("\t\t\t\t\t**************************\n");
	printf("\t\t\t\t\t**************************\n");
	printf("\t\t\t\t\t*********1.开始***********\n");
	printf("\t\t\t\t\t*********0.退出***********\n");
	printf("\t\t\t\t\t**************************\n");
	printf("\t\t\t\t\t**************************\n");
}
void Game()
{
	char ret = 0;//定义一个接收判断谁赢的返回字符
	char board[3][3] = { 0 };//用二维数组定义表示棋盘
	InitBoard(board, 3, 3);//初始化棋盘，让棋盘为空
	ShowBoard(board, 3, 3);//显示棋盘
	while (1)//
	{
		PlayerMove(board, 3, 3);
		ShowBoard(board, 3, 3);
		ret = IsWin(board, 3, 3);
		if (ret != ' ')
		{
			break;
		}
		ComputerMove(board, 3, 3);
		ShowBoard(board, 3, 3);
		ret = IsWin(board, 3, 3);
		if (ret != ' ')
		{
			break;
		}
	}
	if (ret == 'X')
	{
		printf("玩家获胜\n");
	}
	if (ret == 'O')
	{
		printf("电脑获胜\n");
	}
	if (ret == 'P')
	{
		printf("平局\n");
	}
}
int main()
{
	int  input = 0;
	srand((unsigned int)time(NULL));//设置随机种子，使每次游戏时电脑操作不和上次游戏完全相同
	do{
		Menu();
		printf("请输入你的选择：");
		scanf("%d", &input);
		switch (input)
		{
		case 1:
			Game();
			break;
		case 0:
			printf("游戏结束！\n");
			break;
		default:
			printf("您的选择有误！\n\n");
			break;
		}
	} while (input);
	return 0;
}