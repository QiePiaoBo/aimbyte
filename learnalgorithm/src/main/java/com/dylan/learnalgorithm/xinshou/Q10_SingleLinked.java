package com.dylan.learnalgorithm.xinshou;

/**
 * @author Dylan
 * @Date : Created in 2:15 2021/11/5
 * @Description :
 * @Function :
 */
public class Q10_SingleLinked {

    static class Node {
        public int anInt;

        public Node next;

        public Node(int data){
            anInt = data;
        }
    }

    /**
     * 反转单链表并返回反转之后的头节点
     * @param head
     * @return
     */
    private static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        // 将头节点设置为反转之后的新头节点
        // 对引用数据类型来说，传入方法的只是一个引用的拷贝，在方法中的修改并不会影响原值
        head = reverseLinkedList(head);
        // 遍历链表
        while (head != null){
            System.out.print(head.anInt + " ");
            head = head.next;
        }
        System.out.println();
    }

}
