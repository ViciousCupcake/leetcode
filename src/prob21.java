package src;

public class prob21 {
    public static void main(String[] args) {

    }

    static public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode current = null;
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                if (current == null) {
                    head.next = l1;
                } else {
                    current.next = l1;
                }
                current = l1;
                l1 = l1.next;
            } else {
                if (current == null) {
                    head.next = l2;
                } else {
                    current.next = l2;
                }
                current = l2;
                l2 = l2.next;

            }
        }
        if (l1 != null) {
            if (current == null) {
                head.next = l1;
            } else {
                current.next = l1;
            }
        } else if (l2 != null) {
            if (current == null) {
                head.next = l2;
            } else {
                current.next = l2;
            }
        }
        return head;
    }

    class ListNode {
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
}
