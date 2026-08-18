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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode h=new ListNode(0);
        h.next=head;
        ListNode x=h;
        ListNode y=h;
        for(int i=0;i<n;i++) y=y.next;
        while(y.next!=null){
            x=x.next;
            y=y.next;
        }x.next=x.next.next;
        return h.next;
    }
}