#define _CRT_SECURE_NO_WARNINGS 1

#include<stdio.h>
#include<stdlib.h>
#include<string.h>



#if 0
//38����
//3.     21
//4.     1211
//5.     111221
//6.     312211
//7.     13112221
//8.     1113213211
//9.     31131211131221

//ͳ��һ���ַ�����
//char *countOne(char *str){
//
//}

//д����
char * countAndSayerror(int n){
	if (n == 1) return "1";
	else if (n == 2) return "111";
	else {
		int cnt = 0;
		int i = 0;
		char *cur_str = countAndSay(n - 1);
		char *new_str=(char *)malloc(sizeof(char)*100); //ָ��ָ�����һ���̶���  ���ܸı�
		//memset(new_str, 0, sizeof(new_str));
		char *p = cur_str;
		while (*p != '\0'){
			if ((*p) == *(p + 1)){
				cnt++;
			}
			else{
				*new_str= cnt + '0'; //error
				new_str++;
				*new_str= *cur_str;
			}
			p++;
			cur_str++;
			//new_str++;
		}
		*(new_str+1) = '\0';
		return new_str;
	}
}

//�ڶ���
char * countAndSay(int n){
	if (n == 1) return "1";
	else if (n == 2) return "11";
	else {
		char *new_str = (char *)malloc(sizeof(char)* 100);
		char *cur_str = countAndSay(n - 1);
		int len = strlen(cur_str);
		int cnt = 1;
		int i = 0;
		int j = 0;
		for (; i < len; i++){
			if (cur_str[i] == cur_str[i + 1]){
				cnt++;
			}
			else {
				new_str[j] = cnt + '0';
				j++;
				new_str[j] = cur_str[i + cnt - 1];
			}
		}
		return new_str;
	}
}

#endif

#if 1
//������ c++
#include<cstdio>
#include<cstdlib>
#include<string>
#include<iostream>

using namespace std;

string countAndSay(int n){
	if (n == 1) return "1";
	else if (n == 2) return "11";
	else {
		string new_str;
		string cur_str = countAndSay(n - 1);
		int cnt = 1;
		int i = 0;
		for (; i < cur_str.size(); i++){
			if (cur_str[i] == cur_str[i + 1]){
				cnt++;
			}
			else {
				new_str = new_str+(char)(cnt + '0')+cur_str[i];
				cnt = 1;
			}
		}
		return new_str;
	}
}



int main(){
	string p = countAndSay(4);
	cout << p;
	system("pause");
	return 0;
}
#endif
