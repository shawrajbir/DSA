/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2) {
    struct ListNode *head = NULL, *tail = NULL;
    int carry = 0;
    while(l1 || l2 || carry) {
        int sum = carry;
        if(l1){ sum += l1->val; l1 = l1->next; }
        if(l2){ sum += l2->val; l2 = l2->next; }
        struct ListNode* node = malloc(sizeof(struct ListNode));
        node->val = sum % 10;
        node->next = NULL;
        if(!head) head = tail = node;
        else { tail->next = node; tail = node; }
        carry = sum / 10;
    }
    return head;
}