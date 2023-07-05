public class CountItems {
    static Node head;

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    static Node push(Node head, int new_data) {
        // allocate node
        Node new_node = new Node(new_data);

        // link the old list of the new node
        new_node.next = head;

        // move the head to point to the new node
        head = new_node;

        return head;
    }

    static int getCount(Node head, int key) {
        if (head == null)
            return 0;
        if (head.data == key)
            return 1 + getCount(head.next, key);
        return getCount(head.next, key);
    }

    public static void main(String[] args) {
        Node head = null;

        /*
         * Use push() to construct below list
         * 1->2->1->3->1
         */
        head = push(head, 1);
        head = push(head, 3);
        head = push(head, 1);
        head = push(head, 2);
        head = push(head, 1);

        /* Check the count function */
        System.out.print("count of 1 is " + getCount(head, 1));
    }
}
