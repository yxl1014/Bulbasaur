package leetcode.number.number77.dalao;

/**
 * @author yxl
 * @date 2023/2/4 下午4:42
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
     * TODO 大佬永远是大佬!!!
     * 作者：tandztc
     * 链接：https://leetcode.cn/problems/7WHec2/solutions/967368/yi-bu-bu-jiang-kong-jian-fu-za-du-cong-o-oxes/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    //通俗易懂的说就是从前往后的归并算法每次比较2的倍数 的数，  直到这个数大于链表长度，结束排序
    public ListNode SortList(ListNode head) {
        if (head == null || head.next == null) return head;
        //链表长度
        int n = 0;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            n++;
        }
        int len = 1;
        //若len>=长度说明合并完成
        //最外层循环每次两个 四个 八个的比  ，简而言之 外层循环规定比较的个数
        while (len < n) {
            //before是链表头
            ListNode beforeHead = dummy;
            //这一层循环是将所有的数两个 比 四个比 八个比，简而言之 内层循环具体执行比较
            while (beforeHead != null) {
                ListNode mid = beforeHead.next;
                for (int i = 0; i < len; i++) {
                    if (mid != null) mid = mid.next;
                    else break;
                }
                //after是链表最后一个指向null的指针
                ListNode afterTail = mid;
                for (int i = 0; i < len; i++) {
                    if (afterTail != null) afterTail = afterTail.next;
                    else break;
                }
                //排序
                Merge(beforeHead, mid, afterTail);
                for (int i = 0; i < len * 2; i++) {
                    if (beforeHead != null)
                        beforeHead = beforeHead.next;
                    else break;
                }
            }
            len *= 2;
        }
        return dummy.next;
    }


    //使用双指针对链表进行排序
    void Merge(ListNode beforeHead, ListNode mid, ListNode afterTail) {
        ListNode cur = beforeHead;
        ListNode head1 = cur.next;
        ListNode head2 = mid;
        while (head1 != mid && head2 != afterTail) {
            if (head1.val <= head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        while (head1 != mid) {
            cur.next = head1;
            head1 = head1.next;
            cur = cur.next;
        }
        while (head2 != afterTail) {
            cur.next = head2;
            head2 = head2.next;
            cur = cur.next;
        }
        cur.next = afterTail;
    }

}
