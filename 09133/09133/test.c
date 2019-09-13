#define _CRT_SECURE_NO_WARNINGS 1

#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#if 1
//最后一个单词的长度
//（一个字符、多个字符、）只有最后有空格、最后有空格+前面有空格
/*char *p1 = s[len - 1];
char *p2 = s[len - 1];*/
int lengthOfLastWord(char * s){
	//空字符
	if (*s == NULL){ return 0; }
	//最后空格的个数
	int blankLast = 0;
	int len = strlen(s);
	for (int i = len - 1; i >= 0; i--){
		if (s[i] != ' '){
			break;
		}
		blankLast++;
	}
	char *p = s;
	int blank = 0;
	while (*p != NULL){
		if (*p == ' '){
			blank++;
		}
		p++;
	}
	if (blankLast != 0 && blank == blankLast){
		return len - blankLast;
	}
	if (!blank){//一个字符 遍历找空格 没有空格就是一个字符
		return strlen(s);
	}
	else { //多个字符
		int p1 = len - 1-blankLast;
		int p2 = len - 1-blankLast;
		while (p2){
			if (s[p2] == ' '){
				break;
			}
			p2--;
		}
		return p1 - p2;
	}
}

int main(){
	char str[] = "asd abnnv   ";
	printf("%d \n", lengthOfLastWord(str));
	system("pause");
	return 0;
}
#endif