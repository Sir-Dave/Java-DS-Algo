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

    static ListNode reverseLinkedList(ListNode head){
        ListNode current = head;
        ListNode prev = null;
        while (current != null){
            ListNode next = current.next;
            current.next = prev;

            prev = current;
            current = next;
        }

        return prev;
    }

    static ListNode addReverseNodes(ListNode a, ListNode b, int carry){
        if (a == null && b == null && carry == 0){
            return null;
        }
        ListNode result = new ListNode();
        int value = carry;
        if (a != null){
            value += a.val;
        }

        if (b != null){
            value += b.val;
        }
        result.val = value % 10;

        result.next = addReverseNodes(a == null ? null : a.next,
                 b == null ? null : b.next, value/10);
        return result;

    }

    // method 1
    public static boolean isPalindrome(ListNode head){
        ListNode reversed = reverseAndClone(head);
        return isEqual(head, reversed);
    }

    static ListNode reverseAndClone(ListNode node) {
        ListNode head = null;
        while (node != null) {
            ListNode n = new ListNode(node.val); // Clone
            n.next = head;
            head = n;
            node = node.next;

        }
        return head;
    }

    public static boolean isEqual(ListNode node1, ListNode node2){
        while (node1 != null && node2 != null){
            if (node1.val != node2.val){
                return false;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1 == null && node2 == null;
    }

    // method 2
    public static boolean isLinkedListPalindrome(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        Stack<Integer> stack = new Stack<>();

        while (fast != null && fast.next != null){
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null){
            slow = slow.next;
        }

        while (slow != null){
            int top = stack.pop();
            if (slow.val != top){
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        int length = 0;
        ListNode current = head;
        while (current != null){
            length++;
            current = current.next;
        }

        current = dummy;
        int stop = length-n+1;
        int count = 0;
        while (current != null){
            count++;
            if (count == stop){
                current.next = current.next.next;
                break;
            }
            current = current.next;

        }
        return dummy.next;
    }

    static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode current = dummy;
        while (current != null && current.next != null){
            if (current.next.val == val){
                current.next = current.next.next;
            }
            else {
                current = current.next;
            }
        }
        return dummy.next;
    }

    static ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (ListNode node: lists){
            ListNode current = node;
            while (current != null){
                pq.add(current.val);
                current = current.next;
            }
        }
        ListNode first = null;
        ListNode head = null;
        while(!pq.isEmpty()){
            int val = pq.poll();
            ListNode node = new ListNode(val);
            if (first == null){
                first = node;
                head = node;
            }
            else{
                head.next = node;
                head = head.next;
            }
        }

        return first;
    }

    public static ListNode swapNodes(ListNode head, int k) {
        ListNode dummy = new ListNode();

        dummy.next = head;

        ListNode first = new ListNode();
        ListNode last = new ListNode();

        int length = 0;
        ListNode current = head;
        while (current != null){
            length++;
            current = current.next;
        }

        current = dummy;
        int count = 0;

        while (current != null){
            count++;
            if (count == k){
                first = current.next;
                break;
            }
            current = current.next;
        }

        current = dummy;
        count = 0;
        int stop = length - k +1;

        while (current != null){
            count++;
            if (count == stop){
                last = current.next;
                break;
            }
            current = current.next;
        }

        int temp = first.val;
        first.val = last.val;
        last.val = temp;

        return dummy.next;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4,5));


        ListNode node = createLinkedList(list);
        head = swapNodes(node, 2);
        //head = oddEvenList(node);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

        //ListNode head = removeElements(node, 6);


        //System.out.println(isPalindrome(node));
        //System.out.println(isLinkedListPalindrome(node));

        /* ArrayList<Integer> a = new ArrayList<>(List.of(7, 1, 6));
        ArrayList<Integer> b = new ArrayList<>(List.of(5, 9));
        ListNode l1 = createLinkedList(a);
        ListNode l2 = createLinkedList(b);
        ListNode sum = addReverseNodes(l1, l2, 0);
        */

    }
}
