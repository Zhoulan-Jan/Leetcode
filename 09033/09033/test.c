#define _CRT_SECURE_NO_WARNINGS 1

#include<stdlib.h>
#include<stdio.h>

#if 1
//在排序数组中查找元素的第一个和最后一个元素的位置
int* searchRange(int* nums, int numsSize, int target, int* returnSize){
	int *result = (int *)malloc(sizeof(int)* 2);
	*returnSize = 2;
	if (numsSize == 0){
		result[0] = -1;
		result[1] = -1;
		return result;
	}
	int left = 0;
	int right = numsSize - 1;
	int s = 0;
	int mid;
	while (left <= right){
		mid = (left + right) / 2;
		if (target > nums[mid]) left = mid + 1;
		else if (target < nums[mid]) right = mid - 1;
		else{
			s = mid;
			break;
		}
	}
	//if (left>right){
	//	result[0] = -1;
	//	result[1] = -1;
	//}
	for (int i = s;; i--){ //当数组的第一个元素就是target就会堆溢出
		if (target != nums[i]){
			result[0] = i+1;
			break;
		}
		if (i == 0){
			result[0] = 0;
			break;
		}
	}
	for (int j = s;; j++){//哭了，j++之后满足第一个if 故result[1]=5;但一个if中，j->s,第二个ifj越界,交换两个if
		
		if (target != nums[j]){
			result[1] = j-1;
			break;
		}
		if (j == numsSize - 1){
			result[1] = numsSize - 1;
			break;
		}
	}
	if (left>right){
		result[0] = -1;
		result[1] = -1;
	}
	return result;
}

int main(){
	int arr[] = {1,4 };
	int len = sizeof(arr) / sizeof(arr[0]);
	int returnSz = 0;
	int *s=searchRange(arr,len,4,&returnSz);
	for (int i = 0; i < returnSz; i++){
		printf("%d ", s[i]);
	}
	
	system("pause");
	return 0;
}
#endif

#if 0
int searchBinary(int* nums, int numsSize, int target){
	int *result = (int *)malloc(sizeof(int)* 2);
	int left = 0;
	int right = numsSize - 1;
	while (left <= right){
		int mid = (left + right) / 2;
		if (target > nums[mid]) left = mid + 1;
		else if (target < nums[mid]) right = mid - 1;
		else{
			return mid;
		}
	}
}

int main(){
	int arr[] = { 5, 7, 7, 8, 8, 8,8,8,8,8,10 };
	int len = sizeof(arr) / sizeof(arr[0]);
	printf("%d ", searchBinary(arr, len, 8));  //mid只会返回某一个8的位子
	system("pause");
	return 0;
}
#endif 