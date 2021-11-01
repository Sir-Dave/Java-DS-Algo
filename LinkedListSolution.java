package com.sirdave.data_structures;

import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(){}

    ListNode(int val) {
        this.val = val;
    }
}


public class LinkedListSolution {
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

    static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
            }
            else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1 != null)
            tail.next = l1;

        else if (l2 != null)
            tail.next = l2;

        return dummy.next;
    }

    static ListNode removeDuplicates(ListNode head){
        Set<Integer> set = new HashSet<>();
        ListNode current = head;
        ListNode prev = null;
        while (current != null){
            if (set.contains(current.val)){
                prev.next = current.next;
                current = prev.next;
            }
            else {
                set.add(current.val);
                prev = current;
                current = current.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(List.of(1,2,4));
        ArrayList<Integer> b = new ArrayList<>(List.of(1,3,4, 7, 8, 9));
        ListNode l1 = createLinkedList(a);
        ListNode l2 = createLinkedList(b);
        //ListNode current = mergeTwoLists(l1, l2);
        ArrayList<Integer> c = new ArrayList<>(List.of(1,2,2, 3, 4, 4, 5));
        ListNode head = createLinkedList(c);
        ListNode current = removeDuplicates(head);
        while (current != null){
            System.out.println(current.val);
            current = current.next;
        }
    }
}
