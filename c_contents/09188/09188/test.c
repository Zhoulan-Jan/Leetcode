#define _CRT_SECURE_NO_WARNINGS 1.

#include<stdio.h>
#include<stdlib.h>

//存在重复元素
// 1 存在     0 不存在

//先排序 在往后比较
int containsDuplicate(int* nums, int numsSize){
	for (int i = 0; i < numsSize - 1; i++){
		for (int j = 0; j < numsSize - 1 - i; j++){
			if (nums[j]>nums[j + 1]){
				int t = nums[j];
				nums[j] = nums[j + 1];
				nums[j + 1] = t;
			}
		}
	}
	//qsort(nums, numsSize, sizeof(int), nums);
	/*sort(nums, nums + numsSize);*/
	for (int k = 0; k < numsSize; k++){
		if (nums[k] == nums[k + 1]){
			return 1;
		}
	}
	return 0;

}
//哈希表 error
int containsDuplicate1(int* nums, int numsSize){
	int hash[10000] = { 0 };
	for (int i = 0; i < numsSize; i++){
		hash[nums[i]]++; //nums[i] 为负数时leetcode报错，因为数组下标不能为负数
	}
	//如果哈希表的数字都是1 就是false 0
	int len = sizeof(hash) / sizeof(hash[0]);
	for (int j = 0; j < len; j++){
		if (hash[j]>1){
			return 1;
		}
	}
	return 0;
}

int main(){
	int arr[] = { 1,5,-2,-2,0 }; //1
	int len = sizeof(arr) / sizeof(arr[0]);
	printf("%d \n", containsDuplicate(arr, len));
	system("pause");
	return 0;
}

