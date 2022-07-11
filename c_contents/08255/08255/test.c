#define _CRT_SECURE_NO_WARNINGS 1

#include<stdio.h>
#include<stdlib.h> 
#include<string.h>

#if 1
//删除排序数组中的重复项
int removeDuplicates(int* nums, int numsSize){
	int i = 0; int j = 0;
	int cnt = 0;
	while (numsSize--){
		if (nums[i] == nums[i + 1]){
			cnt++;
		}
		else {
			nums[j++] = nums[i];
		}
		i++;
	}
	for (int i = 0; i < cnt; i++){
		printf("%d ", nums[i]);
	}
	printf("\n");
	return cnt;
}

int removeDuplicates2(int* nums, int numsSize){
	int cnt = 1;
	int i ;
	for (i = 0; i < numsSize-1; i++){
		if (nums[i] != nums[i + 1]){
			nums[cnt] = nums[i+1];
			cnt++;
		}
	}
	for (int i = 0; i < cnt; i++){
		printf("%d ", nums[i]);
	}
	printf("\n");
		return cnt;
}


int main(){
	int arr[] = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4, };
	printf("%d\n", removeDuplicates2(arr, 10));
	system("pause");
	return 0;
}
#endif

#if 0
//两串字符串的最大长度
char * longTwoCommon(char *str1, char *str2){
	char *p = str1;
	char *q = str2;
	while (*p != '\0'){
		if ((*p) == (*q)){
			p++;
			q++;
		}
		else { break; }
	}
	*p = '\0';
	return str1;
}

//多组字符串的最大前缀
char * longestCommonPrefix(char ** strs, int strsSize){
	if (strsSize == 0) return "";
	int len = strlen(strs[0]);
	char *res = (char *)malloc(sizeof(char)*(len+5));
	strcpy(res, strs[0]);
	for (int i = 0; i < strsSize-1; i++){
		res = longTwoCommon(res, strs[i + 1]);
	}
	return res;
}
                    
int main(){
	char *string[] = { "flower", "flow", "flight" };//"flower", "flow", "flight" 
	int size = sizeof(string) / sizeof(string[0]);
	//printf("%d\n", size);
	//printf("%s\n", string[0]);
	//char *p = string[0];
	//printf("%c\n", *p);

	printf("longestCommonPrefix:%s \n", longestCommonPrefix(string, size));

	//char str1[] = "flower";
	//char str2[] = "float";
	//char *common = longTwoCommon(str1, str2);
	//printf("common:%s\n", common);

	system("pause");
	return 0;
}
#endif 