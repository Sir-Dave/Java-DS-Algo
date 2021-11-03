package com.sirdave.data_structures;

import java.util.ArrayList;
import java.util.List;

class Result{
    int size;
    ListNode tail;

    public Result(int size, ListNode tail){
        this.size = size;
        this.tail = tail;
    }
}

public class FindLinkedListIntersection {
    static ListNode head;

    public static ListNode createLinkedList(ArrayList<Integer> arr) {
        ListNode first = null;
        for (int num : arr) {
            ListNode node = new ListNode(num);
            if (first == null){
                first = node;
                head = node;
            }
            else {
                head.next = node;
                head = head.next;
            }
        }
        return first;
    }

    static ListNode findIntersection(ListNode a , ListNode b){
        if (a == null || b == null) return null;

        Result result1 = getTailAndSize(a);
        Result result2 = getTailAndSize(b);

        if (result2.tail != result1.tail){
            return null;
        }

        ListNode shorter = result1.size < result2.size ? a: b;
        ListNode longer = result1.size < result2.size ? b: a;

        //move the longer linkedList by the
        // difference between the both of them

        longer = movePointer(longer, Math.abs(result2.size - result1.size));

        while (shorter != longer){
            shorter = shorter.next;
            longer = longer.next;
        }
        return shorter;
    }

    static ListNode movePointer(ListNode node, int k){
        ListNode current = node;
        while (k > 0 && current != null){
            current = current.next;
            k--;
        }
        return current;
    }

    static Result getTailAndSize(ListNode node){
        if (node == null) return null;
        int size = 1;
        while (node.next != null){
            size++;
            node = node.next;
        }
        return new Result(size, node);
    }

    public static void main(String[] args) {
        ArrayList<Integer> listA = new ArrayList<>(List.of(4,1,8,4,5));
        ArrayList<Integer> listB = new ArrayList<>(List.of(5,6,1,8,4,5));

        ListNode nodeA = createLinkedList(listA);
        ListNode nodeB = createLinkedList(listB);

        ListNode intersection = findIntersection(nodeA, nodeB);
        System.out.println(intersection.val);
    }

}
