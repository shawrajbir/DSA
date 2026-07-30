/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* swapPairs(struct ListNode* head) {
    struct ListNode dummy;
    dummy.next = head;
    
    struct ListNode *prev = &dummy, *a, *b;
    
    while (prev->next && prev->next->next) {
        a = prev->next;
        b = a->next;
        
        a->next = b->next;
        b->next = a;
        prev->next = b;
        
        prev = a;
    }
    
    return dummy.next;
}