#define _CRT_SECURE_NO_WARNINGS 1

#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#if 1
//���һ�����ʵĳ���
//��һ���ַ�������ַ�����ֻ������пո�����пո�+ǰ���пո�
/*char *p1 = s[len - 1];
char *p2 = s[len - 1];*/
int lengthOfLastWord(char * s){
	//���ַ�
	if (*s == NULL){ return 0; }
	//���ո�ĸ���
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
	if (!blank){//һ���ַ� �����ҿո� û�пո����һ���ַ�
		return strlen(s);
	}
	else { //����ַ�
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