#define _CRT_SECURE_NO_WARNINGS 1

#include<stdio.h>
#include<stdlib.h>

int hammingWeight(uint32_t n) {
	int cnt = 0;
	while (n){
		n = n & (n - 1);
		cnt++;
	}
	return cnt;
}