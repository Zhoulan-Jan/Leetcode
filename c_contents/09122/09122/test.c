#define _CRT_SECURE_NO_WARNINGS 1

#include<stdio.h>
#include<stdlib.h>

#if 1
//删除链表结点
struct ListNode {
    int val;
    struct ListNode *next;
 };

//head不需要传递过来吗 不需要，
//通过node找到下一个节点，将node->val= 下一个节点->val,删除下一个节点即可
void deleteNode(struct ListNode* node) {  
	node->val = node->next->val;
	node->next = node->next->next;
}
#endif
