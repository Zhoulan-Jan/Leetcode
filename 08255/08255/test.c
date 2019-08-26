#define _CRT_SECURE_NO_WARNINGS 1

#include<stdio.h>
#include<stdlib.h> 

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