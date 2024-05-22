import java.io.*;
import java.util.*;

public class Solution {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) throws IOException {
        while (node != null) {
            System.out.print(node.data);

            node = node.next;

            if (node != null) {
                System.out.print(sep);
            }
        }
    }

    class Result {

        /*
         * Complete the 'insertNodeAtPosition' function below.
         *
         * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
         * The function accepts following parameters:
         *  1. INTEGER_SINGLY_LINKED_LIST llist
         *  2. INTEGER data
         *  3. INTEGER position
         */

        /*
         * For your reference:
         *
         * SinglyLinkedListNode {
         *     int data;
         *     SinglyLinkedListNode next;
         * }
         *
         */

        public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
            // Write your code here
            SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

            if (llist == null || position == 0) {
                newNode.next = llist;
                return newNode;
            }

            int count = 0;
            SinglyLinkedListNode prev = null;
            SinglyLinkedListNode current = llist;
            while (true) {
                if (count == position) {
                    prev.next = newNode;
                    prev.next.next = current;
                    break;
                }
                prev = current;
                current = current.next;
                count++;
            }
            return llist;
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = scanner.nextInt();

        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();

            llist.insertNode(llistItem);
        }

        int data = scanner.nextInt();

        int position = scanner.nextInt();


        SinglyLinkedListNode llist_head = Result.insertNodeAtPosition(llist.head, data, position);

        printSinglyLinkedList(llist_head, " ");

        scanner.close();
    }
}
