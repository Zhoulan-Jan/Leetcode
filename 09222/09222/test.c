#define _CRT_SECURE_NO_WARNINGS 1

/**
* Definition for singly-linked list.
* struct ListNode {
*     int val;
*     struct ListNode *next;
* };
*/


struct ListNode* removeElements(struct ListNode* head, int val){
	if (head == NULL) return head;  //返回空链表 返回空不行
	if (head->next == NULL && head->val == val) return; //只有一个节点
	struct ListNode* p = head;
	if (head->val == val) p = head->next;
	if (head->next == NULL && head->val != val) return head;

	while (p != NULL) {
		if (p->next != NULL && p->next->val == val) {
			struct ListNode* q = p->next;
			p->next = q->next;
		}
		p = p->next;
	}
	return head;
}
