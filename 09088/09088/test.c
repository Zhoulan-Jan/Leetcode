#define _CRT_SECURE_NO_WARNINGS 1

#include<stdio.h>
#include<stdlib.h>

//只出现一次的数字
int singleNumber(int* nums, int numsSize){
	int ans = 0;
	for (int i = 0; i < numsSize; i++){
		ans ^= nums[i];
	}
	return ans;
}

int main(){
	int arr[] = { 4,1,2,1,2 };
	int len = sizeof(arr) / sizeof(arr[0]);
	printf("%d ", singleNumber(arr, len));
	system("pause");
	return 0;
}