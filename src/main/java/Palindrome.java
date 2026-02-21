
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
    static class Node {
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

}
