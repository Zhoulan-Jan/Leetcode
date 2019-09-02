#define _CRT_SECURE_NO_WARNINGS 1

#include<stdio.h>
#include<stdlib.h>

//最大子序和
int maxSubArray(int* nums, int numsSize){
	int i = 0;
	int mx = nums[0];
	int sum = 0;
	for (; i < numsSize; i++){
		if (sum < 0) sum = nums[i];
		else sum += nums[i];
		if (mx < sum) mx = sum;
	}
	return mx;
}


int main(){
	int arr[] = {1,2 };
	int len = sizeof(arr) / sizeof(arr[0]);
	printf("%d\n",maxSubArray(arr, len));
	system("pause");
	return 0;
}