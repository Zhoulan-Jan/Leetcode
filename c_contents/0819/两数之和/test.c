#define _CRT_SECURE_NO_WARNINGS 1

#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#if 1
//罗马数字转整数

//转换
int read(char c){
	switch (c){
	case 'I':return 1; break;
	case 'V':return 5; break;
	case 'X':return 10; break;
	case 'L':return 50; break;
	case 'C':return 100; break;
	case 'D':return 500; break;
	case 'M':return 1000; break;
	}
}

//计算
int romanToInt(char * s){
	int num = 0;
	char *p = s;
	while (*p != '\0'){
		if (read(*p) == 1 || read(*p) == 10 || read(*p) == 100){
			if (read(*p) < read(*(p+1))){
				num += read(*(p+1)) - read(*p);
				p+=2;
			}
			else {
				num += read(*p);
				p++;
			}
		}
		if (read(*p) == 5 || read(*p) == 50 || read(*p) == 500||read(*p)==1000){
			num += read(*p);
			p++;
		}
	}
	return num;
}

int main(){
	char *str = "III";
	printf("%d ", romanToInt(str));
	system("pause");
	return 0;
}
#endif

#if 0
//给定一个整数数组 nums 和一个目标值 target，
//请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

int *twoSum(int* nums, int numsSize, int target, int* returnSize){
	int *result;
	for (int i = 0; i < numsSize; i++){
		for (int j = i+1; j < numsSize; j++){
			if (nums[i] + nums[j] == target){
				result = (int *)malloc(sizeof(int)* 2);
				result[0] = i;
				result[1] = j;
				*returnSize = 2;
				return result;
			}
		}
	}
	return 0;
}

int main(){
	int arr[] = {3,2,3 };
	int *t=twoSum(arr, 3, 6,2);
	printf("%d %d", t[0],t[1]);
	system("pause");
	return 0;
}
#endif 