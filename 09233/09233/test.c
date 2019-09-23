#define _CRT_SECURE_NO_WARNINGS 1

#include<stdio.h>
#include<stdlib.h>

//°Ë»Êºó
#define NUM 4
int Q[10] = { 0 };
void queen(int cur){
	if (cur == NUM) {
		for (int i = 0; i < NUM; i++){
			printf("%d ", Q[i]);
		}
	}
	else {
		for (int i = 0; i < NUM; i++){
			Q[cur] = i;
			for (int j = 0; j < cur; j++){

			}
		}
	}
}

int main(){
	queen(0);
	system("pause");
	return 0;
}
