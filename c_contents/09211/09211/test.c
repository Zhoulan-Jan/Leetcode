#define _CRT_SECURE_NO_WARNINGS 1

#include<stdio.h>
#include<stdlib.h>

//¥Úº“ΩŸ…·
int rob(int* nums, int numsSize){
	int sum = 0;
	for (int i = 0; i < numsSize; i+=2){
		sum += nums[i];
	}
	return sum;
}

int main(){
	int arr[] = { 2, 7, 9, 3, 1 };
	int len = sizeof(arr) / sizeof(arr[0]);
	printf("%d\n", rob(arr, len));
	system("pause");
	return 0;
}