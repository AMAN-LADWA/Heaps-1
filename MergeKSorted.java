/*
Desc : We use general logic of if corresponding nodes compared between two lists the lesser one is added to current list. 
Time Complexity : O(kn)
Space Complexity :O(n)
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode merged = new ListNode(Integer.MIN_VALUE);
        for(ListNode head: lists){
            if(head!=null)
                merged = merge(merged,head);
        }
        return merged.next;
    }
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if(l1 == null){
            curr.next = l2;
        }
        if(l2 == null){
            curr.next = l1;
        }
        return dummy.next;
    }
}
