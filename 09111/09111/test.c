#define _CRT_SECURE_NO_WARNINGS 1

#include<stdio.h>
#include<stdlib.h>

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

int main(){
	int n = 6;
	/*printf("%d ", climbStairs(0,n));*/
	printf("%d ", climbStairs3(18));
	system("pause");
	return 0;
}
