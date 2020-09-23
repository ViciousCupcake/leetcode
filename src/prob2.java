package src;

import java.math.BigInteger;
import java.util.LinkedList;

public class prob2 {
    public static void main(String[] args) {
        ListNode output = addTwoNumbers(new ListNode(7), new ListNode(8));
        while (output != null) {
            System.out.println(output.val);
            output = output.next;
        }
    }

    static public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<Character> num1 = new LinkedList<Character>();
        LinkedList<Character> num2 = new LinkedList<Character>();

        while (l1 != null || l2 != null) {

            if (l1 != null) {
                num1.addFirst((char) ('0' + l1.val));
                l1 = l1.next;
            }
            if (l2 != null) {
                num2.addFirst((char) ('0' + l2.val));
                l2 = l2.next;
            }
        }
        StringBuilder s1 = new StringBuilder(num1.size());
        for (Character ch : num1) {
            s1.append(ch);
        }
        StringBuilder s2 = new StringBuilder(num2.size());
        for (Character ch : num2) {
            s2.append(ch);
        }
        BigInteger sum = new BigInteger(s1.toString());
        sum = sum.add(new BigInteger(s2.toString()));

        System.out.println(sum);
        if (sum.equals(BigInteger.ZERO)) {
            return new ListNode(0);
        }
        ListNode head = new ListNode();
        ListNode previous = head;
        while (!sum.equals(BigInteger.ZERO)) {
            ListNode current = new ListNode((int) (sum.mod(BigInteger.TEN).longValue()));
            previous.next = current;
            previous = current;
            sum = sum.divide(BigInteger.TEN);
        }
        return head.next;
    }
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
