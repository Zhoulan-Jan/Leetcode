#define _CRT_SECURE_NO_WARNINGS 1

#include<stdio.h>
#include<stdlib.h>

//简单版八皇后
#define NUM 4
int Q[10] = { 0 };
void queen(int cur){
	if (cur == NUM) {
		for (int i = 0; i < NUM; i++){
			printf("%d ", Q[i]);
		}
		printf("\n");
	}
	else {
		for (int i = 0; i < NUM; i++){
			Q[cur] = i;
			int ok = 1;
			for (int j = 0; j < cur; j++){
				if (Q[cur] == Q[j] || cur - Q[cur] == j - Q[j] || cur + Q[cur] == j + Q[j]){
					ok = 0;
					break;
				}
			}
			if (ok) queen(cur + 1);  //cur为什么会慢慢变成0呀
		}
	}
}

int main(){
	queen(0);
	system("pause");
	return 0;
}
