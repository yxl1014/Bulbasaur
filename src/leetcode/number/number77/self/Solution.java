package leetcode.number.number77.self;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author yxl
 * @date 2023/2/4 下午4:31
 */


public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode sortList(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        Collections.sort(list);
        ListNode res = null;

        for (Integer i : list) {
            if (res == null) {
                res = new ListNode(i);
                temp = res;
            } else {
                temp.next = new ListNode(i);
                temp = temp.next;
            }
        }

        return res;
    }
}
