package leetcode.number.number21.double_pointer;

/**
 * @author yxl
 * @date 2023/2/2 上午1:17
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

    /**
     * 时间 0 ms 击败 100%
     * 内存 40.8 MB 击败 73.83%
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = null;
        ListNode temp = null;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                if (res == null) {
                    res = list2;
                    list2=list2.next;
                    temp = res;
                    continue;
                }
                temp.next = list2;
                list2 = list2.next;
                temp=temp.next;
                continue;
            }
            if (list2 == null) {
                if (res == null) {
                    res = list1;
                    list1=list1.next;
                    temp = res;
                    continue;
                }
                temp.next = list1;
                list1 = list1.next;
                temp=temp.next;
                continue;
            }
            if (list1.val <= list2.val) {
                if (res == null) {
                    res = list1;
                    list1=list1.next;
                    temp = res;
                    continue;
                }
                temp.next = list1;
                list1 = list1.next;
            } else {
                if (res == null) {
                    res = list2;
                    list2=list2.next;
                    temp = res;
                    continue;
                }
                temp.next = list2;
                list2 = list2.next;
            }
            temp=temp.next;
        }
        return res;
    }
}
