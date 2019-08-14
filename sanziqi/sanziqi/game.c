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
	memset(board, ' ', row*col*sizeof(char));//��Ϸ��ʼ�����̵�ÿ���ռ䶼��Ϊ��
}
void ShowBoard(char board[][3], int row, int col)
{
	int  i = 0;
	int j = 0;
	for (i = 0; i < row; i++)//������
	{
		for (j = 0; j < col; j++)//������
		{
			printf(" %c ", board[i][j]);//��ӡ�ַ���ά�����д洢�ķ���
			if (j < col - 1)//ֻ��Ҫ�����У�����Ϊcol-1,����������ӡ|
			{
				printf("|");
			}
		}
		putchar('\n');//ÿһ�д����ʹ��putchar���л���
		if (i < row - 1)//ͬ���ÿ�еķָ������д�ӡ
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
	int x = 0;//�������X��Y�������������
	int y = 0;
	while (1)
	{

		printf("�������������λ�ã�1-3����");
		scanf("%d%d", &x, &y);
		if (x>=1&&x<=3&&y>=1&&y<=3)//�������̴�С������׼����ֵ
		{
			if (board[x - 1][y - 1] == ' ')//����λ��Ϊ�գ��Ըø���и�ֵ
			{
				board[x - 1][y - 1] = 'X';
				break;

			}
			else//����λ�ò�Ϊ�գ���ʾ��������
			{
				printf("��λ���ѱ�ռ�ã����������롣\n");
			}
		}
		else//������������������ʾ���벻����
		{
			printf("�������λ�ò�����\n");
		}
	}
}
void ComputerMove(char board[][3], int row, int col)
{
	int i=0, j=0;
	printf("���Ե�ѡ��\n\n");
	while (1)
	{
		i = rand() % 3 + 1;//��ȡ�����i��j
		j = rand() % 3 + 1;
		if (board[i][j] == ' ')//����λ��Ϊ�գ�����
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
//		//��
//		if (board[i][0] == board[i][1]
//			&& board[i][1] == board[i][2]
//			&& board[i][0] != ' ')
//		{
//			return board[i][0];
//		}
//		//��
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
//		//ƽ��
//		if (full(board, row, col) == 1)
//		{
//			return 'Q';
//		}
//	}
//	//û��ӮҲû��ƽ��
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
