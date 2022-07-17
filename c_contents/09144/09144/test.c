#define _CRT_SECURE_NO_WARNINGS 1

#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#if 1
//字符串相乘

//字符串反转
char *my_strrev(char *str){
	char *p1 = str;
	char *p2 = str + strlen(str) - 1;
	for (; p1 < p2; ++p1, --p2){
		*p1 ^= *p2;
		*p2 ^= *p1;
		*p1 ^= *p2;
	}
	return str;
}

//大数相乘
int ans[100000] = { 0 };
char num[10000] = { 0 };
char * multiply(char * num1, char * num2){
	if (*num1 == '0' || *num2 == '0') return "0";
	my_strrev(num1);
	my_strrev(num2);
	int lena = strlen(num1);
	int lenb = strlen(num2);
	
	for (int i = 0; i < lena; i++){
		for (int j = 0; j < lenb; j++){
			ans[i + j] += (num1[i] - '0')*(num2[j] - '0');
		}
	}
	int ci = 0;
	int i = 0;
	for (i = 0;; i++){
		if (i < lena + lenb - 1 || ci != 0){
			ci = ans[i] + ci;
			ans[i] = ci%10;
			ci = ci / 10;
		}
		else break;
	}
	int nu = 0;
	
	while (i--){
		num[nu++] = ans[i] + '0';
	}
	return num;
}

int main(){
	char str1[] = "123";
	char str2[] = "456";
	printf("%s\n", multiply(str1, str2));
	system("pause");
	return 0;
}
#endif