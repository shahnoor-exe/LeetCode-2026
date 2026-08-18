/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null) return null;
        ListNode x=head;
        ListNode y=head;
        while(y!=null && y.next!=null){
            x=x.next;
            y=y.next.next;
            if(x==y){
                ListNode z=head;
                while(z!=x){
                    z=z.next;
                    x=x.next;
                }return z;
            }
        }return null;
    }
}