#define _CRT_SECURE_NO_WARNINGS 1.

#include<stdio.h>
#include<stdlib.h>

//�����ظ�Ԫ��
// 1 ����     0 ������

//������ ������Ƚ�
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
//��ϣ�� error
int containsDuplicate1(int* nums, int numsSize){
	int hash[10000] = { 0 };
	for (int i = 0; i < numsSize; i++){
		hash[nums[i]]++; //nums[i] Ϊ����ʱleetcode������Ϊ�����±겻��Ϊ����
	}
	//�����ϣ������ֶ���1 ����false 0
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

