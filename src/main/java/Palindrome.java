
public class Palindrome {
    /**
     * Assignment 2: Palindrome
     * Checks if singly linked list is a palindrome.
     * Ex. 1 -> 2 -> 3 -> 2 -> 1
     * 
     */

    /**
     * Node class
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
     * LIST-INSERT: insert node x at the head
     * Returns new head
     */
    public static Node listInsert(Node head, Node x) {
        // x becomes the new head
        x.next = head;
        return x;
    }

    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Find middle (slow ends at middle)
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // If odd length, slow is at the middle element
        // We reverse from slow onwards (works for both even and odd)
        Node secondHalfHead = reverseList(slow);

        // Compare the first half and the reverse second half
        Node p1 = head;
        Node p2 = secondHalfHead;
        boolean ok = true;
        while (p2 != null) { // compare only the length of the second half
            if (p1.key != p2.key) {
                ok = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // Restore
        reverseList(secondHalfHead);

        return ok;
    }

    public static Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node nextTemp = curr.next; // save next
            curr.next = prev;          // reverse pointer
            prev = curr;               // move prev
            curr = nextTemp;           // move curr
        }

        return prev;
    }

    // Print list
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.key + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        System.out.println("Assignment 2: Palindrome Check");

        // 1 → 2 → 3 → 2 → 1
        Node p1 = null;
        p1 = listInsert(p1, new Node(1));
        p1 = listInsert(p1, new Node(2));
        p1 = listInsert(p1, new Node(3));
        p1 = listInsert(p1, new Node(2));
        p1 = listInsert(p1, new Node(1));
        // head-insert builds reversed order; to match exact order,
        // you can build with tail inserts, but palindrome result still works.

        System.out.print("Palindrome list: ");
        printList(p1);
        System.out.println("isPalindrome: " + isPalindrome(p1));

        // 5 → 10 → 17
        Node p2 = null;
        p2 = listInsert(p2, new Node(17));
        p2 = listInsert(p2, new Node(10));
        p2 = listInsert(p2, new Node(5));

        System.out.print("Non-palindrome list: ");
        printList(p2);
        System.out.println("isPalindrome: " + isPalindrome(p2));

        System.out.println();
    }
}
