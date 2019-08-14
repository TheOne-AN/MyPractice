#define _CRT_SECURE_NO_WARNINGS  1
#include "game.h"

static int full(char board[][3], int row, int col)
{
	int i, j;
	for (i = 0; i < row; i++)
	{
		for (j = 0; j < col; j++)
		{
			if (board[i][j] == ' ')
			{
				return 0;
			}
		}
	}
	return 1;
}
void InitBoard(char board[][3], int row, int col)
{
	memset(board, ' ', row*col*sizeof(char));//游戏开始给棋盘的每个空间都置为空
}
void ShowBoard(char board[][3], int row, int col)
{
	int  i = 0;
	int j = 0;
	for (i = 0; i < row; i++)//控制行
	{
		for (j = 0; j < col; j++)//控制列
		{
			printf(" %c ", board[i][j]);//打印字符二维数组中存储的符号
			if (j < col - 1)//只需要打两列，所以为col-1,满足条件打印|
			{
				printf("|");
			}
		}
		putchar('\n');//每一行打完后使用putchar进行换行
		if (i < row - 1)//同理对每行的分隔符进行打印
		{
			for (j = 0; j < col; j++)
			{
				printf("---");
				if (j < col - 1)
				{
					printf("|");
				}
			}
			putchar('\n');	
		}
	}
}
void PlayerMove(char board[][3], int row, int col)
{
	int x = 0;//定义变量X和Y，玩家输入坐标
	int y = 0;
	while (1)
	{

		printf("请输入你的落子位置（1-3）：");
		scanf("%d%d", &x, &y);
		if (x>=1&&x<=3&&y>=1&&y<=3)//满足棋盘大小条件，准备赋值
		{
			if (board[x - 1][y - 1] == ' ')//当该位置为空，对该格进行赋值
			{
				board[x - 1][y - 1] = 'X';
				break;

			}
			else//当该位置不为空，提示重新输入
			{
				printf("此位置已被占用，请重新输入。\n");
			}
		}
		else//不满足棋盘条件，提示输入不合理
		{
			printf("您输入的位置不合理。\n");
		}
	}
}
void ComputerMove(char board[][3], int row, int col)
{
	int i=0, j=0;
	printf("电脑的选择：\n\n");
	while (1)
	{
		i = rand() % 3 + 1;//获取随机数i和j
		j = rand() % 3 + 1;
		if (board[i][j] == ' ')//当该位置为空，下棋
		{
			board[i][j] = 'O';
			break;
		}
	}
}
//char IsWin(char board[][3], int row, int col)
//{
//	int i = 0;
//	for (i = 0; i < row; i++)
//	{
//		//行
//		if (board[i][0] == board[i][1]
//			&& board[i][1] == board[i][2]
//			&& board[i][0] != ' ')
//		{
//			return board[i][0];
//		}
//		//列
//		if (board[0][i] == board[1][i] && board[1][i] == board[2][i]
//			&& board[0][i] != ' ')
//		{
//			return board[0][i];
//		}
//		if (board[0][0] == board[1][1] && board[1][1] == board[2][2]
//			&& board[0][0] != ' ')
//		{
//			return board[0][0];
//		}
//
//		if (board[0][2] == board[1][1] && board[1][1] == board[2][0]
//			&& board[0][0] != ' ')
//		{
//			return board[0][2];
//		}
//		//平局
//		if (full(board, row, col) == 1)
//		{
//			return 'Q';
//		}
//	}
//	//没有赢也没有平局
//	return ' ';
//}
char IsWin(char board[][3], int row, int col)
{
	if (board[0][2] == board[1][2] && board[0][2] == board[2][2] && board[0][2] != ' ')
	{
		return board[0][0];
	}
	if (board[0][1] == board[1][1] && board[0][1] == board[2][1] && board[0][1] != ' ')
	{
		return board[0][1];
	}
	if (board[0][0] == board[1][0] && board[0][0] == board[2][0] && board[0][0] != ' ')
	{
		return board[0][0];
	}
	if (board[0][0] == board[0][1] && board[0][0] == board[0][2] && board[0][0] != ' ')
	{
		return board[0][0];
	}
	if (board[1][0] == board[1][1] && board[1][0] == board[1][2] && board[1][0] != ' ')
	{
		return board[1][0];
	}
	if (board[2][0] == board[2][1] && board[2][0] == board[2][2] && board[2][0] != ' ')
	{
		return board[2][0];
	}
	if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != ' ')
	{
		return board[0][0];
	}
	if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] != ' ')
	{
		return board[0][2];
	}
	if (full(board, row, col) == 1)
	{
		return 'p';
	}
	return ' ';
}
//static int full(char board[][3], int row, int col)
//{
//	int i, j;
//	for (i = 0; i < row; i++)
//	{
//		for (j = 0; j < col; j++)
//		{
//			if (board[i][j] == ' ')
//			{
//				return 0;
//			}
//		}
//	}
//	return 1;
//}
