package com.monkey.sorts;

/**
 * 对链表进行插入排序
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
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
            if (lastSorted.val <= curr.val) {
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
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        //ListNode node3 = new ListNode(1);
        //ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = null;
        //node2.next = node3;
        //node3.next = node4;

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