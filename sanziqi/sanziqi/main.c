#define _CRT_SECURE_NO_WARNINGS  1
#include "game.h"

void Menu()
{
	printf("\t\t\t\t\t**************************\n");
	printf("\t\t\t\t\t**************************\n");
	printf("\t\t\t\t\t*********1.��ʼ***********\n");
	printf("\t\t\t\t\t*********0.�˳�***********\n");
	printf("\t\t\t\t\t**************************\n");
	printf("\t\t\t\t\t**************************\n");
}
void Game()
{
	char ret = 0;//����һ�������ж�˭Ӯ�ķ����ַ�
	char board[3][3] = { 0 };//�ö�ά���鶨���ʾ����
	InitBoard(board, 3, 3);//��ʼ�����̣�������Ϊ��
	ShowBoard(board, 3, 3);//��ʾ����
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
		printf("��һ�ʤ\n");
	}
	if (ret == 'O')
	{
		printf("���Ի�ʤ\n");
	}
	if (ret == 'P')
	{
		printf("ƽ��\n");
	}
}
int main()
{
	int  input = 0;
	srand((unsigned int)time(NULL));//����������ӣ�ʹÿ����Ϸʱ���Բ��������ϴ���Ϸ��ȫ��ͬ
	do{
		Menu();
		printf("���������ѡ��");
		scanf("%d", &input);
		switch (input)
		{
		case 1:
			Game();
			break;
		case 0:
			printf("��Ϸ������\n");
			break;
		default:
			printf("����ѡ������\n\n");
			break;
		}
	} while (input);
	return 0;
}