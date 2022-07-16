#define _CRT_SECURE_NO_WARNINGS 1

#include<stdlib.h>
#include<stdio.h>

//删除排序链表中的重复元素ii
typedef struct ListNode {
	int val;
	struct ListNode *next;
}ListNode;

#if 1
struct ListNode* deleteDuplicates(struct ListNode* head){
	if (head == NULL || head->next == NULL) return head;
	struct ListNode* pCur = head;
	struct ListNode HEAD = { 0, NULL };
	struct ListNode *pNew = &HEAD;
	int n;
	int value;
	while (pCur != NULL){
		struct ListNode* t = pCur;
		for (n = 0, value = pCur->val; pCur && pCur->val == value; ++n){
			pCur = pCur->next;
		}if (n == 1){
			pNew->next = t;
			pNew = t;
		}
	}
	pNew->next = NULL;
	return HEAD.next;
}
#endif

#if 0
//带头结点？？
struct ListNode* deleteDuplicates(struct ListNode* head){
	struct ListNode* pfast = head;
	struct ListNode* pslow = NULL;
	while (pfast != NULL){
		if (pfast->val != pfast->next->val){
			if (pslow->next != pfast){
				pslow->next = pfast->next;
			}
			else {
				pslow = pfast;
			}
		}
		pfast = pfast->next;
	}
	return pslow;
}
#endif

int main(){
	system("pause");
	return 0;
}