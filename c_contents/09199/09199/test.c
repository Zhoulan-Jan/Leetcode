#define _CRT_SECURE_NO_WARNINGS 1

#include<stdio.h>
#include<stdlib.h>

//��ת����
//ʹ�÷�ת
//��ת����k�κ�k%n��Ԫ�ػᵽǰ����
//1.���巴ת
//2.ǰk����ת
//3.��n-k����ת
void reverse(int *arr, int start, int end){
	while (start <= end){
		int tmp = arr[start];
		arr[start] = arr[end];
		arr[end] = tmp;
		start++;
		end--;
	}
}

void rotate(int* nums, int numsSize, int k){
	k %= numsSize;
	reverse(nums, 0, numsSize - 1);
	reverse(nums, 0, k-1 );
	reverse(nums, k, numsSize - 1);
}

int main(){
	int arr[] = { 1, 2 ,3,4,5,6,7};
	int len = sizeof(arr) / sizeof(arr[0]);
	rotate(arr, len, 3);  
	for (int i = 0; i < len; i++){
		printf("%d ", arr[i]);
	}
	system("pause");
	return 0;
}
//1.�ȰѺ�k��������浽������
//2.ǰ�������˳�����  //bug:����֮�󳤶ȴ���ԭ����
//3.�����鸳ֵ��nums
#if 0
void rotate(int* nums, int numsSize, int k){
	int tmp[100000] = { 0 }; //����������ĳ��ȱ���Ϊ����
	int nu = 0;
	for (int i = numsSize - k; i < numsSize ; i++){
		tmp[nu++] = nums[i];
	}
	int k2 = k;
	for (int i = 0; i < numsSize - k ; i++){
		nums[k2++] = nums[i];
	}
	for (int i = 0; i < k; i++){
		nums[i] = tmp[i];
	}
}

int main(){
	int arr[] = { 1, 2};
	int len = sizeof(arr) / sizeof(arr[0]);
	int tmp[100000] = { 0 }; //����������ĳ��ȱ���Ϊ����
	int nu = 0;
	int k = 3;
	for (int i = len - k; i < len; i++){
		tmp[nu++] = arr[i];
	}
	//int k2 = k;
	//for (int i = 0; i < len - k; i++){
	//	arr[k2++] = arr[i];   //�����Ѿ��ı��� �ָ�ֵ��ȥ�� 1 2 3 1 2 3 1
	//  tmp[k2++] = arr[i];   //��
	//}
	int num = len - 1;
	for (int i = k; i >= 0; i--){
		arr[num--] = arr[i];
	}
	for (int i = 0; i < k; i++){
		arr[i] = tmp[i];
	}
	//rotate(arr, len, 3);  
	for (int i = 0; i < len; i++){
		printf("%d ", arr[i]);
	}
	system("pause");
	return 0;
}
#endif 


