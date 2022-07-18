#define _CRT_SECURE_NO_WARNINGS 1

#include<stdio.h>
#include<stdlib.h>

//两个数的交集
//hash  lieshuji
int* intersection(int* nums1, int nums1Size, int* nums2, int nums2Size, int* returnSize){
	int vis[10000] = { 0 };
	int *result = (int *) malloc (sizeof(int)*100000);
	int cnt = 0;
	for (int i = 0; i < nums1Size; i++){
		vis[nums1[i]]++;
	}
	for (int j = 0; j < nums2Size; j++){
		if (vis[nums2[j]]){
			result[cnt] = nums2[j];
			vis[nums2[j]] = 0;
			cnt++;
		}
	}
	*returnSize = cnt;
	return result;
}

//O(m*n)
int* intersection1(int* nums1, int nums1Size, int* nums2, int nums2Size, int* returnSize){
	int mn = min(nums1Size, nums2Size);
	int mx = max(nums1Size, nums2Size);
	int *result = (int *)malloc(sizeof(int)*mn);
	int cnt = 0;
	for (int i = 0; i < mn; i++){
		for (int j = 0; j < mx; j++){
			if (nums1[i] == nums2[j]){
				result[i] = nums1[i];
				cnt++;
				continue;
			}
		}
	}
	*returnSize = cnt;
	return result;
}

int main(){
	int arr1[] = { 4,9,5};
	int arr2[] = { 9,4,9,8,4};
	int len1 = sizeof(arr1) / sizeof(arr1[0]);
	int len2 = sizeof(arr2) / sizeof(arr2[0]);
	int returnsz = 0;
	int *result = intersection(arr1, len1, arr2, len2, &returnsz);
	for (int i = 0; i < returnsz; i++){
		printf("%d ", result[i]);
	}
	system("pause");
	return 0;
}