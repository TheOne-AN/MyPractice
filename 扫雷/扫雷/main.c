#define _CRT_SECURE_NO_WARNINGS  1
#include<stdio.h>
#include"game.h"
void menu()
{
	printf("********************************\n");
	printf("*************1.��ʼ*************\n");
	printf("*************0.�˳�*************\n");
	printf("********************************\n");
}
void game()
{
	//�����
	char mine[ROWS][COLS] = { 0 };
	//�Ų���
	char mineinfo[ROWS][COLS] = { 0 };
	//��ʼ������
	initboard(mine, ROWS, COLS, '0');
	initboard(mineinfo, ROWS, COLS, '*');
	//��ӡ��ά���飨��������
	showboard(mineinfo, ROW, COL);
	//������
	setmine(mine, ROW, COL);
	//����
	findmine(mine,mineinfo,ROW,COL);
}
int main()
{
	int input = 0;
	srand((unsigned int)time(NULL));
	do{
		menu();
		printf("��������Ĳ�����");
		scanf("%d", &input);
		switch (input)
		{
		case 1:
			game();
			break;
		case 0:
			printf("��Ϸ������\n");
			break;
		default:
			printf("���������������������롣\n");
			break;
		}
	} while (input);
	return 0;
}
