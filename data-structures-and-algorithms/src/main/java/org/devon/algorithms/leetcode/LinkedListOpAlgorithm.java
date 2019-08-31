package org.devon.algorithms.leetcode;


import java.util.*;

public class LinkedListOpAlgorithm {
    /**
     * complexity analysis
     * T(n) = n + n + n + n = 4n
     * <p>Time complexity</p> O(n)
     * <p>Space complexity</p> O(0)
     *
     * @param head
     * @return
     */
    public static ListNode findMiddleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * complexity analysis
     * T(n) = n + n + n + 2n +n =6n
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * if has cycle,  fast pointer already meeting slow pointer
     * complexity analysis
     * T(n) = n + n + n =3n
     * Time complexity: O(n)
     * S(n) = n
     * Space complexity: O(n)
     *
     * @param head
     * @return
     */
    public static boolean hasCycle1(ListNode head) {
        Set<String> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head.toString());
            }
            head = head.next;
        }
        return false;
    }

    /**
     * complexity analysis
     * T(n) = n + n + n + n + n + n = 6n
     * Time complexity:O(n)
     * S(n) = 1
     * Space complexity:O(1)
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode result = new ListNode(0);
        ListNode dummy = null;
        while (head != null) {
            //取出单节点
            dummy = head;
            head = head.next;
            dummy.next = null;

            dummy.next = result.next;
            result.next = dummy;
        }
        return result.next;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        //快指针先走n+1
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }
        //快慢指针一块走 快指针到尾节点，满指针才到倒数n-1
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        //removeIndex = (L-N)+1 添加辅助节点后变为removeIndex =（L-N）
        length -= n;
        first = dummy;
        //用辅助节点从链表头部走到 removeIndex
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        // find middle node
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = reverse(slow);
        while (slow != null) {
            if (slow.val != head.val) {
                return false;
            }
            slow = slow.next;
            head = head.next;
        }
        return true;
    }

    private static ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode rotateRight(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy.next;
        ListNode slow = dummy.next;
        int i = 0;
        while (fast != null) {
            fast = fast.next;
            i++;
        }

        for (int j = i - n % i; j > 0; j--) {//Get the i-n%i th node
            slow = slow.next;
        }

        fast.next = dummy.next; //Do the rotation
        dummy.next = slow.next;
        slow.next = null;

        return dummy.next;

    }

    /**
     * double pointer，include pre (Predecessor) pointer and current pointer,
     * current pointer merge save value node, compare pre pointer and cur pointer is same node
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode current = head;
        while (current != null) {
            // merge same value node
            while (current.next!= null && current.val == current.next.val){
                current = current.next;
            }
            //
            if(pre.next == current){
                //与前驱节点对比
                pre = pre.next;
            }else {
                //拼接不同节点
                pre.next = current.next;
            }
            //对比节点指针向后移动
            current = current.next;
        }

        return dummy.next;
    }

    /**
     * complexity analysis
     * T(n) = 5n
     * Time complexity:O(n)
     * S(n) = 2
     * Space complexity:O(1)
     *
     * @param head
     * @return
     */

    public static ListNode partition(ListNode head, int x) {
        ListNode first = new ListNode(0);
        ListNode dummy = first;
        ListNode second= new ListNode(0);
        ListNode dummy2 = second;
        while(head!=null){
            if(head.val < x){
                dummy.next = head;
                head =head.next;
                dummy = dummy.next;
                dummy.next = null;
            }else {
                dummy2.next = head;
                head = head.next;
                dummy2 = dummy2.next;
                dummy2.next = null;
            }
        }
        dummy.next= second.next;
        return first.next;
    }

    public int numComponents(ListNode head, int[] G) {
        Set<Integer> Gset = new HashSet();
        for (int x: G) Gset.add(x);

        ListNode cur = head;
        int ans = 0;

        while (cur != null) {
            if (Gset.contains(cur.val) &&
                    (cur.next == null || !Gset.contains(cur.next.val)))
                ans++;
            cur = cur.next;
        }

        return ans;
    }

}