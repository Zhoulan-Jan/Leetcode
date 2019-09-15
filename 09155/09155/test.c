#define _CRT_SECURE_NO_WARNINGS 1

#include<stdio.h>
#include<stdlib.h>

//气球的最大数量
int maxNumberOfBalloons(char * text){
	char *p = text;
	int arr[256] = { 0 };
	while (*p != '\0'){
		arr[*p]++;
		p++;
	}
	int balon[] = { arr[98], arr[97], arr[108]/2, arr[111]/2, arr[110] };
	int len = sizeof(balon) / sizeof(balon[0]);
	printf("before:");
	for (int k = 0; k < len; k++){
		printf("%d ", balon[k]);
	}
	printf("\n");
	for (int i = 0; i < len-1; i++){
		for (int j = 0; j < len-1-i; j++){
			if (balon[j]>balon[j + 1]){
				int t = balon[j];
				balon[j] = balon[j + 1];
				balon[j + 1] = t;
			}
		}
	}
	printf("after: ");
	for (int k = 0; k < len; k++){
		printf("%d ", balon[k]);
	}
	printf("\n");
	return balon[0];
}


int main(){
	char text[] = "ballon";
	printf("maxNumberOfBalloons(text):%d \n", maxNumberOfBalloons(text));
	system("pause");
	return 0;
}