#define _CRT_SECURE_NO_WARNINGS 1

#include<stdio.h>
#include<stdlib.h>

#if 0
//ÒÆ³ýÔªËØ
int removeElement(int *nums, int numsSize, int val){
	int i = 0;
	int cnt = 0;
	for (; i <= numsSize-1; i++){
		if (nums[i] != val){
			nums[cnt] = nums[i];
			cnt++;
		}
	}
	for (int j = 0;j< cnt; j++){
		printf("%d ", nums[j]);
	}
	printf("\n");
	return cnt;
}

int main(){
	int arr[] = { 0,1,2,2,3,0,4,2 };
	int len = sizeof(arr) / sizeof(arr[0]);
	printf("%d\n", removeElement(arr, len, 2));
	system("pause");
	return 0;
}
#endif