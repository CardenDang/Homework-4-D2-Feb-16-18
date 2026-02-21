
/* Assignment 1 */
public class LinkedList {
    
    // 1. Node Class
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
}
