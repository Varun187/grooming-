package com.day3;

public class CustomLinkedList {

    Node head;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Method to insert a new node
    public static CustomLinkedList insert(CustomLinkedList list, int data) {

        Node new_node = new Node(data);

        new_node.next = null;

        if (list.head == null) {
            list.head = new_node;
        } else {

            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            last.next = new_node;
        }

        return list;
    }

    // Method to print the LinkedList.
    public static void printList(CustomLinkedList list) {
        Node currNode = list.head;

        System.out.print("\nLinkedList: ");

        while (currNode != null) {
            System.out.print(currNode.data + " ");

            currNode = currNode.next;
        }
        System.out.println("\n");
    }

    // Method to delete a node in the LinkedList by KEY
    public static CustomLinkedList deleteByKey(CustomLinkedList list,
            int key) {

        Node currNode = list.head, prev = null;

        if (currNode != null && currNode.data == key) {
            list.head = currNode.next;

            System.out.println(key + " found and deleted");

            return list;
        }

        while (currNode != null && currNode.data != key) {

            prev = currNode;
            currNode = currNode.next;
        }
        if (currNode != null) {
            prev.next = currNode.next;
            System.out.println(key + " found and deleted");
        }

        if (currNode == null) {
            System.out.println(key + " not found");
        }
        return list;
    }

    // Method to delete a node in the LinkedList by POSITION
    public static CustomLinkedList deleteAtPosition(CustomLinkedList list, int index) {
        Node currNode = list.head, prev = null;

        if (index == 0 && currNode != null) {
            list.head = currNode.next;
            System.out.println(index + " position element deleted");
            return list;
        }

        int counter = 0;
        while (currNode != null) {

            if (counter == index) {
                prev.next = currNode.next;
                System.out.println(index + " position element deleted");
                break;
            } else {
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }

        if (currNode == null) {
            System.out.println(index + " position element not found");
        }

        return list;
    }

    public static void main(String[] args) {

        CustomLinkedList list = new CustomLinkedList();

        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 6);
        list = insert(list, 7);
        list = insert(list, 8);

        printList(list);
        deleteByKey(list, 1);
        printList(list);
        deleteByKey(list, 4);
        printList(list);
        deleteByKey(list, 10);
        printList(list);
        deleteAtPosition(list, 0);
        printList(list);
        deleteAtPosition(list, 2);
        printList(list);
        deleteAtPosition(list, 10);
        printList(list);
    }
}
