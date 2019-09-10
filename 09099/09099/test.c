#define _CRT_SECURE_NO_WARNINGS 1

#include<stdio.h>
#include<stdlib.h>

//删除排序链表中的重复元素i
struct ListNode {
	int val;
	struct ListNode *next;
};

struct ListNode* deleteDuplicates(struct ListNode* head){
	if (head == NULL || head->next == NULL) return head;
	struct ListNode* pCur = head;
	struct ListNode HEAD = { 0, NULL };
	struct ListNode *pNew = &HEAD;
	int value;
	int cnt;
	while (pCur != NULL){
		struct ListNode* tmp = pCur;
		// value = pCur->val;
		// int cnt=0;
		// while (value == pCur->next->val&&pCur){
		// 	++cnt;
		// 	pCur = pCur->next;
		// }
		for (cnt = 0, value = pCur->val; pCur&&value == pCur->val; ++cnt){
			pCur = pCur->next;
		}
		if (cnt != 0){
			pNew->next = tmp;
			pNew = tmp;
		}
		//pCur = pCur->next;
	}
	pNew->next = NULL;
	return HEAD.next;
}


int main(){
	system("pause");
	return 0;
}