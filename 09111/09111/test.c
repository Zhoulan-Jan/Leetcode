#define _CRT_SECURE_NO_WARNINGS 1

#include<stdio.h>
#include<stdlib.h>

#if 0
//��¥�� ��ʵ����쳲���������
int climbStairs1(int i,int n){
	if (i > n) return 0;
	else if (i == n) return 1;
	else return climbStairs1(i + 1, n) + climbStairs1(i + 2, n);
}

int climbStairs2(int n){
	if (n == 1) return 1;
	if (n == 2) return 2;
	return climbStairs2(n - 1) + climbStairs2(n - 2);
}

//�Ľ�
//�������鱣��
int climbStairs3(int n){
	//arr[1] = 1;
	//arr[2] = 2;
	//if (n == 1) arr[1] = 1;
	//if (n == 2) arr[2] = 2;
	int arr[10000] = { 1,1,2,0 };
	if (arr[n]) return arr[n];
	else return climbStairs3(n - 1) + climbStairs3(n - 2);
} 

int main(){
	int n = 6;
	/*printf("%d ", climbStairs(0,n));*/
	printf("%d ", climbStairs3(18));
	system("pause");
	return 0;
}
#endif 

#if 1
//n!
#define N 10000
int main()
{
	int r[N] = { 1 };
	int i, j;
	int k = 0, l = 0;
	for (i = 1; i <= 50; i++)
	{
		for (j = 0; j <= l; j++)
		{
			r[j] = r[j] * i + k;
			/* ����Ϊ���ƣ���������ٶ� */
			k = r[j] / 10000;
			r[j] = r[j] % 10000;
		}
		if (k)
		{
			l++;
			r[j] = k;
			k = 0;
		}
		j = l;
		/* �������һ��������ֹ��λ����0 */
		printf("%d!=%d", i, r[j--]);
		for (; j >= 0; j--)
		{
			/* ��������������Ϊ����ƣ���Ҫ��0 */
			printf("%04d", r[j]);
		}
		printf("\n");
	}
	system("pause");
	return 0;
}
#endif