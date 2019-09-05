#define _CRT_SECURE_NO_WARNINGS 1

#include<stdio.h>
#include<stdlib.h>

//加一 
//法一：数组转变为数字再加一 ，再转变为数组 //数字容易溢出
//法二：遇到9，前面的数字加一，该数字变零；遇到全为9，returnSize加一
int* plusOne(int* digits, int digitsSize, int* returnSize){
	int cnt = 0;
	for (int i = digitsSize - 1; i >= 0; i--){ //统计9的个数
		if (digits[i] == 9){
			cnt++;
		}
	}
	if (cnt != digitsSize){  //非全9
		if (digits[digitsSize - 1] != 9){//最后一个数字不为9
			int *res = (int *)malloc(sizeof(int)*(digitsSize));
			*returnSize = digitsSize;
			res[digitsSize - 1] = digits[digitsSize - 1] + 1;
			for (int i = 0; i < *returnSize - 1; i++){
				res[i] = digits[i];
			}
			return res;
		}
		else{//最后一个数字为9  8,9,9,9 cnt=3
			int *res = (int *)malloc(sizeof(int)*(digitsSize ));
			*returnSize = digitsSize;
			if (digits[digitsSize - 2] == 9){
				int d = cnt;
				for (int i = *returnSize - 1; cnt; i--){
					res[i] = 0;
					cnt--;
				}
				res[*returnSize - 1 - d] = digits[*returnSize - 1 - d] + 1;
				for (int j = *returnSize - 1 - d - 1; j >= 0; j--){
					res[j] = digits[j];
				}
				return res;
			}
			else{
				res[digitsSize - 2] = digits[digitsSize - 2] + 1;
				res[digitsSize - 1] = 0;
				for (int i = 0; i < *returnSize - 2; i++){
					res[i] = digits[i];
				}
				return res;
			}		
		}
	}
	else{ //全9
		int *res = (int *)malloc(sizeof(int)*(digitsSize+1));
		*returnSize = digitsSize+1;
		res[0] = 1;
		for (int i = 1; i <= digitsSize; i++){
			res[i] = 0;
		}
		return res;
	}
}

int main(){
	int arr[] = {2,4,9,3,9 };
	int len = sizeof(arr) / sizeof(arr[0]);
	int returnSz = 0;
	int *t = plusOne(arr, len, &returnSz);
	for (int i = 0; i < returnSz; i++){
		printf("%d ", t[i]);
	}
	system("pause");
	return 0;
}