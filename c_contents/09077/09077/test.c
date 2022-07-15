#define _CRT_SECURE_NO_WARNINGS 1

#include<stdio.h>
#include<stdlib.h>

#if 1
//合并两个有序数组
void merge(int* nums1, int nums1Size, int m, int* nums2, int nums2Size, int n){
	int i = 0;
	int j = 0;
	int nums_copy[10000]= { 5 };
	for (int k = 0; k < nums1Size; k++){
		nums_copy[k] = nums1[k];
	}
	int new_num = 0;
	while ((i < m)&&(j < n)){
		if (nums_copy[i] < nums2[j]){
			nums1[new_num++] = nums_copy[i++]; //nums改变了
		}
		else{
			nums1[new_num++] = nums2[j++];
		}
	}
	while (i< m){
		nums1[new_num++] = nums_copy[i++];
	}
	while(j< n){
		nums1[new_num++] = nums2[j++];
	}
}

int main(){
	int arr1[] = { 4,5,6, 0, 0, 0 };
	int arr2[] = { 1,2,3 };
	int lena = sizeof(arr1) / sizeof(arr1[0]);
	int lenb = sizeof(arr2) / sizeof(arr2[0]);
	merge(arr1, lena, 3, arr2, lenb, 3);
	for (int i = 0; i < lena; i++){
		printf("%d ", arr1[i]);
	}
	system("pause");
	return 0;
}
#endif