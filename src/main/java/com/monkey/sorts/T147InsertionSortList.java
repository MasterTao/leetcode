package com.monkey.sorts;

/**
 * 对链表进行插入排序
 *
 *
 * @author tao
 * @date 2021/1/28 7:46 下午
 */
public class T147InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode lastSorted = head;
        ListNode curr = head.next;

        while (curr != null) {
            if (lastSorted.val < curr.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dummyNode;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        T147InsertionSortList t147InsertionSortList = new T147InsertionSortList();
        ListNode sortedNode = t147InsertionSortList.insertionSortList(node1);
        if (sortedNode != null) {
            System.out.println(sortedNode.val);
            while (sortedNode.next != null) {
                System.out.println(sortedNode.next.val);
                sortedNode = sortedNode.next;
            }
        }
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}