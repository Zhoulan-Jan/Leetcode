#define _CRT_SECURE_NO_WARNINGS 1



#if 0 error
#include<stdio.h>
#include<stdlib.h>
//两数相除
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

#if 1
//c++版本 参考他人想法
#include<cstdio>
#include<cstdlib>
#include<iostream>
using namespace std;
class Solution {
public:
	int divide(int dividend, int divisor) {
		long long a=dividend;
		long long b=divisor;
		if((a==INT_MIN&&b==-1)||(a==INT_MAX&&b==1)) return INT_MAX;
		if((a==INT_MAX&&b==-1)||(a==INT_MIN&&b==1)) return INT_MIN;
		long sum = 0;
		long cnt = 0;
		long base=0;
		long x = std::fabs(dividend);
		long y = std::fabs(divisor);

		while (x >= y){
			cnt = 1;
			base = y;
			while (x>(base << 1)){
				cnt <<= 1;
				base <<= 1;
			}
			sum += cnt;
			x -= base;
		}
		sum = ((a<0) ^ (b<0)) ? -sum : sum;
		return sum;
	}
};

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