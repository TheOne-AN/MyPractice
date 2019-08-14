#define _CRT_SECURE_NO_WARNINGS  1
#include<stdio.h>
#include"game.h"
static int  getmine(char mine[][COLS], int x, int y)
{
	return mine[x - 1][y - 1] + mine[x - 1][y] + mine[x - 1][y + 1] +
		mine[x][y - 1] + mine[x][y + 1] + mine[x + 1][y - 1] +
		mine[x + 1][y] + mine[x + 1][y + 1] - 8*'0';
}
void initboard(char board[][COLS], int row, int col, char set)
{
	memset(board, set, row*col*sizeof(char));
	//int i = 0, j = 0;
	//for (i = 0; i <= row; i++)
	//{
	//	for (j = 0; j <= col; j++)
	//	{
	//		board[i][j] = set;
	//	}
	//}	
}
void showboard(char board[][COLS], int row, int col)
{
	int i = 0;
	int j = 0;
	printf("-------------------------------------------------------\n");
	for (i = 0; i <= row; i++)
	{
		printf("%d ", i);
	}
	putchar('\n');
	for (i = 1; i <= row; i++)
	{
		printf("%d ", i);
		for (j = 1; j <=col; j++)
		{
			printf("%c ", board[i][j]);
		}
		putchar('\n');
	}
	printf("-------------------------------------------------------\n");
}
void setmine(char mine[][COLS], int row, int col)
{
	int x, y;
	int count = 0;
	while (count < MINE_NUM)
	{
		x = rand() % row + 1;//[1,10)
		y = rand() % col + 1;
		if (mine[x][y] == '0')
		{
			mine[x][y] = '1';
			count++;
		}
	}
}
void findmine(char mine[][COLS], char mineinfo[][COLS], int row, int col)
{
	int count = 0;
	int x = 0, y = 0;
	while (count < row*col - MINE_NUM)
	{
		printf("请输入坐标：");
		scanf("%d%d", &x, &y);
		//判断坐标是否合法
		if (x >= 1 && x <= 9 && y >= 1 && y <= 9)
		{
			if (mine[x][y] == '1')
			{
				printf("你被炸死了。\n");
				break;
			}
			else
			{
				//统计当前位置附近有几颗雷
				int ret = getmine(mine, x, y);
				mineinfo[x][y] = ret+'0';
				showboard(mineinfo, row, col);
				count++;
			}
		}
		else
		{
			printf("坐标不合法\n");
		}
	}
}
