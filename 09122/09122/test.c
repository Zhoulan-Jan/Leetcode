#define _CRT_SECURE_NO_WARNINGS 1

#include<stdio.h>
#include<stdlib.h>

#if 1
//ɾ��������
struct ListNode {
    int val;
    struct ListNode *next;
 };

//head����Ҫ���ݹ����� ����Ҫ��
//ͨ��node�ҵ���һ���ڵ㣬��node->val= ��һ���ڵ�->val,ɾ����һ���ڵ㼴��
void deleteNode(struct ListNode* node) {  
	node->val = node->next->val;
	node->next = node->next->next;
}
#endif
