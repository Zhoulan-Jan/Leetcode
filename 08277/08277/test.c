#define _CRT_SECURE_NO_WARNINGS 1

#include<stdio.h>
#include<stdlib.h>

#if 1
//搜索插入位置 二分查找
int searchInsert(int* nums, int numsSize, int target){
	int left = 0;
	int right = numsSize - 1;
	
	while (left <= right){
		int mid = (left+right)/2;
		if (target < nums[mid]) right = mid - 1;
		else if (target > nums[mid]) left = mid + 1;
		else return mid;
	}
	return left;
}

int main(){
	int arr[] = { 1, 3, 5, 6 };
	int len = sizeof(arr) / sizeof(arr[0]);
	printf("%d\n", searchInsert(arr, len, 7));
	system("pause");
	return 0;
}

#endif

#if 0
//移除元素
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