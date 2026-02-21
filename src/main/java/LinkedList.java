
/* Assignment 1: Implement Basic Linked List Operations */
public class LinkedList {
    /**
     * Node Class
     */
    public static class Node {
        int key;
        Node next;

        Node(int key) {
            this.key = key;
            this.next = null;
        }
        @Override
        public String toString() {
            return String.valueOf(key);
    }
}

/**
 * LIST-INSERT(L, x): insert node x at the head.
 * Returns new head.
 */
public static Node listInsert(Node head, Node x) {
    // x becomes the new head
    x.next = head;
    return x;
}

/**
 * LIST-SEARCH(L, K): return the first node with key == k, else null.
 */
public static Node listSearch(Node head, int key) {
    Node curr = head;
    while (curr != null) {
        if (curr.key == key) {
            return curr;
        }
        else {
            curr = curr.next;
        }
    }
    return null;
}

/**
 * LIST-DELETE(L, x): delete the given node reference x
 * Returns updated head
 */
public static Node listDelete(Node head, Node x) {
    if (head == null || x == null) {
        return head;
    }

    // Check if head is deleted
    if (head == x) {
        return head.next;
    }

    // Find the prev node before x
    Node prev = head;
    while (prev.next != null && prev.next != x) {
        prev = prev.next;
    }

    // If found, skip x
    if (prev.next == x) {
        prev.next = x.next;
    }
    return head;
}

/** Print list */
public static void printList(Node head) {
    Node curr = head;
    while (curr != null) {
        System.out.print(curr.key + " -> ");
        curr = curr.next;
    }
    System.out.println("null");
}
}
