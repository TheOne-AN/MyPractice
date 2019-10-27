package test;

import java.io.EOFException;
import java.util.Scanner;

import static sun.nio.ch.IOStatus.EOF;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution {

    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return  list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        ListNode newHead = new ListNode(0);
        ListNode newTail = newHead;
        while ( cur1 != null && cur2 != null)
            if (cur1.val < cur2.val) {
            newTail.next = new ListNode(cur1.val);
            newTail = newTail.next;
            cur1 = cur1.next;
        } else {
            newTail = new ListNode(cur2.val);
            newTail = newTail.next;
            cur2 = cur2.next;
        }
        if (cur1.next == null) {
            newTail.next = cur1;
        }
        if (cur2.next == null) {
            newTail.next = cur2;
        }
        return newHead.next;
    }

    }
