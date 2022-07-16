#define _CRT_SECURE_NO_WARNINGS 1

#include<stdio.h>
#include<stdlib.h>
#include<math.h>

#if 0
//爬楼梯 其实就是斐波那契数列
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

//改进
//利用数组保存
int climbStairs3(int n){
	//arr[1] = 1;
	//arr[2] = 2;
	//if (n == 1) arr[1] = 1;
	//if (n == 2) arr[2] = 2;
	int arr[10000] = { 1,1,2,0 };
	if (arr[n]) return arr[n];
	else return climbStairs3(n - 1) + climbStairs3(n - 2);
} 

//改进
//找到第n个斐波那契数
int climbStairs4(int n){
	if (n == 1) return 1;
	int first = 1;
	int second = 2;
	for (int i = 3; i <= n; i++){
		int third = first + second;
		first = second;
		second = third;
	}
	return second;
}

//利用斐波那契公式
int climbStairs5(int n){
	double sqrt5 = sqrt(5.0);
	double res = pow((1 + sqrt5) / 2, n + 1) - pow((1 - sqrt5) / 2, n + 1);
	return (int)(res / sqrt5);
}


int main(){
	int n = 6;
	/*printf("%d ", climbStairs(0,n));*/
	printf("%d ", climbStairs1(0,18));
	printf("%d ", climbStairs2(18));
	printf("%d ", climbStairs3(18));
	printf("%d ", climbStairs4(18));
	printf("%d ", climbStairs5(18));
	system("pause");
	return 0;
}
#endif 

#if 1
//判断子序列
int isSubsequence(char * s, char * t){
	char *ps = s;
	char *pt = t;
	while (*ps != '\0' && *pt!='\0'){
		if (*ps == *pt){
			ps++;
		}
			pt++;
	}
	if (*ps == '\0'){
		return 1;
	}
	else return 0;
}


int main(){
	int str1 = "axc";
	int str2 = "ahbgdc";
	printf("%d ", isSubsequence(str1, str2));
	system("pause");
	return 0;
}
#endif

#if 0
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
			/* 以万为进制，提高运算速度 */
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
		/* 先输出第一个数，防止首位出现0 */
		printf("%d!=%d", i, r[j--]);
		for (; j >= 0; j--)
		{
			/* 输出其余的数，因为万进制，需要补0 */
			printf("%04d", r[j]);
		}
		printf("\n");
	}
	system("pause");
	return 0;
}
#endif