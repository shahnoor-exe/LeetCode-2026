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
    public ListNode middleNode(ListNode head) {
        int l=0;
        ListNode x=head;
        while(x!=null){
            l++;
            x=x.next;
        }
        x=head;
        for(int i=0;i<l/2;i++){
            x=x.next;
        }return x;
    }
}