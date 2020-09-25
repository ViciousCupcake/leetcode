package src;

import java.util.ArrayList;

public class prob19 {
    public static void main(String[] args) {

    }

    static public ListNode removeNthFromEnd(ListNode head, int n) {
        // if head is deleted;
        ArrayList<ListNode> list = new ArrayList<ListNode>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr);
            curr = curr.next;
        }
        /*
         * if(list.size()-n-1 == 0){ if(list.size()>0){ return list.get(1); } else
         * return null; }
         */
        if (list.size() - n - 1 == -1) {
            if (list.size() < 2)
                return null;
            return list.get(1);
        }
        /*
         * if(list.size() - n - 1 ==0){ return list.get(1); }
         */
        list.get(list.size() - n - 1).next = list.get(list.size() - n).next;
        return head;
    }
}
