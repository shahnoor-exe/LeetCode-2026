/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null||(left==right)) return head;
        ListNode h=new ListNode(0);
        h.next=head;
        ListNode x=h;
        for(int i=1;i<left;i++) x=x.next;
        ListNode x1=x.next;
        for(int i=0;i<right-left;i++){
            ListNode x2=x1.next;
            x1.next=x2.next;
            x2.next=x.next;
            x.next=x2;
        }return h.next;
    }
}