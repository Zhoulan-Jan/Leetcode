#define _CRT_SECURE_NO_WARNINGS 1

#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#include<string.h>

#if 0
int main(){
	printf("hello world");
	system("pause");
	return 0;
}

#endif

#if 0
//x��ƽ����
int mySqrt(int x){
	if (x == 0) return 0;
	if (x < 4) return 1;
	int left = 1;
	int right = x / 2;
	while (left < right){
		int mid = (left + right+1) /2;
		//if (mid*mid >x)  right = mid - 1;  ������������
		if (mid>sqrt(x)) right = mid - 1;
		else left = mid ;
		}
	return left;
	}

int main(){
	int x = 2147395599;
	printf("%d \n", mySqrt(x));
	system("pause");
	return 0;
}

#endif

#if 1
//���������
//�ַ�����ת
//��ת��ӣ�����ٷ�ת
char * addBinary(char * a, char * b){
	char aa[]=_strrev(a);
	char bb[]=_strrev(b);
	int lena = strlen(aa);
	int lenb = strlen(bb);
	//�̵��ַ������油��

	//���

}

int  main(){
	char str1[] = "110";
	/*_strrev(str1);
	printf("%s ", str1);*/
	char *str2 = "1";
	printf("%s ", addBinary(str1, str2));
	system("pause");
	return 0;
}
#endif