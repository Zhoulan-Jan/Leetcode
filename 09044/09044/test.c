#define _CRT_SECURE_NO_WARNINGS 1

#include<stdio.h>
#include<stdlib.h>

#if 1
//БЅКэПаіэ
int divide(int dividend, int divisor){
	if (dividend<INT_MIN || dividend>INT_MAX - 1) return INT_MAX;
	int cnt = 0;
	long long x = dividend;
	long long y = divisor;
	long long sum = 0;
	if (dividend < 0 && divisor < 0){
		x= -dividend;
		y = -divisor;
	}
	else if (dividend<0 && divisor>0){
		x = -dividend;
	}
	else if (dividend>0 && divisor < 0){
		y = -divisor;
	}
	while (sum <= x){
		sum += y;
		cnt++;
	}
	if (divisor*dividend < 0){
		return -(cnt - 1);
	}
	else return cnt - 1;
}


int main(){
	int dividend = -2147483648;
	int divisor = -1;
	printf("%d \n", divide(dividend, divisor));
	printf("correct:%d \n", dividend / divisor);
	system("pause");
	return 0;
}
#endif

#if 0
int main(){
	long long dividend= INT_MIN-1;
	long long divisor = -1;
	printf("correct:%d \n", dividend / divisor);
	system("pause");
	return 0;
}
#endif