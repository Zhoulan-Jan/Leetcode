#define _CRT_SECURE_NO_WARNINGS 1

#include<stdio.h>
#include<stdlib.h>
#include<string.h>

//�ַ������

//�ַ�����ת
char *my_strrev(char * str){
	char *p1 = str;
	char *p2 = str + strlen(str) -1;
	for (; p1 < p2; p1++, p2--){
		*p1 ^= *p2;
		*p2 ^= *p1;
		*p1 ^= *p2;
		//*p2 ^= *p1; //������
	}
	return str;  //�ҳ���Ҫ
}

//���
#if 1
char sum[10000] = { 0 };
char num[10000] = { 0 };
char * addStrings(char * num1, char * num2){
	memset(sum, 0, sizeof(sum));
	memset(num, 0, sizeof(num));

	int lena = strlen(num1);
	int lenb = strlen(num2);

	char *numa = my_strrev(num1);
	char *numb = my_strrev(num2);

	int i = 0;
	for (i = 0; i < min(lena, lenb); i++){
		sum[i] = (numa[i] - '0') + (numb[i] - '0');
	}
	//�ϳ����ַ������油ȫ��ע��߽� //���߷�ת��ʱ��϶̵ĺ��油��
	int index = i;
	if (lena > lenb){
		while (i < lena){
			sum[index++] = numa[i++]-'0';
		}
	}
	else{
		while (i < lenb){
			sum[index++] = numb[i++]-'0';
		}
	}

	int ci = 0;
	int k = 0;
	//while (k <= index || ci != 0){   //�Ҳ��ܽ�����ڽ�λ����� ����9+1=10
	//	ci = ci + sum[k];
	//	sum[k] = ci % 10;
	//	ci /= 10;
	//	k++;
	//}
	/*if (ci == 0){
		index++;
	}*/

	//if (lena == lenb){  //ֻ�ܽ��һЩ����
	//	if (((num1[0] - '0') + (num2[0] - '0')) > 9){
	//		index++;
	//	}
	//}
	//index++;

	for (k = 0;; k++){ //ѧ�Ե�˼��̫cool��
		if (k < max(lena,lenb)|| ci != 0){
			ci = ci + sum[k];
			sum[k] = ci % 10;
			ci /= 10;
		}
		else break;
	}

	//��תsum
	/*index++;*/
	int nu = 0;
	while (k--){  //�ĳ�index�ʹ���
		num[nu++] = sum[k] + '0';
	}

	return num;  //sum�����飬����ֱ�ӷ���
}
#endif

int main(){
	char str1[] = "456";
	char str2[] = "923";
	//int x = (str1[0] - '0') + (str2[0] - '0');
	//printf("%d \n", x);
	//printf("%s \n", my_strrev(str1));
	printf("%s \n", addStrings(str1, str2));
	/*int *res = addStrings(str1, str2);
	for (int i = 0; i < 8; i++){
		printf("%d ", res[i]);
	}*/
	system("pause");
	return 0;
}